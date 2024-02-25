package com.hwmvc.demo.controller;

import com.hwmvc.demo.entities.Note;
import com.hwmvc.demo.servicies.NoteService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping(value = "/note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @GetMapping(value = "/list")
    public ModelAndView listOfNotes() {
        ModelAndView result = new ModelAndView("notes/notesMainPage");
        result.addObject("notes", noteService.getAllNotes());
        return result;
    }

    @PostMapping(value = "/add")
    public String addNote(@NotNull  @RequestParam(name = "title") String title,
                                @NotNull @RequestParam(name = "content") String content){
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        noteService.addNote(note);
        return "redirect:/note/list";
    }

    @GetMapping(value = "/edit")
    public ModelAndView getNoteForEdit(@NotNull @RequestParam(name = "id") String id) throws Exception {
        UUID uuid = UUID.fromString(id);
        ModelAndView result = new ModelAndView("notes/noteEdit");
        result.addObject("note", noteService.getById(uuid));
        return result;
    }

    @PostMapping(value = "/edit")
    public String editNote(@NotNull @RequestParam(name = "id") String id,
                                 @NotNull @RequestParam(name = "title") String title,
                                 @NotNull @RequestParam(name = "content") String content) throws Exception {
        UUID uuid = UUID.fromString(id);
        Note note = noteService.getById(uuid);
        note.setTitle(title);
        note.setContent(content);
        noteService.update(note);
        return "redirect:/note/list";
    }

    @PostMapping(value = "/delete")
    public String deleteNote(@NotNull @RequestParam(name = "id") String id) throws Exception {
        UUID uuid = UUID.fromString(id);
        noteService.deleteById(uuid);
        return "redirect:/note/list";
    }

}

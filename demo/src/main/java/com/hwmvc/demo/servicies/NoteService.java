package com.hwmvc.demo.servicies;

import com.hwmvc.demo.dao.NoteDao;
import com.hwmvc.demo.entities.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private NoteDao noteDao;

    @Autowired
    public NoteService(NoteDao noteDao){
        this.noteDao = noteDao;
    }


    //повертає список всіх нотаток
    public List<Note> getAllNotes(){
        return noteDao.listAll();
    }

    //додає нову нотатку, генеруючи для цієї нотатки унікальний (випадковий) числовий ідентифікатор, повертає цю ж нотатку з згенерованим ідентифікатором.
    public Note addNote(Note note){ return noteDao.add(note);}

    //видаляє нотатку з вказаним ідентифікатором. Якщо нотатки з ідентифікатором немає - викидає виключення.
    public void deleteById(UUID id) throws Exception {
        noteDao.deleteById(id);
    }

    //шукає нотатку по note.id. Якщо нотатка є - оновлює для неї title та content. Якщо нотатки немає - викидає виключення.
    public void update(Note note) throws Exception {
        noteDao.update(note);
    }

    //повертає нотатку по її ідентифікатору. Якщо нотатки немає - викидає виключення.
    public Note getById(UUID id) throws Exception {
        return noteDao.getById(id);
    }
}

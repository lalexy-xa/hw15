package com.hwmvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    public ModelAndView getTime() {
        ModelAndView result = new ModelAndView("test/hellowWorld");
        return result;
    }
}

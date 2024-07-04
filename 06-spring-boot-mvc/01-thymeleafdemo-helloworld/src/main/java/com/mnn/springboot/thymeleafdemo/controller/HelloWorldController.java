package com.mnn.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need a controller method to show initial form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // need a controller method to read form data and also add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letShoutDude(HttpServletRequest request, Model model) {
        // read the request parameter from the HTML form
        String name = request.getParameter("studentName");

        // convert the data to all caps
        name = name.toUpperCase();

        // create the message
        String result = "Yo " + name;

        // add message to the model
        model.addAttribute("message", result);
        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model) {

        // convert the data to all caps
        name = name.toUpperCase();

        // create the message
        String result = "Hey my friend from V3, " + name;

        // add message to the model
        model.addAttribute("message", result);
        return "helloworld";
    }
}

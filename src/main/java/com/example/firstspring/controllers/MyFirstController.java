package com.example.firstspring.controllers;

import com.example.firstspring.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class MyFirstController {

    @GetMapping("/first")
    public ModelAndView showUserName(){
        return new ModelAndView("index").addObject("username", "Majsan");
    }

    @GetMapping("/withModel")
    public String showUserNameWithModel(Model model){
        model.addAttribute("username", "Majsan");
        return "index";
    }

    @GetMapping("/user")
    public ModelAndView showUser(){
        return new ModelAndView("showUser", "user", new User("Majsan Lund"));

    }

    @RequestMapping(value = "/user/{name}", method= GET)
    @ResponseBody
    public User createUser(@PathVariable("name") String name){
        return new User(name);
    }

    @RequestMapping(value = "/user/requestParam", method= GET)
    @ResponseBody
    public User createUserRequestParam(@RequestParam("name") String name){
        return new User(name);
    }


    @GetMapping("/json")
    @ResponseBody
    public User getJson(){
        return new User("Majsan");
    }

    @GetMapping("list")
    public ModelAndView showList(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Hejsan");
        list.add("Hej");
        list.add("Test");

        return new ModelAndView("list").addObject("list", list);
    }



}

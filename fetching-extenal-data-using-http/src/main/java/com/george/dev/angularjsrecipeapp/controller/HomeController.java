package com.george.dev.angularjsrecipeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by George on 24/11/2018
 */

@Controller
public class HomeController {

    @RequestMapping({"/","/index","/home"})
    public String indexPage(){
        return "index";
    }

}

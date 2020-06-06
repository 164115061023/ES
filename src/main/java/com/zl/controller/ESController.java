package com.zl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ES")
public class ESController {


    @RequestMapping("/start")
    public String ES(){
        return "/ES";
    }

}

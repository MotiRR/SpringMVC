package org.vtb.edu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {

    @RequestMapping("/app")
    public String showIndex() {
        return "index";
    }
}

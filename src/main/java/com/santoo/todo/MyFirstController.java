package com.santoo.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyFirstController {
    @RequestMapping("/")
    public String index(){
        return "Test";
    }
}

package com.lizhengyu.train;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/hello")
    public String hello(){
        System.out.println("热部署");
        System.out.println("热部署");
        return "Hello World123sssss11111232";

    }
}

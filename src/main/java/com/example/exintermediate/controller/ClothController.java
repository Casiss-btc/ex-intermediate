package com.example.exintermediate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediate.domain.Cloth;
import com.example.exintermediate.form.ClothForm;
import com.example.exintermediate.service.ClothService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cloth")
public class ClothController {
    @Autowired
    private ClothService clothService;
    @Autowired
    private HttpSession session;
    @GetMapping()
    public String index(ClothForm form) {
        
        return "clothform";
    }
    @PostMapping("/search")
    public String search(ClothForm form) {
        System.out.println(form.getGender());
        System.out.println(form.getColor());
        Integer gender = form.getGender();
        String color = form.getColor();
        Cloth cloth = clothService.find(gender, color);
        session.setAttribute("cloth", cloth);
        return "clothform";
    }

}

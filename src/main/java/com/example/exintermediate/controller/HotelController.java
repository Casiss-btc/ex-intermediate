package com.example.exintermediate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediate.domain.Hotel;
import com.example.exintermediate.form.HotelForm;
import com.example.exintermediate.service.HotelService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelservice;
    @Autowired
    private HttpSession session;
    @GetMapping("")
    public String index(HotelForm form) {
        return "hotelform";
    }
    @GetMapping("/search")
    public String search(HotelForm form) {
        if(form.getPrice()==null) {
            Integer price = 1000000000;
            List<Hotel> hotelList = hotelservice.findByPrice(price);
            session.setAttribute("hotelList", hotelList);
            return "hotelform";
        }
        Integer price = form.getPrice();
        List<Hotel> hotelList = hotelservice.findByPrice(price);
        session.setAttribute("hotelList", hotelList);
        return "hotelform";
    }
    
}

package com.example.exintermediate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediate.domain.Team;
import com.example.exintermediate.service.TeamService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private HttpSession session;
    @GetMapping("/showList")
    public String showList() {
        List<Team> teamList = teamService.showList();
        session.setAttribute("teamList",teamList);
        return "teamlist";
    }
    @GetMapping("/showDetail")
    public String showDetail(String id) {
        int teamId = Integer.valueOf(id);
        Team team = teamService.showDetail(teamId);
        session.setAttribute("team",team);
        return "teamdetails";
    }
    @PostMapping("/back")
    public String back() {
        return "/teamlist";
    }
}

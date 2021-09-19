package com.mhasandev.CoronavirusTrackerApp.controller;

import com.mhasandev.CoronavirusTrackerApp.entity.TrackingStats;
import com.mhasandev.CoronavirusTrackerApp.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    Services services;
    @GetMapping("/")
    public String home(Model model){
        List<TrackingStats> trackingStats=services.getRecords();
        int totalCases=trackingStats.stream().mapToInt(stat->stat.getCases()).sum();
        model.addAttribute("trackingStats",trackingStats);
        model.addAttribute("totalCases",totalCases);
       return "home";
    }
}

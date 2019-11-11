package com.afitnerd.doyouknowaracist.controller;

import com.afitnerd.doyouknowaracist.model.RacistResponse;
import com.afitnerd.doyouknowaracist.service.RacistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    RacistService racistService;

    public HomeController(RacistService racistService) {
        this.racistService = racistService;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @PostMapping
    public ModelAndView isRacist(@RequestParam String email) {
        RacistResponse response = racistService.isRacist(email);
        ModelAndView mav = new ModelAndView();
        mav.addObject("racist", response.getRacist());
        mav.addObject("email", email);
        mav.setViewName("results");
        return mav;
    }
}

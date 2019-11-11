package com.afitnerd.doyouknowaracist.controller;

import com.afitnerd.doyouknowaracist.model.RacistResponse;
import com.afitnerd.doyouknowaracist.service.RacistService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RacistController {

    private RacistService racistService;

    public RacistController(RacistService racistService) {
        this.racistService = racistService;
    }

    @GetMapping("/is_racist/{email}")
    public RacistResponse isRacist(@PathVariable String email) {
        return racistService.isRacist(email);
    }
}

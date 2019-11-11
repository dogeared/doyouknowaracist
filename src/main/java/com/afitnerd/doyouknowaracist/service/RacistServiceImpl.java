package com.afitnerd.doyouknowaracist.service;

import com.afitnerd.doyouknowaracist.model.Racist;
import com.afitnerd.doyouknowaracist.model.RacistResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RacistServiceImpl implements RacistService {


    @Value("#{ @environment['racists'] }")
    private List<String> racistsRaw;

    private List<String> racists;

    @PostConstruct
    void setup() {
        racists = racistsRaw.stream()
            .map(String::toLowerCase)
            .collect(Collectors.toList());

        // don't need it anymore
        racistsRaw = null;
    }

    @Override
    public RacistResponse isRacist(String email) {
        Racist racist = racists.contains(email.toLowerCase()) ? Racist.PROBABLY : Racist.UNKNOWN;
        return new RacistResponse(racist);
    }
}

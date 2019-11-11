package com.afitnerd.doyouknowaracist.service;

import com.afitnerd.doyouknowaracist.model.Racist;
import com.afitnerd.doyouknowaracist.model.RacistResponse;

public interface RacistService {

    RacistResponse isRacist(String email);
}

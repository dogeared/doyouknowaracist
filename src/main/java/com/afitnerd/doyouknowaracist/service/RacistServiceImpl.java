package com.afitnerd.doyouknowaracist.service;

import com.afitnerd.doyouknowaracist.model.Racist;
import com.afitnerd.doyouknowaracist.model.RacistResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.zip.GZIPInputStream;

@Service
public class RacistServiceImpl implements RacistService {


    @Value("#{ @environment['racists'] }")
    private String racistsB64;

    private List<String> racists;

    @PostConstruct
    void setup() throws IOException {
        racists = Arrays.asList(parseRacists());

        // don't need it anymore
        racistsB64 = null;
    }

    private String[] parseRacists() throws IOException  {
        byte[] decodedBytes = Base64.getMimeDecoder().decode(racistsB64);
        GZIPInputStream gzippedData = new GZIPInputStream(new ByteArrayInputStream(decodedBytes));
        byte[] buffer = new byte[1024];
        int len;
        StringBuilder delimitedRacists = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader(gzippedData, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c;
            while ((c = reader.read()) != -1) {
                delimitedRacists.append((char) c);
            }
        }
        gzippedData.close();
        return delimitedRacists.toString().split("\n");
    }

    @Override
    public RacistResponse isRacist(String email) {
        Racist racist = racists.contains(email.toLowerCase()) ? Racist.PROBABLY : Racist.UNKNOWN;
        return new RacistResponse(racist);
    }
}

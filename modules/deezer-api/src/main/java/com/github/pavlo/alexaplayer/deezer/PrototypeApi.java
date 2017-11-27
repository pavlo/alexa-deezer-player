package com.github.pavlo.alexaplayer.deezer;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;

public class PrototypeApi {

    private static final String DEEZER_API_URL = "https://api.deezer.com";
    private static final OkHttpClient CLIENT = new OkHttpClient();

    private static final Logger log = LoggerFactory.getLogger(PrototypeApi.class);

    public void sampleSearch(String artist, String accessToken) {

        log.debug("Entered sampleSearch");

        String searchUrl = String.format("%s/search?q=artist:\"%s\"&access_token=%s", DEEZER_API_URL, artist, accessToken);
        log.debug("Search URL: {}", searchUrl);
        Request request = new Request.Builder().url(searchUrl).build();

        try {
            Response response = CLIENT.newCall(request).execute();
            log.debug("Got response code: {}", response.code());

            if (response.body() != null) {
                log.debug("Response body:{}", response.body().string());
            } else {
                log.debug("Got no response body!");

            }
        }
        catch (IOException e) {
            log.error("Failed to call search API", e);
        }
    }

}

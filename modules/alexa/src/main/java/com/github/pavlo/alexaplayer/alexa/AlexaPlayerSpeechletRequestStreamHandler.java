package com.github.pavlo.alexaplayer.alexa;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

import java.util.HashSet;
import java.util.Set;

public final class AlexaPlayerSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {
    private static final Set<String> supportedApplicationIds;
    static {
        supportedApplicationIds = new HashSet<>();
        supportedApplicationIds.add(System.getenv("APPLICATION_ID"));
    }

    public AlexaPlayerSpeechletRequestStreamHandler() {
        super(new AlexaPlayerSpeechlet(), supportedApplicationIds);
    }
}

package com.github.pavlo.alexaplayer.alexa;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.speechlet.interfaces.audioplayer.AudioPlayer;
import com.amazon.speech.speechlet.interfaces.audioplayer.request.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlexaPlayerSpeechlet implements SpeechletV2 , AudioPlayer {

    private static final Logger log = LoggerFactory.getLogger(AlexaPlayerSpeechlet.class);

    @Override
    public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
        log.debug("onLaunch entered...");
        return null;
    }

    @Override
    public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {
        log.debug("onSessionStarted entered...");
    }

    @Override
    public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
        log.debug("onSessionEnded entered...");
    }

    @Override
    public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {

        User user = requestEnvelope.getSession().getUser();

        log.debug("onIntent requestId={}, sessionId={} accessToken={} userId={} appId={}",
                requestEnvelope.getRequest().getRequestId(),
                requestEnvelope.getSession().getSessionId(),
                user.getAccessToken(),
                user.getUserId(),
                requestEnvelope.getSession().getApplication().getApplicationId()
        );

        if (user.getAccessToken() == null) {
            return ResponseUtils.simpleSpeech("The still is not linked to your Deezer.com account, " +
                    "please link it in the Alexa app and then try again!");
        }

        Intent intent = requestEnvelope.getRequest().getIntent();
        String intentName = (intent != null) ? intent.getName() : null;
        log.debug("intent={}", intentName);


        if ("SampleSearch".equals(intentName)) {
            return ResponseUtils.simpleSpeech("SampleSearch is not yet implemented!");
        }
        else if ("SamplePlayback".equals(intentName)) {
            return ResponseUtils.simpleSpeech("SamplePlayback is not yet implemented");
        }
        else {
            return ResponseUtils.simpleSpeech("Unknown command received");
        }
    }

    @Override
    public SpeechletResponse onPlaybackFailed(SpeechletRequestEnvelope<PlaybackFailedRequest> requestEnvelope) {
        log.debug("onPlaybackFailed entered...");
        return null;
    }

    @Override
    public SpeechletResponse onPlaybackFinished(SpeechletRequestEnvelope<PlaybackFinishedRequest> requestEnvelope) {
        log.debug("onPlaybackFinished entered...");
        return null;
    }

    @Override
    public SpeechletResponse onPlaybackNearlyFinished(SpeechletRequestEnvelope<PlaybackNearlyFinishedRequest> requestEnvelope) {
        log.debug("onPlaybackNearlyFinished entered...");
        return null;
    }

    @Override
    public SpeechletResponse onPlaybackStarted(SpeechletRequestEnvelope<PlaybackStartedRequest> requestEnvelope) {
        log.debug("onPlaybackStarted");
        return null;
    }

    @Override
    public SpeechletResponse onPlaybackStopped(SpeechletRequestEnvelope<PlaybackStoppedRequest> requestEnvelope) {
        log.debug("onPlaybackStopped");
        return null;
    }
}

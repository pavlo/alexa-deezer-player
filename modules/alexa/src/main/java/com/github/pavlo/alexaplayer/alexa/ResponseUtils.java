package com.github.pavlo.alexaplayer.alexa;

import com.amazon.speech.speechlet.Directive;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.interfaces.audioplayer.AudioItem;
import com.amazon.speech.speechlet.interfaces.audioplayer.PlayBehavior;
import com.amazon.speech.speechlet.interfaces.audioplayer.Stream;
import com.amazon.speech.speechlet.interfaces.audioplayer.directive.PlayDirective;
import com.amazon.speech.speechlet.interfaces.audioplayer.directive.StopDirective;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ResponseUtils {

    private static final Logger log = LoggerFactory.getLogger(ResponseUtils.class);

    public static SpeechletResponse playFile(String url, String token, long offset, String intoSpeech) {
        Stream stream = new Stream();
        stream.setUrl(url);
        stream.setToken(token);
        stream.setOffsetInMilliseconds(offset);

        AudioItem audioItem = new AudioItem();
        audioItem.setStream(stream);

        PlayDirective playDirective = new PlayDirective();
        playDirective.setAudioItem(audioItem);
        playDirective.setPlayBehavior(PlayBehavior.REPLACE_ALL);

        List<Directive> directives = new ArrayList<>();
        directives.add(playDirective);

        SpeechletResponse result = new SpeechletResponse();

        if (intoSpeech != null) {
            PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
            speech.setText(intoSpeech);
            result.setOutputSpeech(speech);
        }

        result.setDirectives(directives);
        return result;
    }

    public static SpeechletResponse enqueueFile(String url, String token, String expectedToken, long offset) {
        Stream stream = new Stream();
        stream.setUrl(url);
        stream.setToken(token);
        stream.setExpectedPreviousToken(expectedToken);
        stream.setOffsetInMilliseconds(offset);

        AudioItem audioItem = new AudioItem();
        audioItem.setStream(stream);

        PlayDirective playDirective = new PlayDirective();
        playDirective.setAudioItem(audioItem);
        playDirective.setPlayBehavior(PlayBehavior.ENQUEUE);


        List<Directive> directives = new ArrayList<>();
        directives.add(playDirective);

        SpeechletResponse result = new SpeechletResponse();
        result.setDirectives(directives);

        return result;
    }

    public static SpeechletResponse stopPlayback() {

        Directive stopDirective = new StopDirective();
        List<Directive> directives = new ArrayList<>();
        directives.add(stopDirective);

        SpeechletResponse response = new SpeechletResponse();
        response.setDirectives(directives);

        return response;
    }

    public static SpeechletResponse simpleSpeech(String text) {
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(text);

        SpeechletResponse result = new SpeechletResponse();
        result.setOutputSpeech(speech);
        return result;
    }


}

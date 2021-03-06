package lu.mir.android.pomodorobox.util;

import java.util.Locale;

import android.content.Context;
import android.speech.tts.TextToSpeech;

public class EnglishSpeechEngine extends TextToSpeech {

	public EnglishSpeechEngine(Context context, OnInitListener listener) {
		super(context, listener);
	}
	
	public void speak(String text) {
		setLanguage(Locale.US);
		speak(text, TextToSpeech.QUEUE_ADD, null);
	}



}

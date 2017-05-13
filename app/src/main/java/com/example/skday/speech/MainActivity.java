package com.example.skday.speech;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etText;
    Button btnPlay;
    TextToSpeech toSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etText = (EditText) findViewById(R.id.et_text);
        btnPlay = (Button) findViewById(R.id.btn_play);
        toSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                toSpeech.setLanguage(new Locale("id", "ID"));
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    toSpeech.speak(etText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);
                }else{
                    toSpeech.speak(etText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });
    }
}

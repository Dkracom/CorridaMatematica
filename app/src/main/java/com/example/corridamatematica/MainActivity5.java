package com.example.corridamatematica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import static android.os.SystemClock.elapsedRealtime;

public class MainActivity5 extends AppCompatActivity {

    private long pauseOffset;
    private boolean running;
    Chronometer chronometer;
    Button tentenov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle paramss = intent.getExtras();
            if (paramss != null) {
                Long pauseOffsets = paramss.getLong("pauseOffsets");//////////////////////
                Integer erros = paramss.getInt("erro");
                pauseOffset = pauseOffsets;
                TextView textofinal = findViewById(R.id.textView10);
                if (erros >= 3){
                    textofinal.setText("Que pena, com 3 tentativas erradas o jogo acaba , ou você cancelou o jogo!");
                }else {
                    textofinal.setText("Parabéns, você acertou todas as questões. Que tal tentar num nível mais difícil?");
                }
            }
        }

        //CRONOMETRO
        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Seu tempo de jogo foi de: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());
        startChronometer();
        pauseChronometer();

        tentenov = (Button) findViewById(R.id.button);
        tentenov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity5.this, MainActivity3.class);
                startActivity(i);
            }
        });

    }

    //FUNCOES CRONOMETRO
    public void startChronometer() {
        if (!running) {
            chronometer.setBase(elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }
    }
    public void pauseChronometer() {
        if (running) {
            chronometer.stop();
            pauseOffset = elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }
    public void resetChronometer() {
        chronometer.setBase(elapsedRealtime());
        pauseOffset = 0;
    }
}
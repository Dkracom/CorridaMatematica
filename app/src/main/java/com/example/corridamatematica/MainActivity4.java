package com.example.corridamatematica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        TextView texto1 = findViewById(R.id.textView8);
        texto1.setText("- A aplicação propõe desafios matemáticos para crianças e adolescentes, com o intuito de testar seus conhecimentos matemáticos e aprimorá-los.\n\n"+"- O jogador deverá selecionar a operação desejada e o nível da operação, quanto maior o nível mais difícil será o teste. \n\n"+"- Se o jogador errar uma resposta receberá feedback visual e auditivo, assim como acréscimo de dez segundos no cronômetro, o qual inicia a contagem quando o jogo começa.\n\n"+"- Seu desafio é cumprir com todos os testes em todos os níveis para se tornar o rei dos cálculos, está preparado para isso?\n\n");
    }
}
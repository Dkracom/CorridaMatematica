package com.example.corridamatematica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    public static final int CONSTANT_TELA7 = 1;
    private long pauseOffset;
    ImageButton play, Inst, adicao,sub, div, mult, niv1, niv2, niv3, niv4, niv5;
    Integer sinais,niveis,questoes, erro, auxresps,aux;
    EditText nomes;
    String nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Inst = (ImageButton) findViewById(R.id.imageButton2);
        Inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(i);
            }
        });

        play = (ImageButton) findViewById(R.id.imageButton);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sinais == null){
                    Toast.makeText(MainActivity3.this, "Faltou escolher o cálculo!", Toast.LENGTH_SHORT).show();
                }else if (niveis == null) {
                    Toast.makeText(MainActivity3.this, "Escolha um nÍvel!", Toast.LENGTH_SHORT).show();
                }else{
                    int[] resp1 = new int[10];
                    int[] resp2 = new int[10];
                    for (aux = 0; aux < 10; aux++){
                        resp1[aux]=0;
                        resp2[aux]=0;
                    }
                    nomes = (EditText) findViewById(R.id.editTextNome);
                    nome = nomes.getText().toString();
                    if (nome == "Escreva seu Nome aqui")
                    {
                        nome = null;
                    }
                    if (nome == "")
                    {
                        nome = null;
                    }
                    auxresps = sortearordem();
                    Bundle params = new Bundle();
                    params.putInt("sinais", sinais);
                    params.putInt("niveis", niveis);
                    params.putInt("questoes", questoes);
                    params.putInt("erro", erro);
                    params.putString("nome", nome);
                    params.putLong("pauseOffsets", pauseOffset);
                    params.putInt("auxresps", auxresps);
                    params.putIntArray("resp1", resp1);
                    params.putIntArray("resp2", resp2);
                    Intent i = new Intent(MainActivity3.this, MainActivity7.class);
                    i.putExtras(params);
                    startActivityForResult(i, CONSTANT_TELA7);
                }
            }
        });
        adicao = (ImageButton) findViewById(R.id.imageButton5);
        sub = (ImageButton) findViewById(R.id.imageButton6);
        div = (ImageButton) findViewById(R.id.imageButton7);
        mult = (ImageButton) findViewById(R.id.imageButton8);

        adicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicao.setImageResource(R.drawable.mais_com_v);
                sub.setImageResource(R.drawable.menos_sem_v);
                div.setImageResource(R.drawable.dividiso_sem_v);
                mult.setImageResource(R.drawable.vezes_sem_v);
                sinais = 10;
                questoes=1;

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicao.setImageResource(R.drawable.mais_sem_v);
                sub.setImageResource(R.drawable.menos_com_v);
                div.setImageResource(R.drawable.dividiso_sem_v);
                mult.setImageResource(R.drawable.vezes_sem_v);
                sinais = 20;
                questoes=1;
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicao.setImageResource(R.drawable.mais_sem_v);
                sub.setImageResource(R.drawable.menos_sem_v);
                div.setImageResource(R.drawable.dividido_com_v);
                mult.setImageResource(R.drawable.vezes_sem_v);
                sinais = 30;
                questoes=1;
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicao.setImageResource(R.drawable.mais_sem_v);
                sub.setImageResource(R.drawable.menos_sem_v);
                div.setImageResource(R.drawable.dividiso_sem_v);
                mult.setImageResource(R.drawable.vezes_com_v);
                sinais = 40;
                questoes=1;
            }
        });

        niv1 = (ImageButton) findViewById(R.id.imageButton9);
        niv2 = (ImageButton) findViewById(R.id.imageButton10);
        niv3 = (ImageButton) findViewById(R.id.imageButton11);
        niv4 = (ImageButton) findViewById(R.id.imageButton12);
        niv5 = (ImageButton) findViewById(R.id.imageButton13);
        niv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                niv1.setImageResource(R.drawable.umcomv);
                niv2.setImageResource(R.drawable.doissemv);
                niv3.setImageResource(R.drawable.tressemv);
                niv4.setImageResource(R.drawable.quatrosemv);
                niv5.setImageResource(R.drawable.cincosemv);
                niveis = 1;
            }
        });

        niv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                niv1.setImageResource(R.drawable.umsemv);
                niv2.setImageResource(R.drawable.doiscomv);
                niv3.setImageResource(R.drawable.tressemv);
                niv4.setImageResource(R.drawable.quatrosemv);
                niv5.setImageResource(R.drawable.cincosemv);
                niveis = 2;
            }
        });

        niv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                niv1.setImageResource(R.drawable.umsemv);
                niv2.setImageResource(R.drawable.doissemv);
                niv3.setImageResource(R.drawable.trescomv);
                niv4.setImageResource(R.drawable.quatrosemv);
                niv5.setImageResource(R.drawable.cincosemv);
                niveis = 3;

            }
        });

        niv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                niv1.setImageResource(R.drawable.umsemv);
                niv2.setImageResource(R.drawable.doissemv);
                niv3.setImageResource(R.drawable.tressemv);
                niv4.setImageResource(R.drawable.quatrocomv);
                niv5.setImageResource(R.drawable.cincosemv);
                niveis = 4;

            }
        });

        niv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                niv1.setImageResource(R.drawable.umsemv);
                niv2.setImageResource(R.drawable.doissemv);
                niv3.setImageResource(R.drawable.tressemv);
                niv4.setImageResource(R.drawable.quatrosemv);
                niv5.setImageResource(R.drawable.cincocomv);
                niveis = 5;
            }
        });
        erro = 0;

    }//final oncreate
    private int sortearordem() {
        Integer numero = new Random().nextInt(3);
        numero = numero + 1;
        return numero;
    }
    public void clearLog(View view) {
        nomes = (EditText) findViewById(R.id.editTextNome);
        nomes.setText("");
        nomes.clearComposingText();
    }
}
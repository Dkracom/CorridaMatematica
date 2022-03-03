package com.example.corridamatematica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.Random;

import static android.os.SystemClock.elapsedRealtime;

public class MainActivity7 extends AppCompatActivity {

    private long pauseOffset;
    private boolean running;
    public static final int CONSTANT_TELA7 = 1;
    public static final int CONSTANT_TELA5 = 1;
    Chronometer chronometer;
    Button canc, bt1, bt2, bt3, bt4;
    Integer sinal, nivel, numero1, numero2, questao, erro, numero3, aux, b1, b2, b3, b4, resultado, varrand,auxresp;
    String nomes;
    int[] resp1aux;
    int[] resp2aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        final MediaPlayer certos = MediaPlayer.create(MainActivity7.this, R.raw.certo);
        final MediaPlayer errados = MediaPlayer.create(MainActivity7.this, R.raw.errado);
        final MediaPlayer gameover = MediaPlayer.create(MainActivity7.this, R.raw.game_over);
        final MediaPlayer sucesso = MediaPlayer.create(MainActivity7.this, R.raw.fim_jogo_sucesso);
        final MediaPlayer rodando = MediaPlayer.create(MainActivity7.this, R.raw.tempo_rodando);

        //CRONOMETRO
        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Tempo: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                /*if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 100000) {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(MainActivity7.this, "Bing!", Toast.LENGTH_SHORT).show();
                }*/
            }
        });


        bt1 = (Button) findViewById(R.id.button5);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b1 == 3){
                    rodando.stop();
                    bt1.setBackgroundColor(getResources().getColor(R.color.sua_cor_pressionado));
                    TextView botoes = findViewById(R.id.textView17);
                    botoes.setText(" RESPOSTA CORRETA ");
                    questao = questao + 1;
                    if (questao < 11){
                        certos.start();
                    }else {
                        sucesso.start();
                    }
                    pauseChronometer();
                    Bundle params = new Bundle();
                    params.putInt("sinais", sinal);
                    params.putInt("niveis", nivel);
                    params.putInt("questoes", questao);
                    params.putInt("erro", erro);
                    params.putString("nome", nomes);
                    params.putLong("pauseOffsets",pauseOffset);
                    params.putInt("auxresps", auxresp);
                    params.putIntArray("resp1", resp1aux);
                    params.putIntArray("resp2", resp2aux);
                    Intent i = new Intent(MainActivity7.this, MainActivity7.class);
                    i.putExtras(params);
                    startActivityForResult(i, CONSTANT_TELA7);
                }else {
                    bt1.setBackgroundColor(getResources().getColor(R.color.vermelho));
                    TextView botoes = findViewById(R.id.textView17);
                    botoes.setText(" RESPOSTA ERRADA ");
                    erro = erro + 1;
                    pauseChronometer();
                    pauseOffset = pauseOffset + 10000;
                    startChronometer();
                    if (erro == 3){
                        rodando.stop();
                        gameover.start();
                        Bundle paramss = new Bundle();
                        paramss.putLong("pauseOffsets",pauseOffset);
                        paramss.putInt("erro", erro);
                        Intent i = new Intent(MainActivity7.this, MainActivity5.class);
                        i.putExtras(paramss);
                        startActivityForResult(i, CONSTANT_TELA5);
                    }else {
                        errados.start();
                    }
                }
            }
        });

        bt2 = (Button) findViewById(R.id.button6);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b2 == 3){
                    rodando.stop();
                    bt2.setBackgroundColor(getResources().getColor(R.color.sua_cor_pressionado));
                    TextView botoes = findViewById(R.id.textView17);
                    botoes.setText(" RESPOSTA CORRETA ");
                    questao = questao + 1;
                    if (questao < 11){
                        certos.start();
                    }else {
                        sucesso.start();
                    }
                    pauseChronometer();
                    Bundle params = new Bundle();
                    params.putInt("sinais", sinal);
                    params.putInt("niveis", nivel);
                    params.putInt("questoes", questao);
                    params.putInt("erro", erro);
                    params.putString("nome", nomes);
                    params.putLong("pauseOffsets",pauseOffset);
                    params.putInt("auxresps", auxresp);
                    params.putIntArray("resp1", resp1aux);
                    params.putIntArray("resp2", resp2aux);
                    Intent i = new Intent(MainActivity7.this, MainActivity7.class);
                    i.putExtras(params);
                    startActivityForResult(i, CONSTANT_TELA7);
                }else {
                    bt2.setBackgroundColor(getResources().getColor(R.color.vermelho));
                    TextView botoes = findViewById(R.id.textView17);
                    botoes.setText(" RESPOSTA ERRADA ");
                    erro = erro + 1;
                    pauseChronometer();
                    pauseOffset = pauseOffset + 10000;
                    startChronometer();
                    if (erro == 3){
                        rodando.stop();
                        gameover.start();
                        Bundle paramss = new Bundle();
                        paramss.putLong("pauseOffsets",pauseOffset);
                        paramss.putInt("erro", erro);
                        Intent i = new Intent(MainActivity7.this, MainActivity5.class);
                        i.putExtras(paramss);
                        startActivityForResult(i, CONSTANT_TELA5);
                    }else {
                        errados.start();
                    }
                }
            }
        });

        bt3 = (Button) findViewById(R.id.button16);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b3 == 3){
                    rodando.stop();
                    bt3.setBackgroundColor(getResources().getColor(R.color.sua_cor_pressionado));
                    TextView botoes = findViewById(R.id.textView17);
                    botoes.setText(" RESPOSTA CORRETA ");
                    questao = questao + 1;
                    if (questao < 11){
                        certos.start();
                    }else {
                        sucesso.start();
                    }
                    pauseChronometer();
                    Bundle params = new Bundle();
                    params.putInt("sinais", sinal);
                    params.putInt("niveis", nivel);
                    params.putInt("questoes", questao);
                    params.putInt("erro", erro);
                    params.putString("nome", nomes);
                    params.putLong("pauseOffsets",pauseOffset);
                    params.putInt("auxresps", auxresp);
                    params.putIntArray("resp1", resp1aux);
                    params.putIntArray("resp2", resp2aux);
                    Intent i = new Intent(MainActivity7.this, MainActivity7.class);
                    i.putExtras(params);
                    startActivityForResult(i, CONSTANT_TELA7);
                }else {
                    bt3.setBackgroundColor(getResources().getColor(R.color.vermelho));
                    TextView botoes = findViewById(R.id.textView17);
                    botoes.setText(" RESPOSTA ERRADA ");
                    erro = erro + 1;
                    pauseChronometer();
                    pauseOffset = pauseOffset + 10000;
                    startChronometer();
                    if (erro == 3){
                        rodando.stop();
                        gameover.start();
                        Bundle paramss = new Bundle();
                        paramss.putLong("pauseOffsets",pauseOffset);
                        paramss.putInt("erro", erro);
                        Intent i = new Intent(MainActivity7.this, MainActivity5.class);
                        i.putExtras(paramss);
                        startActivityForResult(i, CONSTANT_TELA5);
                    }else {
                        errados.start();
                    }
                }
            }
        });

        bt4 = (Button) findViewById(R.id.button17);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b4 == 3){
                    rodando.stop();
                    bt4.setBackgroundColor(getResources().getColor(R.color.sua_cor_pressionado));
                    TextView botoes = findViewById(R.id.textView17);
                    botoes.setText(" RESPOSTA CORRETA ");
                    if (questao < 11){
                        certos.start();
                    }else {
                        sucesso.start();
                    }
                    questao = questao + 1;
                    pauseChronometer();
                    Bundle params = new Bundle();
                    params.putInt("sinais", sinal);
                    params.putInt("niveis", nivel);
                    params.putInt("questoes", questao);
                    params.putInt("erro", erro);
                    params.putString("nome", nomes);
                    params.putLong("pauseOffsets",pauseOffset);
                    params.putInt("auxresps", auxresp);
                    params.putIntArray("resp1", resp1aux);
                    params.putIntArray("resp2", resp2aux);
                    Intent i = new Intent(MainActivity7.this, MainActivity7.class);
                    i.putExtras(params);
                    startActivityForResult(i, CONSTANT_TELA7);
                }else {
                    bt4.setBackgroundColor(getResources().getColor(R.color.vermelho));
                    TextView botoes = findViewById(R.id.textView17);
                    botoes.setText(" RESPOSTA ERRADA ");
                    erro = erro + 1;
                    pauseChronometer();
                    pauseOffset = pauseOffset + 10000;
                    startChronometer();
                    if (erro == 3){
                        rodando.stop();
                        gameover.start();
                        Bundle paramss = new Bundle();
                        paramss.putLong("pauseOffsets",pauseOffset);
                        paramss.putInt("erro", erro);
                        Intent i = new Intent(MainActivity7.this, MainActivity5.class);
                        i.putExtras(paramss);
                        startActivityForResult(i, CONSTANT_TELA5);
                    }else {
                        errados.start();
                    }
                }
            }
        });

        canc = (Button) findViewById(R.id.button18);
        canc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                erro = 3;
                rodando.stop();
                gameover.start();
                pauseChronometer();
                Bundle paramss = new Bundle();
                paramss.putLong("pauseOffsets",pauseOffset);
                paramss.putInt("erro", erro);
                Intent i = new Intent(MainActivity7.this, MainActivity5.class);
                i.putExtras(paramss);
                startActivityForResult(i, CONSTANT_TELA5);
                //certos.release();
                //errados.release();
                //sucesso.release();
                //gameover.release();
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            Bundle params = intent.getExtras();
            if (params != null) {
                Integer niveis = params.getInt("niveis");
                Integer sinais = params.getInt("sinais");
                Integer questoes = params.getInt("questoes");
                Integer erros = params.getInt("erro");
                String nome = params.getString("nome");
                Long pauseOffsets = params.getLong("pauseOffsets");
                int auxresps = params.getInt("auxresps");
                int[] resp1 = params.getIntArray("resp1");
                int[] resp2 = params.getIntArray("resp2");
                resp1aux = resp1;
                resp2aux = resp2;
                auxresp = auxresps;
                pauseOffset = pauseOffsets;
                sinal = sinais;
                nivel = niveis;
                questao=questoes;
                erro = erros;
                nomes = nome;
                startChronometer();
                if (questoes < 11) {
                    TextView teste1 = findViewById(R.id.textView15);
                    if (nome != null)
                    {
                        nome = nome + " - ";
                    }
                    teste1.setText(nome + " QUESTÃO " + questoes + " / 10");
                    rodando.start();

                    if (sinais == 10) {//OPERACOES ADICAO-----------------------------------------------
                        TextView teste = findViewById(R.id.textView14);
                        teste.setText("ADIÇÃO - Nível: " + nivel);
                        if(niveis == 1){
                            numero1 = soma1();
                            numero2 = soma1();
                            for (aux=0; aux+1 < questoes; aux++){
                                if (resp1aux[aux] == numero1 && resp2aux[aux] == numero2){
                                    numero1 = soma1();
                                    numero2 = soma1();
                                }
                            }
                            resp1aux[questoes-1] = numero1;
                            resp2aux[questoes-1] = numero2;
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1+" + "+numero2);
                            resultado = numero1 + numero2;
                        }else if(niveis == 2){
                            numero1 = soma2();
                            numero2 = soma2();
                            for (aux=0; aux+1 < questoes; aux++){
                                if (resp1aux[aux] == numero1 && resp2aux[aux] == numero2){
                                    numero1 = soma2();
                                    numero2 = soma2();
                                }
                            }
                            resp1aux[questoes-1] = numero1;
                            resp2aux[questoes-1] = numero2;
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1+" + "+numero2);
                            resultado = numero1 + numero2;
                        }else if(niveis == 3){
                            numero1 = soma3();
                            numero2 = soma3();
                            numero3 = soma3();
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1+" + "+numero2+" + "+numero3);
                            resultado = (numero1 + numero2) + numero3;
                        }else if(niveis == 4){
                            numero1 = soma4();
                            numero2 = soma4();
                            for (aux=0; aux+1 < questoes; aux++){
                                if (resp1aux[aux] == numero1 && resp2aux[aux] == numero2){
                                    numero1 = soma4();
                                    numero2 = soma4();
                                }
                            }
                            resp1aux[questoes-1] = numero1;
                            resp2aux[questoes-1] = numero2;
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1+" + "+numero2);
                            resultado = numero1 + numero2;
                        }else{
                            numero1 = soma5();
                            numero2 = soma5();
                            for (aux=0; aux+1 < questoes; aux++){
                                if (resp1aux[aux] == numero1 && resp2aux[aux] == numero2){
                                    numero1 = soma5();
                                    numero2 = soma5();
                                }
                            }
                            resp1aux[questoes-1] = numero1;
                            resp2aux[questoes-1] = numero2;
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1+" + "+numero2);
                            resultado = numero1 + numero2;
                        }
                    }else if (sinais == 20) {//OPERACOES SUBTRACAO--------------------------------------
                        TextView teste = findViewById(R.id.textView14);
                        teste.setText("SUBTRAÇÃO - Nível: " + nivel);
                        if(niveis == 1) {
                            numero1 = sub1();
                            numero2 = sub1();
                            while (numero2 > numero1) {
                                numero2 = sub1();
                            }
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1 + " - " + numero2);
                            resultado = numero1 - numero2;
                        }else if (niveis == 2) {
                            numero1 = sub2();
                            numero2 = sub2();
                            while (numero2 > numero1) {
                                numero2 = sub2();
                            }
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1 + " - " + numero2);
                            resultado = numero1 - numero2;
                        }else if (niveis == 3) {
                            numero1 = sub3();
                            numero2 = sub3();
                            while (numero2 > numero1) {
                                numero2 = sub2();
                            }
                            numero3=sub3();
                            aux=numero2+numero3;
                            while (aux > numero1) {
                                numero3 = sub2();
                                aux=numero2+numero3;
                            }
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1+" - "+numero2+" - "+numero3);
                            resultado = (numero1 - numero2) - numero3;
                        }else if(niveis == 4) {
                            numero1 = sub4();
                            numero2 = sub4();
                            while (numero2 > numero1) {
                                numero2 = sub4();
                            }
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1 + " - " + numero2);
                            resultado = numero1 - numero2;
                        }else{
                            numero1 = sub5();
                            numero2 = sub5();
                            while (numero2 > numero1) {
                                numero2 = sub5();
                            }
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1 + " - " + numero2);
                            resultado = numero1 - numero2;
                        }
                    } else if (sinais == 30) {//OPERACOES DIVISAO-----------------------------------
                        TextView teste = findViewById(R.id.textView14);
                        teste.setText("DIVISÃO - Nível: " + nivel);
                        if(niveis == 1) {
                            numero1 = div1();
                            numero2 = 9;
                            numero3 = numero1 % numero2;
                            while (numero3 != 0) {
                                if (numero2 == 1){
                                    numero2 = 11;
                                }
                                numero2--;
                                numero3 = numero1 % numero2;
                            }
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1 + " / " + numero2);
                            resultado = numero1 / numero2;
                        }else if (niveis == 2){
                            numero1 = div2();
                            numero2 = div2();
                            numero3 = numero1 % numero2;
                            while (numero3 != 0){
                                numero2 = div2();
                                numero3 = numero1 % numero2;
                            }
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1 + " / " + numero2);
                            resultado = numero1 / numero2;
                        }else if (niveis == 3){
                            numero1 = div3();
                            numero2 = 99;
                            numero3 = numero1 % numero2;
                            while (numero3 != 0) {
                                if (numero2 <= 10){
                                    numero2 = 100;
                                    numero1 = div3();
                                }
                                numero2--;
                                numero3 = numero1 % numero2;
                            }
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1 + " / " + numero2);
                            resultado = numero1 / numero2;
                        }else if (niveis == 4){
                            numero1 = div4();
                            numero2 = 99;
                            numero3 = numero1 % numero2;
                            while (numero3 != 0) {
                                if (numero2 <= 10){
                                    numero2 = 100;
                                    numero1 = div4();
                                }
                                numero2--;
                                numero3 = numero1 % numero2;
                            }
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1 + " / " + numero2);
                            resultado = numero1 / numero2;
                        }else {
                            numero1 = div5();
                            numero2 = 999;
                            numero3 = numero1 % numero2;
                            while (numero3 != 0) {
                                if (numero2 <= 100){
                                    numero2 = 1000;
                                    numero1 = div5();
                                }
                                numero2--;
                                numero3 = numero1 % numero2;
                            }
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1 + " / " + numero2);
                            resultado = numero1 / numero2;
                        }
                    } else {//OPERACOES MULTIPLICACAO---------------------------------------------------
                        TextView teste = findViewById(R.id.textView14);
                        teste.setText("MULTIPLICAÇÃO - Nível: " + nivel);
                        if(niveis == 1){
                            numero1 = mult1();
                            numero2 = mult1();
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1+" X "+numero2);
                            resultado = numero1 * numero2;
                        }else if(niveis == 2){
                            numero1 = mult2();
                            numero2 = mult2();
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1+" X "+numero2);
                            resultado = numero1 * numero2;
                        }else if (niveis == 3){
                            numero1 = mult1();
                            numero2 = mult1();
                            numero3 = mult1();
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1+" X "+numero2+" X "+numero3);
                            resultado = (numero1 * numero2) * numero3;
                        }else if (niveis == 4){
                            numero1 = mult4();
                            numero2 = mult4();
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1+" X "+numero2);
                            resultado = numero1 * numero2;
                        }else{
                            numero1 = mult5();
                            numero2 = mult5();
                            TextView teste2 = findViewById(R.id.textView16);
                            teste2.setText(numero1+" X "+numero2);
                            resultado = numero1 * numero2;
                        }
                    }
                    //FUNÇOES VERIFICACAO RESPOSTA------------------------------------------------------
                    /*NUM 3 RESULTADO*/
                    if(auxresp == 1){
                        b1 = sortearordem();
                        b2 = sortearordem();
                        while (b2 == b1){
                            b2 = sortearordem();
                        }
                        b3 = sortearordem();
                        while ((b3 == b1) || (b3 == b2)){
                            b3 = sortearordem();
                        }
                        if (b1 == 3){
                            b4 = 4;
                        }else if (b2 == 3){
                            b4 = 2;
                        }else if (b3 == 3){
                            b4 = 1;
                        }else {
                            b4 = 3;
                        }
                    }else if (auxresp == 2){
                        b2 = sortearordem();
                        b3 = sortearordem();
                        while (b3 == b2){
                            b3 = sortearordem();
                        }
                        b4 = sortearordem();
                        while ((b4 == b2) || (b4 == b3)){
                            b4 = sortearordem();
                        }
                        if (b2 == 3){
                            b1 = 4;
                        }else if (b3 == 3){
                            b1 = 2;
                        }else if (b4 == 3){
                            b1 = 1;
                        }else {
                            b1 = 3;
                        }
                    }else if (auxresp == 3){
                        b3 = sortearordem();
                        b4 = sortearordem();
                        while (b4 == b3){
                            b4 = sortearordem();
                        }
                        b1 = sortearordem();
                        while ((b1 == b4) || (b1 == b3)){
                            b1 = sortearordem();
                        }
                        if (b3 == 3){
                            b2 = 4;
                        }else if (b4 == 3){
                            b2 = 2;
                        }else if (b1 == 3){
                            b2 = 1;
                        }else {
                            b2 = 3;
                        }
                    }else if (auxresp == 4){
                        b4 = sortearordem();
                        b1 = sortearordem();
                        while (b1 == b4){
                            b1 = sortearordem();
                        }
                        b2 = sortearordem();
                        while ((b2 == b4) || (b2 == b1)){
                            b2 = sortearordem();
                        }
                        if (b4 == 3){
                            b3 = 4;
                        }else if (b1 == 3){
                            b3 = 2;
                        }else if (b2 == 3){
                            b3 = 1;
                        }else {
                            b3 = 3;
                        }
                    }
                    if (auxresp == 4){
                        auxresp = 1;
                    } else {
                        auxresp++;
                    }
                    if (b1 == 3){
                        bt1.setText(resultado+"");
                    }else {
                        varrand = randres1(resultado);
                        bt1.setText(varrand+"");
                    }
                    if (b2 == 3){
                        bt2.setText(resultado+"");
                    }else {
                        varrand = randres2(resultado);
                        bt2.setText(varrand+"");
                    }
                    if (b3 == 3){
                        bt3.setText(resultado+"");
                    }else {
                        varrand = randres3(resultado);
                        bt3.setText(varrand+"");
                    }
                    if (b4 == 3){
                        bt4.setText(resultado+"");
                    }else {
                        varrand = randres4(resultado);
                        bt4.setText(varrand+"");
                    }

                } else {
                    //ACABOU O JOGO
                    Bundle paramss = new Bundle();
                    paramss.putLong("pauseOffsets",pauseOffset);
                    Intent i = new Intent(MainActivity7.this, MainActivity5.class);
                    i.putExtras(paramss);
                    startActivityForResult(i, CONSTANT_TELA5);
                }
            }
        }
    }//final oncreate
    //FUNCOES DA SOMA
    private int soma1() {
        Integer numero = new Random().nextInt(9);
        return numero;
    }
    private int soma2() {
        Integer numero = new Random().nextInt(50);
        return numero;
    }
    private int soma3() {
        Integer numero = new Random().nextInt(99);
        return numero;
    }
    private int soma4() {
        Integer numero = new Random().nextInt(949);
        numero = numero + 50;
        return numero;
    }
    private int soma5() {
        Integer numero = new Random().nextInt(9999);
        return numero;
    }
    //FUNCOES DA SUBTRACAO
    private int sub1() {
        Integer numero = new Random().nextInt(9);
        return numero;
    }
    private int sub2() {
        Integer numero = new Random().nextInt(50);
        return numero;
    }
    private int sub3() {
        Integer numero = new Random().nextInt(50);
        return numero;
    }
    private int sub4() {
        Integer numero = new Random().nextInt(949);
        numero = numero + 50;
        return numero;
    }
    private int sub5() {
        Integer numero = new Random().nextInt(9999);
        return numero;
    }
    //FUNCOES DA MULTIPLICACAO----------------------------------------------------------------------
    private int mult1() {
        Integer numero = new Random().nextInt(9);
        return numero;
    }
    private int mult2() {
        Integer numero = new Random().nextInt(20);
        return numero;
    }
    private int mult4() {
        Integer numero = new Random().nextInt(99);
        return numero;
    }
    private int mult5() {
        Integer numero = new Random().nextInt(999);
        return numero;
    }
    //FUNCOES DA DIVISAO----------------------------------------------------------------------------
    private int div1() {
        Integer numero = new Random().nextInt(99);
        while ((numero == 0) || (numero == 1)){
            numero = new Random().nextInt(99);
        }
        return numero;
    }

    private int div2() {
        Integer numero = new Random().nextInt(500);
        while (numero == 0){
            numero = new Random().nextInt(500);
        }
        return numero;
    }

    private int div3() {
        Integer numero = new Random().nextInt(1000);
        while (numero < 500){
            numero = new Random().nextInt(1000);
        }
        return numero;
    }

    private int div4() {
        Integer numero = new Random().nextInt(9999);
        while (numero < 1000){
            numero = new Random().nextInt(9999);
        }
        return numero;
    }

    private int div5() {
        Integer numero = new Random().nextInt(99999);
        while (numero < 10000){
            numero = new Random().nextInt(99999);
        }
        return numero;
    }

    private int divteste() {
        Integer numero = new Random().nextInt(99);
        while (numero < 10){
            numero = new Random().nextInt(99);
        }
        return numero;
    }

    //FUNÇOES DE VERIFICACAO DO RESULTADO-----------------------------------------------------------
    private int sortearordem() {
        Integer numero = new Random().nextInt(3);
        numero = numero + 1;
        return numero;
    }
    private int randres1(Integer resultado) {
        Integer numero = new Random().nextInt(2);
        numero = numero + 1;
        numero = numero + resultado;
        return numero;
    }
    private int randres2(Integer resultado) {
        Integer numero = new Random().nextInt(4);
        numero = numero + 3;
        numero = numero + resultado;
        return numero;
    }
    private int randres3(Integer resultado) {
        Integer numero = new Random().nextInt(6);
        numero = numero + 4;
        numero = numero + resultado;
        return numero;
    }
    private int randres4(Integer resultado) {
        Integer numero = new Random().nextInt(8);
        numero = numero + 5;
        numero = numero + resultado;
        return numero;
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


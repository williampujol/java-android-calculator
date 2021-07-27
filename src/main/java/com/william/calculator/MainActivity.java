package com.william.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero,numeroUm,numeroDois,numeroTres,numeroQuatro,numeroCinco,numeroSeis,numeroSete,numeroOito,numeroNove,
    ponto,soma,subtracao,multiplicacao,divisao,igual,botaoLimpar,botaoHistorico;

    private TextView txtExpressao, txtResultado;

    //protected ArrayList<String> historicoLista = new ArrayList<String>();

    //protected ArrayList<TelaHistorico>lista;

    //TelaHistorico historico = new TelaHistorico();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);

        botaoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build(); // Responsável pelos calculos
                    double resultado = expressao.evaluate(); // método que faz os calculos funcionarem

                    long longResult = (long) resultado; //Está recebendo o resultado

                    if(resultado == (double)longResult){
                        txtResultado.setText((CharSequence) String.valueOf(longResult)); //txtResultado recebe longResult e converte em String
                    }else{
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }

                    /*Salva o resultado no arraylist de Historico*/
                    //historico.adicionaHistorico(String.valueOf(txtExpressao.getText()),resultado);
                    //lista.add(adicionaHistorico);

                }catch (Exception e){

                }
            }
        });

        /*Talvez colocar em um arraylist, e exibir essa lista ao clicar em historico*/
        botaoHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMain = new Intent(getBaseContext(), TelaHistorico.class);
                intentMain.putExtra("chave_expressao", txtExpressao.getText().toString());
                intentMain.putExtra("chave_resultado", txtResultado.getText().toString());


                //Bundle parametros = new Bundle();

                //setando os parametros que a Bundle vai levar
                //parametros.putString("chave_historico", String.valueOf(txtExpressao));

                //Faz a intent levar os dados juntos
                //intentMain.putExtras(parametros);
                startActivity(intentMain);

            }
        });

    }

    /*Adicionando Interface de Click*/
    @Override
    public void onClick(View view) {
        switch (view.getId()){

            /*Numeros*/
            case R.id.bt_0:
                AcrescentarUmaExpressao("0",true);
                break;

            case R.id.bt_1:
                AcrescentarUmaExpressao("1",true);
                break;

            case R.id.bt_2:
                AcrescentarUmaExpressao("2",true);
                break;

            case R.id.bt_3:
                AcrescentarUmaExpressao("3",true);
                break;

            case R.id.bt_4:
                AcrescentarUmaExpressao("4",true);
                break;

            case R.id.bt_5:
                AcrescentarUmaExpressao("5",true);
                break;

            case R.id.bt_6:
                AcrescentarUmaExpressao("6",true);
                break;

            case R.id.bt_7:
                AcrescentarUmaExpressao("7",true);
                break;

            case R.id.bt_8:
                AcrescentarUmaExpressao("8",true);
                break;

            case R.id.bt_9:
                AcrescentarUmaExpressao("9",true);
                break;

            case R.id.bt_ponto:
                AcrescentarUmaExpressao(".",true);
                break;

                /*Operadores logicos*/

            case R.id.bt_mais:
                AcrescentarUmaExpressao("+",false);
                break;

            case R.id.bt_menos:
                AcrescentarUmaExpressao("-",false);
                break;

            case R.id.bt_multiplicar:
                AcrescentarUmaExpressao("*",false);
                break;

            case R.id.bt_dividir:
                AcrescentarUmaExpressao("/",false);
                break;

        }
    }

    private void IniciarComponentes(){
        //Pegando os ID's dos numeros
        numeroZero = findViewById(R.id.bt_0);
        numeroUm = findViewById(R.id.bt_1);
        numeroDois = findViewById(R.id.bt_2);
        numeroTres = findViewById(R.id.bt_3);
        numeroQuatro = findViewById(R.id.bt_4);
        numeroCinco = findViewById(R.id.bt_5);
        numeroSeis = findViewById(R.id.bt_6);
        numeroSete = findViewById(R.id.bt_7);
        numeroOito = findViewById(R.id.bt_8);
        numeroNove = findViewById(R.id.bt_9);

        //Pegando os ID'S operações

        soma = findViewById(R.id.bt_mais);
        subtracao = findViewById(R.id.bt_menos);
        multiplicacao = findViewById(R.id.bt_multiplicar);
        divisao= findViewById(R.id.bt_dividir);
        igual = findViewById(R.id.bt_resultado);
        botaoLimpar = findViewById(R.id.bt_limpar);
        botaoHistorico = findViewById(R.id.bt_historico);

        //ponto
        ponto = findViewById(R.id.bt_ponto);

        //Pegando ID's dos Textos
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_historico_resultado);
    }

    public void AcrescentarUmaExpressao(String string, boolean limparDados) {

        if (txtResultado.getText().equals("")) {
            txtExpressao.setText("");
        }

        if (limparDados) {
            txtResultado.setText(" ");
            //txtExpressao.setText(" "); -não funcionou... Aprender append...
            txtExpressao.append(string); //funciona
        } else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }

    }

}
package com.william.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TelaHistorico extends MainActivity {

    private Button btBack;
    private TextView txtHistoricoExpressao;
    private TextView txtHistoricoResultado;
    public String expressao;
    public String resultado;

    protected ArrayList<String> lista;

    public TelaHistorico(TextView txtHistorico) {
        this.txtHistoricoExpressao = txtHistorico;
    }

    public TelaHistorico() {

    }
    public TelaHistorico( String resultado) {
        this.resultado = resultado;
        //this.expressao = expressao;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_historico);

        txtHistoricoExpressao = findViewById(R.id.txt_historico_expressao);
        txtHistoricoResultado = findViewById(R.id.txt_historico_resultado);
        btBack = findViewById(R.id.bt_back);

        Intent intentHistorico = getIntent();
        Bundle recebeParametros = intentHistorico.getExtras();

        if(recebeParametros != null){

            //lista.add(recebeParametros.getString("chave_resultado"));

            /*for(int i = 0; i < lista.size(); i++){
                txtHistorico.setText((CharSequence) lista);
            }*/

            txtHistoricoExpressao.setText((CharSequence) recebeParametros.getString("chave_expressao"));
            txtHistoricoResultado.setText((CharSequence) recebeParametros.getString("chave_resultado"));
           // Toast.makeText(this, "Se der..." + txtHistorico, Toast.LENGTH_SHORT).show();

        }

        //txtHistorico.setText((CharSequence) historicoLista);

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentHistorico = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intentHistorico);
            }
        });

    }



    public void adicionaHistorico(String expressao,String resultado){
        this.expressao = expressao;
        this.resultado = resultado;

    }




}
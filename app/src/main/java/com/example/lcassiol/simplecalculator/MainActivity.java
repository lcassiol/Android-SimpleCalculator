package com.example.lcassiol.simplecalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView campoTexto;
    float  numeroA = 0;
    String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        campoTexto = (TextView)findViewById(R.id.txtResult);
        campoTexto.setText("0");

    }

    public  void calculate(View view){
        switch (view.getId()){
            case R.id.btnClear:
                campoTexto.setText("0");
                numeroA=0;
                operacao="";
                break;
            case R.id.btnPlus:
                calculaNumeros("+");
                break;
            case R.id.btnMinus:
                calculaNumeros("-");
                break;
            case R.id.btnDiv:
                calculaNumeros("/");
                break;
            case R.id.btnMulti:
                calculaNumeros("*");
                break;
            case R.id.btnResult:
                mostraResultado();
                break;
            default :
                String numb;
                numb = ((Button)view).getText().toString();
                getKeyboard(numb);
                break;
        }
    }


    public void calculaNumeros(String tipoOperacao){
        numeroA = Float.parseFloat(campoTexto.getText().toString());
        operacao = tipoOperacao;
        campoTexto.setText(campoTexto.getText().toString() + tipoOperacao);
    }


    public void getKeyboard(String str)
    {
        //float atualValue = Float.parseFloat(campoTexto.getText().toString());
        String ScrCurrent = campoTexto.getText().toString();//String.valueOf(atualValue);
        float atualValue = Float.parseFloat(campoTexto.getText().toString());
        float digitadoValue = Float.parseFloat(str);

        atualValue += digitadoValue;
        campoTexto.setText(String.valueOf(atualValue));
    }


    public void mostraResultado()
    {
        float numeroB = Integer.parseInt(campoTexto.getText().toString());
        float result = 0;
        if(operacao.equals("+"))
        {
            result = numeroB + numeroA;
        }
        if(operacao.equals("-"))
        {
            result = numeroA - numeroB;
        }
        if(operacao.equals("*"))
        {
            result = numeroB * numeroA;
        }
        if(operacao.equals("/"))
        {
            result = numeroA / numeroB;
        }
        campoTexto.setText(String.valueOf(result));
    }
}

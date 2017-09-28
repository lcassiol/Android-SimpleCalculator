package com.example.lcassiol.simplecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    String lastInsertNumber = "";
    ArrayList<Float> stackNumbers = new ArrayList<Float>();
    ArrayList<String> stackOperations = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtResult = (TextView)findViewById(R.id.txtResult);
        txtResult.setText("0");

    }

    public  void calculate(View view){
        switch (view.getId()){
            case R.id.btnClear:
                txtResult.setText("0");
                break;
            case R.id.btnPlus:
                updateTxtResult("+");
                break;
            case R.id.btnMinus:
                updateTxtResult("-");
                break;
            case R.id.btnDiv:
                updateTxtResult("/");
                break;
            case R.id.btnMulti:
                updateTxtResult("*");
                break;
            case R.id.btnResult:
                showResult();
                break;
            default :
                String numb;
                numb = ((Button)view).getText().toString();
                getKeyboard(numb);
                break;
        }
    }


    public void updateTxtResult(String tipoOperacao){
        float number = Float.parseFloat(txtResult.getText().toString());
        stackNumbers.add(number);
        lastInsertNumber = "";
        stackOperations.add(tipoOperacao);
        txtResult.setText(txtResult.getText().toString() + tipoOperacao);
    }


    public void getKeyboard(String str)
    {
        String scrCurrent = "";
        lastInsertNumber += str;
        if(!txtResult.getText().toString().equalsIgnoreCase("0")){
            scrCurrent = txtResult.getText().toString();
        }

        scrCurrent += str;
        txtResult.setText(scrCurrent);
    }


    public void showResult()
    {
        float result = 0;
        String currentOperation = "";
        float newNumber = Float.parseFloat(lastInsertNumber.toString());
        stackNumbers.add(newNumber);

        for(int i = 0; i< stackNumbers.size() ; i++){

            if(i==0){
                result = stackNumbers.get(i);
            }else{
                result = makeOperation(result, stackNumbers.get(i), currentOperation);
            }

            if(stackOperations.size() > i){
                currentOperation = stackOperations.get(i);
            }
        }

        stackOperations.clear();
        stackNumbers.clear();
        txtResult.setText(String.valueOf(result));
    }

    public float makeOperation(float number1, float number2, String operation){
        float result = 0;
        if(operation.equals("+"))
        {
            result = number1 + number2;
        }
        if(operation.equals("-"))
        {
            result = number1 - number2;
        }
        if(operation.equals("*"))
        {
            result = number1 * number2;
        }
        if(operation.equals("/"))
        {
            result = number1 / number2;
        }

        return result;
    }
}

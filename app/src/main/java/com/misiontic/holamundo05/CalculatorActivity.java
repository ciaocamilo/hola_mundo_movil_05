package com.misiontic.holamundo05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private EditText etNumberOne;
    private EditText etNumberTwo;
    private EditText etNumberThree;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    public void calcularPromedio(View view) {

        etNumberOne = (EditText) findViewById(R.id.etNumberOne);
        etNumberTwo = findViewById(R.id.etNumberTwo);
        etNumberThree = findViewById(R.id.etNumberThree);
        tvResult = findViewById(R.id.tvResult);

        double numberOne = Double.parseDouble(etNumberOne.getText().toString());
        double numberTwo = Double.parseDouble(etNumberTwo.getText().toString());
        double numberThree = Double.parseDouble(etNumberThree.getText().toString());

        double average = (numberOne + numberTwo + numberThree) / 3;

        tvResult.setText("Promedio = " + average);
    }

}
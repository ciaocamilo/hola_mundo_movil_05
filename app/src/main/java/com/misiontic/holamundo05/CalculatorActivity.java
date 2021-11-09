package com.misiontic.holamundo05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        String strNumberOne = etNumberOne.getText().toString();
        String strNumberTwo = etNumberTwo.getText().toString();
        String strNumberThree = etNumberThree.getText().toString();
        Resources res = getResources();
        if (!strNumberOne.equals("") && !strNumberTwo.equals("") && !strNumberThree.equals("")) {
            double numberOne = Double.parseDouble(strNumberOne);
            double numberTwo = Double.parseDouble(strNumberTwo);
            double numberThree = Double.parseDouble(strNumberThree);

            double average = (numberOne + numberTwo + numberThree) / 3;

            String result = String.format(res.getString(R.string.avg_equals), String.valueOf(average));

            tvResult.setText(result);
        } else {
            Toast.makeText(this, res.getString(R.string.warning_all_numbers), Toast.LENGTH_LONG).show();
        }

    }

}
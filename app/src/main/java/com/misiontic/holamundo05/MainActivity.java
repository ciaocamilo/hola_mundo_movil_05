package com.misiontic.holamundo05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String name = getIntent().getStringExtra("user");
        Toast.makeText(this, "Bienvenido(a) " + name, Toast.LENGTH_LONG).show();
    }

    public void goToLogin(View view) {
        Intent intentLogin = new Intent(this, LoginActivity.class);
        startActivity(intentLogin);
    }

    public void goToCalculator(View view) {
        Intent intentCalculator = new Intent(this, CalculatorActivity.class);
        startActivity(intentCalculator);
    }

    public void goToPersonForm(View view) {
        Intent intentPersonForm = new Intent(this, PersonFormActivity.class);
        startActivity(intentPersonForm);
    }

    public void goToContacts(View view) {
        Intent intentContacts = new Intent(this, ContactActivity.class);
        startActivity(intentContacts);
    }

    public void goToOrder(View view) {
        Intent intentOrder = new Intent(this, OrderActivity.class);
        startActivity(intentOrder);
    }

}
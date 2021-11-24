package com.misiontic.holamundo05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    // Método para generar el menú
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // Método para asignar funciones al menú
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_calculadora) {
            goToCalculator();
        } else if (id == R.id.item_contacto) {
            goToContacts();
        } else if (id == R.id.item_formulario) {
            goToPersonForm();
        } else if (id == R.id.item_order) {
            goToOrder();
        } else if (id == R.id.item_exit) {
            goToLogin();
        }
        return super.onOptionsItemSelected(item);
    }


    public void goToLogin() {
        Intent intentLogin = new Intent(this, LoginActivity.class);
        startActivity(intentLogin);
    }

    public void goToCalculator(View view) {
        Intent intentCalculator = new Intent(this, CalculatorActivity.class);
        startActivity(intentCalculator);
    }

    public void goToCalculator() {
        Intent intentCalculator = new Intent(this, CalculatorActivity.class);
        startActivity(intentCalculator);
    }

    public void goToPersonForm() {
        Intent intentPersonForm = new Intent(this, PersonFormActivity.class);
        startActivity(intentPersonForm);
    }

    public void goToContacts() {
        // Intent intentContacts = new Intent(this, ContactActivity.class);
        Intent intentContacts = new Intent(this, Contact2Activity.class);
        startActivity(intentContacts);
    }

    public void goToOrder() {
        Intent intentOrder = new Intent(this, OrderActivity.class);
        startActivity(intentOrder);
    }

}
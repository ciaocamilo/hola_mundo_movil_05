package com.misiontic.holamundo05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Button btnOrder = findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarPedido();
            }
        });
    }

    public void realizarPedido() {
        CheckBox cbPollo = findViewById(R.id.cbPollo);
        if (cbPollo.isChecked()) {
            Toast.makeText(this, "Pedido realizado con Pollo", Toast.LENGTH_LONG).show();
        }
    }

}
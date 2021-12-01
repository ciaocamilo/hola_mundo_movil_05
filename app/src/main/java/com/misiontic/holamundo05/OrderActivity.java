package com.misiontic.holamundo05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.misiontic.holamundo05.api.ApiRequest;
import com.misiontic.holamundo05.model.Pedido;
import com.misiontic.holamundo05.model.Producto;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private SharedPreferences settings; // SP

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        settings = getSharedPreferences("id", Context.MODE_PRIVATE); //SP

        Button btnOrder = findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarPedido();
            }
        });

        // Test API
        ApiRequest api = new ApiRequest();
        ArrayList<Producto> listaProductos = api.consultarProductos();

        Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show();


    }

    public void realizarPedido() {

        String usuario = settings.getString("usuario", "Pepe");

        CheckBox cbPollo = findViewById(R.id.cbPollo);
        CheckBox cbSalami = findViewById(R.id.cbSalami);
        CheckBox cbJamon = findViewById(R.id.cbJamon);

        String strPedido = getString(R.string.strOrderBase);
        // Pedido realizado con los siguientes ingredientes:

        if (cbPollo.isChecked()) {
            strPedido = strPedido.concat(" pollo ");
        }
        if (cbSalami.isChecked()) {
            strPedido = strPedido.concat("salami ");
        }
        if (cbJamon.isChecked()) {
            strPedido = strPedido.concat("jamón ");
        }

        // API
        Pedido nuevoPedido = new Pedido(usuario, strPedido, 1200.0, "0.0");
        ApiRequest api = new ApiRequest();
        api.guardarPedido(nuevoPedido);
        //


        strPedido = strPedido.concat(" para el señor(a) " + usuario);

        Toast.makeText(this, strPedido, Toast.LENGTH_LONG).show();
    }

}
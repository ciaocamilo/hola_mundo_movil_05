package com.misiontic.holamundo05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.misiontic.holamundo05.db.MySQLiteHelper;

public class PersonFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_form);
    }

    public void guardarFormulario(View view) {
        MySQLiteHelper conexion_bd = new MySQLiteHelper(this);
        // Error en el Query
        /*String insert_query = "INSERT INTO personas (nombres, apellidos, direccion, telefono, fecha_nacimiento) " +
                "VALUES ('Juan', 'Castro', 'Avenida Y', '31517454', '05/08/2005')";
        conexion_bd.insertData(insert_query);*/
    }

}
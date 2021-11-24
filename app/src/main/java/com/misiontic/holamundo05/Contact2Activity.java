package com.misiontic.holamundo05;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.misiontic.holamundo05.db.MySQLiteHelper;

import java.util.ArrayList;

public class Contact2Activity extends AppCompatActivity {

    private ArrayList<String> list_one;
    private ListView lvOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact2);

        list_one = new ArrayList<>();
        lvOne = findViewById(R.id.lvOne);
        showContacts();
    }

    public void showContacts () {
        int id;
        String nombre;
        String apellidos;

        MySQLiteHelper conexion_bd = new MySQLiteHelper(this);
        String sentence = "SELECT * FROM PERSONAS";

        Cursor resultados = conexion_bd.getData(sentence, null);

        try {
            resultados.moveToFirst();

            do {
                id = resultados.getInt(0);
                int indice = resultados.getColumnIndex("nombres");
                nombre = resultados.getString(indice);
                apellidos = resultados.getString(2);
                // Toast.makeText(this, id + "- " + nombre + " " + apellidos, Toast.LENGTH_LONG).show();

                //Lista
                list_one.add(id + "- " + nombre + " " + apellidos);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list_one);
                lvOne.setAdapter(adapter);
                //

            } while (resultados.moveToNext());
            
        } catch (Exception e) {
            Toast.makeText(this, "Error al realizar la consulta", Toast.LENGTH_SHORT).show();
        } finally {
            resultados.close();
        }
        


    }

}
package com.misiontic.holamundo05;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.misiontic.holamundo05.db.MySQLiteHelper;
import com.misiontic.holamundo05.listviews.ContactListViewAdapter;
import com.misiontic.holamundo05.model.Persona;

import java.util.ArrayList;

public class ContactListActivity extends AppCompatActivity {

    private ArrayList<Persona> contactList;
    private static ListView listView;
    private static ContactListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        contactList = new ArrayList<>();
        listView = findViewById(R.id.contactList);
        showContacts();
    }

    public void showContacts () {
        int id;
        String nombre;
        String apellidos;
        String direccion;
        String telefono;
        String fecha_nacimiento;

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
                direccion = resultados.getString(3);
                telefono = resultados.getString(4);
                fecha_nacimiento = resultados.getString(5);
                Persona nuevoContacto = new Persona(nombre, apellidos, direccion, telefono, fecha_nacimiento, null);
                nuevoContacto.setId(id);
                // Toast.makeText(this, id + "- " + nombre + " " + apellidos, Toast.LENGTH_LONG).show();

                //Lista
                contactList.add(nuevoContacto);
                //
            } while (resultados.moveToNext());

            adapter = new ContactListViewAdapter(this, contactList);
            listView.setAdapter(adapter);

        } catch (Exception e) {
            Toast.makeText(this, "Error al realizar la consulta", Toast.LENGTH_SHORT).show();
        } finally {
            resultados.close();
        }



    }

}
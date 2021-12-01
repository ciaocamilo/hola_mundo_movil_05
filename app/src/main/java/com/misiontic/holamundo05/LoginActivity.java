package com.misiontic.holamundo05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.misiontic.holamundo05.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPassword;
    private SharedPreferences settings; // SP

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        settings = getSharedPreferences("id", Context.MODE_PRIVATE); //SP
    }

    public void goToMain(View view) {
        etName = (EditText) findViewById(R.id.etPersonName);
        String name = etName.getText().toString();
        etPassword = findViewById(R.id.etPassword);
        String password = etPassword.getText().toString();

        Intent intentMain = new Intent(this, MainActivity.class);

        intentMain.putExtra("user", name);

        //SP
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("id", 1);
            editor.putString("usuario", name);
            editor.commit();
        //

        checkUser(name, password, intentMain);

        // startActivity(intentMain);
    }

    public void goToNewUser(View view) {
        Intent newUserIntent = new Intent(this, NewUserActivity.class);
        startActivity(newUserIntent);
    }


    public void checkUser(String nombre, String contrasena, Intent intentMain) {

        // Leer en base de datos
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("usuarios");
        myRef.child("u_" + nombre).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Usuario value = snapshot.getValue(Usuario.class);
                if (value != null) {
                    String saved_password = value.getContrasena();
                    if (saved_password.equals(contrasena)) {
                        startActivity(intentMain);
                    } else {
                        Toast.makeText(LoginActivity.this, "Usuario y/o contraseña no válido", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Usuario y/o contraseña no válido", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled( DatabaseError error) {
                Toast.makeText(LoginActivity.this, "Failed to read value." + error.toException(), Toast.LENGTH_SHORT);
            }
        });

    }


}
package com.misiontic.holamundo05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        // readTest();
    }

    public void createUser(View view) {
        EditText etNewUser = findViewById(R.id.etNewUser);
        EditText etNewPassword = findViewById(R.id.etNewPassword);
        String newUser = etNewUser.getText().toString();
        String newPassword = etNewPassword.getText().toString();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("usuarios");

        myRef.child("u_" + newUser).child("nombre").setValue(newUser);
        myRef.child("u_" + newUser).child("contrasena").setValue(newPassword);
    }



    public void writeTest(View view) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
    }

    public void readTest() {
        // Read from the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(NewUserActivity.this, "Value is: " + value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(NewUserActivity.this, "Failed to read value." + error.toException(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
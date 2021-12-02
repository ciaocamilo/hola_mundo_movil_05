package com.misiontic.holamundo05;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.misiontic.holamundo05.db.MySQLiteHelper;

import java.io.File;
import java.io.FileOutputStream;

public class PersonFormActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etLastname;
    private EditText etAddress;
    private EditText etPhone;
    private EditText etBirthday;

    private ImageView ivPictureForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_form);

        etName = findViewById(R.id.etFormPersonName);
        etLastname = findViewById(R.id.etFormLastname);
        etAddress = findViewById(R.id.etFormAddress);
        etPhone = findViewById(R.id.etTelephone);
        etBirthday = findViewById(R.id.etBirthday);

        ivPictureForm = findViewById(R.id.ivPictureForm);
        ivPictureForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();
            }
        });
    }

    public void guardarFormulario(View view) {
        String name = etName.getText().toString();
        String lastname = etLastname.getText().toString();
        String address = etAddress.getText().toString();
        String phone = etPhone.getText().toString();
        String birthday = etBirthday.getText().toString();

        MySQLiteHelper conexion_bd = new MySQLiteHelper(this);
        String insert_query = "INSERT INTO personas (nombres, apellidos, direccion, telefono, fecha_nacimiento) " +
                "VALUES ('" + name + "', '" + lastname + "', '" + address + "', '" + phone + "', '" + birthday + "')";

        boolean success = conexion_bd.insertData(insert_query);
        if (success) {
            Toast.makeText(this, "Persona guardada con éxito", Toast.LENGTH_LONG).show();
            limpiarFormulario();
        } else {
            Toast.makeText(this, "Error al guardar la persona", Toast.LENGTH_LONG).show();
        }

        // Tests save
        saveToGallery();

    }

    public void limpiarFormulario(View view) {
        etName.setText("");
        etLastname.setText("");
        etAddress.setText("");
        etPhone.setText("");
        etBirthday.setText("");
    }

    public void limpiarFormulario() {
        etName.setText("");
        etLastname.setText("");
        etAddress.setText("");
        etPhone.setText("");
        etBirthday.setText("");
    }


    private void abrirCamara() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
           pictureActivityResultLauncher.launch(intent);
        }
    }

    private ActivityResultLauncher<Intent> pictureActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();

                        Bundle extras = data.getExtras();
                        Bitmap imgBitmap = (Bitmap) extras.get("data");
                        ivPictureForm.setImageBitmap(imgBitmap);
                    } else {
                        Toast.makeText(PersonFormActivity.this, "Fotografía cancelada", Toast.LENGTH_SHORT).show();
                    }
                }
            });


    private void saveToGallery() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Bitmap bitmap = ((BitmapDrawable) ivPictureForm.getDrawable()).getBitmap();

            FileOutputStream outputStream = null;
            File file = Environment.getExternalStorageDirectory();
            File dir = new File(file.getAbsolutePath() + "/Fotos_05");
            dir.mkdirs();

            String filename = String.format("%d.png", System.currentTimeMillis());
            File outfile = new File (dir, filename);

            try {
                outputStream = new FileOutputStream(outfile);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                outputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ActivityCompat.requestPermissions(PersonFormActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 44);
        }
    }


}
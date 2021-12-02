package com.misiontic.holamundo05.location;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.List;
import java.util.Locale;

public class MyLocation {

    FusedLocationProviderClient fusedLocationProviderClient;
    Context context;

    private String latitud;
    private String longitud;

    public MyLocation(Context context, Activity activity) {

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        this.context = context;

        // Check de permisos
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    Location location = task.getResult();
                    if (location != null) {
                        try {
                            Geocoder geocoder = new Geocoder(context, Locale.getDefault());

                            List<Address> address = geocoder.getFromLocation(
                              location.getLatitude(),location.getLongitude(), 1
                            );

                            latitud = String.valueOf(address.get(0).getLatitude());
                            longitud = String.valueOf(address.get(0).getLongitude());

                            // Test
                            Toast.makeText(context, "Latitud: " + address.get(0).getLatitude(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(context, "Longitud: " + address.get(0).getLongitude(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(context, "País: " + address.get(0).getCountryName(), Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }
}

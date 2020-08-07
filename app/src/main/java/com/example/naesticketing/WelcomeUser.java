package com.example.naesticketing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeUser extends AppCompatActivity {
    // String name;
    TextView namee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_user);
        namee = findViewById(R.id.name);

        String namefromlogin = getIntent().getExtras().getString("name");
        final String username = namefromlogin;
        namee.setText(username);
        String namefromdetail = getIntent().getExtras().getString("username");
        String namefromaddbalance = getIntent().getExtras().getString("name");
        String namefromentername = getIntent().getExtras().getString("name");

        if (namefromlogin == null)
            namee.setText(namefromdetail);
        else if (namefromaddbalance == null)
            namee.setText(namefromentername);
        else if (namefromentername == null)
            namee.setText(namefromlogin);
        // Toast.makeText(this,"Welcome "+names,Toast.LENGTH_SHORT).show();
        // android:text="WELCOME USER "
    }

    public void trainticket(View v) {
        String name = getIntent().getExtras().getString("name");
        String addbal = getIntent().getExtras().getString("amount");
        if (addbal == null) {
            Toast.makeText(this, "please first click on add balance button to add amount into your account  ", Toast.LENGTH_SHORT).show();
        } else {
            Intent trainticket = new Intent(this, TrainTicket.class);
            trainticket.putExtra("name", name);
            trainticket.putExtra("amount", addbal);
            startActivity(trainticket);
        }
    }


    public void addBalance(View v) {
        String username = namee.getText().toString();
        Intent addBalance = new Intent(this, AddBalance.class);
        addBalance.putExtra("name", username);
        startActivity(addBalance);
    }

    /*public void details(View v)
    {
     Intent details=new Intent(this,Details.class);
     startActivity(details);

        }*/
    public void vd(View view) {
        Intent mydetails = new Intent(this, ViewDetails.class);
        startActivity(mydetails);
    }

    public void onLogout(View v) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure?");
        alertDialogBuilder.setPositiveButton("yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent details = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(details);
                    }
                });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }




    public void queries(View v)
    {
        try {
            Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "groupmembers06@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
            intent.putExtra(Intent.EXTRA_TEXT, "Enter Text Here");
            startActivity(intent);
        }catch(Exception e) {
            Toast.makeText(this, "Sorry...You don't have gmail app", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }
    public void onClick(View view){
        //String username=getIntent().getExtras().getString("username");
        Intent secondpage=new Intent(this,SecondPage.class);
        //trainticket.putExtra("username",username);
        startActivity(secondpage);
    }


    private GpsTracker gpsTracker;

    public void onloc(View v)
    {
        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        gpsTracker = new GpsTracker(this);
        if(gpsTracker.canGetLocation()){
            double latitude = gpsTracker.getLatitude();
            double longitude = gpsTracker.getLongitude();
            Toast.makeText(this, "Latitude: " + latitude + "\n" + "Longitude: " + longitude, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("http://maps.google.com/maps?&saddr="
                            + latitude
                            + ","
                            + longitude
                            + "&daddr=nearby railway station"

                    ));
            startActivity(intent);

        }else{
            gpsTracker.showSettingsAlert();
        }


    }
}

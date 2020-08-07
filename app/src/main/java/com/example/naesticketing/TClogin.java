package com.example.naesticketing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TClogin extends AppCompatActivity {
    EditText tcname;
    EditText pwd;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tclogin);
        tcname= (EditText) findViewById(R.id.tcname);
        pwd= (EditText) findViewById(R.id.tcpwd);
        builder= new AlertDialog.Builder(this);
        builder.setTitle("Admin info");
        builder.setMessage("For Logging In as Ticket Checker, \n " +
                "  Username:admin  \n Password:admin123");
        builder.setPositiveButton("OK", null);
        AlertDialog alert= builder.create();
        alert.show();
        Intent tclogin = getIntent();
    }

    public void tclogin(View v) {
        if((tcname.getText().toString().equals(""))||(pwd.getText().toString().equals(""))) {
            Toast.makeText(this,"Fill Both the Fields",Toast.LENGTH_LONG).show();
        }

        else if((tcname.getText().toString().equals("admin"))&&(pwd.getText().toString().equals("admin123"))) {
            Intent tclogin = new Intent(this, CheckTicket.class);
            startActivity(tclogin);
        }
        else{
            Toast.makeText(this,"Wrong Username OR Password", Toast.LENGTH_LONG).show();
        }
    }

}


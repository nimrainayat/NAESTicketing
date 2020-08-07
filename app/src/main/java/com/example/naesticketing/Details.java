package com.example.naesticketing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Details extends AppCompatActivity {
TextView t1;
TextView t2;
TextView t3;
TextView t4;
TextView t5;
TextView t6;
TextView t7;
TextView t8;
TextView t9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
       t1=findViewById(R.id.SetName);
       t2=findViewById(R.id.SetFrom);
       t3=findViewById(R.id.SetTo);
       t4=findViewById(R.id.SetTrainName);
       t5=findViewById(R.id.SetSeat);
       t6=findViewById(R.id.SetTicket);
       t9=findViewById(R.id.SetRs);
        t7=findViewById(R.id.SetBal);
        t8=findViewById(R.id.SetCuBal);
        Intent detail=getIntent();
        String username=detail.getExtras().getString("username");
        String from=detail.getExtras().getString("from");
        String to=detail.getExtras().getString("to");
        String trainnames=detail.getExtras().getString("trainnames");
        String seatno=detail.getExtras().getString("seatno");
        String tickets=detail.getExtras().getString("ticketno");
        String rupees=detail.getExtras().getString("rupees");
        String balance=detail.getExtras().getString("Previousbalance");
        String cubalance=detail.getExtras().getString("Currentbalance");
        t1.setText(username);
        t2.setText(from);
        t3.setText(to);
        t4.setText(trainnames);
        t5.setText(seatno);
        t6.setText(tickets);
        t7.setText(balance);
        t9.setText(rupees);
        t8.setText(cubalance);

    }
    public void onClick(View view){
        String username=getIntent().getExtras().getString("username");
        Intent trainticket=new Intent(this,WelcomeUser.class);
        trainticket.putExtra("username",username);
        startActivity(trainticket);
    }
}

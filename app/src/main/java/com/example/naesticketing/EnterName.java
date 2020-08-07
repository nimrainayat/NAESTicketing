package com.example.naesticketing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//import static com.example.naesticketing.UserLoginDbHelper.COL_amount;
import static com.example.naesticketing.UserLoginDbHelper.COL_addamount;
import static com.example.naesticketing.UserLoginDbHelper.COL_from;
import static com.example.naesticketing.UserLoginDbHelper.COL_rs;
import static com.example.naesticketing.UserLoginDbHelper.COL_seatNumber;
import static com.example.naesticketing.UserLoginDbHelper.COL_tickets;
import static com.example.naesticketing.UserLoginDbHelper.COL_to;
import static com.example.naesticketing.UserLoginDbHelper.COL_trainNames;
import static com.example.naesticketing.UserLoginDbHelper.COL_ttId;
import static com.example.naesticketing.UserLoginDbHelper.COL_username;
import static com.example.naesticketing.UserLoginDbHelper.TABLE_NAME1;

public class EnterName extends AppCompatActivity {
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    TextView t7;
    TextView t8;
    TextView t9;
    SQLiteDatabase sq;
    UserLoginDbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);
        db=new UserLoginDbHelper(this);
        t7=findViewById(R.id.SetUserId);
        t1=findViewById(R.id.SetName);
        t2=findViewById(R.id.SetFrom);
        t3=findViewById(R.id.SetTo);
        t4=findViewById(R.id.SetTrainName);
        t5=findViewById(R.id.SetSeat);
        t9=findViewById(R.id.SetRs);
        t6=findViewById(R.id.SetTicket);
        t8=findViewById(R.id.SetBal);

       /*  Intent detail=getIntent();
       String username=detail.getExtras().getString("username");
        String from=detail.getExtras().getString("from");
        String to=detail.getExtras().getString("to");
        String trainnames=detail.getExtras().getString("trainnames");
        String seatno=detail.getExtras().getString("seatno");
        String tickets=detail.getExtras().getString("ticketno");
        String rupees=detail.getExtras().getString("rupees");
        t1.setText(username);
        t2.setText(from);
        t3.setText(to);
        t4.setText(trainnames);
        t5.setText(seatno);

        t6.setText(tickets);
        t9.setText(rupees);*/
        sq=db.getReadableDatabase();
        Intent detail=getIntent();
        String username=detail.getExtras().getString("username");
        // Boolean res=db.searchName(username);

        String[] column={COL_ttId,COL_username,COL_from,COL_to,COL_trainNames,COL_seatNumber,COL_rs,COL_tickets,COL_addamount};
        String sortOrder =COL_from+ " ASC";
        Cursor c;
        c = sq.query(TABLE_NAME1,column,COL_username  + "=?",new String[] { username},null,null, sortOrder);
        while (c.moveToNext())
        {
            t7.setText(c.getString(0));
            t1.setText(c.getString(1));
            t2.setText(c.getString(2));
            t3.setText(c.getString(3));
            t4.setText(c.getString(4));
            t5.setText(c.getString(5));
            t9.setText(c.getString(6));
            t6.setText(c.getString(7));

        }
        c.close();

    }
    public void onClick(View view){
        String name=t1.getText().toString();
        Intent welcomepage=new Intent(this,WelcomeUser.class);
        welcomepage.putExtra("name",name);
        startActivity(welcomepage);
    }
}

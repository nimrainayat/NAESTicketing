package com.example.naesticketing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

//import static com.example.naesticketing.UserLoginDbHelper.COL_amount;
/*import static com.example.naesticketing.UserLoginDbHelper.COL_addamount;
import static com.example.naesticketing.UserLoginDbHelper.COL_from;
import static com.example.naesticketing.UserLoginDbHelper.COL_rs;
import static com.example.naesticketing.UserLoginDbHelper.COL_ruId;
import static com.example.naesticketing.UserLoginDbHelper.COL_seatNumber;
import static com.example.naesticketing.UserLoginDbHelper.COL_to;
import static com.example.naesticketing.UserLoginDbHelper.COL_trainNames;
import static com.example.naesticketing.UserLoginDbHelper.TABLE_NAME1;*/

public class CheckTicket extends AppCompatActivity {
    Spinner sp_type;
    EditText ed1;
    UserLoginDbHelper db;
SQLiteDatabase sq;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkticket);
        db=new UserLoginDbHelper(this);
    }
    public void search(View v)
    {
        ed1=(EditText)findViewById(R.id.uname);
        String ed2=ed1.getText().toString();
       Boolean res=db.searchName(ed2);
       if((ed2.isEmpty()))
       {
           Toast.makeText(this,"no such name exists",Toast.LENGTH_SHORT).show();
       }
       else if(res==true)
       {
           Toast.makeText(this,"name found",Toast.LENGTH_SHORT).show();
           Intent intent=new Intent(this,UserDetails.class);
           intent.putExtra("name",ed2);
           String name=ed1.getText().toString();
           intent.putExtra("username",name);
      sq=db.getReadableDatabase();
    //  String[] column={COL_from,COL_to,COL_trainNames,COL_seatNumber,COL_rs,COL_addamount};
         //  Cursor c=sq.query(TABLE_NAME1,null,null,null,null,null,null);

           startActivity(intent);
       }

       else
       {Toast.makeText(this,"name doesnot exists",Toast.LENGTH_SHORT).show();}
    }

    public void onlogout(View v) {
        Intent onlogout = new Intent(this, MainActivity.class);
        startActivity(onlogout);
    }
}

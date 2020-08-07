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

public class ViewDetails extends AppCompatActivity {
    Spinner sp_type;

    UserLoginDbHelper db;
    SQLiteDatabase sq;
    EditText ed11;
    String ed22="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        db=new UserLoginDbHelper(this);

    }

    public void onClick(View v)
    {try
    {

            ed11 = (EditText) findViewById(R.id.uname);
            ed22 = ed11.getText().toString();
            Boolean res = db.searchName(ed22);
            if ((ed22.isEmpty())) {
                Toast.makeText(this, "no such name exists", Toast.LENGTH_SHORT).show();

            }
            else if (res == true)
            {
                Toast.makeText(this, "name found", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, EnterName.class);

                intent.putExtra("name", ed22);

                String name = ed11.getText().toString();

                intent.putExtra("username", name);

                sq = db.getReadableDatabase();
                //  String[] column={COL_from,COL_to,COL_trainNames,COL_seatNumber,COL_rs,COL_addamount};
                //  Cursor c=sq.query(TABLE_NAME1,null,null,null,null,null,null);

                startActivity(intent);
            }

        else
        {Toast.makeText(this,"name doesnot exists",Toast.LENGTH_SHORT).show();}

    }
        catch (Exception e)
    {
        e.printStackTrace();
    }}

}

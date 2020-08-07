package com.example.naesticketing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBalance extends AppCompatActivity {
    EditText ed1;
    UserLoginDbHelper db;
    SQLiteDatabase sq;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    EditText ed5;
    Button b1;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_balance);
        username = getIntent().getExtras().getString("name");

    }

    public void insertData(View v) {
        db = new UserLoginDbHelper(this);
        sq = db.getReadableDatabase();
        ed1 = (EditText) findViewById(R.id.cardNum);
        ed2 = (EditText) findViewById(R.id.cvv);
        ed3 = (EditText) findViewById(R.id.card_name);
        ed4 = (EditText) findViewById(R.id.amount);
        String card = ed1.getText().toString();
        String cvv = ed2.getText().toString();
        String name = ed3.getText().toString();
        String amount = ed4.getText().toString();
        String namePattern = "^[a-z0-9_-]{3,15}$";
        //  long values=db.addBalance(card,cvv,name);
        // long val=db.addUsertotrainticket(null,null,null,null,null,null,null,amount);
        if ((card.isEmpty()) || (cvv.isEmpty()) || (name.isEmpty()) || amount.isEmpty()) {
            Toast.makeText(this, "You must fill all fields", Toast.LENGTH_SHORT).show();
        } else if (amount.length() > 6) {
            Toast.makeText(this, "your amount length cannot exceed 5", Toast.LENGTH_SHORT).show();
        } else if (amount.length() < 3) {
            Toast.makeText(this, "your amount length cannot be less than 3", Toast.LENGTH_SHORT).show();
        } else if (card.length() > 16) {
            Toast.makeText(this, "enter 16 digit card number", Toast.LENGTH_SHORT).show();
        } else if (card.length() < 16) {
            Toast.makeText(this, "enter 16 digit card number", Toast.LENGTH_SHORT).show();
        } else if (cvv.length() > 3) {
            Toast.makeText(this, "enter 3 digit cvv number", Toast.LENGTH_SHORT).show();
        } else if (cvv.length() < 3) {
            Toast.makeText(this, "enter 3 digit cvv number", Toast.LENGTH_SHORT).show();
        } else if (!name.matches(namePattern)) {
            Toast.makeText(this, "you have entered wrong user name", Toast.LENGTH_SHORT).show();
        } else if (name.equals(username)) {//Toast.makeText(this, "Welcome "+name, Toast.LENGTH_SHORT).show();
            // if((val>0)){
            Toast.makeText(this, "record Inserted" + " "+ card +" "+ cvv +" "+ name +" "+ amount, Toast.LENGTH_SHORT).show();
            Intent trainticket = new Intent(this, TrainTicket.class);
            trainticket.putExtra("amount", amount);
            Intent welcomeuser = new Intent(this, WelcomeUser.class);
            welcomeuser.putExtra("name", name);
            welcomeuser.putExtra("amount", amount);
            startActivity(welcomeuser);
        }


   else

    {
        Toast.makeText(this, "Enter valid user name which you entered while logging in", Toast.LENGTH_SHORT).show();
    }
}




    }

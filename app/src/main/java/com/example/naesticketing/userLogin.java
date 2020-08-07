package com.example.naesticketing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class userLogin extends AppCompatActivity {
    EditText username;
    EditText password;
UserLoginDbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        db=new UserLoginDbHelper(this);
        Intent userlogin=getIntent();
        Intent useloginn=getIntent();
        username=findViewById(R.id.userid);
        password=findViewById(R.id.password);
    }
    public void userRegistration(View view)
    {
        Intent userregistration=new Intent(this,UserRegistration.class);
        startActivity(userregistration);
    }
    public void welcomeuser(View view)
    {
        String user=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        Boolean res=db.checkUser(user,pass);

        if((user.isEmpty())||(pass.isEmpty())){
            Toast.makeText(this, "fill both fields first", Toast.LENGTH_SHORT).show();


        }

        else if(res == true)
        {
           // Toast.makeText(this, "Welcome "+user, Toast.LENGTH_SHORT).show();
            Intent welcomeuser=new Intent(this,WelcomeUser.class);
            welcomeuser.putExtra("name",user);
            startActivity(welcomeuser);
           //// Intent detail=new Intent(this,Details.class);
          //  detail.putExtra("name",user);
          //  startActivity(detail);
        }
        else {
            Toast.makeText(this, "ERROR..enter data again or please sign up first", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClick(View view){
        Intent secondpage=new Intent(this,SecondPage.class);
        startActivity(secondpage);
    }
}

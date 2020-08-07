package com.example.naesticketing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        Intent secondpage=getIntent();
    }
    public  void userlogin(View v)
    {
        Intent userlogin=new Intent(this,userLogin.class);
        startActivity(userlogin);
    }
    public  void onCheck(View v)
    {
        Intent onCheck=new Intent(this,TClogin.class);
        startActivity(onCheck);
    }
    public  void onBack(View v)
    {
        Intent onBack=new Intent(this,MainActivity.class);
        startActivity(onBack);
    }
}

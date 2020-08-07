package com.example.naesticketing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearlayout;
    TextView name;
    ImageView train;
    ImageView bus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void secondPage(View view)
    {
        Intent secondpage=new Intent(this,SecondPage.class);
        startActivity(secondpage);
    }
}

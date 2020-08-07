package com.example.naesticketing;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class UserRegistration extends AppCompatActivity {
    UserLoginDbHelper db;
    TextView id;
   SQLiteDatabase sq;
    EditText fullname,phoneno,emailid,passwordd;
    Spinner type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        db = new UserLoginDbHelper(this);
        sq=db.getReadableDatabase();
        Intent userregistration = getIntent();

    }
    public void InsertData(View v)
    {
        fullname= (EditText) findViewById(R.id.fullname);
  phoneno= (EditText) findViewById(R.id.phoneno);
  emailid= (EditText) findViewById(R.id.emailid);
  passwordd= (EditText) findViewById(R.id.password);
  id=findViewById(R.id.t1);
        String user = fullname.getText().toString().trim();
        String phonenoo = phoneno.getText().toString();
        String emailidd = emailid.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String MobilePattern = "^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$";
        String namePattern="^[a-z0-9_-]{3,15}$";
        String pass  = passwordd.getText().toString().trim();
        long val=  db.addUser(user,pass );
long usertt=db.addUsertotrainticket(user,null,null,null,null,null,null,null);
        if((user.isEmpty())||(phonenoo.isEmpty())||(emailidd.isEmpty())||(pass.isEmpty()))
        {
            Toast.makeText(this, "You must fill all fields",Toast.LENGTH_SHORT).show();
        }
        else if (!user.matches(namePattern))
        {
            Toast.makeText(getApplicationContext()," Enter valid user name as per defined",Toast.LENGTH_SHORT).show();
        }
        else if (!emailidd.matches(emailPattern))
        {
            Toast.makeText(getApplicationContext()," Enter valid email address",Toast.LENGTH_SHORT).show();
        }
        else if(!phonenoo.matches(MobilePattern)) {

            Toast.makeText(getApplicationContext(), "Please enter valid 11 digit phone number", Toast.LENGTH_SHORT).show();
        }
        else if(fullname.length()>15)
        {
            Toast.makeText(getApplicationContext(),"Name is too long. you can only  Enter upto 15 characters",Toast.LENGTH_SHORT).show();

        }
        else if(fullname.length()<3)
        {
            Toast.makeText(getApplicationContext(),"Name is too short. you cmust enter atleast 3 characters",Toast.LENGTH_SHORT).show();

        }
        else if(pass.length()>12)
        {
            Toast.makeText(getApplicationContext(),"Password is too long. you can only Enter upto 12 characters ",Toast.LENGTH_SHORT).show();

        }


        else if (val > 0&&usertt>0) {
            Toast.makeText(this, "New Record Inserted ", Toast.LENGTH_SHORT).show();
            Intent userlogin=new Intent(this,userLogin.class);
            startActivity(userlogin);
        }
       else{
           Toast.makeText(this, "This username is already taken..Enter another other username ", Toast.LENGTH_SHORT).show();

        }

}}
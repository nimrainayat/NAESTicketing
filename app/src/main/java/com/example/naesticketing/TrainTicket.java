package com.example.naesticketing;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TrainTicket extends AppCompatActivity {
    UserLoginDbHelper db;
    AlertDialog.Builder builder;

    String name;
    TextView ed_name;
    Spinner sp_trainnames;
    Spinner sp_from;
    Spinner sp_to;
    Spinner sp_seatno;
    Spinner sp_ticketnumb;
    RadioGroup class_type;
    RadioButton regular, first;
    RadioGroup ticket_type;
    RadioButton single, return1;
    TextView rupees;
    Button submit;
    String selectedItemfrom;
    String selectedItemto;
   String selectedItemtrainnames;
   String selectedSeatNumber;
    String TicketNumber;
    long seatnumbersspinnervalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_ticket);
        ed_name = findViewById(R.id.ed_name);
        name=getIntent().getExtras().getString("name");
        Intent welcomeuser=new Intent(this,WelcomeUser.class);
        welcomeuser.putExtra("name",name);
       // startActivity(welcomeuser);

        ed_name.setText(name);
        sp_trainnames=findViewById(R.id.train_names);
        sp_from = findViewById(R.id.sp_from);
        sp_to = findViewById(R.id.sp_to);
        sp_seatno=findViewById(R.id.seatnumber);
        sp_ticketnumb=findViewById(R.id.sp_ticketsno);
        rupees= findViewById(R.id.Rs);
        db=new UserLoginDbHelper(this);
          submit=findViewById(R.id.submit);
       final String[] citiesName = getResources().getStringArray(R.array.citiesNames);
       final String[] trainnames1=getResources().getStringArray(R.array.trainnames1);
        final String[] trainnames2=getResources().getStringArray(R.array.trainnames2);
        final String[] trainnames3=getResources().getStringArray(R.array.trainnames3);
        final String[] trainnames4=getResources().getStringArray(R.array.trainnames4);
        final String[] trainnames5=getResources().getStringArray(R.array.trainnames5);

        final String[] seatnumbers1=getResources().getStringArray(R.array.seatnumber1);
        final String[] seatnumbers2=getResources().getStringArray(R.array.seatnumber2);
        final String[] seatnumbers3=getResources().getStringArray(R.array.seatnumber3);
        final String[] seatnumbers4=getResources().getStringArray(R.array.seatnumber4);
        final String[] seatnumbers5=getResources().getStringArray(R.array.seatnumber5);
        final String[] seatnumbers6=getResources().getStringArray(R.array.seatnumber6);
        final String[] seatnumbers7=getResources().getStringArray(R.array.seatnumber7);
        final String[] seatnumbers8=getResources().getStringArray(R.array.seatnumber8);
        final String[] seatnumbers9=getResources().getStringArray(R.array.seatnumber9);
        final String[] seatnumbers10=getResources().getStringArray(R.array.seatnumber10);

        final String[] ticketsnumber=getResources().getStringArray(R.array.ticketsnumber);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, citiesName);
        sp_from.setAdapter(adapter2);
         ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, citiesName);
        sp_to.setAdapter(adapter3);
      final   ArrayAdapter<String>  t1=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,trainnames1);
       final ArrayAdapter<String>  t2=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,trainnames2);
        final ArrayAdapter<String>  t3=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,trainnames3);
        final ArrayAdapter<String>  t4=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,trainnames4);
        final ArrayAdapter<String>  t5=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,trainnames5);
      final  ArrayAdapter<String> s1=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,seatnumbers1);
      final  ArrayAdapter<String> s2=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,seatnumbers2);
       final ArrayAdapter<String> s3=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,seatnumbers3);
      final  ArrayAdapter<String> s4=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,seatnumbers4);
        final  ArrayAdapter<String> s5=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,seatnumbers5);
        final  ArrayAdapter<String> s6=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,seatnumbers6);
        final  ArrayAdapter<String> s7=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,seatnumbers7);
        final  ArrayAdapter<String> s8=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,seatnumbers8);
        final  ArrayAdapter<String> s9=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,seatnumbers9);
        final  ArrayAdapter<String> s10=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,seatnumbers10);


        final ArrayAdapter<String>  adapter6=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,ticketsnumber);


        sp_from.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int position, long id) {
                selectedItemfrom = parent.getItemAtPosition(position).toString().trim();
              /*  long fromspinnervalue=  db.addFromSpinnerValue(selectedItemfrom );
                if(fromspinnervalue>0)
                {
                    Toast.makeText(getApplicationContext()," from record inserted"+selectedItemfrom , Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"from record insertion failed", Toast.LENGTH_LONG).show();

                }
*/
                    }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        } );
        sp_to.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int position, long id) {
                selectedItemto = parent.getItemAtPosition(position).toString().trim();
              //  long tospinnervalue = db.addToSpinnerValue(selectedItemto);
              //  if (tospinnervalue > 0) {
                  //  Toast.makeText(getApplicationContext(), " To record inserted" + selectedItemto, Toast.LENGTH_LONG).show();

                       if (selectedItemto.equals(selectedItemfrom)) { rupees.setText(""); }
                     /////////karachi combo
                       else if(((selectedItemfrom.equals("Karachi"))&& (selectedItemto.equals("Islamabad")) )){
                       // rupees.setText(String.valueOf(1550));
                           sp_trainnames.setAdapter(t1);
                        //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();

                    } else if (((selectedItemfrom.equals("Karachi"))&&(selectedItemto.equals("Lahore")))) {
                        //rupees.setText(String.valueOf(1400));
                           sp_trainnames.setAdapter(t2);
                       // Toast.makeText(getApplicationContext(), "150", Toast.LENGTH_LONG).show();

                    }
                    else if( ((selectedItemfrom.equals("Karachi"))&&( selectedItemto.equals("Multan")) )){
                       // rupees.setText(String.valueOf(1000) );
                           sp_trainnames.setAdapter(t3);
                        //Toast.makeText(getApplicationContext(), "200", Toast.LENGTH_LONG).show();

                    }
                       else if( ((selectedItemfrom.equals("Karachi"))&&( selectedItemto.equals("Peshawar")) )){
                          // rupees.setText(String.valueOf(1500) );
                           sp_trainnames.setAdapter(t4);
                           //Toast.makeText(getApplicationContext(), "200", Toast.LENGTH_LONG).show();

                       }
                       ///////////islamabad
                       else if(((selectedItemfrom.equals("Islamabad"))&& (selectedItemto.equals("Karachi")) )){
                         //  rupees.setText(String.valueOf(1550));
                           sp_trainnames.setAdapter(t1);
                           //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();
                       }
                       else if(((selectedItemfrom.equals("Islamabad"))&& (selectedItemto.equals("Lahore")) )){
                         //  rupees.setText(String.valueOf(500));
                           sp_trainnames.setAdapter(t2);
                           //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();
                       }
                       else if(((selectedItemfrom.equals("Islamabad"))&& (selectedItemto.equals("Multan")) )){
                         //  rupees.setText(String.valueOf(600));
                           sp_trainnames.setAdapter(t3);
                           //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();
                       }
                       else if(((selectedItemfrom.equals("Islamabad"))&& (selectedItemto.equals("Peshawar")) )){
                          // rupees.setText(String.valueOf(400));
                           sp_trainnames.setAdapter(t4);
                           //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();
                       }

                       ///////////////////Lahore
                       else if(((selectedItemfrom.equals("Lahore"))&& (selectedItemto.equals("Karachi")) )){
                         //  rupees.setText(String.valueOf(1400));
                           sp_trainnames.setAdapter(t2);
                           //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();
                       }
                       else if(((selectedItemfrom.equals("Lahore"))&& (selectedItemto.equals("Islamabad")) )){
                          // rupees.setText(String.valueOf(500));
                           sp_trainnames.setAdapter(t2);
                           //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();
                       }
                       else if(((selectedItemfrom.equals("Lahore"))&& (selectedItemto.equals("Multan")) )){
                          // rupees.setText(String.valueOf(500));
                           sp_trainnames.setAdapter(t1);
                           //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();
                       }
                       else if(((selectedItemfrom.equals("Lahore"))&& (selectedItemto.equals("Peshawar")) )){
                          // rupees.setText(String.valueOf(700));
                           sp_trainnames.setAdapter(t3);
                           //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();
                       }
                       //////////////////Multan
                       else if(((selectedItemfrom.equals("Multan"))&& (selectedItemto.equals("Karachi")) )){
                          // rupees.setText(String.valueOf(1000));
                           sp_trainnames.setAdapter(t3);
                           //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();
                       }
                       else if(((selectedItemfrom.equals("Multan"))&& (selectedItemto.equals("Islamabad")) )){
                          // rupees.setText(String.valueOf(600));
                           sp_trainnames.setAdapter(t3);
                           //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();
                       }
                       else if(((selectedItemfrom.equals("Multan"))&& (selectedItemto.equals("lahore")) )){
                          // rupees.setText(String.valueOf(500));
                           sp_trainnames.setAdapter(t1);
                           //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();
                       }
                       else if(((selectedItemfrom.equals("Multan"))&& (selectedItemto.equals("Peshawar")) )){
                          // rupees.setText(String.valueOf(1100));
                           sp_trainnames.setAdapter(t2);
                           //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();
                       }
                       /////////////////Peshawar
                       else if(((selectedItemfrom.equals("Peshawar"))&& (selectedItemto.equals("Karachi")) )){
                           //rupees.setText(String.valueOf(1500));
                           sp_trainnames.setAdapter(t4);
                           //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();
                       }
                       else if(((selectedItemfrom.equals("Peshawar"))&& (selectedItemto.equals("Islamabad")) )){
                          // rupees.setText(String.valueOf(400));
                           sp_trainnames.setAdapter(t4);
                           //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();
                       }
                       else if(((selectedItemfrom.equals("Peshawar"))&& (selectedItemto.equals("Lahore")) )){
                         //  rupees.setText(String.valueOf(700));
                           //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();
                           sp_trainnames.setAdapter(t3);
                       }
                       else if(((selectedItemfrom.equals("Peshawar"))&& (selectedItemto.equals("Multan")) )){
                          // rupees.setText(String.valueOf(1100));
                           sp_trainnames.setAdapter(t2);
                           //Toast.makeText(getApplicationContext(), "100", Toast.LENGTH_LONG).show();
                       }



                    else { rupees.setText(String.valueOf(600) );
                       }
                }// else {
                 //   Toast.makeText(getApplicationContext(), "to record insertion failed", Toast.LENGTH_LONG).show();

              //  }


          //  }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });
        sp_trainnames.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int position, long id) {
                selectedItemtrainnames = parent.getItemAtPosition(position).toString().trim();
               // long trainnamesspinnervalue=  db.addTrainNamesSpinnerValue(selectedItemtrainnames );

               // if(trainnamesspinnervalue>0)
              //  {
                  //  Toast.makeText(getApplicationContext()," trainnames record inserted "+selectedItemtrainnames , Toast.LENGTH_LONG).show();
                     if (selectedItemtrainnames.startsWith("Awam Express")){sp_seatno.setAdapter(s1);}
                   else if (selectedItemtrainnames.startsWith("Shalimar Express")){sp_seatno.setAdapter(s2);}
                     else if (selectedItemtrainnames.startsWith("Badar Express")){sp_seatno.setAdapter(s3);}
                     else if (selectedItemtrainnames.startsWith("Super Express")){sp_seatno.setAdapter(s4);}
                     else if (selectedItemtrainnames.startsWith("Chenab Express")){sp_seatno.setAdapter(s5);}
                     else if (selectedItemtrainnames.startsWith("Dachi Express")){sp_seatno.setAdapter(s6);}
                     else if (selectedItemtrainnames.startsWith("Ravi Express")){sp_seatno.setAdapter(s7);}
                     else if (selectedItemtrainnames.startsWith("Faisal Express")){sp_seatno.setAdapter(s8);}
                     else if (selectedItemtrainnames.startsWith("Mehr Express")){sp_seatno.setAdapter(s9);}
                     else if (selectedItemtrainnames.startsWith("Qalandar Express")){sp_seatno.setAdapter(s10);}

                }
              //  else
              ////  {
               //     Toast.makeText(getApplicationContext(),"trainnames record insertion failed", Toast.LENGTH_LONG).show();

              //  }

          //  }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        } );
        sp_seatno.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int position, long id) {
                selectedSeatNumber = parent.getItemAtPosition(position).toString().trim();
              //  seatnumbersspinnervalue=  db.addSeatNumberSpinnerValue(selectedSeatNumber );
                sp_ticketnumb.setAdapter(adapter6);

              /* if(seatnumbersspinnervalue>0)
                {
                    Toast.makeText(getApplicationContext()," seatnumber record inserted "+selectedSeatNumber , Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"seat number record insertion failed", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(),"seat number already taken", Toast.LENGTH_LONG).show();

                }*/

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        } );
        sp_ticketnumb.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int position, long id) {
                TicketNumber = parent.getItemAtPosition(position).toString().trim();
               // long ticketspinnervalue=  db.addTicketsSpinnerValue(TicketNumber);
              //  if(ticketspinnervalue>0)
              ////  {
             //       Toast.makeText(getApplicationContext()," tickets inserted "+TicketNumber , Toast.LENGTH_LONG).show();

             //   }
             //   else
             //   {
             //       Toast.makeText(getApplicationContext(),"ticket record insertion failed", Toast.LENGTH_LONG).show();

             //   }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        } );



      /*  submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long val=  db.addSeatNumberSpinnerValue(selectedSeatNumber );
                if (val > 0) {
                    Toast.makeText(v.getContext(), "New Record Inserted ", Toast.LENGTH_SHORT).show();
                    Intent userlogin=new Intent(v.getContext(),userLogin.class);
                    startActivity(userlogin);
                }
                else{
                    Toast.makeText(v.getContext(), "This seat is already taken..", Toast.LENGTH_SHORT).show();

                }

            }
        });  */
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rs = rupees.getText().toString().trim();

            if (rs.isEmpty()) {
                    Toast.makeText(getApplicationContext(), " Please fill all fields ", Toast.LENGTH_LONG).show();
                }
else
            {
                int intrs=Integer.parseInt(rs);
                String balance = getIntent().getExtras().getString("amount");
                int intbal=Integer.parseInt(balance);
                if(intrs>intbal) {
                    openlDialog();

                    // Toast.makeText(getApplicationContext(), " You have in sufficient balance in your account. kindly go back to add balance and recharge your account ", Toast.LENGTH_LONG).show();}
                }  else {
                    Boolean res = db.checkSeatNumber(selectedSeatNumber);
                    if (res == false) {
                        int remainingBal=intbal-intrs;
                        String Remainingbal=String.valueOf(remainingBal);
                        long values = db.addUsertotrainticket(name, selectedItemfrom,
                                selectedItemto, selectedItemtrainnames, selectedSeatNumber, rs, TicketNumber, balance);
                        if (values > 0) {
                            Toast.makeText(getApplicationContext(), "  record inserted " + values, Toast.LENGTH_LONG).show();
                            Intent detail = new Intent(v.getContext(), Details.class);
                            String name = ed_name.getText().toString();
                            detail.putExtra("username", name);
                            detail.putExtra("from", selectedItemfrom);
                            detail.putExtra("to", selectedItemto);
                            detail.putExtra("trainnames", selectedItemtrainnames);
                            detail.putExtra("seatno", selectedSeatNumber);
                            detail.putExtra("ticketno", TicketNumber);
                            detail.putExtra("rupees", rs);
                            detail.putExtra("Previousbalance", balance);
                            detail.putExtra("Currentbalance", Remainingbal);
                            startActivity(detail);
                        } else {
                            Toast.makeText(getApplicationContext(), " record insertion failed", Toast.LENGTH_LONG).show();
                        }


                    } else {
                        Toast.makeText(getApplicationContext(), "ERROR..seat number already taken", Toast.LENGTH_SHORT).show();
                    }

                }
            } } });



    }
    public void onTrainClicked(View view) {
        switch (view.getId()) {
            case R.id.single: {
                if (selectedItemto.equals(selectedItemfrom)) {
                    rupees.setText("");
                }
                /////////karachi combo
                else if ((selectedItemfrom.equals("Karachi")) && (selectedItemto.equals("Islamabad"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(1550));
                    if (TicketNumber.equals("2")) {
                        int t = 1550 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 1550 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 1550 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 1550 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 1550 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 1550 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 1550 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 1550 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 1550 * 10;
                        rupees.setText(String.valueOf(t));
                    }


                }
                //karachi to lahore
                else if ((selectedItemfrom.equals("Karachi")) && (selectedItemto.equals("Lahore"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(1400));
                    if (TicketNumber.equals("2")) {
                        int t = 1400 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 1400 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 1400 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 1400 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 1400 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 1400 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 1400 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 1400 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 1400 * 10;
                        rupees.setText(String.valueOf(t));
                    }

                }
                //karachi to multan
                else if ((selectedItemfrom.equals("Karachi")) && (selectedItemto.equals("Multan"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(1000));
                    if (TicketNumber.equals("2")) {
                        int t = 1000 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 1000 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 1000 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 1000 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 1000 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 1000 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 1000 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 1000 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 1000 * 10;
                        rupees.setText(String.valueOf(t));
                    }


                }
                //karachi to peshawar
                else if ((selectedItemfrom.equals("Karachi")) && (selectedItemto.equals("Peshawar"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(1500));
                    if (TicketNumber.equals("2")) {
                        int t = 1500 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 1500 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 1500 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 1500 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 1500 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 1500 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 1500 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 1500 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 1500 * 10;
                        rupees.setText(String.valueOf(t));
                    }


                }

                ///////////islamabad
                //isb to karachi
                else if ((selectedItemfrom.equals("Islamabad")) && (selectedItemto.equals("Karachi")) && (sp_trainnames != null)
                        && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(1550));
                    if (TicketNumber.equals("2")) {
                        int t = 1550 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 1550 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 1550 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 1550 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 1550 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 1550 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 1550 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 1550 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 1550 * 10;
                        rupees.setText(String.valueOf(t));
                    }


                } else if ((selectedItemfrom.equals("Islamabad")) && (selectedItemto.equals("Lahore"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(500));
                    if (TicketNumber.equals("2")) {
                        int t = 500 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 500 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 500 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 500 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 500 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 500 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 500 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 500 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 500 * 10;
                        rupees.setText(String.valueOf(t));
                    }


                } else if ((selectedItemfrom.equals("Islamabad")) && (selectedItemto.equals("Multan"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(600));
                    if (TicketNumber.equals("2")) {
                        int t = 600 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 600 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 600 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 600 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 600 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 600 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 600 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 600 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 600 * 10;
                        rupees.setText(String.valueOf(t));
                    }
                }
                //isb to peshawar
                else if ((selectedItemfrom.equals("Islamabad")) && (selectedItemto.equals("Peshawar"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(400));
                    if (TicketNumber.equals("2")) {
                        int t = 400 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 400 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 400 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 400 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 400 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 400 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 400 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 400 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 400 * 10;
                        rupees.setText(String.valueOf(t));
                    }
                }

                ///////////////////Lahore
                else if ((selectedItemfrom.equals("Lahore")) && (selectedItemto.equals("Karachi"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(1400));
                    if (TicketNumber.equals("2")) {
                        int t = 1400 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 1400 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 1400 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 1400 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 1400 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 1400 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 1400 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 1400 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 1400 * 10;
                        rupees.setText(String.valueOf(t));
                    }

                } else if ((selectedItemfrom.equals("Lahore")) && (selectedItemto.equals("Islamabad"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(500));
                    if (TicketNumber.equals("2")) {
                        int t = 500 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 500 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 500 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 500 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 500 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 500 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 500 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 500 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 500 * 10;
                        rupees.setText(String.valueOf(t));
                    }

                } else if ((selectedItemfrom.equals("Lahore")) && (selectedItemto.equals("Multan"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(500));
                    if (TicketNumber.equals("2")) {
                        int t = 500 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 500 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 500 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 500 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 500 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 500 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 500 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 500 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 500 * 10;
                        rupees.setText(String.valueOf(t));
                    }

                } else if ((selectedItemfrom.equals("Lahore")) && (selectedItemto.equals("Peshawar"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(700));
                    if (TicketNumber.equals("2")) {
                        int t = 700 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 700 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 700 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 700 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 700 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 700 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 700 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 700 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 700 * 10;
                        rupees.setText(String.valueOf(t));
                    }

                }
                //////////////////Multan
                else if ((selectedItemfrom.equals("Multan")) && (selectedItemto.equals("Karachi"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(1000));
                    if (TicketNumber.equals("2")) {
                        int t = 1000 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 1000 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 1000 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 1000 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 1000 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 1000 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 1000 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 1000 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 1000 * 10;
                        rupees.setText(String.valueOf(t));
                    }

                } else if ((selectedItemfrom.equals("Multan")) && (selectedItemto.equals("Islamabad"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(600));
                    if (TicketNumber.equals("2")) {
                        int t = 600 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 600 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 600 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 600 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 600 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 600 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 600 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 600 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 600 * 10;
                        rupees.setText(String.valueOf(t));
                    }
                } else if ((selectedItemfrom.equals("Multan")) && (selectedItemto.equals("lahore"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(500));
                    if (TicketNumber.equals("2")) {
                        int t = 500 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 500 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 500 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 500 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 500 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 500 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 500 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 500 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 500 * 10;
                        rupees.setText(String.valueOf(t));
                    }
                } else if ((selectedItemfrom.equals("Multan")) && (selectedItemto.equals("Peshawar"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(1100));
                    if (TicketNumber.equals("2")) {
                        int t = 1100 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 1100 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 1100 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 1100 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 1100 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 1100 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 1100 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 1100 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 1100 * 10;
                        rupees.setText(String.valueOf(t));
                    }
                }
                /////////////////Peshawar
                else if ((selectedItemfrom.equals("Peshawar")) && (selectedItemto.equals("Karachi"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(1500));
                    if (TicketNumber.equals("2")) {
                        int t = 1500 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 1500 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 1500 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 1500 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 1500 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 1500 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 1500 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 1500 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 1500 * 10;
                        rupees.setText(String.valueOf(t));
                    }


                } else if ((selectedItemfrom.equals("Peshawar")) && (selectedItemto.equals("Islamabad"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(400));
                    if (TicketNumber.equals("2")) {
                        int t = 400 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 400 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 400 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 400 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 400 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 400 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 400 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 400 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 400 * 10;
                        rupees.setText(String.valueOf(t));
                    }

                } else if ((selectedItemfrom.equals("Peshawar")) && (selectedItemto.equals("Lahore"))
                        && (sp_trainnames != null) && (sp_seatno != null)) {
                    if (TicketNumber.equals("1"))
                        rupees.setText(String.valueOf(700));
                    if (TicketNumber.equals("2")) {
                        int t = 700 * 2;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("3")) {
                        int t = 700 * 3;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("4")) {
                        int t = 700 * 4;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("5")) {
                        int t = 700 * 5;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("6")) {
                        int t = 700 * 6;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("7")) {
                        int t = 700 * 7;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("8")) {
                        int t = 700 * 8;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("9")) {
                        int t = 700 * 9;
                        rupees.setText(String.valueOf(t));
                    }
                    if (TicketNumber.equals("10")) {
                        int t = 700 * 10;
                        rupees.setText(String.valueOf(t));
                    }


                } else if (((selectedItemfrom.equals("Peshawar")) && (selectedItemto.equals("Multan")))) {
                    rupees.setText(String.valueOf(1100));
                }

            }
            break;
            case R.id.returnbtn:
                String r1 = rupees.getText().toString();
                if (r1.isEmpty()) {
                    rupees.setText("");
                } else {
                    int r2 = Integer.parseInt(r1);
                    int r3 = r2 * 2;
                    rupees.setText(String.valueOf(r3));
                }
                break;
        }
    }
    public void openlDialog()
    {
        lDialog ldialog=new lDialog();
        ldialog.show(getSupportFragmentManager(),"Lose Dialog");
    }
}
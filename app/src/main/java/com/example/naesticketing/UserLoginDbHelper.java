package com.example.naesticketing;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class UserLoginDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "registerUser";//table 1
    public static final String TABLE_NAME1 = "TrainTicket";//table 2
    public static final String TABLE_NAME2="AddBalance";//table 3
    //table 1 column names
    public static final String COL_1 = "ID";//Primary key also common column
    public static final String COL_2 = "username";
    public static final String COL_3 = "password";
    //table 2 column names
    public static final String COL_ttId = "ttID";
    public static final String COL_username = "username";
    public static final String COL_from = "FromspinnerValue";
    public static final String COL_to = "TospinnerValue";
    public static final String COL_trainNames = "TrainNamesSpinnerValue";
    public static final String COL_seatNumber = "SeatNumbersSpinnerValue";
    public static final String COL_rs = "trainticket";
    public static final String COL_tickets = "AddTicket";
    public static final String COL_addamount = "AddAmount";
    //table 3 colum names
    public static final String Col_card="Card";
    public static final String Col_cvv="CVV";
    public static final String Col_Name="Name";

    public UserLoginDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_NAME + " (" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                COL_2 + " TEXT UNIQUE NOT NULL , " +
                COL_3 + " TEXT  NOT NULL);"
        );
        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_NAME1 + " (" +
                COL_ttId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_username+ " TEXT, " +
                COL_from + " TEXT,"+
                COL_to + " TEXT," +
                COL_trainNames+ " TEXT," +
                COL_seatNumber+ " TEXT UNIQUE," +
                COL_rs + " INTEGER,"+
                COL_tickets + " INTEGER,"+
                COL_addamount + " INTEGER );"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME2 + " ( " +
                Col_card + "TEXT ," +
                Col_cvv + "TEXT," +
                Col_Name + "TEXT );"
        );
        // TODO Auto-generated method stub
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        Log.w(TAG, "Upgrading database from version " + oldVersion

                + " to "

                + newVersion + ", which will destroy all old data");

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS registerUser");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS TrainTicket");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS AddBalance");


        onCreate(sqLiteDatabase);

    }
    public long addUser( String username,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long res= db.insert("registerUser",null,contentValues);
        db.close();
        return res;

    }
    public long addUsertotrainticket( String username,String from,String to,String trainnames,
            String seatnumber,String rs,String tickets,String bal)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("FromspinnerValue",from);
        contentValues.put("TospinnerValue",to);
        contentValues.put("TrainNamesSpinnerValue",trainnames);
        contentValues.put("SeatNumbersSpinnerValue",seatnumber);
        contentValues.put("trainticket",rs);
        contentValues.put("AddTicket",tickets);
        contentValues.put("AddAmount",bal);
        long res= db.insert("TrainTicket",null,contentValues);
        db.close();
        return res;

    }
    public long addBalance(String card, String cvv,String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Card",card);
        contentValues.put("Cvv",cvv);
        contentValues.put("Name",name);
        long value;
        value = db.insert("AddBalance",null,contentValues);

        db.close();
        return value;
    }


    public boolean checkUser(String username,String password)
    {
        String[] columns={COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection= COL_2 + "=?" + " and " + COL_3 + "=?" ;
        String[] selectionArgs={username,password};
        Cursor cursor=db.query(TABLE_NAME,columns,selection,selectionArgs,null ,null,null);
        int count=cursor.getCount();
        cursor.close();
        db.close();
        if(count>0)
        { return true;}
        else
        { return  false;}
    }

   /* public boolean checkUsername(String username)
    {
        String[] columns={COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection= COL_2 + "=?"  ;
        String[] selectionArgs={username};
        Cursor cursor=db.query(TABLE_NAME,columns,selection,selectionArgs,null ,null,null);
        int count=cursor.getCount();
        cursor.close();
        db.close();
        if(count>0)
        { return true;}
        else
        { return  false;}
    }
    public String returnId()
    {
        SQLiteDatabase db = getReadableDatabase();
        return COL_1;

    }

    public long addSpinnerValue( String username,String fromspinnerValue, String tospinnerValue)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("FromspinnerValue",fromspinnerValue);
        contentValues.put("TOspinnerValue",tospinnerValue);
        long spinnervalue= db.insert("TrainTicket",null,contentValues);
        db.close();
        return spinnervalue;

    }*/public boolean searchName(String username)
   {
       String[] columns={COL_1};
       SQLiteDatabase db=getReadableDatabase();
       String selection=COL_2 + "=?";
       String[] selectionArgs={username};
       Cursor cursor=db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
       int count=cursor.getCount();
       cursor.close();
       db.close();
       if (count>0)
       {
           return true;
       }
       else{return false;}
   }
  /*  public String returnId()
    {
        SQLiteDatabase db = getReadableDatabase();
        return COL_1;

    }

    public long addFromSpinnerValue( String fromspinnerValue)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("FromspinnerValue",fromspinnerValue);
        long fromspinnervalue= db.insert("TrainTicket",null,contentValues);
        db.close();
        return fromspinnervalue;

    }
    public long addToSpinnerValue( String tospinnerValue)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("TOspinnerValue",tospinnerValue);
        long tospinnervalue= db.insert("TrainTicket",null,contentValues);
        db.close();
        return tospinnervalue;

    }
    public long addTrainNamesSpinnerValue( String trainnamesSpinnerValue)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("TrainNamesSpinnerValue",trainnamesSpinnerValue);
        long trainnamesspinnervalue= db.insert("TrainTicket",null,contentValues);
        db.close();
        return trainnamesspinnervalue;

    }

    public long addSeatNumberSpinnerValue( String seatnumbersSpinnerValue)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("SeatNumbersSpinnerValue",seatnumbersSpinnerValue);
        long seatnumbersspinnervalue= db.insert("TrainTicket",null,contentValues);
        db.close();
        return seatnumbersspinnervalue;

    }
    public long addRupees( String rupee)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("trainticket",rupee);
        long addrupee= db.insert("TrainTicket",null,contentValues);
        db.close();
        return addrupee;

    }
    public long addTicketsSpinnerValue( String ticketsSpinnerValue)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("AddTicket",ticketsSpinnerValue);
        long ticketsspinnervalue= db.insert("TrainTicket",null,contentValues);
        db.close();
        return ticketsspinnervalue;

    }
    public long addAmount( String addamount)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("AddAmount",addamount);
        long amount= db.insert("TrainTicket",null,contentValues);
        db.close();
        return amount;

    }
 */   public boolean checkSeatNumber(String seatnumber)
    {
        String[] columns={COL_ttId };
        SQLiteDatabase db = getReadableDatabase();
        String selection= COL_seatNumber + "=?"  ;
        String[] selectionArgs={seatnumber};
        Cursor cursor=db.query(TABLE_NAME1,columns,selection,selectionArgs,null ,null,null);
        int count=cursor.getCount();
        cursor.close();
        db.close();
        if(count>0)
        { return true;}
        else
        { return  false;}
    }
public Cursor Getamount(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT * from "+ TABLE_NAME1,null);
        return  res;
}
    public Cursor GetallData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT * from "+ TABLE_NAME1,null);
        return  res;
    }
}
package com.example.sidebar;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper
{
    private static final String dbname = "expensify_db.db";
    public dbHelper(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS addincome(incomeid INTEGER PRIMARY KEY AUTOINCREMENT,date DATE NOT NULL,amount INTEGER NOT NULL,note Text NOT NULL,paymentmode Text NOT NULL)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public String AddRecord(String date, int amount, String note,String paymentmode)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", date);
        contentValues.put("amount", amount);
        contentValues.put("note", note);
        contentValues.put("paymentmode", paymentmode);
        Long res = db.insert("addincome", null, contentValues);

        if (res == -1) { return "failed";}
        else { return "SuccessFully Inserted";}
    }
}

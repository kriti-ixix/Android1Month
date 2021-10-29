package com.kriti.android1month;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper
{
    public static final String DB_NAME = "school";
    public static final String TABLE_NAME = "students";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    long addData(int rn, String n, double m)
    {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("rollno", rn);
        cv.put("name", n);
        cv.put("marks", m);
        return sq.insert(TABLE_NAME, null, cv);
    }

    int updateData(int rn, String n)
    {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", n);
        return sq.update(TABLE_NAME, cv, "rollno = " + rn, null);
    }

    int deleteData(int rn)
    {
        SQLiteDatabase sq = this.getWritableDatabase();
        return sq.delete(TABLE_NAME, "rollno = " + rn, null);
    }

    ArrayList<StudentInfo> getAllData()
    {
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor cursor = sq.rawQuery("select * from " + TABLE_NAME, null);

        ArrayList<StudentInfo> list = new ArrayList<StudentInfo>();

        while (cursor.moveToNext())
        {
            StudentInfo stdInfo = new StudentInfo();

            stdInfo.setsRollNo(cursor.getInt(0));
            stdInfo.setsName(cursor.getString(1));
            stdInfo.setsMarks(cursor.getDouble(2));

            list.add(stdInfo);
        }

        return list;
    }

    StudentInfo getInfo(int roll)
    {
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor cursor = sq.rawQuery("select * from " + TABLE_NAME + " where rollno = " + roll, null);

        StudentInfo stdInfo = new StudentInfo();

        if (cursor.moveToNext())
        {
            stdInfo.setsRollNo(cursor.getInt(0));
            stdInfo.setsName(cursor.getString(1));
            stdInfo.setsMarks(cursor.getDouble(2));
        }

        return stdInfo;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        //sqLiteDatabase.execSQL("create database " + DB_NAME + ";");
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (rollno integer, name text, marks double)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}
}

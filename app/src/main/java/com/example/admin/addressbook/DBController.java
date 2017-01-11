package com.example.admin.addressbook;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017-01-11.
 */
public class DBController extends SQLiteOpenHelper {
    private Context context;
    public DBController(Context context){
        this(context,"address",null,1);
        this.context=context;
    }

    public DBController(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // DB를 새로 생성할 때 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db) {
        //테이블생성
        //테이블 이름 : ADDRESSBOOK, 속성값들은 : 이름, 휴대폰번호, 집번호, 이메일
        db.execSQL("CREATE TABLE ADDRESSBOOK (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, cell TEXT, house TEXT, email TEXT);");
    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //데이터 삽입
    public void insert(String name, String cell, String house, String email) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO ADDRESSBOOK VALUES(null,'" + name + "', '" + cell + "', '" + house + "','" + email + "');");
        db.close();
    }

    //데이터 갱신
    public void update(String name,String cell,String house,String email) {
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행의 가격 정보 수정
        db.execSQL("UPDATE ADDRESSBOOK SET cell=" + cell + ", house="+house+", email="+email+", WHERE name='" + name + "';");
        db.close();
    }

    //데이터 삭제
    public void delete(String name) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM ADDRESSBOOK WHERE name='" + name + "';");
        db.close();
    }

    //결과 조회
    public String getResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM ADDRESSBOOK", null);
        while (cursor.moveToNext()) {
            result += cursor.getString(0)
                    + " : "
                    + cursor.getString(1)
                    + " | "
                    + cursor.getString(2)
                    + " | "
                    + cursor.getString(3)
                    + " | "
                    + cursor.getString(4)
                    + "\n";
        }

        return result;
    }
    public List<AddressInfo> getAllAddress(){

        SQLiteDatabase db=getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM ADDRESSBOOK", null);
        List<AddressInfo> addressList = new ArrayList<AddressInfo>();
        AddressInfo addressInfo = null;

        while (cursor.moveToNext()){
            addressInfo = new AddressInfo();
            addressInfo.setName(cursor.getString(0));
            addressInfo.setCell(cursor.getString(1));
            addressInfo.setHouse(cursor.getString(2));
            addressInfo.setEmail(cursor.getString(3));
            addressList.add(addressInfo);
        }
        return addressList;
    }
}


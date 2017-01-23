package com.example.admin.addressbook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    DBController dbController;
    SQLiteDatabase db;
    Cursor addressCursor;
    ListView addressList;
    AddressAdapter addressAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);



        setTitle("주소록");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        addressList = (ListView)findViewById(R.id.listview);


    }
    protected void onResume(){
        super.onResume();
        dbController=new DBController(getApplicationContext());
        db=dbController.getReadableDatabase();
        addressCursor=db.rawQuery("SELECT * FROM ADDRESSBOOK",null);
        addressAdapter=new AddressAdapter(this,addressCursor);
        addressList.setAdapter(addressAdapter);
    }

}

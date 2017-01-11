package com.example.admin.addressbook;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView addressList;

    private  DBController dbController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        dbController = new DBController(this);

        setTitle("주소록");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        addressList = (ListView) findViewById(R.id.listview);

        List<AddressInfo> addressInfoList = dbController.getAllAddress();
        addressList.setAdapter(new AddressAdapter(addressInfoList, this));
    }

}

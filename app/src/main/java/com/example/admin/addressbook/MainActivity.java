package com.example.admin.addressbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by admin on 2017-01-11.
 */
public class MainActivity extends AppCompatActivity{
    private Button mAddButton;
    private Button mListButton;
    private Button mSearchButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAddButton=(Button)findViewById(R.id.add);
        mListButton=(Button)findViewById(R.id.list);
        mSearchButton=(Button)findViewById(R.id.search);

        mAddButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent addIntent=new Intent(MainActivity.this,AddActivity.class);
                startActivity(addIntent);
            }
        });
        mListButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent listIntent=new Intent(MainActivity.this,ListActivity.class);
                startActivity(listIntent);
            }
        });
        mSearchButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent searchIntent=new Intent(MainActivity.this,SearchActivity.class);
                startActivity(searchIntent);
            }
        });
    }
}
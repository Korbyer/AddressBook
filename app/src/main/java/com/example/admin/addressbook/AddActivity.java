package com.example.admin.addressbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by admin on 2017-01-11.
 */

public class AddActivity extends AppCompatActivity{
    DBController dbController;
    TextView result;
    EditText txtName;
    EditText txtCell;
    EditText txtHouse;
    EditText txtEmail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        dbController=new DBController(getApplicationContext(),"ADDRESSBOOK.db",null,1);
        result = (TextView) findViewById(R.id.result);
        txtName = (EditText) findViewById(R.id.name);
        txtCell = (EditText) findViewById(R.id.cell);
        txtHouse = (EditText) findViewById(R.id.house);
        txtEmail=(EditText) findViewById(R.id.email);

        // DB에 데이터 추가
        Button insert = (Button) findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String cell = txtCell.getText().toString();
                String house = txtHouse.getText().toString();
                String email=txtEmail.getText().toString();

                dbController.insert(name,cell,house,email);
                result.setText(dbController.getResult());
                Toast.makeText(AddActivity.this,"추가되었습니다!",Toast.LENGTH_SHORT).show();
            }
        });

        // DB에 있는 데이터 수정
        Button update = (Button) findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String cell = txtCell.getText().toString();
                String house = txtHouse.getText().toString();
                String email=txtEmail.getText().toString();

                dbController.update(name,cell,house,email);
                result.setText(dbController.getResult());
                Toast.makeText(AddActivity.this,"수정되었습니다!",Toast.LENGTH_SHORT).show();
            }
        });

        // DB에 있는 데이터 삭제
        Button delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();

                dbController.delete(name);
                result.setText(dbController.getResult());
                Toast.makeText(AddActivity.this,"삭제되었습니다!",Toast.LENGTH_SHORT).show();
            }
        });

        // DB에 있는 데이터 조회
        Button select = (Button) findViewById(R.id.select);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(dbController.getResult());
                Toast.makeText(AddActivity.this,"조회되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

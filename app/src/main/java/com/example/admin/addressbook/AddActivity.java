package com.example.admin.addressbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by admin on 2017-01-11.
 */

public class AddActivity extends AppCompatActivity{
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        final DBController dbController = new DBController(getApplicationContext(), "ADDRESSBOOK.db", null, 1);

        // 테이블에 있는 모든 데이터 출력
            //
            final TextView result = (TextView) findViewById(R.id.result);

            final EditText txtName = (EditText) findViewById(R.id.name);
            final EditText txtCell = (EditText) findViewById(R.id.cell);
            final EditText txtHouse = (EditText) findViewById(R.id.house);
            final EditText txtEmail=(EditText) findViewById(R.id.email);

        // 날짜는 현재 날짜로 고정
        // 현재 시간 구하기
        /*long now = System.currentTimeMillis();
        Date date = new Date(now);
        // 출력될 포맷 설정
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
        etDate.setText(simpleDateFormat.format(date));*/

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
            }
        });

        // DB에 있는 데이터 조회
        Button select = (Button) findViewById(R.id.select);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(dbController.getResult());
            }
        });
    }
}
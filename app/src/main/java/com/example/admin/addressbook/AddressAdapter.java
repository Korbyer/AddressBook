package com.example.admin.addressbook;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by admin on 2017-01-12.
 */
public class AddressAdapter extends CursorAdapter{
    public AddressAdapter(Context context, Cursor cursor){
        super(context,cursor,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.content_list,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView adName=(TextView)view.findViewById(R.id.name);
        TextView adCell=(TextView)view.findViewById(R.id.cell);
        TextView adHouse=(TextView)view.findViewById(R.id.house);
        TextView adEmail=(TextView)view.findViewById(R.id.email);

        String name=cursor.getString(cursor.getColumnIndex("name"));
        String cell=cursor.getString(cursor.getColumnIndex("cell"));
        String house=cursor.getString(cursor.getColumnIndex("house"));
        String email=cursor.getString(cursor.getColumnIndex("email"));

        adName.setText(name);
        adCell.setText(cell);
        adHouse.setText(house);
        adEmail.setText(email);

    }
}
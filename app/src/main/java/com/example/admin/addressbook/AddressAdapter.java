package com.example.admin.addressbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 2017-01-12.
 */
public class AddressAdapter extends BaseAdapter {

    private List<AddressInfo> addressInfoList;
    private Context context;

    public AddressAdapter(List<AddressInfo> addressInfoList, Context context) {
        this.addressInfoList = addressInfoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return addressInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return addressInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        AddressHolder holder = null;
        if(convertView == null){
            holder = new AddressHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.content_list, parent, false);

            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.txtCell = (TextView) convertView.findViewById(R.id.cell);
            holder.txtHouse = (TextView) convertView.findViewById(R.id.house);
            holder.txtEmail = (TextView) convertView.findViewById(R.id.email);

        }
        else{
            holder = (AddressHolder) convertView.getTag();
        }

        AddressInfo addAdressInfo = (AddressInfo) getItem(position);

        holder.txtName.setText(addAdressInfo.getName());
        holder.txtCell.setText(addAdressInfo.getCell());
        holder.txtHouse.setText(addAdressInfo.getHouse());
        holder.txtEmail.setText(addAdressInfo.getEmail());

        convertView.setTag(holder);
        return convertView;
    }
}
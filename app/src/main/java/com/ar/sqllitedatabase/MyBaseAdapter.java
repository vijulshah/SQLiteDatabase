package com.ar.sqllitedatabase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyBaseAdapter extends BaseAdapter {
    Context context;
    ArrayList<ContactModel> cn;

    public MyBaseAdapter(Context context, ArrayList<ContactModel> cn) {

        this.context = context;
        this.cn = cn;
    }

    @Override
    public int getCount()
    {

        return cn.size();
    }

    @Override
    public Object getItem(int position) {

        return cn.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.raw_list, null);

        }
         final ContactModel contactModel = (ContactModel) getItem(position);
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        tvName.setText(cn.get(position).getFirstName() +
                "  " + cn.get(position).getLastName());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strfn = cn.get(position).getFirstName();
                String strln = contactModel.getLastName();
                String strid = contactModel.getID();


                Intent i = new Intent(context, UpdateActivity.class);
                i.putExtra("FN_KEY",strfn );
                i.putExtra("LN_KEY",strln );
                i.putExtra("ID_KEY",strid );

                context.startActivity(i);

            }
        });
        return convertView;
    }
}

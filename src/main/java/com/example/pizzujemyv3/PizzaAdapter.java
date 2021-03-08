package com.example.pizzujemyv3;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class PizzaAdapter extends ArrayAdapter<Pizza> {
    private Context mContext;
    private int mResource;
    public PizzaAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Pizza> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);


        convertView = layoutInflater.inflate(mResource,parent,false);

        TextView txtSumPrice = convertView.findViewById(R.id.sumTxtPrice);

        TextView addCounter = convertView.findViewById(R.id.addCounter);

        ImageView imageView = convertView.findViewById(R.id.image);

        TextView txtName = convertView.findViewById(R.id.txtName);

        TextView txtPrice = convertView.findViewById(R.id.txtPrice);

        TextView txtContent = convertView.findViewById(R.id.txtContent);

        Button minButton = convertView.findViewById(R.id.minButton);

        Button addButton = convertView.findViewById(R.id.addButton);

        imageView.setImageResource(Integer.parseInt(toString().valueOf(getItem(position).getResID())));
        addCounter.setText((getItem(position).getStringOnOrder()));

        txtName.setText(getItem(position).getName());

        txtSumPrice.setText(getItem(position).getStringSumPrice());

        txtPrice.setText(getItem(position).getStringPrice());

        txtContent.setText(getItem(position).getDes());

        minButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getItem(position).minOnOrder();
                addCounter.setText(((getItem(position).getStringOnOrder())));
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                Toast.makeText(getContext(), "Dodano do koszyka!", Toast.LENGTH_SHORT).show();
                getItem(position).addOnOrder();
                addCounter.setText((getItem(position).getStringOnOrder()));
            }
        });


        return convertView;
    }

}
package com.example.pizzujemyv3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class rvPizzaAdapter {
    private Context mContext;
    private PizzaAdapter mPizzaAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, ArrayList<Pizza> pizzaArrayList, ArrayList<String> keys){
        mContext = context;
        mPizzaAdapter = new PizzaAdapter(pizzaArrayList, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mPizzaAdapter);

    }
    class PizzaItemView  extends RecyclerView.ViewHolder{
        private TextView mName;
        private TextView mDes;
        private TextView mPrice;
        private TextView mSumPrice;
        private TextView mCounter;
        private View rootView = itemView;
        ImageView mImage;
        Button minButton;
        Button addButton;

        private String key;
        public PizzaItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.pizza_list_row, parent, false));

            mName = (TextView) itemView.findViewById(R.id.name);
            mDes = (TextView) itemView.findViewById(R.id.des);
            mPrice = (TextView) itemView.findViewById(R.id.price);
            mSumPrice = (TextView) itemView.findViewById(R.id.sumPrice);
            mCounter = (TextView) itemView.findViewById(R.id.counter);
          //  mImage = itemView.findViewById(R.id.image);
     /*   addButton.findViewById(R.id.addbutton).setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Toast.makeText(mContext, "Dodano do koszyka!", Toast.LENGTH_SHORT).show();
               }
           });
               minButton.findViewById(R.id.minButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Usunieto z koszyka!", Toast.LENGTH_SHORT).show();
                }
            });
        */}
        public void bind(Pizza pizza, String key){
            mName.setText(pizza.getName());
            mDes.setText(pizza.getDes());
            mPrice.setText(pizza.getStringPrice());
            mSumPrice.setText(pizza.getStringSumPrice());
            mCounter.setText(pizza.getStringOnOrder());
          //  Glide.with(mContext).load(pizza.getResID()).into(mImage);
            this.key = key;
        }
    }
    class PizzaAdapter extends RecyclerView.Adapter<PizzaItemView>{
        private ArrayList<Pizza> pizzaArrayList;
        private ArrayList<String> mKeys;

        public PizzaAdapter(ArrayList<Pizza> pizzaArrayList, ArrayList<String> mKeys){
            this.pizzaArrayList = pizzaArrayList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public PizzaItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PizzaItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull PizzaItemView holder, int position) {
            holder.bind(pizzaArrayList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return pizzaArrayList.size();
        }
    }

}

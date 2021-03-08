package com.example.pizzujemyv3;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CartActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
ArrayList<Pizza> menuArrayList = new ArrayList<>();
Switch oSwitch;
Button oButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

       /* ArrayList<Pizza> cartArrayList = new ArrayList<>();
      menuArrayList = getIntent().getParcelableArrayListExtra("pizzas");
       Cart cart= new Cart(menuArrayList);
        TextView totalPrice = (TextView)findViewById(R.id.totalPrice);
        totalPrice.setText("Cena: " + cart.getStringTotalPrice());
*/
        new FirebaseDatabaseHelper().readPizzas(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(ArrayList<Pizza> pizzaArrayList, ArrayList<String> keys) {
                new rvPizzaAdapter().setConfig(mRecyclerView,CartActivity.this, pizzaArrayList,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

       oButton = findViewById(R.id.zamow);
       oButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            if(oSwitch.isChecked());

               {
                   Toast.makeText(getApplicationContext(),"Szacowany czas oczekiwania: 50 minut", Toast.LENGTH_SHORT);
               }
           }
       });


    }
}
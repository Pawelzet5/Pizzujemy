package com.example.pizzujemyv3;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    ListView menuListView;
    Button cartButton;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

       recyclerView = findViewById(R.id.recyclerView);
        ArrayList<Pizza> arrayList = new ArrayList<>();

       arrayList.add(new Pizza(1, "Margarita", "24", R.drawable.img1 , "sos pomidorowy\nmozzarella fior di latte", 0));
        arrayList.add(new Pizza(2, "Marinara", "22", R.drawable.img2, "sos pomidorowy\noregano\nczosnek\nbazylia",0));
        arrayList.add(new Pizza(3, "Napoli", "26", R.drawable.img3 , "sos pomidorowy\nmozzarella fior di latte\nsalami napoli",0));
        arrayList.add(new Pizza(4, "Parma", "26", R.drawable.img4 ,"sos pomidorowy\nmozzarella fior di latte\ncebula czerwona\nszynka parmenska",0));
        arrayList.add(new Pizza(5, "Diavola", "28", R.drawable.img5 ,"sos pomidorowy\nmozzarella fior di latte\ncebula czerwona\nsalami spianata piccante",0));

        PizzaAdapter pizzaAdapter = new PizzaAdapter(this,R.layout.list_row,arrayList);
        menuListView.setAdapter(pizzaAdapter);


        cartButton = findViewById(R.id.cart);

        cartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, CartActivity.class);
                intent.putParcelableArrayListExtra("pizzas",arrayList);
                startActivity(intent);
           };
    });
}}

package com.example.pizzujemyv3;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferencePizza;
    private ArrayList<Pizza> pizzaArrayList = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(ArrayList<Pizza> pizzaArrayList, ArrayList<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper(){
        mDatabase = FirebaseDatabase.getInstance();
        mReferencePizza = mDatabase.getReference("Pizze");
    }
    public void readPizzas(final DataStatus dataStatus){
        mReferencePizza.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                pizzaArrayList.clear();
                ArrayList<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    Pizza pizza = keyNode.getValue(Pizza.class);
                    pizzaArrayList.add(pizza);
                }
                dataStatus.DataIsLoaded(pizzaArrayList,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

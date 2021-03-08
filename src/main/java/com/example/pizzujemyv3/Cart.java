package com.example.pizzujemyv3;

import java.util.ArrayList;

public class Cart {
    public ArrayList<Pizza> cartLista = new ArrayList<>();
    private int totalPrice = 0;
    public Cart(ArrayList<Pizza> menuList){
        setCartLista(menuList);
        setTotalPrice();
    }
    public void setCartLista(ArrayList<Pizza> menuList)
    {
        menuList.forEach(pizza -> addToCart(pizza));
    }

    public void addToCart(Pizza pizza){
        if(pizza.getOnOrder()>0)
        {
            cartLista.add(new Pizza(pizza));
        }
    }


    public void setTotalPrice()
    {
    cartLista.forEach(pizza -> totalPrice+= pizza.getSumPrice());
    }

    public int getTotalPrice(){return totalPrice;}
    public String getStringTotalPrice(){return String.valueOf(totalPrice);}
}


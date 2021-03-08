package com.example.pizzujemyv3;

import android.os.Parcel;
import android.os.Parcelable;


public class Pizza implements Parcelable {
    private int id;
    private String name;
    private String price;
    private int resID;
    private String des;
    private int onOrder = 0;

    public Pizza(){

    }

    public Pizza(int id, String name, String price, int resID, String des, int onOrder) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.resID = resID;
        this.des = des;
        this.onOrder = onOrder;
    }

    public Pizza(Pizza pizza)
    {
        this.id = pizza.id;
        this.name = pizza.name;
        this.price = pizza.price;
        this.resID = pizza.resID;
        this.des = pizza.des;
        this.onOrder = pizza.onOrder;
    }


    protected Pizza(Parcel in) {
        id = in.readInt();
        name = in.readString();
        price = in.readString();
        resID = in.readInt();
        des = in.readString();
        onOrder = in.readInt();
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Pizza> CREATOR = new Parcelable.Creator<Pizza>() {
        @Override
        public Pizza createFromParcel(Parcel in) {
            return new Pizza(in);
        }

        @Override
        public Pizza[] newArray(int size) {
            return new Pizza[size];
        }
    };

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", resID=" + resID +
                ", isActive=" + des +
                '}';
    }
    //getery i setery

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return Integer.parseInt(price);
    }

    public String getStringPrice() {return String.valueOf(price);}

    public void setPrice(String price) {
        this.price = price;
    }

    public String getResID() {
        return toString().valueOf(resID);
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    public int getOnOrder(){return onOrder;}
    public void addOnOrder(){this.onOrder += 1;}
    public void minOnOrder(){if(onOrder>0) this.onOrder -= 1;}
    public String getStringOnOrder(){return String.valueOf((onOrder));}
    public int getSumPrice(){return getPrice()*onOrder;}
    public String getStringSumPrice(){return String.valueOf(getSumPrice());}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(price);
        dest.writeInt(resID);
        dest.writeString(des);
        dest.writeInt(onOrder);
    }
}

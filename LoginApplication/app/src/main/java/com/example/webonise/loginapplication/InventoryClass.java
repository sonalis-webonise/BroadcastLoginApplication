package com.example.webonise.loginapplication;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;

/**
 * Created by webonise on 20/9/16.
 */
public class InventoryClass extends RealmObject implements Parcelable {

    public int model, quantity;
    public String category;

    public InventoryClass() {

    }

    public InventoryClass(int model, String category, int quantity) {
        this.model = model;
        this.category = category;
        this.quantity = quantity;
    }

    protected InventoryClass(Parcel in) {
        model = in.readInt();
        category = in.readString();
        quantity = in.readInt();
    }

    public void setModel(int model) {
        this.model = model;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getModel() {
        return model;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public static final Creator<InventoryClass> CREATOR = new Creator<InventoryClass>() {
        @Override
        public InventoryClass createFromParcel(Parcel in) {
            return new InventoryClass(in);
        }

        @Override
        public InventoryClass[] newArray(int size) {
            return new InventoryClass[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(model);
        dest.writeString(category);
        dest.writeInt(quantity);
    }
}

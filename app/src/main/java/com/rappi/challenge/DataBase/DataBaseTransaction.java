package com.rappi.challenge.DataBase;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by yxzan on 15/02/2017.
 */

public class DataBaseTransaction {
    private Realm myRealm;

    public DataBaseTransaction() {
    }

    public Realm InitializeDatabase(Context context){
        myRealm = Realm.getInstance(context);
        return myRealm;
    }

    public void addProduct(String nameProduct, String bodyProduct, String imageProduct, String price, String category){
        myRealm.beginTransaction();

        // Create an object
        ProductTable productTable1 = myRealm.createObject(ProductTable.class);

        // Set its fields
        productTable1.setNameProduct(nameProduct);
        productTable1.setBodyProduct(bodyProduct);
        productTable1.setImageProduct(imageProduct);
        productTable1.setPriceProduct(price);
        productTable1.setCategory(category);

        myRealm.commitTransaction();
    }

    public RealmResults<ProductTable> getAll(){

        return myRealm.where(ProductTable.class).findAll();
    }

    public RealmResults<ProductTable> searchCategory(String category){
        return myRealm.where(ProductTable.class).equalTo("category", category).findAll();
    }

    public boolean searchProduct(String nameProduct){
        ProductTable result = myRealm.where(ProductTable.class).equalTo("nameProduct", nameProduct).findFirst();
        return result != null;
    }

    public int sizeAllProduct(){

        RealmResults<ProductTable> result = myRealm.where(ProductTable.class).findAll();
        return result.size();

    }
}


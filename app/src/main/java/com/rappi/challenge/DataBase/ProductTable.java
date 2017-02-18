package com.rappi.challenge.DataBase;

import io.realm.RealmObject;

/**
 * Created by yxzan on 15/02/2017.
 */
public class ProductTable extends RealmObject {

    private String nameProduct, bodyProduct, imageProduct, priceProduct, category;

    public ProductTable() { }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String name) {
        this.nameProduct = name;
    }

    public String getBodyProduct() {
        return bodyProduct;
    }

    public void setBodyProduct(String bodyProduct) {
        this.bodyProduct = bodyProduct;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
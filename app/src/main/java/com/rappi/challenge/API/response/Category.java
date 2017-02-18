package com.rappi.challenge.API.response;

/**
 * Created by yxzan on 14/02/2017.
 */

public class Category {

    private Attributes attributes;

    public Category(Attributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Category{" +
                "attributes=" + attributes +
                '}';
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

}
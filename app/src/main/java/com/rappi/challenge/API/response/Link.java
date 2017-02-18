package com.rappi.challenge.API.response;

/**
 * Created by yxzan on 14/02/2017.
 */

public class Link {

    private Attributes attributes;

    public Link(Attributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Link{" +
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
package com.rappi.challenge.API.response;

/**
 * Created by yxzan on 14/02/2017.
 */
public class ImReleaseDate {

    private String label;
    private Attributes attributes;


    public ImReleaseDate(String label, Attributes attributes) {
        this.label = label;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "ImReleaseDate{" +
                "label='" + label + '\'' +
                ", attributes=" + attributes +
                '}';
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

}
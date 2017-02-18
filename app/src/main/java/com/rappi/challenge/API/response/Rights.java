package com.rappi.challenge.API.response;

/**
 * Created by yxzan on 14/02/2017.
 */

public class Rights {

    private String label;


    public Rights(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Rights{" +
                "label='" + label + '\'' +
                '}';
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
package com.rappi.challenge.API.response;

/**
 * Created by yxzan on 14/02/2017.
 */

public class ImName {

    private String label;

    public ImName(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "ImName{" +
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
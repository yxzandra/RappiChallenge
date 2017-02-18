package com.rappi.challenge.API.response;

/**
 * Created by yxzan on 14/02/2017.
 */

public class Title {

    private String label;

    public Title(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Title{" +
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
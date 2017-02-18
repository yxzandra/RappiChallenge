package com.rappi.challenge.API.response;

/**
 * Created by yxzan on 14/02/2017.
 */

public class Summary {

    private String label;

    public Summary(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Summary{" +
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
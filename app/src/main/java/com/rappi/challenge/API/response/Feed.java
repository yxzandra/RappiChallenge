package com.rappi.challenge.API.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yxzan on 14/02/2017.
 */

public class Feed {

    private ArrayList<Entry> entry;

    public Feed(ArrayList<Entry> entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "entry=" + entry +
                '}';
    }

    public ArrayList<Entry> getEntry() {
        return entry;
    }

    public void setEntry(ArrayList<Entry> entry) {
        this.entry = entry;
    }
}

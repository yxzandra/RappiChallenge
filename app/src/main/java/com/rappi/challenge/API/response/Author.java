package com.rappi.challenge.API.response;

/**
 * Created by yxzan on 14/02/2017.
 */

public class Author {

    private Name name;
    private Uri uri;

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
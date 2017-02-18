package com.rappi.challenge.API.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yxzan on 14/02/2017.
 */
public class Attributes {

    private String rel;
    private String type;
    private String href;
    private String term;
    private String label;
    private String amount;
    private String currency;
    @SerializedName("im:id")
    private String imId;
    private String scheme;
    @SerializedName("im:bundleId")
    private String imBundleId;
    private String height;

    public Attributes(String rel, String type, String href, String term, String label, String amount,
                      String currency, String imId, String scheme, String imBundleId, String height) {
        this.rel = rel;
        this.type = type;
        this.href = href;
        this.term = term;
        this.label = label;
        this.amount = amount;
        this.currency = currency;
        this.imId = imId;
        this.scheme = scheme;
        this.imBundleId = imBundleId;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "rel='" + rel + '\'' +
                ", type='" + type + '\'' +
                ", href='" + href + '\'' +
                ", term='" + term + '\'' +
                ", label='" + label + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", imId='" + imId + '\'' +
                ", scheme='" + scheme + '\'' +
                ", imBundleId='" + imBundleId + '\'' +
                ", height='" + height + '\'' +
                '}';
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getImId() {
        return imId;
    }

    public void setImId(String imId) {
        this.imId = imId;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getImBundleId() {
        return imBundleId;
    }

    public void setImBundleId(String imBundleId) {
        this.imBundleId = imBundleId;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
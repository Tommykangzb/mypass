package com.example.mypass;

public class DataHolder {
    private static DataHolder dataHolder;
    private String name = "";
    private String number = "";
    private String place = "";
    private String reason = "";

    public static final String KEY_NAME = "TEXT_NAME";
    public static final String KEY_NUMBER = "TEXT_NUMBER";
    public static final String KEY_REASON = "TEXT_REASON";
    public static final String KEY_PLACE = "TEXT_PLACE";

    public static DataHolder newInstance(){
        if (dataHolder == null){
            dataHolder = new DataHolder();
            return dataHolder;
        }
        return dataHolder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

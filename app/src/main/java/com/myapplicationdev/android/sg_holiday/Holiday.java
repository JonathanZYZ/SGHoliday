package com.myapplicationdev.android.sg_holiday;

public class Holiday {
    private String photo;
    private String holiday;
    private String date;
    public Holiday(String photo, String holiday, String date) {
        this.photo = photo;
        this.holiday = holiday;
        this.date = date;
    }
    public String isPhoto() {
        return photo;
    }
    public String getDate() { return date; }
    public String getHoliday() {
        return holiday;
    }
}

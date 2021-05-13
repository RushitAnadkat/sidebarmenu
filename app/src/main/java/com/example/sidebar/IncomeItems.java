package com.example.sidebar;

public class IncomeItems {

    private int spinnerimage;
    private String spinnertext;

    public IncomeItems(int spinnerimage, String spinnertext) {
        this.spinnerimage = spinnerimage;
        this.spinnertext = spinnertext;
    }

    public int getSpinnerimage() {
        return spinnerimage;
    }
    public void setSpinnerimage(int spinnerimage) {
        this.spinnerimage = spinnerimage;
    }
    public String getSpinnertext() {
        return spinnertext;
    }
    public void setSpinnertext(String spinnertext) {
        this.spinnertext = spinnertext;
    }
}

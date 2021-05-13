package com.example.sidebar;

public class Transaction_Item {
    private int image,amount;
    private String date;

    public Transaction_Item(int image, int amount, String date) {
        this.image = image;
        this.amount = amount;
        this.date = date;
    }

    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}

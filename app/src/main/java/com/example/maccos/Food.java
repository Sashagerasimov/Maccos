package com.example.maccos;

public class Food {


    private int foodID;

    private String name;

    private String description;

    private double price;

    private int imageDrawableId;




    public Food(int foodID, String name, String description, double price, int imageDrawableId) {
        this.foodID = foodID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageDrawableId = imageDrawableId;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImageDrawableId() {
        return imageDrawableId;
    }

    public void setImageDrawableId(int imageDrawableId) {
        this.imageDrawableId = imageDrawableId;
    }
}
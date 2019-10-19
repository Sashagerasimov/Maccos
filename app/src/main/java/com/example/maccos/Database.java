package com.example.maccos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Database {


    public static Food getFoodById(int foodID) {
        return foods.get(foodID);
    }


    public static ArrayList<Food> getAllFoods() {
        return new ArrayList<Food>((List) Arrays.asList(foods.values().toArray()));
    }

    private static final HashMap<Integer, Food> foods = new HashMap<>();

    static {
        foods.put(1, new Food(
                1,
                "Big Mac",
                "yum yum for my tum tum",
                5.60,
                 R.drawable.bigmac
        ));
        foods.put(2, new Food(
                2,
                "Big Mac 2",
                "yum yum for my tum tum",
                5.50,
                R.drawable.bigmac
        ));
        foods.put(3, new Food(
                3,
                "Big Mac 3",
                "yum yum for my tum tum",
                5.70,
                R.drawable.bigmac
        ));
    }
}

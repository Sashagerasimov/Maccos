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
                "Bacon & Egg Muffin",
                "A hot brekkie made compact. A perfectly cooked egg, deli style bacon and a slice of cheese, cased in a toasted, warm English muffin.",
                3.95,
                 R.drawable.bacon_egg_mcmuffin
        ));
        foods.put(2, new Food(
                2,
                "Big Mac",
                "It starts with two 100% Aussie beef patties. Then comes the delicious combination of crisp iceberg lettuce, melting signature cheese, onions and pickles, between a toasted sesame seed bun.",
                4.85,
                R.drawable.big_mac
        ));
        foods.put(3, new Food(
                3,
                "Cheeseburger",
                "A legendary combo of 100% Aussie beef, onions, pickle, ketchup, mustard and cheese, all in a soft burger bun.",
                2.95,
                R.drawable.cheeseburger
        ));
        foods.put(4, new Food(
                4,
                "Double Cheeseburger",
                "You really will be seeing double. Two 100%  Aussie beef patties, melted cheese, tangy pickles, mustard and sweet ketchup. Delicious.",
                4.20,
                R.drawable.cheeseburger_double
        ));
        foods.put(5, new Food(
                5,
                "Coca Cola",
                "There's nothing like it with the famous thirst-quenching taste.",
                2.30,
                R.drawable.coke_classic
        ));
        foods.put(6, new Food(
                6,
                "Diet Coca Cola",
                "Deliciously light. Sugar free. Enjoy guilt free today or whenever.",
                2.30,
                R.drawable.coke_diet
        ));
        foods.put(7, new Food(
                7,
                "Fanta",
                "Bright and bubbly, with that great orange taste. Perfect for every meal.",
                2.30,
                R.drawable.fanta
        ));
        foods.put(8, new Food(
                8,
                "Filet-o-Fish",
                "Dive in and enjoy our Filet-o-Fish. Sourced for its succulent and fresh flavour, we cook tender portions of fish and enhance their great taste with zesty tartar sauce and cheese.",
                2.95,
                R.drawable.filet_o_fish
        ));
        foods.put(9, new Food(
                9,
                "Fries",
                "Get them while they're hot. Our legendary, super-tasty French fries are the perfect side to any meal.",
                1.95,
                R.drawable.fries
        ));
        foods.put(10, new Food(
                10,
                "Garden Salad",
                "Prepared fresh daily, we mix a gourmet salad of crisp lettuce, perfectly ripened tomato and cucumber slices, from farmers across Australia.",
                4.95,
                R.drawable.garden_salad
        ));
        foods.put(11, new Food(
                11,
                "Hamburger",
                "It's simple. 100% Aussie beef, topped with onion, pickles, zesty ketchup and mustard, all on a soft, fluffy bun.",
                1.00,
                R.drawable.hamburger
        ));
        foods.put(12, new Food(
                12,
                "Hashbrown",
                "Get 'em hot. A crunchy, golden brown crust with steaming, fluffy potato inside.",
                1.25,
                R.drawable.hashbrown
        ));
        foods.put(13, new Food(
                13,
                "Hotcakes",
                "Start your day the proper way, with the great feeling of pouring sweet syrup over melting whipped butter, watching while it seeps between the layers of fluffy, warm hotcakes.",
                5.50,
                R.drawable.hotcakes_butter_syrup
        ));
        foods.put(14, new Food(
                14,
                "Chicken Burger",
                "It's the simple things that matter. Like our quality chicken breast, cooked in a seasoned tempura coating. It's hard to beat a classic.",
                4.20,
                R.drawable.mc_chicken
        ));
        foods.put(15, new Food(
                15,
                "Chicken Nuggets",
                "Everything's better when it's bite-sized. Like our nuggets made with tender juicy 100% Aussie Chicken Nuggets in a crisp tempura coating, with no artificial colours, flavours or preservatives!",
                9.95,
                R.drawable.mc_nuggets
        ));
        foods.put(16, new Food(
                16,
                "Vanilla Shake",
                "Made with creamy, fresh milk ingredients in a sweet vanilla flavour, it's so thick it barely makes it up the straw.",
                4.00,
                R.drawable.shake_vanilla
        ));
        foods.put(17, new Food(
                17,
                "Quarter Pounder",
                "It's mighty simple, but it works. Take a whole quarter pound of 100% Aussie beef, then complete the tasty picture with cheese, onions, tangy mustard and pickles.",
                4.95,
                R.drawable.quarter_pounder
        ));
        foods.put(18, new Food(
                18,
                "Double Quarter Pounder",
                "Satisfy your ultimate hunger. Take two quarter pounds of 100% Aussie beef, then complete the tasty picture with cheese, onions, tangy mustard and pickles.",
                5.95,
                R.drawable.quarter_pounder_double
        ));
        foods.put(19, new Food(
                19,
                "Sausage & Egg Muffin",
                "A hard-hitting combo of egg, a beef sausage patty and melting slice of cheese on a classic English muffin. Served warm and tasty.",
                2.95,
                R.drawable.sausage_egg_mcmuffin
        ));
        foods.put(20, new Food(
                20,
                "Sprite",
                "It’s refreshing, with a great lemon lime taste. Grab some today and let loose.",
                2.30,
                R.drawable.sprite
        ));
    }
}

package com.andrewxa.arenaassistant.ui.main.fragments.Commanders;

import android.content.Context;

public class CommanderSpecification {

    public CommanderSpecification() {

    }

    public static String getCorrectName(String jsonName) {
        switch (jsonName) {
            case "gre_cynane":
                return "Кинана";
            case "gre_leonidas":
                return "Леонид";
            case "gre_miltiades":
                return "Мильтиад";
            case "gre_alexander":
                return "Александр Македонский";

            case "bar_arminius":
                return "Арминий";
            case "bar_ambiorix":
                return "Амбиорикс";
            case "bar_vercingetorix":
                return "Верцингеториг";

            case "car_hannibal":
                return "Ганнибал";
            case "car_hasdrubal":
                return "Гаструбал";


            case "rom_germanicus":
                return "Германик";
            case "rom_scipio":
                return "Сципион Африканский";
            case "rom_caesar":
                return "Гай Юлий Цезарь";
            case "rom_sulla":
                return "Сулла";
        }
        return "Some Commander";
    }


    public static int getImage(String imageName, Context context) {
        int drawableResourceId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        return drawableResourceId;
    }




}

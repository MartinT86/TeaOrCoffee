package com.martin.teaorcoffee;

import android.support.annotation.NonNull;

/**
 * Created by martin on 12/02/17.
 */

public class DrinkChoice {
    public String Type;
    public Boolean Milk;
    public Integer Sugars;

    public String Message(){
        String message = "";
        if (Type == null)
            return message;

        message = Type;

        if (Milk == null)
            return message;

        message = setMilkMessage(message);

        if (Sugars == null)
            return message;

        message = setSugarMessage(message);

        return message;
    }

    @NonNull
    private String setMilkMessage(String message) {
        if (Milk)
            message += " with milk";
        else
            message += " with no milk";
        return message;
    }

    @NonNull
    private String setSugarMessage(String message) {
        switch (Sugars){
            case 0: message += " and no sugar";
                break;
            case 1: message += " and one sugar";
                break;
            case 2: message += " and two sugars";
                break;
            default: message += " but check sugars";
                break;
        }
        return message;
    }
}

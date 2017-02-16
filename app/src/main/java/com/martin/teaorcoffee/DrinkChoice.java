package com.martin.teaorcoffee;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by martin on 12/02/17.
 */

public class DrinkChoice implements Parcelable {
    public String Type;
    public Boolean Milk;
    public Integer Sugars;

    public DrinkChoice(){

    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Type);
        parcel.writeByte((byte) (Milk ? 1 : 0));
        parcel.writeInt(Sugars);
    }

    public DrinkChoice(Parcel parcel){
        Type = parcel.readString();
        Milk = parcel.readByte() != 0;
        Sugars = parcel.readInt();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public DrinkChoice createFromParcel(Parcel in) {
            return new DrinkChoice(in);
        }

        public DrinkChoice[] newArray(int size) {
            return new DrinkChoice[size];
        }
    };
}

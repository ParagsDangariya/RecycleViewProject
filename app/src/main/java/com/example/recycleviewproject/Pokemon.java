package com.example.recycleviewproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Pokemon implements Parcelable {

    String pimg,pname,type,description,ability,weight,height;


    public Pokemon(String pimg, String pname, String type, String description, String ability, String weight, String height) {
        this.pimg = pimg;
        this.pname = pname;
        this.type = type;
        this.description = description;
        this.ability = ability;
        this.weight = weight;
        this.height = height;
    }


    protected Pokemon(Parcel in) {
        pimg = in.readString();
        pname = in.readString();
        type = in.readString();
        description = in.readString();
        ability = in.readString();
        weight = in.readString();
        height = in.readString();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pimg);
        dest.writeString(pname);
        dest.writeString(type);
        dest.writeString(description);
        dest.writeString(ability);
        dest.writeString(weight);
        dest.writeString(height);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pokemon> CREATOR = new Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}

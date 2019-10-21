package com.example.promopage.Model;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Promo implements Parcelable {
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("title")
    private String title;
    @SerializedName("promo_types")
    private List<Integer> promo_types = new ArrayList<>();
    public Promo(String posterPath,  String title, List<Integer> promo_types) {
        this.posterPath = posterPath;
        this.title = title;
        this.promo_types = promo_types;
    }
    public Promo(){
    }
    public static final Comparator<Promo> BY_NAME_ALPHABETICAL = new Comparator<Promo>() {
        @Override
        public int compare(Promo promotion, Promo t1) {

            return promotion.title.compareTo(t1.title);
        }
    };
    public String getPosterPath(){
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<Integer> getPromo_types(){
        return promo_types;
    }

    public void setPromo_types(List<Integer> promo_types) {
        this.promo_types = promo_types;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.posterPath);
        dest.writeList(this.promo_types);
        dest.writeString(this.title);
    }

    protected Promo(Parcel in){
        this.posterPath=in.readString();
        this.promo_types=new ArrayList<Integer>();
        in.readList(this.promo_types,Integer.class.getClassLoader());
        this.title=in.readString();
    }
    public static final Creator<Promo> CREATOR=new Creator<Promo>() {
        @Override
        public Promo createFromParcel(Parcel source) {
            return new Promo(source);
        }

        @Override
        public Promo[] newArray(int size) {
            return new Promo[size];
        }
    };
}

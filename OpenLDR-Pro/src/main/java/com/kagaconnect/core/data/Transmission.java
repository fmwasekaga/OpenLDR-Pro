package com.kagaconnect.core.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Transmission  implements Parcelable {

    @SerializedName("Name")
    @Expose
    private String Name;

    @SerializedName("System")
    @Expose
    private String System;

    @SerializedName("Year")
    @Expose
    private int Year;

    @SerializedName("Month")
    @Expose
    private int Month;

    @SerializedName("Days")
    @Expose
    private List<Integer> Days;

    @SerializedName("Totals")
    @Expose
    private List<TransmissionTotal> Totals;

    public Transmission() {
        this.Days = new ArrayList<>();
        this.Totals = new ArrayList<>();
    }

    public Transmission(String name, String system, int year, int month, List<Integer> days) {
        super();
        this.Name = name;
        this.System = system;
        this.Year = year;
        this.Month = month;
        this.Days = days;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSystem() {
        return System;
    }

    public void setSystem(String system) {
        System = system;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public List<Integer> getDays() {
        return Days;
    }

    public void setDays(List<Integer> days) {
        Days = days;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Name);
        dest.writeString(this.System);
        dest.writeInt(this.Year);
        dest.writeInt(this.Month);
        dest.writeArray(this.Days.toArray());
        dest.writeArray(this.Totals.toArray());
    }

    @SuppressWarnings("unchecked")
    protected Transmission(Parcel in) {
        this.Name= in.readString();
        this.System= in.readString();
        this.Year= in.readInt();
        this.Month= in.readInt();

        this.Days = new ArrayList<>();
        in.readList(this.Days, Integer.class.getClassLoader());

        this.Totals = new ArrayList<>();
        in.readList(this.Totals, TransmissionTotal.class.getClassLoader());
    }

    public static final Parcelable.Creator<Transmission> CREATOR = new Parcelable.Creator<Transmission>() {
        @Override
        public Transmission createFromParcel(Parcel source) {
            return new Transmission(source);
        }

        @Override
        public Transmission[] newArray(int size) {
            return new Transmission[size];
        }
    };
}

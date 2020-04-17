package com.kagaconnect.core.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transmission  implements Parcelable {

    @SerializedName("Name")
    @Expose
    private String Name;

    @SerializedName("System")
    @Expose
    private String System;

    @SerializedName("Registered")
    @Expose
    private int Registered;

    @SerializedName("Tested")
    @Expose
    private int Tested;

    @SerializedName("Authorised")
    @Expose
    private int Authorised;

    @SerializedName("TestedWorkload")
    @Expose
    private int TestedWorkload;

    @SerializedName("AuthorisedWorkload")
    @Expose
    private int AuthorisedWorkload;

    @SerializedName("Year")
    @Expose
    private int Year;

    @SerializedName("Month")
    @Expose
    private int Month;

    public Transmission() {
    }

    public Transmission(String name, String system, int year, int month) {
        this.Name = name;
        this.System = system;
        this.Year = year;
        this.Month = month;
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

    public int getRegistered() {
        return Registered;
    }

    public void setRegistered(int registered) {
        Registered = registered;
    }

    public int getTested() {
        return Tested;
    }

    public void setTested(int tested) {
        Tested = tested;
    }

    public int getAuthorised() {
        return Authorised;
    }

    public void setAuthorised(int authorised) {
        Authorised = authorised;
    }

    public int getTestedWorkload() {
        return TestedWorkload;
    }

    public void setTestedWorkload(int testedWorkload) {
        TestedWorkload = testedWorkload;
    }

    public int getAuthorisedWorkload() {
        return AuthorisedWorkload;
    }

    public void setAuthorisedWorkload(int authorisedWorkload) {
        AuthorisedWorkload = authorisedWorkload;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Name);
        dest.writeString(this.System);
        dest.writeInt(this.Registered);
        dest.writeInt(this.Tested);
        dest.writeInt(this.Authorised);
        dest.writeInt(this.TestedWorkload);
        dest.writeInt(this.AuthorisedWorkload);
        dest.writeInt(this.Year);
        dest.writeInt(this.Month);
    }



    @SuppressWarnings("unchecked")
    protected Transmission(Parcel in) {
        this.Name= in.readString();
        this.System= in.readString();
        this.Registered= in.readInt();
        this.Tested= in.readInt();
        this.Authorised= in.readInt();
        this.TestedWorkload= in.readInt();
        this.AuthorisedWorkload= in.readInt();
        this.Year= in.readInt();
        this.Month= in.readInt();
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

package com.kagaconnect.core.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TransmissionTotal  implements Parcelable {
    @SerializedName("Name")
    @Expose
    private String Name;

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

    public TransmissionTotal() {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Name);
        dest.writeInt(this.Registered);
        dest.writeInt(this.Tested);
        dest.writeInt(this.Authorised);
        dest.writeInt(this.TestedWorkload);
        dest.writeInt(this.AuthorisedWorkload);
    }



    @SuppressWarnings("unchecked")
    protected TransmissionTotal(Parcel in) {
        this.Name= in.readString();
        this.Registered= in.readInt();
        this.Tested= in.readInt();
        this.Authorised= in.readInt();
        this.TestedWorkload= in.readInt();
        this.AuthorisedWorkload= in.readInt();
    }

    public static final Parcelable.Creator<TransmissionTotal> CREATOR = new Parcelable.Creator<TransmissionTotal>() {
        @Override
        public TransmissionTotal createFromParcel(Parcel source) {
            return new TransmissionTotal(source);
        }

        @Override
        public TransmissionTotal[] newArray(int size) {
            return new TransmissionTotal[size];
        }
    };

}

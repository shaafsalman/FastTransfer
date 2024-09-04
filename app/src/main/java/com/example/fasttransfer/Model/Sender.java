package com.example.fasttransfer.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Sender implements Parcelable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    private String phone;
    private String country;
    private String address;

    public Sender(String name, String email, String phone, String country, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.address = address;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    // Parcelable implementation
    protected Sender(Parcel in) {
        name = in.readString();
        email = in.readString();
        phone = in.readString();
        country = in.readString();
        address = in.readString();
    }

    public static final Creator<Sender> CREATOR = new Creator<Sender>() {
        @Override
        public Sender createFromParcel(Parcel in) {
            return new Sender(in);
        }

        @Override
        public Sender[] newArray(int size) {
            return new Sender[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(country);
        dest.writeString(address);
    }
}

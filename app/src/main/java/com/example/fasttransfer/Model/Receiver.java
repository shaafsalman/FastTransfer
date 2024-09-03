package com.example.fasttransfer.Model;

public class Receiver {
    private String name;
    private String email;
    private String phone;
    private String country;
    private String address;

    public Receiver(String name, String email, String phone, String country, String address) {
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
}

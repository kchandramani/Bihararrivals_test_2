package com.example.bihararrivals_test_2;

public class UserHelperClass {
    String name,email,dob,phone,password;

    public UserHelperClass() {
    }

    public UserHelperClass(String name, String email, String phone, String dob, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}

package com.company;

public class Child {
    String firstName;
    String lastName;
    int age;
    String gender;
    String address;
    String phoneNumber;

    public Child(String firstName, String lastName, int age, String gender, String address, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public String toString(){
        return("Name: " + firstName + " " + lastName + "\n" +
                "Age: " + age + "\n" +
                "Gender: " + gender + "\n" +
                "Address: " + address + "\n" +
                "Phone Number : " + phoneNumber + "\n");
    }

}

package com.liyan.bean;

public class Person {
    private int PersonID;
    private String LastName;
    private String FirstName;
    private String Address;
    private String City;

    public Person() {
    }

    public Person(int personID, String lastName, String firstName, String address, String city) {
        PersonID = personID;
        LastName = lastName;
        FirstName = firstName;
        Address = address;
        City = city;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int personID) {
        PersonID = personID;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "PersonID=" + PersonID +
                ", LastName='" + LastName + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}

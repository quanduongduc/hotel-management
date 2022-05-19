/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Quandeptrai
 */
public class Customer implements Serializable {

    private String id;
    private String name;
    private String gender;
    private Date birthday;
    private String identification;
    private String hometown;
    private Date rentDate;

    public Customer(String id, String name, String gender, Date birthYear, String identification, String hometown, Date rentDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthYear;
        this.identification = identification;
        this.hometown = hometown;
        this.rentDate = rentDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getIdentification() {
        return identification;
    }

    public String getHometown() {
        return hometown;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }
}

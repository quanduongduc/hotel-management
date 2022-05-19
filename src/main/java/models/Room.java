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
public class Room implements Serializable {

    private String id;
    private Customer renter;
    private boolean isRented;
    private Date rentDate;
    private Date orderDate;
    private Customer orderCustomer;
    private int price;
    private Bill bill;

    public Room() {
        System.out.println("models.Room.<init>()");
        this.bill = new Bill(this);
    }

    public Room(String id, Customer renter, boolean isRented, Date rentDate, Date orderDate, int price, Bill bill) {
        this();
        this.id = id;
        this.renter = renter;
        this.isRented = isRented;
        this.rentDate = rentDate;
        this.orderDate = orderDate;
        this.price = price;
        this.bill = bill;
    }

    public Room(String id, int price) {
        this();
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getRenter() {
        return renter;
    }

    public boolean isRented() {
        return isRented;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRenter(Customer renter) {
        this.renter = renter;
    }

    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getOrderCustomer() {
        return orderCustomer;
    }

    public void setOrderCustomer(Customer orderCustomer) {
        this.orderCustomer = orderCustomer;
    }

}

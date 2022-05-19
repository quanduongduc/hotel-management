/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Quandeptrai
 */
public class Service implements Serializable {

    private String name;
    private int cost;
    private List<Room> signedRooms;

    public Service(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.signedRooms = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Room> getSignedRooms() {
        return signedRooms;
    }

    public void setSignedRooms(List<Room> signedRooms) {
        this.signedRooms = signedRooms;
    }
}

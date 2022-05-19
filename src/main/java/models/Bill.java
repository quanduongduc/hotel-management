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
public class Bill implements Serializable {

    private Room room;
    private List<Service> services;

    public Bill() {
        services = new LinkedList<>();
    }

    public Bill(Room room) {
        this();
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public void appendService(Service service) {
        this.services.add(service);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import models.Customer;
import models.Room;
import models.Service;

/**
 *
 * @author Quandeptrai
 */
public class RoomController extends GenericController {

    public int findMaxId(List<Room> rooms) {
        int max = 0;
        for (Room room : rooms) {
            if (Integer.parseInt(room.getId()) > max) {
                max = Integer.parseInt(room.getId());
            }
        }
        return max;
    }

    public Room findById(List<Room> rooms, String id) {
        for (Room room : rooms) {
            if (room.getId().equals(id)) {
                return room;
            }
        }
        return null;
    }

    public List<Room> getEmptyRooms(List<Room> rooms) {
        List<Room> emptyRooms = new LinkedList<>();
        for (Room room : rooms) {
            if (!room.isRented()) {
                emptyRooms.add(room);
            }
        }
        return emptyRooms;
    }

    public boolean sign(Room room, Customer customer, Date rentDate) {
        if (room.isRented()) {
            return false;
        }
        room.setRenter(customer);
        room.setRentDate(rentDate);
        customer.setRentDate(rentDate);
        room.setIsRented(true);
        return true;
    }

    public boolean order(Room room, Customer customer, Date orderDate) {
        room.setOrderCustomer(customer);
        room.setOrderDate(orderDate);
        customer.setRentDate(orderDate);
        return true;
    }

    public boolean removeOrderRoom(Room room) {
        room.setOrderDate(null);
        room.setOrderCustomer(null);
        return true;
    }

    public List<Room> getRentedRooms(List<Room> rooms) {
        List<Room> rentedRooms = new LinkedList<>();
        for (Room room : rooms) {
            if (room.isRented()) {
                rentedRooms.add(room);
            }
        }
        return rentedRooms;
    }

    public List<Room> getSortedRooms(List<Room> rooms, int order) {
        List<Room> sortedRooms = new LinkedList<>(rooms);
        sortedRooms.sort((Room a, Room b) -> {
            int aPrice = a.getPrice();
            int bPrice = b.getPrice();
            if (order < 0) {
                if (aPrice > bPrice) {
                    return 1;
                } else if (aPrice < bPrice) {
                    return -1;
                } else {
                    return 0;
                }

            } else {
                if (aPrice < bPrice) {
                    return 1;
                } else if (aPrice > bPrice) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return sortedRooms;
    }

    public boolean checkOut(Room room) {
        if (!room.isRented()) {
            return false;
        }
        room.setIsRented(false);
        room.setRenter(null);
        room.setRentDate(null);
        room.getBill().setServices(new LinkedList<>());
        return true;
    }

    public void signService(Room room, Service service) {
        room.getBill().appendService(service);
    }

    @Override
    public <T> boolean delete(List<T> list, T element) {
        boolean isDeleted = super.delete(list, element);
        List<Room> rooms = (List<Room>) list;
        return isDeleted;
    }
}

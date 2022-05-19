/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.LinkedList;
import java.util.List;
import models.Customer;

/**
 *
 * @author Quandeptrai
 */
public class CustomerController extends GenericController {

    public Customer findById(List<Customer> list, String id) {
        for (Customer customer : list) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> findByName(List<Customer> list, String name) {
        List<Customer> foundList = new LinkedList();
        for (Customer customer : list) {
            if (customer.getName().contains(name)) {
                foundList.add(customer);
            }
        }
        return foundList;
    }
}

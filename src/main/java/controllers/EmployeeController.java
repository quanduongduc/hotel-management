/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.LinkedList;
import java.util.List;
import models.Employee;

/**
 *
 * @author Quandeptrai
 */
public class EmployeeController extends GenericController {

    public Employee findById(List<Employee> employees, String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> findByName(List<Employee> employees, String name) {
        List<Employee> foundEmployees = new LinkedList<>();
        for (Employee employee : employees) {
            if (employee.getName().contains(name)) {
                foundEmployees.add(employee);
            }
        }
        return foundEmployees;
    }
}

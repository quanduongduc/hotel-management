/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controllers;

import java.util.List;

/**
 *
 * @author Quandeptrai
 */
public interface Controller {

    public <T> void writeToFile(List<T> list, String fileName);

    public <T> List<T> readFromFile(String fileName);

    public <T> boolean addNew(List<T> list, T element);

    public <T> boolean delete(List<T> list, T element);

    public <T> boolean update(List<T> list, T element, T newElement);

}

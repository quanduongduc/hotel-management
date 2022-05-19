package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Quandeptrai
 */
public class GenericController implements Controller {

    @Override
    public <T> void writeToFile(List<T> list, String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> List<T> readFromFile(String fileName) {
        List<T> list = new LinkedList<>();
        try {
            File file = new File(fileName);
            if (file.length() > 0) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                list = (List<T>) ois.readObject();
                fis.close();
                ois.close();
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public <T> boolean addNew(List<T> list, T element) {
        return list.add(element);
    }

    @Override
    public <T> boolean delete(List<T> list, T element) {
        return list.remove(element);
    }

    @Override
    public <T> boolean update(List<T> list, T element, T newElement) {
        int idx = list.indexOf(element);
        if (idx == -1) {
            return false;
        }
        list.set(idx, newElement);
        return true;
    }
}

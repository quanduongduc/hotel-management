/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package views;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Quandeptrai
 */
public interface View {

    public <T> void initData(List<T> list, DefaultTableModel model);

    public <T> void initData(T element, DefaultTableModel model);
}

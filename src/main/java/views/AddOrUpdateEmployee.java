/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views;

import java.awt.HeadlessException;
import java.util.Date;
import javax.swing.JOptionPane;
import models.Employee;

/**
 *
 * @author Quandeptrai
 */
public class AddOrUpdateEmployee extends javax.swing.JDialog {

    /**
     * Creates new form AddOrUpdateEmployee
     */
    private MainFrame mainFrame;
    private Employee updateEmployee;
    private boolean isUpdate;

    public AddOrUpdateEmployee(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        isUpdate = false;
        mainFrame = (MainFrame) parent;
        this.setTitle("Thêm Nhân Viên");
    }

    public AddOrUpdateEmployee(java.awt.Frame parent, boolean modal, Employee updateEmployee) {
        super(parent, modal);
        initComponents();
        mainFrame = (MainFrame) parent;
        this.updateEmployee = updateEmployee;
        this.setLocationRelativeTo(null);
        this.id.setText(updateEmployee.getId());
        this.name.setText(updateEmployee.getName());
        this.gender.setSelectedItem(updateEmployee.getGender());
        this.hometown.setText(updateEmployee.getHometown());
        this.identification.setText(updateEmployee.getIdentification());
        this.birthday.setDate(updateEmployee.getBirthday());
        this.position.setSelectedItem(updateEmployee.getPosition());
        this.salary.setText(String.valueOf(updateEmployee.getSalary()));
        this.isUpdate = true;
        this.setTitle("Sửa Nhân Viên");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        confirm = new Button();
        back = new Button();
        id = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        gender = new javax.swing.JComboBox<>();
        birthday = new com.toedter.calendar.JDateChooser();
        position = new javax.swing.JComboBox<>();
        salary = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        hometown = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        identification = new javax.swing.JTextField();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Mã Nhân Viên");

        jLabel2.setText("Họ Tên");

        jLabel3.setText("Giới Tính");

        jLabel4.setText("Ngày Sinh");

        jLabel5.setText("Chức Vụ");

        jLabel6.setText("Mức Lương");

        confirm.setText("Xác Nhận");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        back.setText("Quay Lại");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lễ Tân", "Bảo Vệ", "Buồng Phòng", "Phục Vụ", "Nhà Bếp", "Quản Lý", "Giám Đốc" }));

        jLabel8.setText("Quê Quán");

        jLabel9.setText("CMND");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3))
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(birthday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(identification)
                    .addComponent(name)
                    .addComponent(hometown)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(back)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(confirm))
                            .addComponent(gender, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(position, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(salary, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(hometown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(identification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(birthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirm)
                    .addComponent(back))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_confirmActionPerformed
        boolean isFilled = !id.getText().isBlank() && !name.getText().isBlank()
                && !gender.getSelectedItem().toString().isBlank() && !(birthday.getDate() == null)
                && !identification.getText().isBlank() && !hometown.getText().isBlank() && !salary.getText().isBlank()
                && !position.getSelectedItem().toString().isBlank();
        if (!isFilled) {
            mainFrame.showMessage("Hãy điền tất cả các ô !!!");
        } else {
            try {
                String id = this.id.getText();
                if (!mainFrame.isUniqeEmployeeId(id) && updateEmployee != null && !id.equals(updateEmployee.getId())) {
                    mainFrame.showMessage("Mã khách hàng đã tồn tại");
                    return;
                }
                String name = this.name.getText().trim().replace("\\s+", " ");
                boolean isValidName = name.matches("[^0-9]*[\\\\p{L}+]*$");
                if (!isValidName) {
                    mainFrame.showMessage("Tên không bao gồm số");
                    return;
                }
                String gender = this.gender.getSelectedItem().toString();
                Date birthday = this.birthday.getDate();
                String identification = this.identification.getText();
                String homeTown = this.hometown.getText();
                String position = this.position.getSelectedItem().toString();
                int salary = Integer.parseInt(this.salary.getText());
                Employee newEmployee = new Employee(id, name, homeTown, identification, birthday, gender, position,
                        salary);
                if (isUpdate) {
                    mainFrame.updateEmployee(updateEmployee, newEmployee);
                    JOptionPane
                            .showConfirmDialog(null, "Update thành công", "Thông Báo", JOptionPane.DEFAULT_OPTION);
                } else {
                    mainFrame.addEmployee(newEmployee);
                }
                this.setVisible(false);
            } catch (NumberFormatException e) {
                mainFrame.showMessage("Giá Không Hợp Lệ");
            } catch (HeadlessException e) {
                mainFrame.showMessage("Có Lỗi Xảy Ra, Vui Lòng Thử Lại");
            }

        }
    }// GEN-LAST:event_confirmActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private com.toedter.calendar.JDateChooser birthday;
    private javax.swing.JButton confirm;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JTextField hometown;
    private javax.swing.JTextField id;
    private javax.swing.JTextField identification;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField name;
    private javax.swing.JComboBox<String> position;
    private javax.swing.JTextField salary;
    // End of variables declaration//GEN-END:variables
}

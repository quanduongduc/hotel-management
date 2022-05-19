/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.CustomerController;
import controllers.EmployeeController;
import controllers.RoomController;
import controllers.ServiceController;
import java.awt.Color;
import java.awt.Font;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Customer;
import models.Employee;
import models.Room;
import models.Service;

/**
 *
 * @author Quandeptrai
 */
public final class MainFrame extends javax.swing.JFrame implements View {

    private static final String DB_PATH = "src\\main\\java\\db\\";

    private CustomerController customerController;
    private List<Customer> customers;
    private DefaultTableModel customerTableModel;

    private RoomController roomController;
    private List<Room> rooms;
    private DefaultTableModel roomTableModel;

    private EmployeeController employeeController;
    private List<Employee> employees;
    private DefaultTableModel employeeTableModel;

    protected ServiceController serviceController;
    private List<Service> services;
    private DefaultTableModel serviceTableModel;

    /**
     * Creates new form HomeFrame
     */
    public MainFrame() {
        this.setUndecorated(false);
        initComponents();
        this.setTitle("Chương Trình Quản Lý Khách Sạn");
        this.setLocationRelativeTo(null);
        customerController = new CustomerController();
        customers = new LinkedList<>();
        customerTableModel = (DefaultTableModel) customerTable.getModel();

        roomController = new RoomController();
        rooms = new LinkedList<>();
        roomTableModel = (DefaultTableModel) roomTable.getModel();

        employeeController = new EmployeeController();
        employees = new LinkedList<>();
        employeeTableModel = (DefaultTableModel) employeeTable.getModel();
        serviceController = new ServiceController();
        services = new LinkedList<>();
        serviceTableModel = (DefaultTableModel) serviceTable.getModel();

        initCustomer();
        initEmployee();
        initRoom();
        initService();
    }

    public <T> void addCustomer(Customer c) {
        customerController.addNew(customers, c);
        customerController.writeToFile(customers, DB_PATH + "customers.txt");
        initData(customers, customerTableModel);
    }

    public boolean isUniqeCustomerId(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public Customer findCustomerById(String id) {
        return customerController.findById(customers, id);
    }

    public void initCustomer() {
        customers = customerController.readFromFile(DB_PATH + "customers.txt");
        initData(customers, customerTableModel);
    }

    public void updateCustomer(Customer customer, Customer newCustomer) {
        boolean isUpdated = customerController.update(customers, customer, newCustomer);
        if (!isUpdated) {
            showMessage("Update Không thành công, thử lại xem sao ha");
        } else {
            customerController.writeToFile(customers, DB_PATH + "customers.txt");
            initData(customers, customerTableModel);
        }
    }

    public void addRoom(Room newRoom) {
        roomController.addNew(rooms, newRoom);
        roomController.writeToFile(rooms, DB_PATH + "rooms.txt");
        initRoom();
    }

    public Room findRoomById(String id) {
        return roomController.findById(rooms, id);
    }

    public List<Room> getEmptyRooms() {
        return roomController.getEmptyRooms(rooms);
    }

    public List<Room> getRentedRooms() {
        return roomController.getRentedRooms(rooms);
    }

    public void signRoom(Room room, Customer customer, Date rentDate) {
        roomController.sign(room, customer, rentDate);
        roomController.writeToFile(rooms, DB_PATH + "rooms.txt");
        customerController.writeToFile(customers, DB_PATH + "customers.txt"); // sign will change customer rentDate;
        initData(rooms, roomTableModel);
        initData(customers, customerTableModel);
    }

    public void orderRoom(Room room, Customer customer, Date orderDate) {
        roomController.order(room, customer, orderDate);
        roomController.writeToFile(rooms, DB_PATH + "rooms.txt");
        customerController.writeToFile(customers, DB_PATH + "customers.txt"); // sign will change customer rentDate;
        initData(rooms, roomTableModel);
        initData(customers, customerTableModel);
    }

    public void signService(Room room, Service service) {
        roomController.signService(room, service);
        roomController.writeToFile(rooms, DB_PATH + "rooms.txt");
        initRoom();
    }

    public void removeOrderRoom(Room room) {
        roomController.removeOrderRoom(room);
        roomController.writeToFile(rooms, DB_PATH + "rooms.txt");
        customerController.writeToFile(customers, DB_PATH + "customers.txt"); // sign will change customer rentDate;
        initData(rooms, roomTableModel);
        initData(customers, customerTableModel);
    }

    public void checkoutRoom(Room room) {
        roomController.checkOut(room);
        roomController.writeToFile(rooms, DB_PATH + "rooms.txt");
        initData(rooms, roomTableModel);
    }

    public boolean isUniqeRoomId(String id) {
        for (Room room : rooms) {
            if (room.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public void addEmployee(Employee e) {
        employeeController.addNew(employees, e);
        employeeController.writeToFile(employees, DB_PATH + "employees.txt");
        initData(employees, employeeTableModel);
    }

    public void updateEmployee(Employee employee, Employee newEmployee) {
        boolean isUpdated = employeeController.update(employees, employee, newEmployee);
        if (!isUpdated) {
            showMessage("Update Không thành công");
        } else {
            employeeController.writeToFile(employees, DB_PATH + "employees.txt");
            initData(employees, employeeTableModel);
        }
    }

    public boolean isUniqeEmployeeId(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public Employee findEmployeeById(String id) {
        return employeeController.findById(employees, id);
    }

    public void addService(Service service) {
        serviceController.addNew(services, service);
        serviceController.writeToFile(services, DB_PATH + "services.txt");
        initService();
    }

    public Service findServiceByName(String name) {
        return serviceController.findServiceByName(services, name);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        addCustomer = new Button();
        deleteCustomer = new Button();
        updateCustomer = new Button();
        findCustomerByName = new Button();
        refreshCustomerList = new Button();
        findCustomerById = new Button();
        findCustomerName = new javax.swing.JTextField();
        findCustomerId = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        roomTable = new javax.swing.JTable();
        checkoutRoom = new Button();
        roomFilter = new javax.swing.JComboBox<>();
        signRoom = new Button();
        displayRenter = new Button();
        addRoom = new Button();
        deleteRoom = new Button();
        signService = new Button();
        jButton1 = new Button();
        removeOrderRoom = new Button();
        displayOrderCustomer = new Button();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        serviceTable = new javax.swing.JTable();
        addService = new Button();
        removeService = new Button();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        addEmployee = new Button();
        updateEmployee = new Button();
        findEmployeeByName = new Button();
        findEmployeeById = new Button();
        employeeNameFilter = new javax.swing.JTextField();
        employeeIdFilter = new javax.swing.JTextField();
        removeEmployee = new Button();
        refreshEmployees = new Button();
        printEmployees = new Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(102, 102, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(320, 27));
        jTabbedPane1.setName(""); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1169, 590));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khách Hàng", "Họ Tên", "Giới Tính", "Năm Sinh", "Quê Quán", "CMND", "Ngày Ðặt Phòng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        customerTable.setFocusable(false);
        customerTable.setRowHeight(25);
        customerTable.setSelectionBackground(new java.awt.Color(255, 102, 0));
        customerTable.getTableHeader().setReorderingAllowed(false);
        customerTable.getTableHeader().setOpaque(false);
        customerTable.setRowHeight(25);
        customerTable.getTableHeader().setBackground(new Color(32, 136, 203));
        customerTable.getTableHeader().setForeground(new Color(255, 255, 255));
        customerTable.getTableHeader().setFont(new Font("Roboto", Font.BOLD,14));
        jScrollPane1.setViewportView(customerTable);

        addCustomer.setText("Thêm Khách Hàng");
        addCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerActionPerformed(evt);
            }
        });

        deleteCustomer.setText("Xóa Khách Hàng");
        deleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCustomerActionPerformed(evt);
            }
        });

        updateCustomer.setText("Sửa Thông Tin Khách ");
        updateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCustomerActionPerformed(evt);
            }
        });

        findCustomerByName.setText("Tìm Khách Hàng Theo Tên");
        findCustomerByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findCustomerByNameActionPerformed(evt);
            }
        });

        refreshCustomerList.setText("Làm Mới Danh Sách");
        refreshCustomerList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshCustomerListActionPerformed(evt);
            }
        });

        findCustomerById.setText("Tìm Khách Hàng Theo Mã Số");
        findCustomerById.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findCustomerByIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(refreshCustomerList, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(deleteCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(findCustomerName)
                    .addComponent(findCustomerByName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(findCustomerId)
                    .addComponent(findCustomerById, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(147, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(findCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteCustomer)
                    .addComponent(addCustomer))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(refreshCustomerList)
                        .addComponent(updateCustomer))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(findCustomerById)
                        .addComponent(findCustomerByName)))
                .addGap(107, 107, 107))
        );

        jTabbedPane1.addTab("Quản Lý Khách Hàng", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFocusable(false);

        roomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phòng", "Trạng thái", "Khách Hàng", "Ngày Thuê", "Ngày Đặt Trước", "Khách Đặt Trước", "Giá Phòng", "Dịch Vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roomTable.setFocusable(false);
        roomTable.setRowHeight(25);
        roomTable.setSelectionBackground(new java.awt.Color(255, 102, 0));
        roomTable.getTableHeader().setReorderingAllowed(false);
        roomTable.getTableHeader().setOpaque(false);
        roomTable.setRowHeight(25);
        roomTable.getTableHeader().setBackground(new Color(32, 136, 203));
        roomTable.getTableHeader().setForeground(new Color(255, 255, 255));
        roomTable.getTableHeader().setFont(new Font("Roboto", Font.BOLD,14));
        jScrollPane3.setViewportView(roomTable);

        checkoutRoom.setText("Khách Trả Phòng");
        checkoutRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutRoomActionPerformed(evt);
            }
        });

        roomFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Phòng còn Trống", "Phòng đã được đặt", "Sắp Xếp Theo Giá Cao", "Sắp Xếp Theo Giá Thấp" }));
        roomFilter.setFocusable(false);
        roomFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomFilterActionPerformed(evt);
            }
        });

        signRoom.setText("Đăng Ký Thuê Phòng");
        signRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signRoomActionPerformed(evt);
            }
        });

        displayRenter.setText("Thông Tin Khách Đang Thuê");
        displayRenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayRenterActionPerformed(evt);
            }
        });

        addRoom.setText("Thêm Phòng");
        addRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomActionPerformed(evt);
            }
        });

        deleteRoom.setText("Xóa Phòng");
        deleteRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRoomActionPerformed(evt);
            }
        });

        signService.setText("Đăng Ký Dịch Vụ");
        signService.setFocusable(false);
        signService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signServiceActionPerformed(evt);
            }
        });

        jButton1.setText("Đặt Trước");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        removeOrderRoom.setText("Hủy Đặt Trước");
        removeOrderRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeOrderRoomActionPerformed(evt);
            }
        });

        displayOrderCustomer.setText("Thông Tin Khách Đặt Trước");
        displayOrderCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayOrderCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(roomFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(displayRenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(signRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkoutRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(deleteRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(signService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removeOrderRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(displayOrderCustomer)))
                .addGap(0, 272, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roomFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkoutRoom)
                    .addComponent(signRoom)
                    .addComponent(signService)
                    .addComponent(jButton1))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteRoom)
                    .addComponent(displayRenter)
                    .addComponent(addRoom)
                    .addComponent(removeOrderRoom))
                .addGap(42, 42, 42)
                .addComponent(displayOrderCustomer)
                .addGap(52, 52, 52))
        );

        jTabbedPane1.addTab("Quản Lý Phòng", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        serviceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên dịch vụ ", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        serviceTable.setFocusable(false);
        serviceTable.setRowHeight(25);
        serviceTable.setSelectionBackground(new java.awt.Color(255, 102, 0));
        serviceTable.getTableHeader().setReorderingAllowed(false);
        serviceTable.getTableHeader().setOpaque(false);
        serviceTable.setRowHeight(25);
        serviceTable.getTableHeader().setBackground(new Color(32, 136, 203));
        serviceTable.getTableHeader().setForeground(new Color(255, 255, 255));
        serviceTable.getTableHeader().setFont(new Font("Roboto", Font.BOLD,14));
        jScrollPane4.setViewportView(serviceTable);

        addService.setText("Thêm Dịch Vụ");
        addService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addServiceActionPerformed(evt);
            }
        });

        removeService.setText("Xóa Dịch Vụ");
        removeService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeServiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(addService, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(removeService)
                .addGap(205, 205, 205))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addGap(73, 73, 73)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addService)
                    .addComponent(removeService))
                .addGap(135, 135, 135))
        );

        jTabbedPane1.addTab("Quản Lý Dịch Vụ", jPanel4);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Họ Tên", "Giới Tính", "Quê Quán", "CMND", "Ngày Sinh", "Chức Vụ", "Lương"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeTable.setFocusable(false);
        employeeTable.setRowHeight(25);
        employeeTable.setSelectionBackground(new java.awt.Color(255, 102, 0));
        employeeTable.setShowGrid(false);
        employeeTable.getTableHeader().setReorderingAllowed(false);
        employeeTable.getTableHeader().setOpaque(false);
        employeeTable.setRowHeight(25);
        employeeTable.getTableHeader().setBackground(new Color(32, 136, 203));
        employeeTable.getTableHeader().setForeground(new Color(255, 255, 255));
        employeeTable.getTableHeader().setFont(new Font("Roboto", Font.BOLD,14));
        jScrollPane2.setViewportView(employeeTable);
        employeeTable.getAccessibleContext().setAccessibleDescription("");

        addEmployee.setText("Thêm Nhân Viên");
        addEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeActionPerformed(evt);
            }
        });

        updateEmployee.setText("Sửa Thông Tin");
        updateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEmployeeActionPerformed(evt);
            }
        });

        findEmployeeByName.setText("Tìm Nhân Viên Theo Tên");
        findEmployeeByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findEmployeeByNameActionPerformed(evt);
            }
        });

        findEmployeeById.setText("Tìm Nhân Viên Theo Mã Số");
        findEmployeeById.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findEmployeeByIdActionPerformed(evt);
            }
        });

        removeEmployee.setText("Xóa Nhân Viên");
        removeEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEmployeeActionPerformed(evt);
            }
        });

        refreshEmployees.setText("Làm Mới Danh Sách");
        refreshEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshEmployeesActionPerformed(evt);
            }
        });

        printEmployees.setText("In Danh Sách Nhân Viên");
        printEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printEmployeesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(removeEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(82, 82, 82)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(refreshEmployees, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(findEmployeeByName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeNameFilter))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(employeeIdFilter)
                    .addComponent(findEmployeeById, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(175, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(printEmployees)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeNameFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeIdFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateEmployee)
                    .addComponent(addEmployee))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(findEmployeeByName)
                    .addComponent(findEmployeeById)
                    .addComponent(refreshEmployees)
                    .addComponent(removeEmployee))
                .addGap(81, 81, 81))
        );

        jTabbedPane1.addTab("Quản Lý Nhân Viên", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1145, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printEmployeesActionPerformed
        try {
            MessageFormat header = new MessageFormat("Danh Sách Nhân Viên");
            MessageFormat footer = new MessageFormat("{0}");
            employeeTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (Exception e) {
            e.printStackTrace();
            showMessage("Có lỗi xảy ra, Vui lòng thử lại");
        }
    }//GEN-LAST:event_printEmployeesActionPerformed

    private void refreshEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshEmployeesActionPerformed
        initEmployee();
    }//GEN-LAST:event_refreshEmployeesActionPerformed

    private void removeEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEmployeeActionPerformed
        int[] selectedRows = employeeTable.getSelectedRows();

        if (selectedRows.length != 0) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Xóa " + selectedRows.length + " Nhân Viên",
                    "Warning", dialogButton);
            if (dialogResult == 0) {
                for (int row : selectedRows) {
                    String id = (String) employeeTableModel.getValueAt(row, 0);
                    employeeController.delete(employees, findEmployeeById(id));
                }
                employeeController.writeToFile(employees, DB_PATH + "employees.txt");
                initData(employees, employeeTableModel);
            }
        } else {
            showMessage("Chọn Để Xóa");
        }
    }//GEN-LAST:event_removeEmployeeActionPerformed

    private void findEmployeeByIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findEmployeeByIdActionPerformed
        String id = this.employeeIdFilter.getText().trim().replace("\\s+", "");
        if (id.isBlank()) {
            showMessage("Vui lòng nhập mã khách hàng");
            return;
        }

        Employee foundCustomer = findEmployeeById(id);
        if (foundCustomer == null) {
            showMessage("Không tìm thấy khách hàng");
        } else {
            initData(foundCustomer, employeeTableModel);
        }

        this.employeeIdFilter.setText("");
    }//GEN-LAST:event_findEmployeeByIdActionPerformed

    private void findEmployeeByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findEmployeeByNameActionPerformed
        String name = this.employeeNameFilter.getText().trim().replace("\\s+", "");
        if (name.isBlank()) {
            showMessage("Vui lòng nhập tên");
            return;
        }
        if (name != null && !name.isBlank()) {
            List<Employee> foundEmployees = employeeController.findByName(employees, name);
            if (foundEmployees.isEmpty()) {
                showMessage("Không tìm thấy nhân viên");
            } else {
                initData(foundEmployees, employeeTableModel);
            }
        }
        this.employeeNameFilter.setText("");
    }//GEN-LAST:event_findEmployeeByNameActionPerformed

    private void updateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEmployeeActionPerformed
        if (employeeTable.getSelectedRows().length > 1) {
            showMessage("Chọn Một Thôi");
            return;
        }
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow != -1) {
            try {
                SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
                String id = employeeTableModel.getValueAt(selectedRow, 0).toString();
                Employee employee = findEmployeeById(id);
                new AddOrUpdateEmployee(this, rootPaneCheckingEnabled, employee).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                showMessage("Có lỗi xảy ra, Vui lòng thử lại");
            }
        } else {
            showMessage("Vui lòng chọn một nhân viên");
        }
    }//GEN-LAST:event_updateEmployeeActionPerformed

    private void addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeActionPerformed
        new AddOrUpdateEmployee(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_addEmployeeActionPerformed

    private void deleteRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRoomActionPerformed
        int[] selectedRows = roomTable.getSelectedRows();

        if (selectedRows.length != 0) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Xóa " + selectedRows.length + " Phòng", "Warning",
                    dialogButton);
            if (dialogResult == 0) {
                for (int row : selectedRows) {
                    String id = (String) roomTableModel.getValueAt(row, 0);
                    roomController.delete(rooms, findRoomById(id));
                }
                roomController.writeToFile(rooms, DB_PATH + "rooms.txt");
                initData(rooms, roomTableModel);
            }
        } else {
            showMessage("Vui lòng chọn một phòng");
        }
    }//GEN-LAST:event_deleteRoomActionPerformed

    private void addRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomActionPerformed
        new AddRoom(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_addRoomActionPerformed

    private void displayRenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayRenterActionPerformed
        if (roomTable.getSelectedRows().length > 1) {
            showMessage("Chỉ Được Chọn Một Phòng");
            return;
        }
        int selectedRow = roomTable.getSelectedRow();
        if (selectedRow == -1) {
            showMessage("Vui lòng chọn phòng");
            return;
        }
        String customerId = roomTableModel.getValueAt(selectedRow, 2).toString();
        if (customerId.isBlank()) {
            showMessage("Phòng Trống");
            return;
        }
        Customer customer = findCustomerById(customerId);
        new ShowCustomer(this, rootPaneCheckingEnabled, customer).setVisible(true);
    }//GEN-LAST:event_displayRenterActionPerformed

    private void signRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signRoomActionPerformed
        if (roomTable.getSelectedRows().length > 1) {
            showMessage("Vui lòng chọn một phòng");
            return;
        }
        int selectedRow = roomTable.getSelectedRow();
        if (selectedRow == -1) {
            showMessage("Vui lòng chọn một phòng");
            return;
        }
        String id = roomTableModel.getValueAt(selectedRow, 0).toString();
        Room selectedRoom = findRoomById(id);
        boolean isRented = selectedRoom.isRented();
        if (isRented) {
            showMessage("Phòng đã được thuê");
            return;
        }

        new SignRoom(this, rootPaneCheckingEnabled, this.customerTable, selectedRoom, false).setVisible(true);
    }//GEN-LAST:event_signRoomActionPerformed

    private void roomFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomFilterActionPerformed
        int index = roomFilter.getSelectedIndex();
        if (index == 0) {
            initRoom();
        } else if (index == 1) {
            List<Room> emptyRooms = getEmptyRooms();
            initData(emptyRooms, roomTableModel);
        } else if (index == 2) {
            List<Room> rentedRooms = getRentedRooms();
            initData(rentedRooms, roomTableModel);
        } else if (index == 3) {
            List<Room> increasingList = roomController.getSortedRooms(rooms, 1);
            initData(increasingList, roomTableModel);
        } else if (index == 4) {
            List<Room> decreasingList = roomController.getSortedRooms(rooms, -1);
            initData(decreasingList, roomTableModel);
        }
    }//GEN-LAST:event_roomFilterActionPerformed

    private void checkoutRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutRoomActionPerformed
        if (roomTable.getSelectedRows().length > 1) {
            showMessage("Chỉ Được Chọn Một Phòng");
            return;
        }
        int selectedRow = roomTable.getSelectedRow();
        if (selectedRow == -1) {
            showMessage("Vui lòng chọn một phòng");
            return;
        }
        String roomId = roomTableModel.getValueAt(selectedRow, 0).toString();
        String customerId = roomTableModel.getValueAt(selectedRow, 2).toString();
        Room selectedRoom = findRoomById(roomId);
        Customer customer = findCustomerById(customerId);
        if (customer == null) {
            showMessage("Khách Hàng Không Tồn Tại");
            return;
        }

        if (selectedRoom == null) {
            showMessage("Phòng Không Tồn Tại");
            return;
        }

        if (!selectedRoom.isRented()) {
            showMessage("Phòng Trống...");
            return;
        }
        new ShowBill(this, rootPaneCheckingEnabled, customer.getName(), selectedRoom).setVisible(true);
    }//GEN-LAST:event_checkoutRoomActionPerformed

    private void findCustomerByIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findCustomerByIdActionPerformed
        String id = this.findCustomerId.getText().trim().replace("\\s+", "");
        if (id.isBlank()) {
            showMessage("Vui lòng nhập mã khách hàng");
            return;
        }

        Customer foundCustomer = findCustomerById(id);
        if (foundCustomer == null) {
            showMessage("Không tìm thấy khách hàng");
        } else {
            initData(foundCustomer, customerTableModel);
        }

        this.findCustomerId.setText("");
    }//GEN-LAST:event_findCustomerByIdActionPerformed

    private void refreshCustomerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshCustomerListActionPerformed
        initCustomer();
    }//GEN-LAST:event_refreshCustomerListActionPerformed

    private void findCustomerByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findCustomerByNameActionPerformed
        String name = this.findCustomerName.getText().trim().replace("\\s+", "");
        if (name.isBlank()) {
            showMessage("Vui lòng nhập tên");
            return;
        }
        if (name != null && !name.isBlank()) {
            List<Customer> foundCustomers = customerController.findByName(customers, name);
            if (foundCustomers.isEmpty()) {
                showMessage("Không tìm thấy khách hàng");
            } else {
                initData(foundCustomers, customerTableModel);
            }
        }
        this.findCustomerName.setText("");
    }//GEN-LAST:event_findCustomerByNameActionPerformed

    private void updateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCustomerActionPerformed
        if (customerTable.getSelectedRows().length > 1) {
            showMessage("Chỉ được chọn một khách hàng");
            return;
        }
        int selectedRow = customerTable.getSelectedRow();
        if (selectedRow != -1) {
            try {
                String id = (String) customerTableModel.getValueAt(selectedRow, 0);
                Customer currentCustomer = findCustomerById(id);
                new AddOrUpdateCustomer(this, rootPaneCheckingEnabled, currentCustomer).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                showMessage("Hình như có lỗi, Vui lòng thử lại");
            }
        } else {
            showMessage("Vui lòng chọn một khách hàng");
        }
    }//GEN-LAST:event_updateCustomerActionPerformed

    private void deleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCustomerActionPerformed
        int[] selectedRows = customerTable.getSelectedRows();

        if (selectedRows.length != 0) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Xóa " + selectedRows.length + " Khách Hàng",
                    "Warning", dialogButton);
            if (dialogResult == 0) {
                for (int row : selectedRows) {
                    String id = (String) customerTableModel.getValueAt(row, 0);
                    customerController.delete(customers, findCustomerById(id));
                }
                customerController.writeToFile(customers, DB_PATH + "customers.txt");
                initData(customers, customerTableModel);
            }
        } else {
            showMessage("Chưa Chọn Khách Hàng");
        }
    }//GEN-LAST:event_deleteCustomerActionPerformed

    private void addCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerActionPerformed
        new AddOrUpdateCustomer(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_addCustomerActionPerformed

    private void addServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addServiceActionPerformed
        new AddService(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_addServiceActionPerformed

    private void removeServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeServiceActionPerformed
        int[] selectedRows = serviceTable.getSelectedRows();

        if (selectedRows.length != 0) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Xóa " + selectedRows.length + " Dịch Vụ", "Warning",
                    dialogButton);
            if (dialogResult == 0) {
                for (int row : selectedRows) {
                    String name = (String) serviceTableModel.getValueAt(row, 0);
                    serviceController.delete(services, findServiceByName(name));
                }
                serviceController.writeToFile(services, DB_PATH + "services.txt");
                initData(services, serviceTableModel);
            }
        } else {
            showMessage("Chưa Chọn Dịch Vụ");
        }
    }//GEN-LAST:event_removeServiceActionPerformed

    private void signServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signServiceActionPerformed
        if (roomTable.getSelectedRows().length > 1) {
            showMessage("Chỉ được chọn một phòng");
            return;
        }
        int selectedRow = roomTable.getSelectedRow();
        if (selectedRow == -1) {
            showMessage("Vui lòng chọn phòng");
            return;
        }
        String id = roomTableModel.getValueAt(selectedRow, 0).toString();
        Room selectedRoom = findRoomById(id);
        boolean isRented = selectedRoom.isRented();
        if (!isRented) {
            showMessage("Phòng Đang Trống, Không Thêm Được Dịch Vụ");
            return;
        }
        new RoomSignService(this, rootPaneCheckingEnabled, serviceTable, selectedRoom).setVisible(true);
    }//GEN-LAST:event_signServiceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (roomTable.getSelectedRows().length > 1) {
            showMessage("Chỉ được chọn một phòng");
            return;
        }
        int selectedRow = roomTable.getSelectedRow();
        if (selectedRow == -1) {
            showMessage("Vui lòng chọn một phòng");
            return;
        }
        String id = roomTableModel.getValueAt(selectedRow, 0).toString();
        Room selectedRoom = findRoomById(id);

        new SignRoom(this, rootPaneCheckingEnabled, this.customerTable, selectedRoom, true).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void removeOrderRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeOrderRoomActionPerformed
        if (roomTable.getSelectedRows().length > 1) {
            showMessage("Chỉ được chọn một phòng");
            return;
        }
        int selectedRow = roomTable.getSelectedRow();
        if (selectedRow == -1) {
            showMessage("Vui lòng chọn một phòng");
            return;
        }
        String id = roomTableModel.getValueAt(selectedRow, 0).toString();
        removeOrderRoom(findRoomById(id));
    }//GEN-LAST:event_removeOrderRoomActionPerformed

    private void displayOrderCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayOrderCustomerActionPerformed
        if (roomTable.getSelectedRows().length > 1) {
            showMessage("Chỉ được chọn một phòng");
            return;
        }
        int selectedRow = roomTable.getSelectedRow();
        if (selectedRow == -1) {
            showMessage("Vui lòng chọn một phòng");
            return;
        }
        String customerId = roomTableModel.getValueAt(selectedRow, 5).toString();
        if (customerId.isBlank()) {
            showMessage("Phòng Chưa Được Đặt Trước");
            return;
        }
        Customer customer = findCustomerById(customerId);
        new ShowCustomer(this, rootPaneCheckingEnabled, customer).setVisible(true);
    }//GEN-LAST:event_displayOrderCustomerActionPerformed

    /**
     * @param <T>
     * @param list
     * @param model
     */
    @Override
    public <T> void initData(List<T> list, DefaultTableModel model) {
        model.setRowCount(0);
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        for (T t : list) {
            if (t instanceof Customer c) {
                model.addRow(new Object[]{
                    c.getId(),
                    c.getName(),
                    c.getGender(),
                    c.getBirthday() == null ? "" : dFormat.format(c.getBirthday()),
                    c.getHometown(),
                    c.getIdentification(),
                    c.getRentDate() == null ? "" : dFormat.format(c.getRentDate()),});
            } else if (t instanceof Room r) {
                String servicesName = "";
                for (Service service : r.getBill().getServices()) {
                    servicesName += service.getName() + ", ";
                }
                model.addRow(new Object[]{
                    r.getId(),
                    !r.isRented() ? "Còn Trống" : "Đã Đặt",
                    r.getRenter() != null ? r.getRenter().getId() : "",
                    r.getRentDate() != null ? dFormat.format(r.getRentDate()) : "",
                    r.getOrderDate() != null ? dFormat.format(r.getOrderDate()) : "",
                    r.getOrderCustomer() != null ? r.getOrderCustomer().getId() : "",
                    r.getPrice(),
                    servicesName}
                );
            } else if (t instanceof Employee e) {
                model.addRow(new Object[]{
                    e.getId(),
                    e.getName(),
                    e.getGender(),
                    e.getHometown(),
                    e.getIdentification(),
                    dFormat.format(e.getBirthday()),
                    e.getPosition(),
                    e.getSalary(),});
            } else if (t instanceof Service s) {
                String rooms = "";
                for (Room signedRoom : s.getSignedRooms()) {
                    rooms += signedRoom.getId() + ", ";
                }
                model.addRow(new Object[]{
                    s.getName(),
                    s.getCost(),
                    rooms,}
                );
            }
        }
    }

    @Override
    public <T> void initData(T element, DefaultTableModel model) {
        model.setRowCount(0);
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        if (element instanceof Customer c) {
            model.addRow(new Object[]{
                c.getId(),
                c.getName(),
                c.getGender(),
                c.getBirthday() == null ? "" : dFormat.format(c.getBirthday()),
                c.getHometown(),
                c.getIdentification(),
                c.getRentDate() == null ? "" : dFormat.format(c.getRentDate())
            });
        } else if (element instanceof Room r) {
            String servicesName = "";
            for (Service service : r.getBill().getServices()) {
                servicesName += service.getName() + ", ";
            }
            model.addRow(new Object[]{
                r.getId(),
                !r.isRented() ? "Còn Trống" : "Đã Thuê",
                r.getRenter() != null ? r.getRenter().getId() : "",
                dFormat.format(r.getRentDate()),
                r.getPrice(),
                servicesName});
        } else if (element instanceof Employee e) {
            model.addRow(new Object[]{
                e.getId(),
                e.getName(),
                e.getGender(),
                e.getHometown(),
                e.getIdentification(),
                dFormat.format(e.getBirthday()),
                e.getPosition(),
                e.getSalary()
            });
        } else if (element instanceof Service s) {
            model.addRow(new Object[]{
                s.getName(),
                s.getCost(),});
        }
    }

    public void initRoom() {
        rooms = roomController.readFromFile(DB_PATH + "rooms.txt");
        initData(rooms, roomTableModel);
    }

    public void initEmployee() {
        employees = employeeController.readFromFile(DB_PATH + "employees.txt");
        initData(employees, employeeTableModel);
    }

    public void initService() {
        services = customerController.readFromFile(DB_PATH + "services.txt");
        initData(services, serviceTableModel);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(rootPane, message);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCustomer;
    private javax.swing.JButton addEmployee;
    private javax.swing.JButton addRoom;
    private javax.swing.JButton addService;
    private javax.swing.JButton checkoutRoom;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton deleteCustomer;
    private javax.swing.JButton deleteRoom;
    private javax.swing.JButton displayOrderCustomer;
    private javax.swing.JButton displayRenter;
    private javax.swing.JTextField employeeIdFilter;
    private javax.swing.JTextField employeeNameFilter;
    private javax.swing.JTable employeeTable;
    private javax.swing.JButton findCustomerById;
    private javax.swing.JButton findCustomerByName;
    private javax.swing.JTextField findCustomerId;
    private javax.swing.JTextField findCustomerName;
    private javax.swing.JButton findEmployeeById;
    private javax.swing.JButton findEmployeeByName;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton printEmployees;
    private javax.swing.JButton refreshCustomerList;
    private javax.swing.JButton refreshEmployees;
    private javax.swing.JButton removeEmployee;
    private javax.swing.JButton removeOrderRoom;
    private javax.swing.JButton removeService;
    private javax.swing.JComboBox<String> roomFilter;
    private javax.swing.JTable roomTable;
    private javax.swing.JTable serviceTable;
    private javax.swing.JButton signRoom;
    private javax.swing.JButton signService;
    private javax.swing.JButton updateCustomer;
    private javax.swing.JButton updateEmployee;
    // End of variables declaration//GEN-END:variables

}

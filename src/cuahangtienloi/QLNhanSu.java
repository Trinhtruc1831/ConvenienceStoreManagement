/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuahangtienloi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
import javax.swing.JOptionPane;


/**
 *
 * @author PC
 */
public class QLNhanSu extends javax.swing.JFrame {
    
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime now = LocalDateTime.now();
    String nowDate = dtf.format(now);
    private Connection conn; 
    String driver = "com.mysql.jdbc.Driver";
    /**
     * Creates new form QLNhanSu
     */
    public QLNhanSu() {
        initComponents();
        setVisible(true);
        this.setLocationRelativeTo(null);
        setPreferredSize(new Dimension(960, 580));
        
        JTableHeader tableHeader = tbNhanSu.getTableHeader();
        tableHeader.setBackground(new java.awt.Color(75, 139, 197));
        tableHeader.setForeground(Color.white);
        tableHeader.setFont(new Font("Tahoma", Font.PLAIN, 11));
        
        tbNhanSu.getColumnModel().getColumn(0).setPreferredWidth(150);
        tbNhanSu.getColumnModel().getColumn(1).setPreferredWidth(110);
        tbNhanSu.getColumnModel().getColumn(2).setPreferredWidth(180);
        tbNhanSu.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbNhanSu.getColumnModel().getColumn(4).setPreferredWidth(100);
        tbNhanSu.getColumnModel().getColumn(5).setPreferredWidth(150);
        tbNhanSu.getColumnModel().getColumn(7).setPreferredWidth(280);
        tbNhanSu.getColumnModel().getColumn(8).setPreferredWidth(200);
        tbNhanSu.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        try {
            //Load driver
            Class.forName(driver).newInstance();
            //conn = DriverManager.getConnection(url+dbName+strUnicode,userName,password);
           
            //Kết nối với Font chữ Unicode
            String urlUnicode = "jdbc:mysql://localhost:3306/quanlycuahang?user=root&password=&useUnicode=true&characterEncoding=utf8";
            //Tạo kết nối
            conn = DriverManager.getConnection(urlUnicode); 
            //-----
            System.out.println("Connected to the database");
           
            String SQL = "SELECT MaNV, TenNV, LoaiNV, CMND, sdtNV, GioiTinh, DiemChuyenCan, NgVaoLam, TinhTrang FROM nhanvien";    
            System.out.print(SQL);
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(SQL);
            Vector data = null;
            rs.last();
            int count;
            count = rs.getRow();
            
            
            rs.beforeFirst(); 
//            int i=0; 
            while (rs.next()) {
                
                int TT = rs.getInt("TinhTrang");
                String strTinhTrang="";
                if(TT==1){
                    strTinhTrang ="Đang Làm";
                }
                else{
                    strTinhTrang ="Đã Nghỉ";
                }
                
                int GT = rs.getInt("GioiTinh");
                String strGioiTinh = "";
                if(GT==1){
                    strGioiTinh ="Nữ";
                }
                else{
                    strGioiTinh ="Nam";
                }
                
                int CV = rs.getInt("LoaiNV");
                String strLoaiNV = "";
                if(CV==1){
                    strLoaiNV ="Quản Lý";
                }
                if(CV==2){
                    strLoaiNV ="Thu Ngân";
                }
                if(CV==3){
                    strLoaiNV ="Thủ Kho";
                }
                data = new Vector();
                data.add(rs.getString("MaNV"));
                data.add(rs.getString("TenNV"));
                data.add(strLoaiNV);
                data.add(rs.getString("CMND"));
                data.add(rs.getString("sdtNV"));
                data.add(strGioiTinh);
                data.add(rs.getString("DiemChuyenCan"));
                data.add(rs.getString("NgVaoLam"));                
                data.add(strTinhTrang);
                // Thêm một dòng vào table model
                DefaultTableModel dsNhanSu =(DefaultTableModel) tbNhanSu.getModel();
                dsNhanSu.addRow(data);
              }
            rs.close();
            stat.close();
            conn.close();
        }catch(SQLException se)
        {
               se.printStackTrace();
        }catch(Exception e){
                // Xu ly cac loi cho Class.forName
                e.printStackTrace();
        }finally{
             
               }// Ket thuc khoi finally
    }
 
    public javax.swing.JLabel getAccount(){
        return lbUserName;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbNhanSu = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tfTen1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfSDT1 = new javax.swing.JTextField();
        tfCMND1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbGioiTinh1 = new javax.swing.JComboBox<>();
        cbChucVu1 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        lbThongBao = new javax.swing.JLabel();
        lbMNV = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbTinhTrang = new javax.swing.JComboBox<>();
        btCapNhat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        tfSDT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfCMND = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbChucVu = new javax.swing.JComboBox<>();
        cbGioiTinh = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        tfTen = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btXacNhan = new javax.swing.JButton();
        pfMatKhau = new javax.swing.JPasswordField();
        cbHien = new javax.swing.JCheckBox();
        tfTimKiem = new javax.swing.JTextField();
        btTimKiem = new javax.swing.JButton();
        IndexIcon = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbUserName = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(956, 539));
        setPreferredSize(new java.awt.Dimension(960, 580));
        getContentPane().setLayout(null);

        tbNhanSu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbNhanSu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Tên ", "Chức Vụ", "CMND", "SĐT", "Giới Tính", "DCC", "Ngày Vào Làm", "Tình Trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbNhanSu.setMinimumSize(new java.awt.Dimension(0, 0));
        tbNhanSu.setRowHeight(20);
        tbNhanSu.setRowMargin(5);
        tbNhanSu.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tbNhanSu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanSuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNhanSu);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(160, 130, 450, 220);

        jPanel3.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("CẬP NHẬT TÀI KHOẢN ");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(80, 20, 170, 30);

        tfTen1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tfTen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTen1ActionPerformed(evt);
            }
        });
        jPanel3.add(tfTen1);
        tfTen1.setBounds(90, 90, 160, 17);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Tên:");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(40, 90, 41, 20);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Sđt:");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(40, 110, 41, 20);

        tfSDT1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jPanel3.add(tfSDT1);
        tfSDT1.setBounds(90, 110, 160, 17);

        tfCMND1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jPanel3.add(tfCMND1);
        tfCMND1.setBounds(90, 130, 160, 17);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("CMND:");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(40, 130, 41, 20);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Giới Tính:");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(20, 150, 60, 20);

        cbGioiTinh1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cbGioiTinh1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nữ", "Nam" }));
        cbGioiTinh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGioiTinh1ActionPerformed(evt);
            }
        });
        jPanel3.add(cbGioiTinh1);
        cbGioiTinh1.setBounds(90, 150, 70, 17);

        cbChucVu1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cbChucVu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thu Ngân", "Thủ Kho", "Quản Lý" }));
        cbChucVu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChucVu1ActionPerformed(evt);
            }
        });
        jPanel3.add(cbChucVu1);
        cbChucVu1.setBounds(90, 170, 70, 17);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Chức vụ:");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(20, 170, 60, 20);

        lbThongBao.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lbThongBao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(lbThongBao);
        lbThongBao.setBounds(30, 70, 170, 20);

        lbMNV.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lbMNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel3.add(lbMNV);
        lbMNV.setBounds(202, 70, 50, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Tình trạng:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(0, 190, 80, 20);

        cbTinhTrang.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cbTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nghỉ Làm", "Đang Làm" }));
        jPanel3.add(cbTinhTrang);
        cbTinhTrang.setBounds(90, 190, 70, 17);

        btCapNhat.setText("Cập Nhật");
        btCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCapNhatActionPerformed(evt);
            }
        });
        jPanel3.add(btCapNhat);
        btCapNhat.setBounds(140, 290, 120, 40);

        jTabbedPane1.addTab("Cập nhật thông tin", jPanel3);

        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ĐĂNG KÝ TÀI KHOẢN");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(80, 20, 170, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Tên:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 100, 41, 20);

        tfUser.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tfUser.setMargin(new java.awt.Insets(1, 1, 1, 1));
        tfUser.setMinimumSize(new java.awt.Dimension(1, 20));
        tfUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUserActionPerformed(evt);
            }
        });
        jPanel2.add(tfUser);
        tfUser.setBounds(80, 83, 150, 17);

        tfSDT.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tfSDT.setMargin(new java.awt.Insets(1, 1, 1, 1));
        tfSDT.setMinimumSize(new java.awt.Dimension(1, 20));
        jPanel2.add(tfSDT);
        tfSDT.setBounds(80, 123, 150, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Sđt:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 120, 41, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Chức vụ:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 180, 60, 20);

        tfCMND.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tfCMND.setMargin(new java.awt.Insets(1, 1, 1, 1));
        tfCMND.setMinimumSize(new java.awt.Dimension(1, 20));
        jPanel2.add(tfCMND);
        tfCMND.setBounds(80, 143, 150, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("CMND:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 140, 41, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Giới Tính:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 160, 60, 20);

        cbChucVu.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thu Ngân", "Thủ Kho", "Quản Lý" }));
        cbChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChucVuActionPerformed(evt);
            }
        });
        jPanel2.add(cbChucVu);
        cbChucVu.setBounds(80, 183, 70, 18);

        cbGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nữ", "Nam" }));
        cbGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGioiTinhActionPerformed(evt);
            }
        });
        jPanel2.add(cbGioiTinh);
        cbGioiTinh.setBounds(80, 163, 70, 18);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("User:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 80, 41, 20);

        tfTen.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tfTen.setMargin(new java.awt.Insets(1, 1, 1, 1));
        tfTen.setMinimumSize(new java.awt.Dimension(1, 20));
        tfTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTenActionPerformed(evt);
            }
        });
        jPanel2.add(tfTen);
        tfTen.setBounds(80, 103, 150, 17);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Mật khẩu:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 200, 60, 20);

        btXacNhan.setText("Xác Nhận");
        btXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXacNhanActionPerformed(evt);
            }
        });
        jPanel2.add(btXacNhan);
        btXacNhan.setBounds(140, 290, 120, 40);

        pfMatKhau.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        pfMatKhau.setMargin(new java.awt.Insets(1, 1, 1, 1));
        pfMatKhau.setMinimumSize(new java.awt.Dimension(1, 20));
        jPanel2.add(pfMatKhau);
        pfMatKhau.setBounds(80, 204, 110, 17);

        cbHien.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cbHien.setText("Hiện");
        cbHien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbHienMouseClicked(evt);
            }
        });
        jPanel2.add(cbHien);
        cbHien.setBounds(190, 200, 60, 25);

        jTabbedPane1.addTab("Đăng ký tài khoản", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(630, 130, 300, 390);
        getContentPane().add(tfTimKiem);
        tfTimKiem.setBounds(160, 100, 140, 22);

        btTimKiem.setText("Tìm");
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });
        getContentPane().add(btTimKiem);
        btTimKiem.setBounds(330, 100, 60, 20);

        IndexIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuahangtienloi/Image/IconCT.png"))); // NOI18N
        IndexIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IndexIconMouseClicked(evt);
            }
        });
        getContentPane().add(IndexIcon);
        IndexIcon.setBounds(30, 20, 60, 60);

        jButton11.setBackground(new java.awt.Color(75, 139, 197));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Đăng Xuất");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11);
        jButton11.setBounds(10, 370, 110, 40);

        jButton10.setBackground(new java.awt.Color(75, 139, 197));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Kho Hàng");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10);
        jButton10.setBounds(10, 320, 110, 40);

        jButton2.setBackground(new java.awt.Color(75, 139, 197));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Thống Kê");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 270, 110, 40);

        jButton7.setBackground(new java.awt.Color(75, 139, 197));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Nhân Viên");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(10, 220, 110, 40);

        jButton9.setBackground(new java.awt.Color(75, 139, 197));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Thành Viên");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(10, 170, 110, 40);

        jButton8.setBackground(new java.awt.Color(75, 139, 197));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Bán Hàng");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(10, 120, 110, 40);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("!!");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(910, 20, 20, 50);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuahangtienloi/Image/IconReload.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel18);
        jLabel18.setBounds(910, 60, 20, 20);

        lbUserName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbUserName.setForeground(new java.awt.Color(255, 255, 255));
        lbUserName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbUserName.setText("NVxx");
        getContentPane().add(lbUserName);
        lbUserName.setBounds(850, 20, 60, 50);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Welcome");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(730, 20, 120, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuahangtienloi/Image/Background.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(973, 580));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbNhanSuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanSuMouseClicked
        DefaultTableModel tbnhansu =(DefaultTableModel)tbNhanSu.getModel();
        int SelectedRows = tbNhanSu.getSelectedRow();
        lbThongBao.setText("Cập nhật nhân viên mã:");
        lbMNV.setText(tbnhansu.getValueAt(SelectedRows,0).toString());
        tfTen1.setText(tbnhansu.getValueAt(SelectedRows,1).toString());
        tfSDT1.setText(tbnhansu.getValueAt(SelectedRows,4).toString());
        tfCMND1.setText(tbnhansu.getValueAt(SelectedRows,3).toString());
        cbGioiTinh1.setSelectedItem(tbnhansu.getValueAt(SelectedRows,5).toString());
        cbChucVu1.setSelectedItem(tbnhansu.getValueAt(SelectedRows,2).toString());
        cbTinhTrang.setSelectedItem(tbnhansu.getValueAt(SelectedRows,8).toString());
              
        
    }//GEN-LAST:event_tbNhanSuMouseClicked

    private void tfUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUserActionPerformed

    private void cbChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbChucVuActionPerformed

    private void cbGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGioiTinhActionPerformed

    private void tfTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTenActionPerformed

    private void btXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXacNhanActionPerformed
        String User = tfUser.getText(); 
        String Ten = tfTen.getText(); 
        String SDT = tfSDT.getText(); 
        String CMND = tfCMND.getText(); 
        String strGT = cbGioiTinh.getSelectedItem().toString();
        String strChucVu = cbChucVu.getSelectedItem().toString();
        String Pass = String.valueOf(pfMatKhau.getPassword());
        try{
        Double.parseDouble(tfSDT.getText());
        Double.parseDouble(tfCMND.getText());
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Số điện thoại hoặc CMND nhập không đúng định dạng!",  "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(User.equals("") | Ten.equals("") | SDT.equals("") | CMND.equals("") | Pass.equals("")){
            JOptionPane.showMessageDialog(null, "Trường thông tin không hợp lệ!",  "", JOptionPane.WARNING_MESSAGE);
            this.dispose();
            QLNhanSu reset = new QLNhanSu();
            reset.getAccount().setText(lbUserName.getText());
        }
        else{
            int GT = 0;
            if(strGT.equals("Nam")){
                GT = 0;
            }
            else {
                GT = 1;
            }
            int CV = 0;
            if(strChucVu.equals("Thu Ngân")){
                CV = 2;
            }
            if(strChucVu.equals("Quản Lý")){
                CV = 1;
            }
            if(strChucVu.equals("Thủ Kho")){
                CV = 3;
            }

            String prefixLessTen = "NV0";
            String prefixEqMoreTen = "NV";
            try {
                //Load driver
                Class.forName(driver).newInstance();
                //conn = DriverManager.getConnection(url+dbName+strUnicode,userName,password);

                //Kết nối với Font chữ Unicode
                String urlUnicode = "jdbc:mysql://localhost:3306/quanlycuahang?user=root&password=&useUnicode=true&characterEncoding=utf8";
                //Tạo kết nối
                conn = DriverManager.getConnection(urlUnicode); 
                //-----
                System.out.println("Connected to the database Them");
                
                String SQL = "SELECT * FROM nhanvien WHERE user =?";//Lấy so password vs user
            
                PreparedStatement stat = conn.prepareStatement(SQL);
                stat.setString(1,User );
                ResultSet rs = stat.executeQuery();
                rs.beforeFirst();
                rs.next();

                if(rs.getRow()>0){
                    JOptionPane.showMessageDialog(null, "User này đã tồn tại!",  "", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    
                    //Tạo mã nv bằng cách đếm dòng hiện tại, tạo string = NV_xx
                    String SQL1 = "SELECT * FROM nhanvien";  
                    System.out.print(SQL1);
                    Statement stat1 = conn.createStatement();
                    ResultSet rs1 = stat1.executeQuery(SQL1);
                    rs1.last();
                    System.out.print("Het truy van");
                    int countnv;//Thứ tự mã lớn nhất hiện tại
                    countnv = rs1.getRow() + 1;//Do Mã bắt đầu từ 01

                    System.out.print(countnv);

                    String strcounthd = String.valueOf(countnv);
                    String MNV="";
                    if(countnv<10){
                        MNV = prefixLessTen+strcounthd;
                    }
                    else{
                        MNV = prefixEqMoreTen+strcounthd;
                    }
                    rs1.close();
                    stat1.close();

                    System.out.print(MNV);



                    //Insert hóa đơn
                    String SQL2 = "INSERT INTO nhanvien VALUES(?,?,?,?,?,?,?,?,0,?,1)"; 
                    System.out.print(SQL2);
                    PreparedStatement stat2 = conn.prepareStatement(SQL2);
                    System.out.println("Test thử thêm một nhân viên!");
                    stat2.setString(1, MNV);
                    System.out.println(MNV);
                    stat2.setString(2, User);
                    System.out.println(User);
                    stat2.setString(3, Pass);
                    System.out.println(Pass);
                    stat2.setString(4, Ten);
                    System.out.println(Ten);
                    stat2.setInt(5, CV);
                    System.out.println(CV);
                    stat2.setString(6, CMND);
                    System.out.println(CMND);
                    stat2.setString(7, SDT);
                    System.out.println(SDT);
                    stat2.setInt(8, GT);
                    System.out.println(GT);
                    stat2.setString(9, nowDate);
                    System.out.println(nowDate);

                    stat2.executeUpdate();
                    stat2.close();


                    JOptionPane.showMessageDialog(null, "Thêm thành viên thành công!",  "", JOptionPane.WARNING_MESSAGE);
                    conn.close();

                    this.dispose();
                    QLNhanSu reset = new QLNhanSu();
                    reset.getAccount().setText(lbUserName.getText());
                    
                }
                
               
            }catch(SQLException se)
            {
                   se.printStackTrace();
            }catch(Exception e){
                    // Xu ly cac loi cho Class.forName
                    e.printStackTrace();
            }finally{

                   }// Ket thuc khoi finally 
        }
           
        
    }//GEN-LAST:event_btXacNhanActionPerformed

    private void cbHienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbHienMouseClicked
        boolean HideShow;
        if(cbHien.isSelected())
            pfMatKhau.setEchoChar((char)0);
        else
           pfMatKhau.setEchoChar('•');
        
       
        
    }//GEN-LAST:event_cbHienMouseClicked

    private void tfTen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTen1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTen1ActionPerformed

    private void cbGioiTinh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGioiTinh1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGioiTinh1ActionPerformed

    private void cbChucVu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChucVu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbChucVu1ActionPerformed

    private void btCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCapNhatActionPerformed
        String MNV = lbMNV.getText();
        String Ten = tfTen1.getText(); 
        String SDT = tfSDT1.getText(); 
        String CMND = tfCMND1.getText(); 
        String strGT = cbGioiTinh1.getSelectedItem().toString();
        String strChucVu = cbChucVu1.getSelectedItem().toString();
        String strTT = cbTinhTrang.getSelectedItem().toString();
        
        try{
        Double.parseDouble(tfSDT1.getText());
        Double.parseDouble(tfCMND1.getText());
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Số điện thoại hoặc CMND nhập không đúng định dạng!",  "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int GT = 0;
        if(strGT.equals("Nam")){
            GT = 0;
        }
        else {
            GT = 1;
        }
        int TT = 0;
        if(strTT.equals("Nghỉ Làm")){
            TT = 0;
        }
        else {
            TT = 1;
        }
        int CV = 0;
        if(strChucVu.equals("Thu Ngân")){
            CV = 2;
        }
        if(strChucVu.equals("Quản Lý")){
            CV = 1;
        }
        if(strChucVu.equals("Thủ Kho")){
            CV = 3;
        }
        String prefixLessTen = "NV0";
        String prefixEqMoreTen = "NV";
        try {
            //Load driver
            Class.forName(driver).newInstance();
            //conn = DriverManager.getConnection(url+dbName+strUnicode,userName,password);
           
            //Kết nối với Font chữ Unicode
            String urlUnicode = "jdbc:mysql://localhost:3306/quanlycuahang?user=root&password=&useUnicode=true&characterEncoding=utf8";
            //Tạo kết nối
            conn = DriverManager.getConnection(urlUnicode); 
            //-----
            System.out.println("Connected to the database Them");
            
            
            
            //Insert hóa đơn
            String SQL2 = "UPDATE nhanvien SET TenNV = ?, LoaiNV = ?,CMND = ?,sdtNV = ?,GioiTinh = ?,TinhTrang = ? WHERE MaNV = ?"; 
            System.out.print(SQL2);
            PreparedStatement stat2 = conn.prepareStatement(SQL2);
            stat2.setString(1, Ten);
            stat2.setInt(2, CV);
            stat2.setString(3, CMND);
            stat2.setString(4, SDT);
            stat2.setInt(5, GT);
            stat2.setInt(6, TT);
            stat2.setString(7, MNV);

            stat2.executeUpdate();
            stat2.close();
            

            JOptionPane.showMessageDialog(null, "Cập nhật thành viên thành công!",  "", JOptionPane.WARNING_MESSAGE);
            conn.close();
            
            this.dispose();
            QLNhanSu reset = new QLNhanSu();
            reset.getAccount().setText(lbUserName.getText());
     
        }catch(SQLException se)
        {
               se.printStackTrace();
        }catch(Exception e){
                // Xu ly cac loi cho Class.forName
                e.printStackTrace();
        }finally{
             
               }// Ket thuc khoi finally  
    }//GEN-LAST:event_btCapNhatActionPerformed

    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed
         DefaultTableModel dsThanhVien =(DefaultTableModel) tbNhanSu.getModel();
        String keyword = tfTimKiem.getText();
        
        String keywordTNV = '%'+keyword+'%';
        
        dsThanhVien.setRowCount(0);
        
        try {
            //Load driver
            Class.forName(driver).newInstance();

           
            //Kết nối với Font chữ Unicode
            String urlUnicode = "jdbc:mysql://localhost:3306/quanlycuahang?user=root&password=&useUnicode=true&characterEncoding=utf8";
            //Tạo kết nối
            conn = DriverManager.getConnection(urlUnicode); 
            //-----
            System.out.println("Connected to the database");
            String SQL = "SELECT MaNV, TenNV, LoaiNV, CMND, sdtNV, GioiTinh, DiemChuyenCan, NgVaoLam, TinhTrang FROM nhanvien WHERE MaNV = ? OR TenNV LIKE ? OR sdtNV = ?";    
            System.out.print(SQL);
            PreparedStatement stat = conn.prepareStatement(SQL);
            stat.setString(1,keyword);
            stat.setString(2,keywordTNV);
            stat.setString(3,keyword);
            
            ResultSet rs = stat.executeQuery();
            
            Vector data = null;
            rs.last();
            int count;
            count = rs.getRow();
            
            
            rs.beforeFirst(); 
//            int i=0; 
            while (rs.next()) {
                
                int TT = rs.getInt("TinhTrang");
                String strTinhTrang="";
                if(TT==1){
                    strTinhTrang ="Đang Làm";
                }
                else{
                    strTinhTrang ="Đã Nghỉ";
                }
                
                int GT = rs.getInt("GioiTinh");
                String strGioiTinh = "";
                if(GT==1){
                    strGioiTinh ="Nữ";
                }
                else{
                    strGioiTinh ="Nam";
                }
                
                int CV = rs.getInt("LoaiNV");
                String strLoaiNV = "";
                if(CV==1){
                    strLoaiNV ="Quản Lý";
                }
                if(CV==2){
                    strLoaiNV ="Thu Ngân";
                }
                if(CV==3){
                    strLoaiNV ="Thủ Kho";
                }
                data = new Vector();
                data.add(rs.getString("MaNV"));
                data.add(rs.getString("TenNV"));
                data.add(strLoaiNV);
                data.add(rs.getString("CMND"));
                data.add(rs.getString("sdtNV"));
                data.add(strGioiTinh);
                data.add(rs.getString("DiemChuyenCan"));
                data.add(rs.getString("NgVaoLam"));                
                data.add(strTinhTrang);
                // Thêm một dòng vào table model
                DefaultTableModel dsNhanSu =(DefaultTableModel) tbNhanSu.getModel();
                dsNhanSu.addRow(data);
              }
            rs.close();
            stat.close();
            conn.close();
        }catch(SQLException se)
        {
               se.printStackTrace();
        }catch(Exception e){
                // Xu ly cac loi cho Class.forName
                e.printStackTrace();
        }finally{
             
               }// Ket thuc khoi finally
    }//GEN-LAST:event_btTimKiemActionPerformed

    private void IndexIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IndexIconMouseClicked
        this.dispose();
        QLTrangChu reset = new QLTrangChu();
        reset.getAccount().setText(lbUserName.getText());
    }//GEN-LAST:event_IndexIconMouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        this.dispose();
        DangNhap login = new DangNhap();
        login.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.dispose();
        QLKhoHang reset = new QLKhoHang();
        reset.getAccount().setText(lbUserName.getText());
        reset.gettfMaNhanVien().setEditable(false);
        reset.gettfMaNhanVien().setText(lbUserName.getText());
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        QLThongKe reset = new QLThongKe();
        reset.getAccount().setText(lbUserName.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
        QLNhanSu reset = new QLNhanSu();
        reset.getAccount().setText(lbUserName.getText());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        this.dispose();
        QLKhachHang reset = new QLKhachHang();
        reset.getAccount().setText(lbUserName.getText());
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
        QLBanHang reset = new QLBanHang();
        reset.getAccount().setText(lbUserName.getText());
        reset.gettfMaNhanVien().setEditable(false);
        reset.gettfMaNhanVien().setText(lbUserName.getText());
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        this.dispose();
        QLBanHang reset = new QLBanHang();
        reset.getAccount().setText(lbUserName.getText());
        reset.gettfMaNhanVien().setEditable(false);
        reset.gettfMaNhanVien().setText(lbUserName.getText());
    }//GEN-LAST:event_jLabel18MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLNhanSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLNhanSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLNhanSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLNhanSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLNhanSu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IndexIcon;
    private javax.swing.JButton btCapNhat;
    private javax.swing.JButton btTimKiem;
    private javax.swing.JButton btXacNhan;
    private javax.swing.JComboBox<String> cbChucVu;
    private javax.swing.JComboBox<String> cbChucVu1;
    private javax.swing.JComboBox<String> cbGioiTinh;
    private javax.swing.JComboBox<String> cbGioiTinh1;
    private javax.swing.JCheckBox cbHien;
    private javax.swing.JComboBox<String> cbTinhTrang;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbMNV;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JPasswordField pfMatKhau;
    private javax.swing.JTable tbNhanSu;
    private javax.swing.JTextField tfCMND;
    private javax.swing.JTextField tfCMND1;
    private javax.swing.JTextField tfSDT;
    private javax.swing.JTextField tfSDT1;
    private javax.swing.JTextField tfTen;
    private javax.swing.JTextField tfTen1;
    private javax.swing.JTextField tfTimKiem;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}

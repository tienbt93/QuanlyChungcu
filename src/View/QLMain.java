/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.CanhoDAO;
import DAO.ChitietGiaodichDAO;
import DAO.ChungcuDAO;
import DAO.GiaodichDAO;
import DAO.KhachhangDAO;
import DAO.NhanvienDAO;
import DAO.ToanhaDAO;
import Model.Canho;
import Model.Chungcu;
import Model.Toanha;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.Common;

/**
 *
 * @author PTIT
 */
public class QLMain extends javax.swing.JFrame {

    /**
     * Creates new form QLMain
     */
    private ChungcuDAO chungcuDAO = new ChungcuDAO();
    private ToanhaDAO toanhaDAO = new ToanhaDAO();
    private CanhoDAO canhoDAO = new CanhoDAO();
    private NhanvienDAO nhanvienDAO = new NhanvienDAO();
    private KhachhangDAO khachhangDAO = new KhachhangDAO();
    private GiaodichDAO giaodichDAO = new GiaodichDAO();
    private ChitietGiaodichDAO chitietGiaodichDAO = new ChitietGiaodichDAO();
    private ArrayList<Chungcu> dsChungcu = new ArrayList<>();
    private ArrayList<Toanha> dsToanha = new ArrayList<>();
    private ArrayList<Canho> dsCanho = new ArrayList<>();
    private int indexChungcu = -1,indexToanha=-1;

    public QLMain() {
        initComponents();
        loadTblChungcu();
        loadTblToanha();
        loadTblCanho();
        loadTblNhanvien();
        loadTblKH();
        loadTblChitietGD();
        loadTblSearchKH();
        loadTblBCCanho();
        loadTblBCDoanhthu();
    }

    public void loadTblChungcu() {
        dsChungcu = (ArrayList<Chungcu>) chungcuDAO.getAll();
        String[] title = {"Mã Chung cư", "Tên Chung cư", "Số tòa nhà", "Tổng diện tích", "Địa chỉ", "Chủ đầu tư", "Mô tả"};
        DefaultTableModel model = new DefaultTableModel(null, title);
        cbChungcu.removeAllItems();
        for (int i = 0; i < dsChungcu.size(); i++) {
            model.addRow(dsChungcu.get(i).getObj());
            cbChungcu.addItem(dsChungcu.get(i).getTenChungcu().trim());
        }
        tblChungcu.setModel(model);
    }

    public void loadTblSearchKH() {
//        dsChungcu = (ArrayList<Chungcu>) chungcuDAO.getAll();
        String[] title = {"Mã KH", "Tên KH"};
        DefaultTableModel model = new DefaultTableModel(null, title);
//        for (int i = 0; i < dsChungcu.size(); i++) {
//            model.addRow(dsChungcu.get(i).getObj());
//        }
//        tblSearchKH.setModel(model);
    }

    public void loadTblChitietGD() {
//        dsChungcu = (ArrayList<Chungcu>) chungcuDAO.getAll();
        String[] title = {"Mã GD", "Tên KH", "Loại giao dịch", "Số lượng", "Ngày lập", "Nhân viên lập", "Tổng số tiền", "Mô tả"};
        DefaultTableModel model = new DefaultTableModel(null, title);
//        for (int i = 0; i < dsChungcu.size(); i++) {
//            model.addRow(dsChungcu.get(i).getObj());
//        }
        tblChitietGD.setModel(model);
    }

    public void loadTblBCCanho() {
//        dsChungcu = (ArrayList<Chungcu>) chungcuDAO.getAll();s
        String[] title = {"Tòa nhà", "Số căn hộ cho thuê", "Số căn hộ đã bán", "Số còn lại"};
        DefaultTableModel model = new DefaultTableModel(null, title);
//        for (int i = 0; i < dsChungcu.size(); i++) {
//            model.addRow(dsChungcu.get(i).getObj());
//        }
        tblBcCanho.setModel(model);
    }

    public void loadTblBCDoanhthu() {
//        dsChungcu = (ArrayList<Chungcu>) chungcuDAO.getAll();s
        String[] title = {"Tòa nhà", "Tống số tiền"};
        DefaultTableModel model = new DefaultTableModel(null, title);
//        for (int i = 0; i < dsChungcu.size(); i++) {
//            model.addRow(dsChungcu.get(i).getObj());
//        }
        tblBcDoanhthu.setModel(model);
    }

    public void loadTblKH() {
//        dsK = (ArrayList<Chungcu>) chungcuDAO.getAll();
        String[] title = {"Mã KH", "Tên KH", "Địa chỉ", "SĐT", "Email", "CMND", "Ngày sinh", "Giới tính", "Số tiền GD", "Mô tả"};
        DefaultTableModel model = new DefaultTableModel(null, title);
//        for (int i = 0; i < dsChungcu.size(); i++) {
//            model.addRow(dsChungcu.get(i).getObj());
//        }
        tblKH.setModel(model);
    }

    public void loadTblToanha() {
        dsToanha = (ArrayList<Toanha>) toanhaDAO.getAll();
        String[] title = {"Mã Tòa nhà", "Tên Tòa nhà", "Địa chỉ", "SĐT BQL", "Số tầng", "Số căn hộ", "Tổng diện tích", "Chung cư", "Ngày xây dựng", "Ngày hoàn thành", "Mô tả"};
        DefaultTableModel model = new DefaultTableModel(null, title);
        cbToanha.removeAllItems();
        for (int i = 0; i < dsToanha.size(); i++) {
            model.addRow(dsToanha.get(i).getObj());
             cbToanha.addItem(dsToanha.get(i).getTenToanha().trim());
        }
        tblToanha.setModel(model);
    }

    public void loadTblCanho() {
        dsCanho = (ArrayList<Canho>) canhoDAO.getAll();
        String[] title = {"Mã Căn hộ", "Tên Tòa nhà", "Số nhà", "Diện tích", "Số phòng", "Giá bán", "Giá thuê", "Mô tả"};
        DefaultTableModel model = new DefaultTableModel(null, title);
//        for (int i = 0; i < dsChungcu.size(); i++) {
//            model.addRow(dsChungcu.get(i).getObj());
//        }
        tblCanho.setModel(model);
    }

    public void loadTblNhanvien() {
        dsCanho = (ArrayList<Canho>) canhoDAO.getAll();
        String[] title = {"Mã Nhân viên", "Tòa nhà", "Hộ tên", "Địa chỉ", "SĐT", "Ngày sinh", "CMND", "Lương", "Ngày bắt đầu", "Mô tả"};
        DefaultTableModel model = new DefaultTableModel(null, title);
//        for (int i = 0; i < dsChungcu.size(); i++) {
//            model.addRow(dsChungcu.get(i).getObj());
//        }
        tblNhanvien.setModel(model);
    }

    public void showMsg(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public void resetForm() {
        txtChuDautu.setText("");
        txtDiachi.setText("");
        txtDiachiToanha.setText("");
        txtDientich.setText("");
        txtDientichCanho.setText("");
        txtDientichToanha.setText("");
        txtGiaban.setText("");
        txtGiathue.setText("");
        txtLuong.setText("");
        txtNVCmnd.setText("");
        txtNVDiachi.setText("");
        txtNVHoten.setText("");
        txtNVSdt.setText("");
        txtSdtToanha.setText("");
        txtSoCanho.setText("");
        txtSoToanha.setText("");
        txtSonha.setText("");
        txtSophong.setText("");
        txtSotang.setText("");
        txtTenChungcu.setText("");
        txtTenToanha.setText("");
        taMota.setText("");
        taMotaCanho.setText("");
        taMotaToanha.setText("");
        taNVMota.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sqlDateModel1 = new org.jdatepicker.impl.SqlDateModel();
        utilDateModel1 = new org.jdatepicker.impl.UtilDateModel();
        sqlDateModel2 = new org.jdatepicker.impl.SqlDateModel();
        sqlDateModel3 = new org.jdatepicker.impl.SqlDateModel();
        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog2 = new datechooser.beans.DateChooserDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChungcu = new javax.swing.JTable();
        Tên = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTenChungcu = new javax.swing.JTextField();
        txtSoToanha = new javax.swing.JTextField();
        txtDientich = new javax.swing.JTextField();
        txtDiachi = new javax.swing.JTextField();
        txtChuDautu = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        taMota = new javax.swing.JTextArea();
        btnThem = new javax.swing.JButton();
        tbnSua = new javax.swing.JButton();
        tbnXoa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblToanha = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTenToanha = new javax.swing.JTextField();
        txtDiachiToanha = new javax.swing.JTextField();
        txtSdtToanha = new javax.swing.JTextField();
        txtSotang = new javax.swing.JTextField();
        txtSoCanho = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        taMotaToanha = new javax.swing.JTextArea();
        dcNgayXD = new datechooser.beans.DateChooserCombo();
        dcNgayHT = new datechooser.beans.DateChooserCombo();
        txtDientichToanha = new javax.swing.JTextField();
        btnThemToanha = new javax.swing.JButton();
        btnSuaToanha = new javax.swing.JButton();
        btnXoaToanha = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbChungcu = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCanho = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cbToanha = new javax.swing.JComboBox<>();
        txtSonha = new javax.swing.JTextField();
        txtDientichCanho = new javax.swing.JTextField();
        txtSophong = new javax.swing.JTextField();
        txtGiaban = new javax.swing.JTextField();
        txtGiathue = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        taMotaCanho = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblNhanvien = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtNVHoten = new javax.swing.JTextField();
        txtNVDiachi = new javax.swing.JTextField();
        txtNVSdt = new javax.swing.JTextField();
        dateChooserCombo3 = new datechooser.beans.DateChooserCombo();
        txtNVCmnd = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        dateChooserCombo4 = new datechooser.beans.DateChooserCombo();
        jScrollPane8 = new javax.swing.JScrollPane();
        taNVMota = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblKH = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        dateChooserCombo5 = new datechooser.beans.DateChooserCombo();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblChitietGD = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        dateChooserCombo6 = new datechooser.beans.DateChooserCombo();
        dateChooserCombo7 = new datechooser.beans.DateChooserCombo();
        jLabel39 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jButton10 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblBcCanho = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        dateChooserCombo8 = new datechooser.beans.DateChooserCombo();
        jLabel42 = new javax.swing.JLabel();
        dateChooserCombo9 = new datechooser.beans.DateChooserCombo();
        jLabel43 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        tblDoanhthu = new javax.swing.JScrollPane();
        tblBcDoanhthu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblChungcu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Mã Chung cư", "Tên Chung cư", "Số tòa nhà", "Tổng diện tích","Địa chỉ","Chủ đầu tư"
                ,"Mô tả"
            }
        ));
        jScrollPane1.setViewportView(tblChungcu);

        Tên.setText("Tên");

        jLabel2.setText("Số Tòa nhà");

        jLabel3.setText("Diện tích");

        jLabel4.setText("Địa chỉ");

        jLabel5.setText("Chủ đầu tư");

        jLabel6.setText("Mô tả");

        taMota.setColumns(20);
        taMota.setRows(5);
        jScrollPane2.setViewportView(taMota);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        tbnSua.setText("Sửa");
        tbnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSuaActionPerformed(evt);
            }
        });

        tbnXoa.setText("Xóa");
        tbnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Tên)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTenChungcu, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoToanha, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDientich, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtChuDautu, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(tbnSua)
                        .addGap(29, 29, 29)
                        .addComponent(tbnXoa)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tên)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtTenChungcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoToanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDientich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChuDautu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem)
                        .addComponent(tbnSua)
                        .addComponent(tbnXoa)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Chung cư", jPanel2);

        tblToanha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblToanha);

        jLabel1.setText("Tên");

        jLabel7.setText("Địa chỉ");

        lb.setText("SĐT");

        jLabel9.setText("Sô tầng");

        jLabel10.setText("Số căn hộ");

        jLabel12.setText("Mô tả");

        jLabel13.setText("Ngày xây dựng");

        jLabel14.setText("Ngày hoàn thành");

        jLabel15.setText("Tổng diện tích");

        taMotaToanha.setColumns(20);
        taMotaToanha.setRows(5);
        jScrollPane4.setViewportView(taMotaToanha);

        btnThemToanha.setText("Thêm");
        btnThemToanha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemToanhaActionPerformed(evt);
            }
        });

        btnSuaToanha.setText("Sửa");
        btnSuaToanha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaToanhaActionPerformed(evt);
            }
        });

        btnXoaToanha.setText("Xóa");
        btnXoaToanha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaToanhaActionPerformed(evt);
            }
        });

        jLabel8.setText("Chung cư");

        cbChungcu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbChungcu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbChungcuItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtTenToanha, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDiachiToanha, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSdtToanha, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dcNgayXD, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnThemToanha)
                                        .addGap(38, 38, 38)
                                        .addComponent(btnSuaToanha)))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnXoaToanha)
                                    .addComponent(jLabel14))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(5, 5, 5)
                                .addComponent(txtSotang, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSoCanho, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(dcNgayHT, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(cbChungcu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDientichToanha, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel7)
                        .addComponent(lb)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(txtDiachiToanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSdtToanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSotang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSoCanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(txtDientichToanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTenToanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(dcNgayXD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcNgayHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(cbChungcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemToanha)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSuaToanha)
                                .addComponent(btnXoaToanha)))))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Tòa nhà", jPanel3);

        tblCanho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblCanho);

        jLabel16.setText("Tòa nhà");

        jLabel17.setText("Số nhà");

        jLabel18.setText("Diện tích");

        jLabel19.setText("Số phòng");

        jLabel20.setText("Giá bán");

        jLabel21.setText("Giá thuê");

        jLabel22.setText("Mô tả");

        cbToanha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tòa A1", "Tòa A2", "Item 3", "Item 4" }));
        cbToanha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbToanhaItemStateChanged(evt);
            }
        });

        taMotaCanho.setColumns(20);
        taMotaCanho.setRows(5);
        jScrollPane6.setViewportView(taMotaCanho);

        jButton1.setText("Thêm");

        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Xóa");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cbToanha, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSonha, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDientichCanho, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)
                        .addGap(43, 43, 43)
                        .addComponent(jButton2)
                        .addGap(64, 64, 64)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSophong, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGiaban, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGiathue, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane5)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(cbToanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txtSonha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDientichCanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSophong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiathue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Căn hộ", jPanel5);

        tblNhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tblNhanvien);

        jLabel11.setText("Họ tên");

        jLabel23.setText("Địa chỉ");

        jLabel24.setText("SĐT");

        jLabel25.setText("Ngày sinh");

        jLabel26.setText("CMND");

        jLabel27.setText("Lương");

        jLabel29.setText("Ngày bắt đầu");

        jLabel30.setText("Mô tả");

        taNVMota.setColumns(20);
        taNVMota.setRows(5);
        jScrollPane8.setViewportView(taNVMota);

        jButton4.setText("Thêm");

        jButton5.setText("Sửa");

        jButton6.setText("Xóa");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtNVHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNVDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(txtNVSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooserCombo4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(dateChooserCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(txtNVCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)
                        .addGap(26, 26, 26)
                        .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton4)
                        .addGap(63, 63, 63)
                        .addComponent(jButton5)
                        .addGap(54, 54, 54)
                        .addComponent(jButton6)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel23)
                        .addComponent(jLabel24)
                        .addComponent(jLabel25)
                        .addComponent(jLabel26)
                        .addComponent(jLabel27)
                        .addComponent(txtNVHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNVDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNVSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNVCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateChooserCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(jLabel30))
                    .addComponent(dateChooserCombo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Nhân viên", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 667, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quản lý chung cư", jPanel1);

        tblKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(tblKH);

        jLabel28.setText("Họ tên");

        jLabel31.setText("Địa chỉ");

        jLabel32.setText("SĐT");

        jLabel33.setText("Email");

        jLabel34.setText("CMND");

        jLabel35.setText("Ngày sinh");

        jLabel36.setText("Giới tính");

        jLabel37.setText("Mô tả");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane10.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateChooserCombo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(jLabel31)
                        .addComponent(jLabel32)
                        .addComponent(jLabel33)
                        .addComponent(jLabel34)
                        .addComponent(jLabel35)
                        .addComponent(jLabel36)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateChooserCombo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Khách hàng", jPanel7);

        jButton8.setText("Thêm giao dịch");

        tblChitietGD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(tblChitietGD);

        jLabel40.setText("Tìm kiếm");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Khách hàng", "Căn hộ" }));

        jButton9.setText("Tìm kiếm");

        jButton7.setText("Xem chi tiết ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addContainerGap(778, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane12)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jLabel40)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9)
                    .addComponent(jButton7))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Giao dịch", jPanel8);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Bán hàng", jPanel4);

        jLabel38.setText("Ngày bắt đầu");

        jLabel39.setText("Ngày kết thúc");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chung cư", "Tòa nhà", "Căn hộ" }));

        jButton10.setText("Xem báo cáo");

        tblBcCanho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane11.setViewportView(tblBcCanho);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooserCombo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooserCombo7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jButton10)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton10))
                    .addComponent(jLabel39)
                    .addComponent(dateChooserCombo7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooserCombo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Căn hộ", jPanel10);

        jLabel41.setText("Ngày bắt đầu");

        jLabel42.setText("Ngày kết thúc");

        jLabel43.setText("Loại giao dịch");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bán căn hộ", "Thuê Căn hộ" }));

        jLabel44.setText("Theo");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chung cư", "Tòa nhà", "Căn hộ"}));

        jButton11.setText("Xem báo cáo");

        tblBcDoanhthu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDoanhthu.setViewportView(tblBcDoanhthu);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tblDoanhthu)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooserCombo8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateChooserCombo9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jButton11)
                        .addGap(0, 299, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel43)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel44)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton11))
                    .addComponent(dateChooserCombo9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(dateChooserCombo8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(18, 18, 18)
                .addComponent(tblDoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Doanh thu", jPanel11);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Báo cáo", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnXoaActionPerformed
        // TODO add your handling code here:
        int selectRow = tblChungcu.getSelectedRow();
        if (selectRow > -1) {
            boolean isdel = (boolean) chungcuDAO.delete(dsChungcu.get(selectRow).getIdChungcu());
            if (isdel) {
                JOptionPane.showMessageDialog(this, "Xóa thông tin Chung cư thành công");
                loadTblChungcu();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thông tin Chung cư không thành công");
            }

        }
    }//GEN-LAST:event_tbnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            int soToanha = 0, tongDientich = 0;
            soToanha = Integer.parseInt(txtSoToanha.getText());
            tongDientich = Integer.parseInt(txtDientich.getText());

            String tenChungcu, diachiChungcu, chuDautu, mota;
            tenChungcu = txtTenChungcu.getText().trim();
            diachiChungcu = txtDiachi.getText().trim();
            chuDautu = txtChuDautu.getText().trim();
            mota = taMota.getText().trim();
            if (tenChungcu.equals("") || diachiChungcu.equals("") || chuDautu.equals("")) {
                showMsg("Yêu cầu nhập đầy đủ thông tin");
            } else {
                Chungcu chungcu = new Chungcu();
                chungcu.setTenChungcu(tenChungcu);
                chungcu.setDiachi(diachiChungcu);
                chungcu.setChuDautu(chuDautu);
                chungcu.setMota(mota);
                chungcu.setSoToanha(soToanha);
                chungcu.setTongDientich(tongDientich);
                try {
                    boolean success = (boolean) chungcuDAO.add(chungcu);
                    if (success) {
                        showMsg("Thêm chung cư thành công");
                        loadTblChungcu();
                        resetForm();
                    } else {
                        showMsg("Thêm chung cư không thành công");
                    }
                } catch (Exception ex) {
                    showMsg("Có lỗi xảy ra");
                }
            }
        } catch (Exception ex) {
            showMsg("Nhập đúng kiểu dữ liệu cho số Tòa nhà và Tổng diện tích");
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaToanhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaToanhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaToanhaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void tbnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSuaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_tbnSuaActionPerformed

    private void btnThemToanhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemToanhaActionPerformed
        // TODO add your handling code here:
        String tenToanha, dcToanha, sdtToanha, mota;
        tenToanha = txtTenToanha.getText().trim();
        dcToanha = txtDiachiToanha.getText().trim();
        sdtToanha = txtSdtToanha.getText().trim();
        mota = taMotaToanha.getText().trim();

        if (tenToanha.equals("") || dcToanha.equals("") || sdtToanha.equals("")) {
            showMsg("Yêu cầu nhập đầy đủ thông tin");
        } else {
            try {
//            showMsg(dcNgayXD.getText());
                Date dateXD = Common.parserDate(dcNgayXD.getText());
                Date dateHT = Common.parserDate(dcNgayHT.getText());
                if (indexChungcu < 0) {
                    showMsg("Yêu cầu chọn Chung cư");
                }
                int soTang, soCanho, tongDientich;
                try {
                    soCanho = Integer.parseInt(txtSoCanho.getText());
                    soTang = Integer.parseInt(txtSotang.getText());
                    tongDientich = Integer.parseInt(txtDientichToanha.getText());

                    Toanha toanha = new Toanha();
                    toanha.setTenToanha(tenToanha);
                    toanha.setDiachi(dcToanha);
                    toanha.setSdtQuanly(sdtToanha);
                    toanha.setMota(mota);
                    toanha.setSoTang(soTang);
                    toanha.setSoCanho(soCanho);
                    toanha.setTongDientich(tongDientich);
                    toanha.setNgayXaydung(dateXD);
                    toanha.setNgayHoanthanh(dateHT);
                    toanha.setChungcu(dsChungcu.get(indexChungcu));
                    try {
                        boolean success = (boolean) toanhaDAO.add(toanha);
                        if (success) {
                            showMsg("Thêm Tòa nhà thành công");
                            loadTblToanha();
                            resetForm();
                        } else {
                            showMsg("Thêm Tòa nhà không thành công");
                        }
                    } catch (Exception ex) {
                        showMsg("Có lỗi xảy ra");
                    }
                } catch (Exception ex) {
                    showMsg("Nhập đúng kiểu dữ liệu");
                }
            } catch (ParseException ex) {
                showMsg("Nhập đúng kiểu dữ liệu");
            }
        }
    }//GEN-LAST:event_btnThemToanhaActionPerformed

    private void cbChungcuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbChungcuItemStateChanged
        // TODO add your handling code here:
        indexChungcu = cbChungcu.getSelectedIndex();
        System.out.println("indexChungcu: " + indexChungcu);
    }//GEN-LAST:event_cbChungcuItemStateChanged

    private void cbToanhaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbToanhaItemStateChanged
        // TODO add your handling code here:
        indexToanha = cbToanha.getSelectedIndex();
        System.out.println("indexChungcu: " + indexToanha);
    }//GEN-LAST:event_cbToanhaItemStateChanged

    private void btnXoaToanhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaToanhaActionPerformed
        // TODO add your handling code here:
        int selectRow = tblToanha.getSelectedRow();
        if (selectRow > -1) {
            boolean isdel = (boolean) toanhaDAO.delete(dsToanha.get(selectRow).getIdToanha());
            if (isdel) {
                JOptionPane.showMessageDialog(this, "Xóa thông tin Tòa nhà thành công");
                loadTblToanha();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thông tin Tòa nhà không thành công");
            }

        }
    }//GEN-LAST:event_btnXoaToanhaActionPerformed

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
            java.util.logging.Logger.getLogger(QLMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Tên;
    private javax.swing.JButton btnSuaToanha;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemToanha;
    private javax.swing.JButton btnXoaToanha;
    private javax.swing.JComboBox<String> cbChungcu;
    private javax.swing.JComboBox<String> cbToanha;
    private datechooser.beans.DateChooserCombo dateChooserCombo3;
    private datechooser.beans.DateChooserCombo dateChooserCombo4;
    private datechooser.beans.DateChooserCombo dateChooserCombo5;
    private datechooser.beans.DateChooserCombo dateChooserCombo6;
    private datechooser.beans.DateChooserCombo dateChooserCombo7;
    private datechooser.beans.DateChooserCombo dateChooserCombo8;
    private datechooser.beans.DateChooserCombo dateChooserCombo9;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private datechooser.beans.DateChooserDialog dateChooserDialog2;
    private datechooser.beans.DateChooserCombo dcNgayHT;
    private datechooser.beans.DateChooserCombo dcNgayXD;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lb;
    private org.jdatepicker.impl.SqlDateModel sqlDateModel1;
    private org.jdatepicker.impl.SqlDateModel sqlDateModel2;
    private org.jdatepicker.impl.SqlDateModel sqlDateModel3;
    private javax.swing.JTextArea taMota;
    private javax.swing.JTextArea taMotaCanho;
    private javax.swing.JTextArea taMotaToanha;
    private javax.swing.JTextArea taNVMota;
    private javax.swing.JTable tblBcCanho;
    private javax.swing.JTable tblBcDoanhthu;
    private javax.swing.JTable tblCanho;
    private javax.swing.JTable tblChitietGD;
    private javax.swing.JTable tblChungcu;
    private javax.swing.JScrollPane tblDoanhthu;
    private javax.swing.JTable tblKH;
    private javax.swing.JTable tblNhanvien;
    private javax.swing.JTable tblToanha;
    private javax.swing.JButton tbnSua;
    private javax.swing.JButton tbnXoa;
    private javax.swing.JTextField txtChuDautu;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtDiachiToanha;
    private javax.swing.JTextField txtDientich;
    private javax.swing.JTextField txtDientichCanho;
    private javax.swing.JTextField txtDientichToanha;
    private javax.swing.JTextField txtGiaban;
    private javax.swing.JTextField txtGiathue;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtNVCmnd;
    private javax.swing.JTextField txtNVDiachi;
    private javax.swing.JTextField txtNVHoten;
    private javax.swing.JTextField txtNVSdt;
    private javax.swing.JTextField txtSdtToanha;
    private javax.swing.JTextField txtSoCanho;
    private javax.swing.JTextField txtSoToanha;
    private javax.swing.JTextField txtSonha;
    private javax.swing.JTextField txtSophong;
    private javax.swing.JTextField txtSotang;
    private javax.swing.JTextField txtTenChungcu;
    private javax.swing.JTextField txtTenToanha;
    private org.jdatepicker.impl.UtilDateModel utilDateModel1;
    // End of variables declaration//GEN-END:variables
}

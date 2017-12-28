/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author PTIT
 */
public class Nhanvien {
    private int idNhanvien;
    private String tenNhanvien;
    private String diachi;
    private String sdt;
    private Date ngaysinh;
    private String cmnd;
    private double luong;
    private String mota;
    private Date ngayBatdau;
    private Toanha toanha;
    private short gioitinh;

    public Nhanvien() {
    }

    public Nhanvien(int idNhanvien, String tenNhanvien, String diachi, String sdt, Date ngaysinh, String cmnd, double luong, String mota, Date ngayBatdau, Toanha toanha, short gioitinh) {
        this.idNhanvien = idNhanvien;
        this.tenNhanvien = tenNhanvien;
        this.diachi = diachi;
        this.sdt = sdt;
        this.ngaysinh = ngaysinh;
        this.cmnd = cmnd;
        this.luong = luong;
        this.mota = mota;
        this.ngayBatdau = ngayBatdau;
        this.toanha = toanha;
        this.gioitinh = gioitinh;
    }

    public short getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(short gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getIdNhanvien() {
        return idNhanvien;
    }

    public void setIdNhanvien(int idNhanvien) {
        this.idNhanvien = idNhanvien;
    }

    public String getTenNhanvien() {
        return tenNhanvien;
    }

    public void setTenNhanvien(String tenNhanvien) {
        this.tenNhanvien = tenNhanvien;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Date getNgayBatdau() {
        return ngayBatdau;
    }

    public void setNgayBatdau(Date ngayBatdau) {
        this.ngayBatdau = ngayBatdau;
    }

    public Toanha getToanha() {
        return toanha;
    }

    public void setToanha(Toanha toanha) {
        this.toanha = toanha;
    }
    
}

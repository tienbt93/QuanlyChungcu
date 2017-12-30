/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author PTIT
 */
public class Khachhang {
    private int idKhachhang;
    private String tenKhachhang;
    private String diachi;
    private String sdt;
    private Date ngaysinh;
    private String email;
    private String cmnd;
    private double tongtienGiaodich;
    private String mota;
    private short gioitinh;

    public Khachhang() {
    }

    public Khachhang(int idKhachhang, String tenKhachhang, String diachi, String sdt, Date ngaysinh, String email, String cmnd, double tongtienGiaodich, String mota, short gioitinh) {
        this.idKhachhang = idKhachhang;
        this.tenKhachhang = tenKhachhang;
        this.diachi = diachi;
        this.sdt = sdt;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.cmnd = cmnd;
        this.tongtienGiaodich = tongtienGiaodich;
        this.mota = mota;
        this.gioitinh = gioitinh;
    }

    public int getIdKhachhang() {
        return idKhachhang;
    }

    public void setIdKhachhang(int idKhachhang) {
        this.idKhachhang = idKhachhang;
    }

    public String getTenKhachhang() {
        return tenKhachhang;
    }

    public void setTenKhachhang(String tenKhachhang) {
        this.tenKhachhang = tenKhachhang;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public double getTongtienGiaodich() {
        return tongtienGiaodich;
    }

    public void setTongtienGiaodich(double tongtienGiaodich) {
        this.tongtienGiaodich = tongtienGiaodich;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public short getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(short gioitinh) {
        this.gioitinh = gioitinh;
    }
    
}

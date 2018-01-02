/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.util.Vector;
import utils.Common;

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
    private short kichhoat;

    public Nhanvien() {
    }

    public Nhanvien(int idNhanvien, String tenNhanvien, String diachi, String sdt, Date ngaysinh, String cmnd, double luong, String mota, Date ngayBatdau, Toanha toanha, short gioitinh, short kichhoat) {
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
        this.kichhoat = kichhoat;
    }

    public short getKichhoat() {
        return kichhoat;
    }

    public void setKichhoat(short kichhoat) {
        this.kichhoat = kichhoat;
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
    public Vector<String> getObj(){
        Vector<String> vt= new Vector<>();
        vt.add(idNhanvien+"");
        vt.add(toanha.getTenToanha().trim());
        vt.add(tenNhanvien+"");
        vt.add(diachi);
        vt.add(sdt);
        vt.add(Common.formatDate(ngaysinh));
        vt.add(cmnd);
        vt.add(Common.formatMoney(luong));
        vt.add(Common.formatDate(ngayBatdau));
        vt.add(mota);
        return vt;
    }
}

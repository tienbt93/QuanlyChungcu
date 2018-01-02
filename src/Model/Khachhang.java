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
    private short kichhoat;

    public Khachhang() {
    }

    public Khachhang(int idKhachhang, String tenKhachhang, String diachi, String sdt, Date ngaysinh, String email, String cmnd, double tongtienGiaodich, String mota, short gioitinh, short kichhoat) {
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
        this.kichhoat = kichhoat;
    }

    public short getKichhoat() {
        return kichhoat;
    }

    public void setKichhoat(short kichhoat) {
        this.kichhoat = kichhoat;
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

    public Vector<String> getObj() {
        Vector<String> vt = new Vector<>();
        vt.add(idKhachhang + "");
        vt.add(tenKhachhang.trim());
        vt.add(diachi);
        vt.add(sdt);
        vt.add(email);
        vt.add(cmnd);
        vt.add(Common.formatDate(ngaysinh));
        vt.add(gioitinh == 0 ? "Nam" : "Nữ");
        vt.add(Common.formatMoney(tongtienGiaodich));
        vt.add(mota);
        return vt;
    }

    public Vector getObjSearch() {
        Vector<String> vt = new Vector<>();
        vt.add(idKhachhang + "");
        vt.add(tenKhachhang.trim());
        vt.add(cmnd);
        vt.add(Common.formatDate(ngaysinh));
        return vt;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author PTIT
 */
public class Giaodich {
    private int idGiaodich;
    private short loaiGiaodich;
    private int soluong;
    private int soPhong;
    private double tonggia;
    private Date ngaylapGiaodich;
    private Nhanvien nhanvien;
    private String mota;
    private Khachhang khachhang;
    private ArrayList<ChitietGiaodich> danhsachChitiet;
    
    public Giaodich() {
    }

    public Giaodich(int idGiaodich, short loaiGiaodich, int soluong, int soPhong, double tonggia, Date ngaylapGiaodich, Nhanvien nhanvien, String mota, Khachhang khachhang, ArrayList<ChitietGiaodich> danhsachChitiet) {
        this.idGiaodich = idGiaodich;
        this.loaiGiaodich = loaiGiaodich;
        this.soluong = soluong;
        this.soPhong = soPhong;
        this.tonggia = tonggia;
        this.ngaylapGiaodich = ngaylapGiaodich;
        this.nhanvien = nhanvien;
        this.mota = mota;
        this.khachhang = khachhang;
        this.danhsachChitiet = danhsachChitiet;
    }

    public ArrayList<ChitietGiaodich> getDanhsachChitiet() {
        return danhsachChitiet;
    }

    public void setDanhsachChitiet(ArrayList<ChitietGiaodich> danhsachChitiet) {
        this.danhsachChitiet = danhsachChitiet;
    }
    public int getIdGiaodich() {
        return idGiaodich;
    }

    public void setIdGiaodich(int idGiaodich) {
        this.idGiaodich = idGiaodich;
    }

    public short getLoaiGiaodich() {
        return loaiGiaodich;
    }

    public void setLoaiGiaodich(short loaiGiaodich) {
        this.loaiGiaodich = loaiGiaodich;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public double getTonggia() {
        return tonggia;
    }

    public void setTonggia(double tonggia) {
        this.tonggia = tonggia;
    }

    public Date getNgaylapGiaodich() {
        return ngaylapGiaodich;
    }

    public void setNgaylapGiaodich(Date ngaylapGiaodich) {
        this.ngaylapGiaodich = ngaylapGiaodich;
    }

    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Khachhang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(Khachhang khachhang) {
        this.khachhang = khachhang;
    }
    
}

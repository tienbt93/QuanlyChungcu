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
public class Toanha {
    private int idToanha;
    private String tenToanha;
    private int soCanho;
    private int soTang;
    private int tongDientich;
    private String diachi;
    private String sdtQuanly;
    private Date ngayHoanthanh;
    private Date ngayXaydung;
    private String mota;
    private ArrayList<Canho> danhsachCanho;
    private Chungcu chungcu;

    public Toanha() {
    }

    public Toanha(int idToanha, String tenToanha, int soCanho, int soTang, int tongDientich, String diachi, String sdtQuanly, Date ngayHoanthanh, Date ngayXaydung, String mota, ArrayList<Canho> danhsachCanho, Chungcu chungcu) {
        this.idToanha = idToanha;
        this.tenToanha = tenToanha;
        this.soCanho = soCanho;
        this.soTang = soTang;
        this.tongDientich = tongDientich;
        this.diachi = diachi;
        this.sdtQuanly = sdtQuanly;
        this.ngayHoanthanh = ngayHoanthanh;
        this.ngayXaydung = ngayXaydung;
        this.mota = mota;
        this.danhsachCanho = danhsachCanho;
        this.chungcu = chungcu;
    }

    public int getIdToanha() {
        return idToanha;
    }

    public void setIdToanha(int idToanha) {
        this.idToanha = idToanha;
    }

    public String getTenToanha() {
        return tenToanha;
    }

    public void setTenToanha(String tenToanha) {
        this.tenToanha = tenToanha;
    }

    public int getSoCanho() {
        return soCanho;
    }

    public void setSoCanho(int soCanho) {
        this.soCanho = soCanho;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    public int getTongDientich() {
        return tongDientich;
    }

    public void setTongDientich(int tongDientich) {
        this.tongDientich = tongDientich;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdtQuanly() {
        return sdtQuanly;
    }

    public void setSdtQuanly(String sdtQuanly) {
        this.sdtQuanly = sdtQuanly;
    }

    public Date getNgayHoanthanh() {
        return ngayHoanthanh;
    }

    public void setNgayHoanthanh(Date ngayHoanthanh) {
        this.ngayHoanthanh = ngayHoanthanh;
    }

    public Date getNgayXaydung() {
        return ngayXaydung;
    }

    public void setNgayXaydung(Date ngayXaydung) {
        this.ngayXaydung = ngayXaydung;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public ArrayList<Canho> getDanhsachCanho() {
        return danhsachCanho;
    }

    public void setDanhsachCanho(ArrayList<Canho> danhsachCanho) {
        this.danhsachCanho = danhsachCanho;
    }

    public Chungcu getChungcu() {
        return chungcu;
    }

    public void setChungcu(Chungcu chungcu) {
        this.chungcu = chungcu;
    }
    
}

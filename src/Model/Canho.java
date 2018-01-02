/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Vector;
import utils.Common;

/**
 *
 * @author PTIT
 */
public class Canho {

    private int idCanho;
    private String soNha;
    private int soPhong;
    private int tongDientich;
    private double giaban;
    private double giathue;
    private String mota;
    private Toanha toanha;
    private short trangthai;
    private short kichhoat;

    public Canho() {
    }

    public Canho(int idCanho, String soNha, int soPhong, int tongDientich, double giaban, double giathue, String mota, Toanha toanha, short trangthai, short kichhoat) {
        this.idCanho = idCanho;
        this.soNha = soNha;
        this.soPhong = soPhong;
        this.tongDientich = tongDientich;
        this.giaban = giaban;
        this.giathue = giathue;
        this.mota = mota;
        this.toanha = toanha;
        this.trangthai = trangthai;
        this.kichhoat = kichhoat;
    }

    public short getKichhoat() {
        return kichhoat;
    }

    public void setKichhoat(short kichhoat) {
        this.kichhoat = kichhoat;
    }

    public short getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(short trangthai) {
        this.trangthai = trangthai;
    }

    public int getIdCanho() {
        return idCanho;
    }

    public void setIdCanho(int idCanho) {
        this.idCanho = idCanho;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public int getTongDientich() {
        return tongDientich;
    }

    public void setTongDientich(int tongDientich) {
        this.tongDientich = tongDientich;
    }

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public double getGiathue() {
        return giathue;
    }

    public void setGiathue(double giathue) {
        this.giathue = giathue;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Toanha getToanha() {
        return toanha;
    }

    public void setToanha(Toanha toanha) {
        this.toanha = toanha;
    }

    public Vector<String> getObj() {
        Vector<String> vt = new Vector<>();

        vt.add(idCanho + "");
        vt.add(toanha.getTenToanha().trim());
        vt.add(soNha.trim());
        vt.add(tongDientich + "");
        vt.add(soPhong + "");
        vt.add(Common.formatMoney(giaban));
        vt.add(Common.formatMoney(giathue));
        vt.add(mota.trim());
        vt.add(trangthai == 0 ? "Đang trống" : trangthai == 1 ? "Đã bán" : "Đang cho thuê");
        return vt;
    }

    public Vector getObjSearch() {
        Vector<String> vt = new Vector<>();
        vt.add(idCanho + "");
        vt.add(toanha.getTenToanha().trim());
        vt.add(soNha.trim());
        vt.add(Common.formatMoney(giaban));
        vt.add(Common.formatMoney(giathue));
        return vt;
    }
}

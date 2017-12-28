/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author PTIT
 */
public class Canho {
    private int idCanho;
    private String tenCanho;
    private String soNha;
    private int soPhong;
    private int tongDientich;
    private double giaban;
    private double giathue;
    private String mota;
    private Toanha toanha;

    public Canho() {
    }

    public Canho(int idCanho, String tenCanho, String soNha, int soPhong, int tongDientich, double giaban, double giathue, String mota, Toanha toanha) {
        this.idCanho = idCanho;
        this.tenCanho = tenCanho;
        this.soNha = soNha;
        this.soPhong = soPhong;
        this.tongDientich = tongDientich;
        this.giaban = giaban;
        this.giathue = giathue;
        this.mota = mota;
        this.toanha = toanha;
    }

    public int getIdCanho() {
        return idCanho;
    }

    public void setIdCanho(int idCanho) {
        this.idCanho = idCanho;
    }

    public String getTenCanho() {
        return tenCanho;
    }

    public void setTenCanho(String tenCanho) {
        this.tenCanho = tenCanho;
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
    
}

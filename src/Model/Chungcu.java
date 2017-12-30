/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author PTIT
 */
public class Chungcu {
    private int idChungcu;
    private String tenChungcu;
    private int soToanha;
    private int tongDientich;
    private String diachi;
    private String chuDautu;
    private String mota;
    private ArrayList<Toanha> listToanha;

    public Chungcu() {
    }

    public Chungcu(int idChungcu, String tenChungcu, int soToanha, int tongDientich, String diachi, String chuDautu, String mota, ArrayList<Toanha> listToanha) {
        this.idChungcu = idChungcu;
        this.tenChungcu = tenChungcu;
        this.soToanha = soToanha;
        this.tongDientich = tongDientich;
        this.diachi = diachi;
        this.chuDautu = chuDautu;
        this.mota = mota;
        this.listToanha = listToanha;
    }

    public int getIdChungcu() {
        return idChungcu;
    }

    public void setIdChungcu(int idChungcu) {
        this.idChungcu = idChungcu;
    }

    public String getTenChungcu() {
        return tenChungcu;
    }

    public void setTenChungcu(String tenChungcu) {
        this.tenChungcu = tenChungcu;
    }

    public int getSoToanha() {
        return soToanha;
    }

    public void setSoToanha(int soToanha) {
        this.soToanha = soToanha;
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

    public String getChuDautu() {
        return chuDautu;
    }

    public void setChuDautu(String chuDautu) {
        this.chuDautu = chuDautu;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public ArrayList<Toanha> getListToanha() {
        return listToanha;
    }

    public void setListToanha(ArrayList<Toanha> listToanha) {
        this.listToanha = listToanha;
    }
    public Vector<String> getObj(){
        Vector<String> vt= new Vector<>();
        vt.add(idChungcu+"");
        vt.add(tenChungcu);
        vt.add(soToanha+"");
        vt.add(tongDientich+"");
        vt.add(diachi);
        vt.add(chuDautu);
        vt.add(mota);
        return vt;
    }
    
}

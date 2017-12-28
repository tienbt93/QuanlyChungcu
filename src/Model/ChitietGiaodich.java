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
public class ChitietGiaodich {
    private Giaodich giaodich;
    private Canho canho;

    public ChitietGiaodich() {
    }

    public ChitietGiaodich(Giaodich giaodich, Canho canho) {
        this.giaodich = giaodich;
        this.canho = canho;
    }

    public Giaodich getGiaodich() {
        return giaodich;
    }

    public void setGiaodich(Giaodich giaodich) {
        this.giaodich = giaodich;
    }

    public Canho getCanho() {
        return canho;
    }

    public void setCanho(Canho canho) {
        this.canho = canho;
    }
    
    
}

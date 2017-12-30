/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.InterfaceDAO;
import Model.Giaodich;
import Model.Khachhang;
import Model.Nhanvien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PTIT
 */
public class GiaodichDAO extends InterfaceDAO {

    public GiaodichDAO() {
    }

    @Override
    public Object add(Object ob) {
        if (ob instanceof Giaodich) {
            Giaodich giaodich = (Giaodich) ob;
            String sql = "INSERT INTO [dbo].[giaodich]\n"
                    + "           ([loai_giaodich]\n"
                    + "           ,[soluong]\n"
                    + "           ,[tong_gia]\n"
                    + "           ,[ngaylap_giaodich]\n"
                    + "           ,[id_nhanvien]\n"
                    + "           ,[id_khachhang]\n"
                    + "           ,[mota])"
                    + "     VALUES(?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
                ps.setInt(1, giaodich.getLoaiGiaodich());
                ps.setInt(2, giaodich.getSoluong());
                ps.setDouble(3, giaodich.getTonggia());
                ps.setDate(4, giaodich.getNgaylapGiaodich());
                ps.setInt(5, giaodich.getNhanvien().getIdNhanvien());
                ps.setInt(6, giaodich.getKhachhang().getIdKhachhang());
                ps.setString(7, giaodich.getMota());
                return ps.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(GiaodichDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            return false;
        } else {
            return false;
        }
    }

    @Override
    public Object delete(int id) {
        String sql = "delete from [dbo].[giaodich] where id_giaodich=?";
        try {
            PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(GiaodichDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Object update(Object ob) {
        if (ob instanceof Giaodich) {
            Giaodich giaodich = (Giaodich) ob;
            String sql = "UPDATE [dbo].[giaodich]\n"
                    + "   SET [loai_giaodich] = ? \n"
                    + "      ,[soluong] = ? \n"
                    + "      ,[tong_gia] = ? \n"
                    + "      ,[ngaylap_giaodich] = ? \n"
                    + "      ,[id_nhanvien] = ? \n"
                    + "      ,[id_khachhang] = ? \n"
                    + "      ,[mota] = ? "
                    + " WHERE id_giaodich=? ";
            try {
                PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
                ps.setInt(1, giaodich.getLoaiGiaodich());
                ps.setInt(2, giaodich.getSoluong());
                ps.setDouble(3, giaodich.getTonggia());
                ps.setDate(4, giaodich.getNgaylapGiaodich());
                ps.setInt(5, giaodich.getNhanvien().getIdNhanvien());
                ps.setInt(6, giaodich.getKhachhang().getIdKhachhang());
                ps.setString(7, giaodich.getMota());
                ps.setInt(8, giaodich.getIdGiaodich());
                return 0 <= ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(GiaodichDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public Object getAll() {
        ArrayList<Giaodich> arr = null;
        String sql = "select * from giaodich";
        ResultSet rs = myConnect.executeQuery(sql);
        KhachhangDAO khachhangDAO = new KhachhangDAO();
        NhanvienDAO nhanvienDAO = new NhanvienDAO();
        if (rs != null) {
            arr = new ArrayList<>();
            try {
                Giaodich giaodich = null;
                while (rs.next()) {
                    giaodich = new Giaodich();
                    giaodich.setIdGiaodich(rs.getInt(1));
                    giaodich.setLoaiGiaodich(rs.getShort(2));
                    giaodich.setSoluong(rs.getInt(3));
                    giaodich.setTonggia(rs.getDouble(4));
                    giaodich.setNgaylapGiaodich(rs.getDate(5));
                    giaodich.setNhanvien((Nhanvien) nhanvienDAO.getId(rs.getInt(6)));
                    giaodich.setKhachhang((Khachhang) khachhangDAO.getId(rs.getInt(7)));
                    giaodich.setMota(rs.getNString(8));
                    arr.add(giaodich);
                }
            } catch (SQLException ex) {
                Logger.getLogger(GiaodichDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arr;
    }

    @Override
    public Object getId(int id) {
        Giaodich giaodich = null;
        String sql = "select * from giaodich where id_giaodich=" + id;
        ResultSet rs = myConnect.executeQuery(sql);
        KhachhangDAO khachhangDAO = new KhachhangDAO();
        NhanvienDAO nhanvienDAO = new NhanvienDAO();

        try {
            if (rs.next()) {
                giaodich = new Giaodich();
                giaodich.setIdGiaodich(rs.getInt(1));
                giaodich.setLoaiGiaodich(rs.getShort(2));
                giaodich.setSoluong(rs.getInt(3));
                giaodich.setTonggia(rs.getDouble(4));
                giaodich.setNgaylapGiaodich(rs.getDate(5));
                giaodich.setNhanvien((Nhanvien) nhanvienDAO.getId(rs.getInt(6)));
                giaodich.setKhachhang((Khachhang) khachhangDAO.getId(rs.getInt(7)));
                giaodich.setMota(rs.getNString(8));
                giaodich.setMota(rs.getNString(9));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GiaodichDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return giaodich;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.InterfaceDAO;
import Model.Khachhang;
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
public class KhachhangDAO extends InterfaceDAO {

    public KhachhangDAO() {
    }

    @Override
    public Object add(Object ob) {
        if (ob instanceof Khachhang) {
            Khachhang khachhang = (Khachhang) ob;
            String sql = "INSERT INTO [dbo].[khachhang]\n"
                    + "           ([hoten]\n"
                    + "           ,[diachi]\n"
                    + "           ,[sdt]\n"
                    + "           ,[email]\n"
                    + "           ,[cmnd]\n"
                    + "           ,[ngay_sinh]\n"
                    + "           ,[gioitinh]\n"
                    + "           ,[tongtien_giaodich]\n"
                    + "           ,[mota])"
                    + "     VALUES(?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
                ps.setNString(1, khachhang.getTenKhachhang());
                ps.setNString(2, khachhang.getDiachi());
                ps.setString(3, khachhang.getSdt());
                ps.setNString(4, khachhang.getEmail());
                ps.setNString(5, khachhang.getCmnd());
                ps.setDate(6, khachhang.getNgaysinh());
                ps.setShort(7, khachhang.getGioitinh());
                ps.setDouble(8, khachhang.getTongtienGiaodich());
                ps.setString(9, khachhang.getMota());
                return ps.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(KhachhangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            return false;
        } else {
            return false;
        }
    }

    @Override
    public Object delete(int id) {
        String sql = "delete from [dbo].[khachhang] where id_khachhang=?";
        try {
            PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(KhachhangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Object update(Object ob) {
        if (ob instanceof Khachhang) {
            Khachhang khachhang = (Khachhang) ob;
            String sql = "UPDATE [dbo].[khachhang]\n"
                    + "   SET [hoten] = ?\n"
                    + "      ,[diachi] = ?\n"
                    + "      ,[sdt] = ?\n"
                    + "      ,[email] = ?\n"
                    + "      ,[cmnd] = ?\n"
                    + "      ,[ngay_sinh] = ?\n"
                    + "      ,[gioitinh] = ?\n"
                    + "      ,[tongtien_giaodich] = ?\n"
                    + "      ,[mota] = ?"
                    + " WHERE id_khachhang=? ";
            try {
                PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
                ps.setNString(1, khachhang.getTenKhachhang());
                ps.setNString(2, khachhang.getDiachi());
                ps.setString(3, khachhang.getSdt());
                ps.setNString(4, khachhang.getEmail());
                ps.setNString(5, khachhang.getCmnd());
                ps.setDate(6, khachhang.getNgaysinh());
                ps.setShort(7, khachhang.getGioitinh());
                ps.setDouble(8, khachhang.getTongtienGiaodich());
                ps.setString(9, khachhang.getMota());
                ps.setInt(10, khachhang.getIdKhachhang());
                return 0 <= ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(KhachhangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public Object getAll() {
        ArrayList<Khachhang> arr = null;
        String sql = "select * from khachhang";
        ResultSet rs = myConnect.executeQuery(sql);
        ToanhaDAO toanhaDAO = new ToanhaDAO();
        if (rs != null) {
            arr = new ArrayList<>();
            try {
                Khachhang khachhang = null;
                while (rs.next()) {
                    khachhang = new Khachhang();
                    khachhang.setIdKhachhang(rs.getInt(1));
                    khachhang.setTenKhachhang((rs.getString(2)));
                    khachhang.setDiachi(rs.getNString(3));
                    khachhang.setSdt(rs.getString(4));
                    khachhang.setEmail(rs.getString(5));
                    khachhang.setCmnd(rs.getString(6));
                    khachhang.setNgaysinh(rs.getDate(7));
                    khachhang.setGioitinh(rs.getShort(8));
                    khachhang.setTongtienGiaodich(rs.getDouble(9));
                    khachhang.setMota(rs.getNString(10));
                    arr.add(khachhang);
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachhangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arr;
    }

    @Override
    public Object getId(int id) {
        Khachhang khachhang = null;
        String sql = "select * from khachhang where id_khachhang=" + id;
        ResultSet rs = myConnect.executeQuery(sql);
        ToanhaDAO toanhaDAO = new ToanhaDAO();
        try {
            if (rs.next()) {
                khachhang = new Khachhang();
                khachhang.setIdKhachhang(rs.getInt(1));
                khachhang.setTenKhachhang((rs.getString(2)));
                khachhang.setDiachi(rs.getNString(3));
                khachhang.setSdt(rs.getString(4));
                khachhang.setEmail(rs.getString(5));
                khachhang.setCmnd(rs.getString(6));
                khachhang.setNgaysinh(rs.getDate(7));
                khachhang.setGioitinh(rs.getShort(8));
                khachhang.setTongtienGiaodich(rs.getDouble(9));
                khachhang.setMota(rs.getNString(10));

            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachhangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return khachhang;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.InterfaceDAO;
import Model.Toanha;
import Model.Nhanvien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PTIT
 */
public class NhanvienDAO extends InterfaceDAO {

    public NhanvienDAO() {
    }

    @Override
    public Object add(Object ob) {
        if (ob instanceof Nhanvien) {
            Nhanvien nhanvien = (Nhanvien) ob;
            String sql = "INSERT INTO [dbo].[nhanvien]\n"
                    + "           ([hoten]\n"
                    + "           ,[diachi]\n"
                    + "           ,[sdt]\n"
                    + "           ,[ngaysinh]\n"
                    + "           ,[cmnd]\n"
                    + "           ,[luong]\n"
                    + "           ,[ngay_batdau]\n"
                    + "           ,[mota]\n"
                    + "           ,[id_toanha])"
                    + "     VALUES(?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
                ps.setNString(1, nhanvien.getTenNhanvien());
                ps.setNString(2, nhanvien.getDiachi());
                ps.setNString(3, nhanvien.getSdt());
                ps.setDate(4, nhanvien.getNgaysinh());
                ps.setString(5, nhanvien.getCmnd());
                ps.setDouble(6, nhanvien.getLuong());
                ps.setDate(7, nhanvien.getNgayBatdau());
                ps.setString(8, nhanvien.getMota());
                ps.setInt(9, nhanvien.getToanha().getIdToanha());
                return ps.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(NhanvienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            return false;
        } else {
            return false;
        }
    }

    @Override
    public Object delete(int id) {
        String sql = "delete from [dbo].[nhanvien] where id_nhanvien=?";
        try {
            PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NhanvienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Object update(Object ob) {
        if (ob instanceof Nhanvien) {
            Nhanvien nhanvien = (Nhanvien) ob;
            String sql = "UPDATE [dbo].[nhanvien]\n"
                    + "   SET [hoten] = ? \n"
                    + "      ,[diachi] = ? \n"
                    + "      ,[sdt] = ? \n"
                    + "      ,[ngaysinh] = ? \n"
                    + "      ,[cmnd] = ? \n"
                    + "      ,[luong] = ? \n"
                    + "      ,[ngay_batdau] = ? \n"
                    + "      ,[mota] = ? \n"
                    + "      ,[id_toanha] = ? "
                    + " WHERE id_nhanvien=? ";
            try {
                PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
                ps.setNString(1, nhanvien.getTenNhanvien());
                ps.setNString(2, nhanvien.getDiachi());
                ps.setNString(3, nhanvien.getSdt());
                ps.setDate(4, nhanvien.getNgaysinh());
                ps.setString(5, nhanvien.getCmnd());
                ps.setDouble(6, nhanvien.getLuong());
                ps.setDate(7, nhanvien.getNgayBatdau());
                ps.setString(8, nhanvien.getMota());
                ps.setInt(9, nhanvien.getToanha().getIdToanha());
                ps.setInt(10, nhanvien.getIdNhanvien());
                return 0 <= ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(NhanvienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public Object getAll() {
        ArrayList<Nhanvien> arr = null;
        String sql = "select * from Nhanvien";
        ResultSet rs = myConnect.executeQuery(sql);
        ToanhaDAO toanhaDAO = new ToanhaDAO();
        if (rs != null) {
            arr = new ArrayList<>();
            try {
                Nhanvien nhanvien = null;
                while (rs.next()) {
                    nhanvien = new Nhanvien();
                    nhanvien.setIdNhanvien(rs.getInt(1));
                    nhanvien.setTenNhanvien(rs.getNString(2));
                    nhanvien.setDiachi(rs.getNString(3));
                    nhanvien.setSdt(rs.getNString(4));
                    nhanvien.setNgaysinh(rs.getDate(5));
                    nhanvien.setCmnd(rs.getString(6));
                    nhanvien.setLuong(rs.getDouble(7));
                    nhanvien.setNgayBatdau(rs.getDate(8));
                    nhanvien.setMota(rs.getNString(9));
                    nhanvien.setToanha((Toanha) toanhaDAO.getId(rs.getInt(10)));
                    arr.add(nhanvien);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanvienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arr;
    }

    @Override
    public Object getId(int id) {
        Nhanvien nhanvien = null;
        String sql = "select * from nhanvien where id_nhanvien=" + id;
        ResultSet rs = myConnect.executeQuery(sql);
        ToanhaDAO toanhaDAO = new ToanhaDAO();
        try {
            if (rs.next()) {
                nhanvien = new Nhanvien();
                nhanvien.setIdNhanvien(rs.getInt(1));
                nhanvien.setTenNhanvien(rs.getNString(2));
                nhanvien.setDiachi(rs.getNString(3));
                nhanvien.setSdt(rs.getNString(4));
                nhanvien.setNgaysinh(rs.getDate(5));
                nhanvien.setCmnd(rs.getString(6));
                nhanvien.setLuong(rs.getDouble(7));
                nhanvien.setNgayBatdau(rs.getDate(8));
                nhanvien.setMota(rs.getNString(9));
                nhanvien.setToanha((Toanha) toanhaDAO.getId(rs.getInt(10)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanvienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nhanvien;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.InterfaceDAO;
import Model.Canho;
import Model.Toanha;
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
public class CanhoDAO extends InterfaceDAO {

    public CanhoDAO() {
    }

    @Override
    public Object add(Object ob) {
        if (ob instanceof Canho) {
            Canho canho = (Canho) ob;
            String sql = "INSERT INTO [QL_Chungcu].[dbo].[canho]\n"
                    + "           ([id_toanha]\n"
                    + "           ,[so_nha]\n"
                    + "           ,[dientich]\n"
                    + "           ,[sophong]\n"
                    + "           ,[gia_ban]\n"
                    + "           ,[gia_thue]\n"
                    + "           ,[mota])"
                    + "     VALUES(?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
                ps.setInt(1, canho.getToanha().getIdToanha());
                ps.setNString(2, canho.getSoNha());
                ps.setInt(3, canho.getTongDientich());
                ps.setInt(4, canho.getSoPhong());
                ps.setDouble(5, canho.getGiaban());
                ps.setDouble(6, canho.getGiathue());
                ps.setString(7, canho.getMota());
                return ps.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(CanhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            return false;
        } else {
            return false;
        }
    }

    @Override
    public Object delete(int id) {
        String sql = "delete from [QL_Chungcu].[dbo].[canho] where id_canho=?";
        try {
            PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CanhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Object update(Object ob) {
        if (ob instanceof Canho) {
            Canho canho = (Canho) ob;
            String sql = "UPDATE [QL_Chungcu].[dbo].[canho] \n"
                    + "   SET [id_toanha] = ?\n"
                    + "      ,[so_nha] = ?\n"
                    + "      ,[dientich] = ?\n"
                    + "      ,[sophong] = ?\n"
                    + "      ,[gia_ban] = ?\n"
                    + "      ,[gia_thue] = ?\n"
                    + "      ,[mota] = ?"
                    + " WHERE id_canho=? ";
            try {
                PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
                ps.setInt(1, canho.getToanha().getIdToanha());
                ps.setNString(2, canho.getSoNha());
                ps.setInt(3, canho.getTongDientich());
                ps.setInt(4, canho.getSoPhong());
                ps.setDouble(5, canho.getGiaban());
                ps.setDouble(6, canho.getGiathue());
                ps.setString(7, canho.getMota());
                ps.setInt(8, canho.getIdCanho());
                return 0 <= ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(CanhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public Object getAll() {
        ArrayList<Canho> arr = null;
        String sql = "select * from [QL_Chungcu].[dbo].[canho]";
        ResultSet rs = myConnect.executeQuery(sql);
        ToanhaDAO toanhaDAO = new ToanhaDAO();
        if (rs != null) {
            arr = new ArrayList<>();
            try {
                Canho canho = null;
                while (rs.next()) {
                    canho = new Canho();
                    canho.setIdCanho(rs.getInt(1));
                    canho.setToanha((Toanha) toanhaDAO.getId(rs.getInt(2)));
                    canho.setSoNha(rs.getString(3));
                    canho.setTongDientich(rs.getInt(4));
                    canho.setSoPhong(rs.getInt(5));
                    canho.setGiaban(rs.getDouble(6));
                    canho.setGiathue(rs.getDouble(7));
                    canho.setMota(rs.getNString(8));
                    arr.add(canho);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CanhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arr;
    }

    @Override
    public Object getId(int id) {
        Canho canho = null;
        String sql = "select * from [QL_Chungcu].[dbo].[canho] where id_canho=" + id;
        ResultSet rs = myConnect.executeQuery(sql);
        ToanhaDAO toanhaDAO = new ToanhaDAO();
        try {
            if (rs.next()) {
                canho = new Canho();
                canho.setIdCanho(rs.getInt(1));
                canho.setToanha((Toanha) toanhaDAO.getId(rs.getInt(2)));
                canho.setSoNha(rs.getNString(3));
                canho.setTongDientich(rs.getInt(4));
                canho.setSoPhong(rs.getInt(5));
                canho.setGiaban(rs.getDouble(6));
                canho.setGiathue(rs.getDouble(7));
                canho.setMota(rs.getNString(8));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CanhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return canho;
    }

}

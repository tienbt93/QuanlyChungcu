/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.InterfaceDAO;
import Model.Chungcu;
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
public class ChungcuDAO extends InterfaceDAO {

    public ChungcuDAO() {
    }

    @Override
    public Object add(Object ob) {
        if (ob instanceof Chungcu) {
            Chungcu chungcu = (Chungcu) ob;
            String sql = "INSERT INTO [QL_Chungcu].[dbo].[chungcu]\n"
                    + "           ([ten_chungcu]\n"
                    + "           ,[so_toanha]\n"
                    + "           ,[tong_dientich]\n"
                    + "           ,[diachi]\n"
                    + "           ,[chu_dautu]\n"
                    + "           ,[mota])"
                    + "     VALUES(?,?,?,?,?,?)";
            try {
                PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
                ps.setNString(1, chungcu.getTenChungcu());
                ps.setInt(2, chungcu.getSoToanha());
                ps.setInt(3, chungcu.getTongDientich());
                ps.setNString(4, chungcu.getDiachi());
                ps.setNString(5, chungcu.getChuDautu());
                ps.setString(6, chungcu.getMota());
                return ps.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(ChungcuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            return false;
        } else {
            return false;
        }
    }

    @Override
    public Object delete(int id) {
        String sql = "delete from [QL_Chungcu].[dbo].[chungcu] where id_chungcu=?";
        try {
            PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ChungcuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Object update(Object ob) {
        if (ob instanceof Chungcu) {
            Chungcu chungcu = (Chungcu) ob;
            String sql = "UPDATE [QL_Chungcu].[dbo].[chungcu]\n"
                    + "   SET [ten_chungcu] = ?\n"
                    + "      ,[so_toanha] = ?\n"
                    + "      ,[tong_dientich] = ?\n"
                    + "      ,[diachi] = ?\n"
                    + "      ,[chu_dautu] = ?\n"
                    + "      ,[mota] = ?"
                    + "      ,[kichhoat] = ?"
                    + " WHERE id_chungcu=? ";
            try {
                PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
                ps.setNString(1, chungcu.getTenChungcu());
                ps.setInt(2, chungcu.getSoToanha());
                ps.setInt(3, chungcu.getTongDientich());
                ps.setNString(4, chungcu.getDiachi());
                ps.setNString(5, chungcu.getChuDautu());
                ps.setString(6, chungcu.getMota());
                ps.setInt(7, chungcu.getKichhoat());
                ps.setInt(8, chungcu.getIdChungcu());
                return 0 <= ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ChungcuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public Object getAll() {
        ArrayList<Chungcu> arr = null;
        String sql = "select * from [QL_Chungcu].[dbo].[chungcu] where [kichhoat] = 1 ";
        ResultSet rs = myConnect.executeQuery(sql);
        ToanhaDAO toanhaDAO = new ToanhaDAO();
        if (rs != null) {
            arr = new ArrayList<>();
            try {
                Chungcu chungcu = null;
                while (rs.next()) {
                    chungcu = new Chungcu();
                    chungcu.setIdChungcu(rs.getInt(1));
                    chungcu.setTenChungcu((rs.getString(2)));
                    chungcu.setSoToanha(rs.getInt(3));
                    chungcu.setTongDientich(rs.getInt(4));
                    chungcu.setDiachi(rs.getString(5));
                    chungcu.setChuDautu(rs.getString(6));
                    chungcu.setMota(rs.getNString(7));
                    arr.add(chungcu);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChungcuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arr;
    }

    @Override
    public Object getId(int id) {
        Chungcu chungcu = null;
        String sql = "select * from [QL_Chungcu].[dbo].[chungcu] where id_chungcu=" + id;
        ResultSet rs = myConnect.executeQuery(sql);
        ToanhaDAO toanhaDAO = new ToanhaDAO();
        try {
            if (rs.next()) {
                chungcu = new Chungcu();
                chungcu.setIdChungcu(rs.getInt(1));
                chungcu.setTenChungcu((rs.getString(2)));
                chungcu.setSoToanha(rs.getInt(3));
                chungcu.setTongDientich(rs.getInt(4));
                chungcu.setDiachi(rs.getString(5));
                chungcu.setChuDautu(rs.getString(6));
                chungcu.setMota(rs.getNString(7));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ChungcuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return chungcu;
    }

    @Override
    public Object getAllByText(String searchText) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

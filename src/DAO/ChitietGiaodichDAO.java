/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.InterfaceDAO;
import Model.Canho;
import Model.ChitietGiaodich;
import Model.Giaodich;
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
public class ChitietGiaodichDAO extends InterfaceDAO {

    public ChitietGiaodichDAO() {
    }

    @Override
    public Object add(Object ob) {
        if (ob instanceof ChitietGiaodich) {
            ChitietGiaodich chitietGiaodich = (ChitietGiaodich) ob;
            String sql = "INSERT INTO [QL_Chungcu].[dbo].[chitiet_giaodich]\n"
                    + "           ([id_giaodich]\n"
                    + "           ,[id_canho])"
                    + "     VALUES(?,?)";
            try {
                PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
                ps.setInt(1, chitietGiaodich.getGiaodich().getIdGiaodich());
                ps.setInt(2, chitietGiaodich.getCanho().getIdCanho());
                return ps.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(ChitietGiaodichDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            return false;
        } else {
            return false;
        }
    }

    public Object delete(ChitietGiaodich chitietGiaodich) {
        String sql = "delete from [QL_Chungcu].[dbo].[chitiet_giaodich] where id_giaodich=? and id_canho = ?";
        try {
            PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
            ps.setInt(1, chitietGiaodich.getGiaodich().getIdGiaodich());
            ps.setInt(2, chitietGiaodich.getCanho().getIdCanho());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ChitietGiaodichDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Object update(Object ob) {
        if (ob instanceof ChitietGiaodich) {
            ChitietGiaodich chitietGiaodich = (ChitietGiaodich) ob;
            String sql = "UPDATE [QL_Chungcu].[dbo].[chitiet_giaodich]\n"
                    + "   SET [id_giaodich] = ? \n"
                    + "      ,[id_canho] = ? "
                    + " WHERE id_giaodich=? and id_canho =?";
            try {
                PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
                ps.setInt(1, chitietGiaodich.getGiaodich().getIdGiaodich());
                ps.setInt(2, chitietGiaodich.getCanho().getIdCanho());
                ps.setInt(3, chitietGiaodich.getGiaodich().getIdGiaodich());
                ps.setInt(4, chitietGiaodich.getCanho().getIdCanho());
                return 0 <= ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ChitietGiaodichDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public Object getAll() {
        ArrayList<ChitietGiaodich> arr = null;
        String sql = "select * from [QL_Chungcu].[dbo].[chitiet_giaodich]";
        ResultSet rs = myConnect.executeQuery(sql);
        GiaodichDAO giaodichDAO = new GiaodichDAO();
        CanhoDAO canhoDAO = new CanhoDAO();
        if (rs != null) {
            arr = new ArrayList<>();
            try {
                ChitietGiaodich chitietGiaodich = null;
                while (rs.next()) {
                    chitietGiaodich = new ChitietGiaodich();
                    chitietGiaodich.setGiaodich((Giaodich) giaodichDAO.getId(rs.getInt(1)));
                    chitietGiaodich.setCanho((Canho) canhoDAO.getId(rs.getShort(2)));
                    arr.add(chitietGiaodich);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChitietGiaodichDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arr;
    }

    @Override
    public Object getId(int id) {
        ChitietGiaodich chitietGiaodich = null;
        String sql = "select * from [QL_Chungcu].[dbo].[chitiet_giaodich] where id_giaodich=" + id;
        ResultSet rs = myConnect.executeQuery(sql);
        GiaodichDAO giaodichDAO = new GiaodichDAO();
        CanhoDAO canhoDAO = new CanhoDAO();

        try {
            if (rs.next()) {
                chitietGiaodich = new ChitietGiaodich();
                chitietGiaodich.setGiaodich((Giaodich) giaodichDAO.getId(rs.getInt(1)));
                chitietGiaodich.setCanho((Canho) canhoDAO.getId(rs.getShort(2)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ChitietGiaodichDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return chitietGiaodich;
    }

    @Override
    public Object delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getAllByText(String searchText) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

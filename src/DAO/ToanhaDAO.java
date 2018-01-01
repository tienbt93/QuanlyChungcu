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
public class ToanhaDAO extends InterfaceDAO {

    public ToanhaDAO() {
    }

    @Override
    public Object add(Object ob) {
        if (ob instanceof Toanha) {
            Toanha toanha = (Toanha) ob;
            String sql = "INSERT INTO [QL_Chungcu].[dbo].[toanha]\n"
                    + "           ([ten_toanha]\n"
                    + "           ,[diachi]\n"
                    + "           ,[sdt_quanly]\n"
                    + "           ,[so_tang]\n"
                    + "           ,[so_canho]\n"
                    + "           ,[tong_dientich]\n"
                    + "           ,[ngay_xaydung]\n"
                    + "           ,[ngay_hoanthanh]\n"
                    + "           ,[mota]\n"
                    + "           ,[id_chungcu])\n"
                    + "     VALUES(?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
                ps.setNString(1, toanha.getTenToanha());
                ps.setNString(2, toanha.getDiachi());
                ps.setNString(3, toanha.getSdtQuanly());
                ps.setInt(4, toanha.getSoTang());
                ps.setInt(5, toanha.getSoCanho());
                ps.setDouble(6, toanha.getTongDientich());
                ps.setDate(7, toanha.getNgayXaydung());
                ps.setDate(8, toanha.getNgayHoanthanh());
                ps.setString(9, toanha.getMota());
                ps.setInt(10, toanha.getChungcu().getIdChungcu());
                return ps.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(ToanhaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            return false;
        } else {
            return false;
        }
    }

    @Override
    public Object delete(int id) {
        String sql = "delete from [QL_Chungcu].[dbo].[toanha] where id_toanha=?";
        try {
            PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ToanhaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Object update(Object ob) {
        if (ob instanceof Toanha) {
            Toanha toanha = (Toanha) ob;
            String sql = "UPDATE [QL_Chungcu].[dbo].[toanha]\n"
                    + "   SET [ten_toanha] = ?\n"
                    + "      ,[diachi] = ?\n"
                    + "      ,[sdt_quanly] = ?\n"
                    + "      ,[so_tang] = ?\n"
                    + "      ,[so_canho] = ?\n"
                    + "      ,[tong_dientich] = ?\n"
                    + "      ,[ngay_xaydung] = ?\n"
                    + "      ,[ngay_hoanthanh] = ?\n"
                    + "      ,[mota] = ?\n"
                    + "      ,[id_chungcu] = ?"
                    + " WHERE id_toanha=? ";
            try {
                PreparedStatement ps = myConnect.getConn().prepareStatement(sql);
                ps.setNString(1, toanha.getTenToanha());
                ps.setNString(2, toanha.getDiachi());
                ps.setNString(3, toanha.getSdtQuanly());
                ps.setInt(4, toanha.getSoTang());
                ps.setInt(5, toanha.getSoCanho());
                ps.setDouble(6, toanha.getTongDientich());
                ps.setDate(7, toanha.getNgayXaydung());
                ps.setDate(8, toanha.getNgayHoanthanh());
                ps.setString(9, toanha.getMota());
                ps.setInt(10, toanha.getChungcu().getIdChungcu());
                ps.setInt(11, toanha.getIdToanha());
                return 0 <= ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ToanhaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public Object getAll() {
        ArrayList<Toanha> arr = null;
        String sql = "select * from [QL_Chungcu].[dbo].[toanha]";
        ResultSet rs = myConnect.executeQuery(sql);
        ChungcuDAO chungcuDAO = new ChungcuDAO();
        if (rs != null) {
            arr = new ArrayList<>();
            try {
                Toanha toanha = null;
                while (rs.next()) {
                    toanha = new Toanha();
                    toanha.setIdToanha(rs.getInt(1));
                    toanha.setTenToanha(rs.getNString(2));
                    toanha.setDiachi(rs.getNString(3));
                    toanha.setSdtQuanly(rs.getNString(4));
                    toanha.setSoTang(rs.getInt(5));
                    toanha.setSoCanho(rs.getInt(6));
                    toanha.setTongDientich(rs.getInt(7));
                    toanha.setNgayXaydung(rs.getDate(8));
                    toanha.setNgayHoanthanh(rs.getDate(9));
                    toanha.setMota(rs.getNString(10));
                    toanha.setChungcu((Chungcu) chungcuDAO.getId(rs.getInt(11)));
                    arr.add(toanha);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ToanhaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arr;
    }

    @Override
    public Object getId(int id) {
        Toanha toanha = null;
        String sql = "select * from [QL_Chungcu].[dbo].[toanha] where id_toanha=" + id;
        ResultSet rs = myConnect.executeQuery(sql);
        ChungcuDAO chungcuDAO = new ChungcuDAO();
        try {
            if (rs.next()) {
                toanha = new Toanha();
                toanha.setIdToanha(rs.getInt(1));
                toanha.setTenToanha(rs.getNString(2));
                toanha.setDiachi(rs.getNString(3));
                toanha.setSdtQuanly(rs.getNString(4));
                toanha.setSoTang(rs.getInt(5));
                toanha.setSoCanho(rs.getInt(6));
                toanha.setTongDientich(rs.getInt(7));
                toanha.setNgayXaydung(rs.getDate(8));
                toanha.setNgayHoanthanh(rs.getDate(9));
                toanha.setMota(rs.getNString(10));
                toanha.setChungcu((Chungcu) chungcuDAO.getId(rs.getInt(11)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ToanhaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return toanha;
    }

}

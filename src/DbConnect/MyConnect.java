/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnect;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PTIT
 */
public class MyConnect {
    private String Url="jdbc:sqlserver://TIEU-TU:1433;databaseName=QuanLyChungcu";
    private String DbClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String user="sa";
    private String pass="12345";
    private String exec;
    private Connection conn;
    private Statement stm;
    private PreparedStatement psm;
    private boolean isServer=false;

    public MyConnect() {
        try {
            Class.forName(DbClass);
            conn=DriverManager.getConnection(Url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MyConnect(String Url,String exec) {
        this.Url = Url;
        this.exec=exec;
        try {
            Class.forName(DbClass);
            conn=DriverManager.getConnection(Url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet executeQuery(String sql){
        ResultSet rs=null;
        try {
            stm =(Statement) getConn().createStatement();
             rs=stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public int executePrepa(PreparedStatement ps){
        int i=-1;
        try {
            this.psm=ps;
            i= psm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public boolean EXEC(){
        try {
            return getConn().createStatement().execute(this.exec);
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public Connection getConn() {
        return conn;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPsm(PreparedStatement psm) {
        this.psm = psm;
    }

    public String getExec() {
        return exec;
    }

    public void setExec(String exec) {
        this.exec = exec;
    }

    public boolean isIsServer() {
        return isServer;
    }

    public void setIsServer(boolean isServer) {
        this.isServer = isServer;
    }
    
    
}

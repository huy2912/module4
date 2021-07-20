
package Bai2;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {
    public Connection conn = null;
    
    public void ConnectSQL(){
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLBanHang";
            String user = "sa";
            String pass = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
        }
    }
    
    public ResultSet LoadData(String sql){       
        try {
            Statement stm = conn.createStatement();           
            return stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void UpdateData(String sql){
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql); 
        } catch (SQLException ex) {
            System.out.println("error");
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnect(){
        return conn;
    }
}

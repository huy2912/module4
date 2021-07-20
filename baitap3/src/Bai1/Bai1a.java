/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;
import java.sql.Connection;
import java.sql.ResultSet;
/**
 *
 * @author binhb
 */
public class Bai1a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connect conn = new Connect();
        conn.ConnectSQL();
        
        ResultSet data = conn.LoadData("select maSP, tenSP, tenLoaiSP from SanPham inner join LoaiSanPham on SanPham.maLoaiSP = LoaiSanPham.maLoaiSP");
        try{
            while(data.next()){
                System.out.println(data.getString(1));
                System.out.println(data.getString(2));
                System.out.println(data.getString(3));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}

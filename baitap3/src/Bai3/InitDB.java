/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author binhb
 */
public class InitDB {
    
    static Connect conn = new Connect();
    public static void createTableTacGia(){
        conn.ConnectSQL();
        String sql = "create table TacGia(" +
                    "MaTacGia nvarchar(30) primary key," +
                    "TenTacGia nvarchar(30)," +
                    "DCLienHe nvarchar(30)" +
                    ")";
        conn.UpdateData(sql);
        
        sql = "insert into TacGia values('1', 'tg1', 'dc1'), ('2', 'tg2', 'dc2'), ('3', 'tg3', 'dc3')";
        conn.UpdateData(sql);
    }
    
    public static void createTableSach(){
        conn.ConnectSQL();
        String sql = "create table Sach(" +
                    "MaSach nvarchar(30) primary key," +
                    "TuSach nvarchar(30)," +
                    "SoTrang int," +
                    "MaTG nvarchar(30) foreign key references TacGia(MaTacGia)," +
                    "NamXB int," +
                    "TuKhoa nvarchar(30)," +
                    "NXB nvarchar(30)" +
                    ")";
        conn.UpdateData(sql);
        
        sql = "insert into Sach values('1', 'sach1', 30, '1', '1999', 'tukhoa1', 'nxb1'),"
                + "('2', 'sach2', 40, '1', '2002', 'tukhoa1', 'nxb2'),"
                + "('3', 'sach3', 10, '2', '1993', 'tukhoa2', 'nxb3'),"
                + "('4', 'sach4', 80, '3', '2000', 'tukhoa3', 'nxb4')";
        conn.UpdateData(sql);
    }
    
    public static void createTableChiTietSach(){
        conn.ConnectSQL();
        String sql = "create table ChiTietSach(" +
                    "MaSach nvarchar(30) foreign key references Sach(MaSach)," +
                    "MaCaBiet nvarchar(30) primary key," +
                    "TinhTrangSach nvarchar(30)," +
                    "TinhTrangPhucVu nvarchar(30)" +
                    ")";
        conn.UpdateData(sql);
        
        sql = "insert into ChiTietSach values('1', 'cb1', 'tinhtrangsach1', 'tinhtrangphucvu1'),"
                + "('2', 'cb2', 'tinhtrangsach2', 'tinhtrangphucvu2'),"
                + "('3', 'cb3', 'tinhtrangsach3', 'tinhtrangphucvu3'),"
                + "('4', 'cb4', 'tinhtrangsach4', 'tinhtrangphucvu4')";
        conn.UpdateData(sql);
    }
    
    public static void createTableSachTG(){
        conn.ConnectSQL();
        String sql = "create table SachTG(" +
                    "MaSach nvarchar(30) foreign key references Sach(MaSach)," +
                    "MaTG nvarchar(30) foreign key references TacGia(MaTacGia)" +
                    "constraint fk_SachTG_Sach primary key(MaSach)" +
                    ")";
        conn.UpdateData(sql);
        
        sql = "insert into SachTG values('1', '1'),"
                + "('2', '1'),"
                + "('3', '2'),"
                + "('4', '3')";
        conn.UpdateData(sql);
    }
    
    public static void createTableDocGia(){
        conn.ConnectSQL();
        String sql = "create table DocGia(" +
                    "SoThe nvarchar(30) primary key," +
                    "HoTen nvarchar(30)," +
                    "DVCT nvarchar(30)" +
                    ")";
        conn.UpdateData(sql);
        
        sql = "insert into DocGia values('1', 'hoten1', 'dv1'),"
                + "('2', 'hoten2', 'dv2'),"
                + "('3', 'hoten3', 'dv3'),"
                + "('4', 'hoten4', 'dv4')";
    }
    
    public static void createTableSachMuon(){
        conn.ConnectSQL();
        String sql = "create table SachMuon(" +
                    "SoThe nvarchar(30) foreign key references DocGia(SoThe)," +
                    "MaCaBiet nvarchar(30) foreign key references ChiTietSach(MaCaBiet)," +
                    "NgayMuon date," +
                    "NgayPhaiTra date," +
                    "NgayTra date," +
                    "constraint pk_SachMuon primary key(SoThe, MaCaBiet)" +
                    ")";
        conn.UpdateData(sql);
    }
    
    public static void getSachs(){
        conn.ConnectSQL();
        String sql = "select * from Sach";
        ResultSet data = conn.LoadData(sql);
        try {
            while(data.next()){
                System.out.print(data.getString(1)+ " ");
                System.out.print(data.getString(2)+ " ");
                System.out.print(data.getString(3)+ " ");
                System.out.print(data.getString(4)+ " ");
                System.out.print(data.getString(5)+ " ");
                System.out.print(data.getString(6)+ " ");
                System.out.print(data.getString(7)+ " ");
                System.out.println("\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void main(String[] args) {
        createTableTacGia();
        createTableSach();
        createTableChiTietSach();
        createTableSachTG();
        createTableDocGia();
        createTableSachMuon();
        getSachs();
    }
}

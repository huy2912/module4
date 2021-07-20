/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai5;

/**
 *
 * @author binhb
 */
public class InitDB {
    static Connect conn = new Connect();
    public static void createTableSinhVien(){
        conn.ConnectSQL();
        String sql = "create table SinhVien("
                + "MaSV int primary key,"
                + "HoTen nvarchar(30),"
                + "DiaChi nvarchar(30),"
                + "Lop nvarchar(10)"
                + ")";
        conn.UpdateData(sql);
    }
    
    public static void createTableHocVi(){
        conn.ConnectSQL();
        String sql = "create table HocVi("
                + "MaHV int primary key,"
                + "TenHV nvarchar(30)"
                + ")";
        conn.UpdateData(sql);
        sql = "insert into HocVi values(1, 'Thac si'),(2, 'Pho giao su'), (3, 'Giao su')";
        conn.InsertData(sql);
    }
    
    public static void createTableGiaoVien(){
        conn.ConnectSQL();
        String sql = "create table GiaoVien("
                + "MaGV int primary key,"
                + "HoTen nvarchar(30),"
                + "DiaChi nvarchar(30),"
                + "MaHV int foreign key references HocVi(MaHV)"
                + ")";
        conn.UpdateData(sql);
    }
    
    public static void createTableDeTai(){
        conn.ConnectSQL();
        String sql = "create table DeTai("
                + "MaDT int primary key,"
                + "TenDT nvarchar(30)"
                + ")";
        conn.UpdateData(sql);
    }
    
    public static void createTableSinhVien_DeTai(){
        conn.ConnectSQL();
        String sql = "create table SinhVien_DeTai(" +
                    "MaSV int foreign key references SinhVien(MaSV)," +
                    "MaDT int foreign key references DeTai(MaDT)," +
                    "constraint sv_dt primary key(MaSV, MaDT)" +
                    ")";
        conn.UpdateData(sql);
    }
    
    public static void createTableGiaoVien_DeTai(){
        conn.ConnectSQL();
        String sql = "create table GiaoVien_DeTai(" +
                    "MaGV int foreign key references GiaoVien(MaGV)," +
                    "MaDT int foreign key references DeTai(MaDT)," +
                    "constraint gv_dt primary key(MaGV, MaDT)" +
                    ")";
        conn.UpdateData(sql);
    }
    
    public static void createTableKetQua(){
        conn.ConnectSQL();
        String sql = "create table KetQua(" +
                    "MaSV int foreign key references SinhVien(MaSV)," +
                    "MaDT int foreign key references DeTai(MaDT)," +
                    "Diem int," +
                    "constraint kq primary key(MaSV, MaDT)" +
                    ")";
        conn.UpdateData(sql);
    }
    
    public static void main(String[] args) {
        createTableSinhVien();
        createTableHocVi();
        createTableGiaoVien();
        createTableDeTai();
        createTableSinhVien_DeTai();
        createTableGiaoVien_DeTai();
        createTableKetQua();
    }
}

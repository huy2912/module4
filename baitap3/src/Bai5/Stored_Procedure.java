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
public class Stored_Procedure {
    static Connect conn = new Connect();
    
    public static void cauA(){
        conn.ConnectSQL();
        String sql = "create proc getDetail_Detai @mdt nvarchar(30)" +
                    " as " +
                    "select SinhVien.HoTen, TenDT, GiaoVien.HoTen from SinhVien " +
                    " inner join SinhVien_DeTai on SinhVien.MaSV = SinhVien_DeTai.MaSV " +
                    " inner join GiaoVien_DeTai on GiaoVien_DeTai.MaDT = SinhVien_DeTai.MaDT " +
                    " inner join GiaoVien on GiaoVien.MaGV = GiaoVien_DeTai.MaGV " +
                    " inner join DeTai on DeTai.MaDT = SinhVien_DeTai.MaDT " +
                    " where DeTai.MaDT = @mdt";
        conn.UpdateData(sql);
    }
    public static void cauB(){
        conn.ConnectSQL();
        String sql = "create proc cauB @diem int " +
                    " as " +
                    " select HoTen, MaDT, Diem from SinhVien inner join KetQua on SinhVien.MaSV = KetQua.MaSV " +
                    " where Diem > @diem";
        conn.UpdateData(sql);
    }
    public static void cauC(){
        conn.ConnectSQL();
        String sql = "create proc cauC @mgv int " +
                    " as " +
                    " select GiaoVien.MaGV, count(*) as slDT from GiaoVien inner join GiaoVien_DeTai on GiaoVien.MaGV = GiaoVien_DeTai.MaGV " +
                    "	where GiaoVien.MaGV = @mgv " +
                    "	group by GiaoVien.MaGV";
        conn.UpdateData(sql);
    }
    public static void cauD(){
        conn.ConnectSQL();
        String sql = "create proc cauD @mdt nvarchar(10) " +
                    " as " +
                    " select MaDT, count(*) as slSV from KetQua " +
                    " where MaDT = @mdt " +
                    " group by MaDT";
        conn.UpdateData(sql);
    }
    
    public static void cauE(){
        conn.ConnectSQL();
        String sql = "create proc cauE " +
            " as " +
            " begin " +
            " alter table KetQua " +
            " add XepLoai nvarchar(30) " +
            " update KetQua " +
            " set XepLoai = case Diem " +
            " when 1 then 'Yeu'" +
            " when 2 then 'Yeu' " +
            " when 3 then 'Yeu' " +
            " when 4 then 'Yeu' " +
            " when 5 then 'Yeu' " +
            " when 6 then 'Trung binh' " +
            " when 7 then 'Trung binh' " +
            " when 8 then 'Kha' " +
            " when 9 then 'Gioi' " +
            " when 10 then 'Gioi' " +
            " else null end " +
            " end";
        conn.UpdateData(sql);
    }
    
    public static void main(String[] args) {
        cauA();
        cauB();
        cauC();
        cauD();
        cauE();
    }
}

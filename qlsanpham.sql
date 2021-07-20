create database qlsanpham
go
use qlsanpham
go

create table LoaiSanPham(
	MaLoaiSP int primary key,
	TenLoaiSP nvarchar(30)
)

create table SanPham(
	MaSP int primary key,
	TenSP nvarchar(30),
	NhaSanXuat nvarchar(30),
	MaLoaiSP int foreign key references LoaiSanPham(MaLoaiSP)
)
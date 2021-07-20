create database qldt
go
use qldt
go


create table SinhVien(
	MaSV int primary key,
	HoTen nvarchar(30),
	DiaChi nvarchar(30),
	Lop nvarchar(10)
)

create table HocVi(
	MaHV int primary key,
	TenHV nvarchar(30)
)

create table DeTai(
	MaDT int primary key,
	TenDT nvarchar(30)
)

create table SinhVien_DeTai(
	MaSV int foreign key references SinhVien(MaSV),
	MaDT int foreign key references DeTai(MaDT),
	constraint sv_dt primary key(MaSV, MaDT)
)

create table GiaoVien(
	MaGV int primary key,
	HoTen nvarchar(30),
	DiaChi nvarchar(30),
	MaHV int foreign key references HocVi(MaHV)
)

create table GiaoVien_DeTai(
	MaGV int foreign key references GiaoVien(MaGV),
	MaDT int foreign key references DeTai(MaDT),
	constraint gv_dt primary key(MaGV, MaDT)
)

create table KetQua(
	MaSV int foreign key references SinhVien(MaSV),
	MaDT int foreign key references DeTai(MaDT),
	Diem int,
	constraint kq primary key(MaSV, MaDT)
)



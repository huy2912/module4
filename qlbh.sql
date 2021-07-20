create database qlbh
go
use qlbh
go

create table NhanVien(
	manv int primary key,
	hoTen nvarchar(30),
	birth nvarchar(20),
	diaChi nvarchar(50),
	sdt nvarchar(10),
	sex nvarchar(10)
)

create table SanPham(
	masp int primary key,
	tensp nvarchar(30),
	gia int
)

create table HoaDon(
	mahd int primary key,
	manv int foreign key references NhanVien(manv),
	loaihd nvarchar(10),
	ngayLap nvarchar(20),
	ngayGiaoNhan nvarchar(20)
)


create table ChiTietHoaDon(
	macthd int primary key,
	mahd int foreign key references HoaDon(mahd),
	masp int foreign key references SanPham(masp),
	sl int,
	gia int
)


insert into NhanVien values(1, 'nhanvien1', '1/1/2000', 'dia chi 1', '12345678', 'nam'),
							(2, 'nhanvien2', '12/10/2003', 'dia chi 2', '12345678', 'nam'),
							(3, 'nhanvien3', '2/1/2001', 'dia chi 3', '12345678', 'nu')

insert into ChiTietHoaDon values(1, 1, 1, 10, 100),
								(2, 1, 21, 10, 100),
								(3, 1, 1, 20, 200),
								(4, 2, 21, 10, 100)
select * from SanPham
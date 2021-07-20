create database qlsach
go
use qlsach
go


create table TacGia(
	MaTacGia nvarchar(30) primary key,
	TenTacGia nvarchar(30),
	DCLienHe nvarchar(30)
)

create table Sach(
	MaSach nvarchar(30) primary key,
	TuSach nvarchar(30),
	SoTrang int,
	MaTG nvarchar(30) foreign key references TacGia(MaTacGia),
	NamXB int,
	TuKhoa nvarchar(30),
	NXB nvarchar(30)
)

create table ChiTietSach(
	MaSach nvarchar(30) foreign key references Sach(MaSach),
	MaCaBiet nvarchar(30) primary key,
	TinhTrangSach nvarchar(30),
	TinhTrangPhucVu nvarchar(30)
)

create table SachTG(
	MaSach nvarchar(30) foreign key references Sach(MaSach),
	MaTG nvarchar(30) foreign key references TacGia(MaTacGia)
	constraint fk_SachTG_Sach primary key(MaSach)
)


create table DocGia(
	SoThe nvarchar(30) primary key,
	HoTen nvarchar(30),
	DVCT nvarchar(30)
)

create table SachMuon(
	SoThe nvarchar(30) foreign key references DocGia(SoThe),
	MaCaBiet nvarchar(30) foreign key references ChiTietSach(MaCaBiet),
	NgayMuon date,
	NgayPhaiTra date,
	NgayTra date,
	constraint pk_SachMuon primary key(SoThe, MaCaBiet)
)


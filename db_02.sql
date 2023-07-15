create database HE_THONG_ORDER_DO_UONG_TAI_QUAY_01
go
use HE_THONG_ORDER_DO_UONG_TAI_QUAY_01
go
create table chucvu
(
	IDChucVu uniqueidentifier primary key default newid(),
	MaChucVu varchar(20),
	TenChucVu nvarchar(20)
)
go
create table ban
(
	IDBan uniqueidentifier primary key default newid(),
	MaBan varchar(20),
	TrangThaiBan int
)
go
create table voucher
(
	IDVoucher uniqueidentifier primary key default newid(),
	MaVoucher varchar(20),
	NgayTao date,
	NgayHetHan date,
	NoiDungVoucher nvarchar(100),
	TrangThaiVoucher int,
	DieuKienApDung nvarchar(50)
)
go
create table mon
(
	IDMon uniqueidentifier primary key default newid(),
	MaMon varchar(20),
	TenMon nvarchar(30)
)
go
create table loai
(
	IDLoai uniqueidentifier primary key default newid(),
	MaLoai varchar(20),
	TenLoai nvarchar(50)
)
go
create table nhanVien
(
	IDNhanVien uniqueidentifier primary key default newid(),
	MaNhanVien varchar(20),
	Ho nvarchar(50),
	TenDem nvarchar(50),
	Ten nvarchar(50),
	NgaySinh date,
	GioiTinh nvarchar(20),
	SĐT varchar(20),
	DiaChi nvarchar(50),
	TrangThai int,
	IDChucVu uniqueidentifier,
	constraint FKChucVu foreign key(IDChucVu) references chucvu(IDChucVu)
)
go
create table monChiTiet
(
	IDMonChiTiet uniqueidentifier primary key default newid(),
	TrangThai int,
	Gia money,
	IDMon uniqueidentifier,
	IDLoai uniqueidentifier,
	constraint FKMon foreign key(IDMon) references mon(IDMon),
	constraint FKLoai foreign key(IDLoai) references loai(IDLoai)
)
go
create table hoaDon
(
	IDHoaDon uniqueidentifier primary key default newid(),
	MaHoaDon varchar(5),
	ThanhTien money,
	TienGiam money,
	ThoiGian date,
	TrangThai int,
	IDBan uniqueidentifier,
	IDNhanVien uniqueidentifier,
	constraint FKBan foreign key(IDBan) references ban(IDBan),
	constraint FKNhanVien foreign key(IDNhanVien) references nhanVien(IDNhanVien)
)
go
create table hoaDon_voucher
(
	IDHoaDon uniqueidentifier,
	IDVoucher uniqueidentifier,
	constraint PKHoadon_voucher primary key(IDHoaDon,IDVoucher),
	constraint FKHoaDon foreign key(IDHoaDon) references hoaDon(IDHoaDon),
	constraint FKVouvher foreign key(IDVoucher) references voucher(IDVoucher)
)
go
create table hoaDonChiTiet
(
	IDHoaDonChiTiet uniqueidentifier primary key default newid(),
	GiaTien money,
	SoLuong int,
	MoTa nvarchar(100),
	TrangThai int,
	IDMonChiTiet uniqueidentifier,
	IDHoaDon uniqueidentifier,
	constraint FKMonChiTiet foreign key(IDMonChiTiet) references monChiTiet(IDMonChiTiet),
	constraint FKHoaDon_HoaDonChiTiet foreign key(IDHoaDon) references hoaDon(IDHoaDon)
)
go

select IDHoaDon,ThoiGian,MaBan from hoaDon join ban on hoaDon.IDBan = ban.IDBan
go

select TenMon,IDMonChiTiet into TenMonMoi from monChiTiet join mon on monChiTiet.IDMon=mon.IDMon
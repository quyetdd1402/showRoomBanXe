USE [master]
GO
/****** Object:  Database [DUAN1]    Script Date: 05/12/2022 2:34:36 CH ******/
CREATE DATABASE [DUAN1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DUAN1', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\DUAN1.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DUAN1_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\DUAN1_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [DUAN1] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DUAN1].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DUAN1] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DUAN1] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DUAN1] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DUAN1] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DUAN1] SET ARITHABORT OFF 
GO
ALTER DATABASE [DUAN1] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DUAN1] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DUAN1] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DUAN1] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DUAN1] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DUAN1] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DUAN1] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DUAN1] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DUAN1] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DUAN1] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DUAN1] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DUAN1] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DUAN1] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DUAN1] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DUAN1] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DUAN1] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DUAN1] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DUAN1] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DUAN1] SET  MULTI_USER 
GO
ALTER DATABASE [DUAN1] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DUAN1] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DUAN1] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DUAN1] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DUAN1] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DUAN1] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [DUAN1] SET QUERY_STORE = OFF
GO
USE [DUAN1]
GO
/****** Object:  Table [dbo].[CHITIETSP]    Script Date: 05/12/2022 2:34:37 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHITIETSP](
	[id] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
	[idSP] [uniqueidentifier] NULL,
	[HangSP] [nvarchar](50) NULL,
	[KieuDang] [nvarchar](50) NULL,
	[MauSac] [nvarchar](50) NULL,
	[NhienLieu] [nvarchar](50) NULL,
	[DongXe] [nvarchar](50) NULL,
	[HopSo] [nvarchar](50) NULL,
	[DongCo] [nvarchar](50) NULL,
	[ChoNgoi] [nvarchar](50) NULL,
	[PhanKhuc] [nvarchar](50) NULL,
	[XuatXu] [nvarchar](50) NULL,
	[NamSX] [int] NULL,
	[SoLuongTon] [int] NULL,
	[GiaBan] [decimal](18, 0) NULL,
	[MoTa] [nvarchar](50) NULL,
	[trangThai] [int] NULL,
 CONSTRAINT [PK_CHITIETSP] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DICHVU]    Script Date: 05/12/2022 2:34:37 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DICHVU](
	[id] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
	[idNhanVien] [uniqueidentifier] NULL,
	[idKhachHang] [uniqueidentifier] NULL,
	[idHoaDon] [uniqueidentifier] NULL,
	[baoHiem] [int] NULL,
	[lamBien] [int] NULL,
 CONSTRAINT [PK_DICHVU] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HINHTHUCTT]    Script Date: 05/12/2022 2:34:37 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HINHTHUCTT](
	[id] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
	[ma] [nvarchar](10) NULL,
	[ten] [nvarchar](50) NULL,
	[trangThai] [int] NULL,
 CONSTRAINT [PK_HINHTHUCTT] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOADON]    Script Date: 05/12/2022 2:34:37 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADON](
	[id] [uniqueidentifier] NOT NULL,
	[idNhanVien] [uniqueidentifier] ROWGUIDCOL  NULL,
	[idHTTT] [uniqueidentifier] NULL,
	[idKhachHang] [uniqueidentifier] NULL,
	[maNV] [nvarchar](50) NULL,
	[tenNV] [nvarchar](50) NULL,
	[maHD] [nvarchar](20) NULL,
	[maSp] [nvarchar](50) NULL,
	[tenXe] [nvarchar](50) NULL,
	[soLuong] [int] NULL,
	[donGia] [decimal](25, 0) NULL,
	[tenKH] [nvarchar](50) NULL,
	[soTienGiam] [decimal](20, 0) NULL,
	[tongTien] [decimal](25, 0) NULL,
	[khachTra] [decimal](25, 0) NULL,
	[ngayTao] [date] NULL,
	[ngayThanhToan] [date] NULL,
	[SĐTNguoiNhan] [nvarchar](10) NULL,
	[diaChi] [nvarchar](50) NULL,
	[trangThai] [int] NULL,
	[note] [nvarchar](100) NULL,
 CONSTRAINT [PK_HOPDONGCT] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOADONCT]    Script Date: 05/12/2022 2:34:37 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADONCT](
	[id] [uniqueidentifier] NOT NULL,
	[idCTSanPham] [uniqueidentifier] NULL,
	[idHoaDon] [uniqueidentifier] NULL,
	[maSp] [nvarchar](50) NULL,
	[tenSp] [nvarchar](50) NULL,
	[donGia] [decimal](18, 0) NULL,
	[soLuong] [int] NULL,
	[tienThua] [decimal](18, 0) NULL,
	[trangThai] [int] NULL,
 CONSTRAINT [PK_HOADONCT] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHACHHANG]    Script Date: 05/12/2022 2:34:37 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHACHHANG](
	[id] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
	[maKH] [nvarchar](10) NULL,
	[hoTenKH] [nvarchar](50) NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [bit] NULL,
	[SĐT] [nvarchar](11) NULL,
	[diaChi] [nvarchar](50) NULL,
	[quocGia] [nvarchar](15) NULL,
	[trangThai] [int] NULL,
 CONSTRAINT [PK_KHACHHANG] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHUYENMAI]    Script Date: 05/12/2022 2:34:37 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHUYENMAI](
	[id] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
	[ma] [nvarchar](5) NULL,
	[ten] [nvarchar](10) NULL,
	[giamGia] [int] NULL,
	[ngayBD] [date] NULL,
	[ngayKT] [date] NULL,
	[trangThai] [bit] NULL,
 CONSTRAINT [PK_VOUCHER] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHANVIEN]    Script Date: 05/12/2022 2:34:37 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHANVIEN](
	[id] [uniqueidentifier] NOT NULL,
	[maNV] [nvarchar](10) NULL,
	[hoTenNv] [nvarchar](50) NULL,
	[vaiTro] [int] NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [bit] NULL,
	[SĐT] [nvarchar](10) NULL,
	[email] [nvarchar](50) NULL,
	[diaChi] [nvarchar](50) NULL,
	[anh] [nvarchar](50) NULL,
	[luong] [nvarchar](50) NULL,
	[trangThai] [int] NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SANPHAM]    Script Date: 05/12/2022 2:34:37 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SANPHAM](
	[id] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
	[ma] [nvarchar](5) NULL,
	[ten] [nvarchar](50) NULL,
	[anh] [nvarchar](50) NULL,
 CONSTRAINT [PK_XECHOTHUE] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SPKHUYENMAI]    Script Date: 05/12/2022 2:34:37 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SPKHUYENMAI](
	[id] [uniqueidentifier] NOT NULL,
	[idSanPham] [uniqueidentifier] NOT NULL,
	[idVoucher] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
	[donGia] [decimal](20, 0) NULL,
	[soTienConLai] [decimal](20, 0) NULL,
	[trangThai] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[USERNAME]    Script Date: 05/12/2022 2:34:37 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USERNAME](
	[id] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
	[userName] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[comfirmPassword] [nvarchar](50) NULL,
	[vaiTro] [int] NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'a82a3f56-8cd0-4e6c-bfb9-14a9b7f389b3', N'0b9e8a3e-8920-409e-875f-10e2e494551a', N'Camry', N'Xe đa dụng', N'Xanh', N'Xăng', N'SA', N'Hộp số tự động', N'Động cơ điện', N'2 chỗ', N'Hạng A', N'Mĩ', 2019, 2, CAST(2500000000 AS Decimal(18, 0)), N'New 100%', 1)
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'e2db8dd9-4cf1-4274-8675-1a845ea630a1', N'e89d3bd3-0aa9-4b02-93c3-b9c5685f8ca9', N'HonDa  ', N'Xe thể thao', N'Đỏ', N'Xăng ', N'City', N'Hộp số tự động', N'Động cơ điện', N'5 chỗ', N'Hạng M', N'Mĩ', 2023, 4, CAST(600000000 AS Decimal(18, 0)), N'New 100%', 1)
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'02ec5df7-02b0-4652-a975-1b4f319e62eb', N'e103c027-7ee4-46f8-a357-5852116c5501', N'Toyota', N'Xe đa dụng', N'Vàng', N'Xăng', N'Vios', N'Hộp số tự động', N'Động cơ xăng', N'4 chỗ', N'Hạng A', N'Việt Nam', 2022, 5, CAST(545000000 AS Decimal(18, 0)), N'New 100%', 1)
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'30da15fe-ecd7-4e15-af1c-2a68195b9ea8', N'e79dfcc2-f163-4e46-af89-86ac744edf76', N'Hyundai', N'Xe thể thao', N'Tím', N'Xăng', N'SeDan', N'Hộp số sàn', N'Hộp số tự động', N'6 chỗ', N'Hạng M', N'Hàn Quốc', 2021, 7, CAST(200000000 AS Decimal(18, 0)), N'New 100%', 1)
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'9924444e-c2f4-4a26-b239-2e61869edc44', N'e89d3bd3-0aa9-4b02-93c3-b9c5685f8ca9', N'Madza', N'Xe đa dụng', N'Đỏ', N'Xăng', N'SA', N'Hộp số tự động', N'Động cơ xăng', N'4 chỗ', N'Hạng A', N'Việt Nam', 2020, 3, CAST(950000000 AS Decimal(18, 0)), N'New 100%', 1)
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'a71810e0-f5f9-4452-b396-41c59e5209fa', N'6511c24d-061b-4d99-bfa2-c3b0c9ef8a3e', N'Lexus', N'Xe thể thao', N'Trắng - Đen', N'Xăng', N'ES250', N'Hộ số tự động', N'Động cơ xăng', N'5 chỗ', N'Hạng A', N'Mĩ', 2022, 2, CAST(2550000000 AS Decimal(18, 0)), N'New 100%', 1)
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'bee94b5b-5837-4a46-9927-432b53701f9f', N'e79dfcc2-f163-4e46-af89-86ac744edf76', N'Toyota', N'Xe bán tải', N'Vàng', N'Điện', N'SUV', N'Hộp số sàn', N'Động cơ điện', N'2 chỗ', N'Hạng A', N'Mĩ', 2022, 3, CAST(850000000 AS Decimal(18, 0)), N'New 100%', 1)
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'de362b2e-d80c-450c-aa50-8e03e3ff4af1', N'76ff9ebc-f1a2-4f00-a1aa-fe4197c6ee8b', N'Porsche', N'Xe thể thao', N'Trắng', N'Xăng', N'V5', N'Hộ số tự động', N'Động cơ xăng', N'5 chỗ', N'Hạng A', N'Úc', 2021, 3, CAST(4650000000 AS Decimal(18, 0)), N'New 100%', 1)
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'9bbaf029-ee51-473e-b280-b1cf5bdd3f2e', N'0b9e8a3e-8920-409e-875f-10e2e494551a', N'Lambo', N'Xe mui trần', N'Xanh', N'Xăng ', N'V6', N'Hộp số sàn', N'Động cơ xăng', N'5 chỗ', N'Hạng A', N'Việt Nam', 2023, 2, CAST(16500000000 AS Decimal(18, 0)), N'New 100%', 1)
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'9ec07b72-3104-4dd8-98b3-b5179afefbca', N'99ec6793-d597-4742-88a8-e756b0962891', N'Ford', N'Xe đa dụng', N'Cam', N'Xăng', N'Territory', N'Hộp số tự động', N'Động cơ xăng', N'5 chỗ', N'Hạng M', N'Việt Nam', 2022, 2, CAST(2500000000 AS Decimal(18, 0)), N'New 100%', 1)
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'72312056-538c-4b83-b1d5-bee33d6b5353', N'709f0874-26ec-451d-b041-5178bf650933', N'Vinfast', N'Xe đa dụng', N'Trắng', N'Điện', N'FV5 ', N'Hộp số tự động', N'Động cơ điện', N'7 chỗ', N'Hạng M', N'Việt Nam', 2022, 4, CAST(780000000 AS Decimal(18, 0)), N'New 100%', 1)
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'fa129196-e168-4e7c-a6ff-d43d827045af', N'0b9e8a3e-8920-409e-875f-10e2e494551a', N'KIA', N'Xe đa dụng', N'Đỏ', N'Xăng', N'Carens', N'Hộp số tự động', N'Động cơ xăng', N'5 chỗ', N'Hạng M', N'Úc', 2021, 3, CAST(950000000 AS Decimal(18, 0)), N'New 100%', 1)
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'd7162fa1-2558-446e-b9f5-e1e37ca5d13d', N'76ff9ebc-f1a2-4f00-a1aa-fe4197c6ee8b', N'HonDa  ', N'Xe thể thao', N'Trắng', N'Điện', N'City', N'Hộp số tự động', N'Động cơ điện', N'6 chỗ', N'Hạng M', N'Úc', 2021, 3, CAST(720000000 AS Decimal(18, 0)), N'New 100%', 1)
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'2faabe25-3b7a-4eac-9d5d-fcafcf38be3d', N'6511c24d-061b-4d99-bfa2-c3b0c9ef8a3e', N'Hyundai', N'Xe thể thao', N'Xanh', N'Điện', N'MPV', N'Hộp số sàn', N'Động cơ điện', N'5 chỗ', N'Hạng E', N'Úc', 2021, 5, CAST(720000000 AS Decimal(18, 0)), N'New 100%', 1)
GO
INSERT [dbo].[DICHVU] ([id], [idNhanVien], [idKhachHang], [idHoaDon], [baoHiem], [lamBien]) VALUES (N'fd6e04fe-5814-4b3b-aa41-00ce816f202f', N'af24dc07-d392-4514-8ec1-0127593b1374', N'8edc5acd-dd0f-4e7e-8502-a0e80c08f0bd', N'b19ff789-13e9-4e43-9201-65910daa815f', 1, 1)
INSERT [dbo].[DICHVU] ([id], [idNhanVien], [idKhachHang], [idHoaDon], [baoHiem], [lamBien]) VALUES (N'3b37b93b-0352-4d1c-8de1-5e622e0000f0', N'0d3c9509-9906-4100-94cf-2d2b254239f9', N'000966a8-ae31-4568-b2db-32934155b2ad', N'012bdd77-e258-455b-8711-e6264702fb2c', 1, 1)
INSERT [dbo].[DICHVU] ([id], [idNhanVien], [idKhachHang], [idHoaDon], [baoHiem], [lamBien]) VALUES (N'ab96263b-616c-4c2f-b739-5f811c40a243', N'af24dc07-d392-4514-8ec1-0127593b1374', N'93a82d13-0271-43fc-a9da-1cd216727599', N'78329df0-4c57-469e-8f43-547ebf1ff0fc', 1, 1)
INSERT [dbo].[DICHVU] ([id], [idNhanVien], [idKhachHang], [idHoaDon], [baoHiem], [lamBien]) VALUES (N'b0c7340d-0a47-4c68-8e95-88fe7724a005', N'0647f1a9-c4d0-4fb1-a0bb-090a96673e69', N'1ab1900f-bb7d-44b6-898f-1dcad47e6ac9', N'b19ff789-13e9-4e43-9201-65910daa815f', 1, 1)
INSERT [dbo].[DICHVU] ([id], [idNhanVien], [idKhachHang], [idHoaDon], [baoHiem], [lamBien]) VALUES (N'91e64a7e-cdf8-41fa-9715-bb361c937c42', N'fd6e04fe-5814-4b3b-aa41-00ce816f202f', N'fd6e04fe-5814-4b3b-aa41-00ce816f202f', N'f3973995-6781-43ed-9c35-288b9e73658e', 1, 1)
INSERT [dbo].[DICHVU] ([id], [idNhanVien], [idKhachHang], [idHoaDon], [baoHiem], [lamBien]) VALUES (N'e27e1e5c-6747-469b-b0e7-defe9b478bb8', N'fd4d696e-c3e6-4b95-a256-0d0361e16ce9', N'd971b12f-3c90-4581-900d-2052d3f51a67', N'fe5fb04f-6329-4659-8855-70d1f1341fdf', 1, 1)
GO
INSERT [dbo].[HINHTHUCTT] ([id], [ma], [ten], [trangThai]) VALUES (N'bd41a4d3-d9e3-465c-8539-1113b00f6f00', N'ma1', N'Online', 0)
INSERT [dbo].[HINHTHUCTT] ([id], [ma], [ten], [trangThai]) VALUES (N'a02cf4c6-a2be-42c7-b0ef-1a94c25ec39f', N'ma4', N'Offline', 0)
INSERT [dbo].[HINHTHUCTT] ([id], [ma], [ten], [trangThai]) VALUES (N'bc4a7d2d-0018-406e-9622-9b2abdef9e5b', N'ma3', N'Offline', 1)
INSERT [dbo].[HINHTHUCTT] ([id], [ma], [ten], [trangThai]) VALUES (N'b750a0e9-0711-4618-a161-af57031bf728', N'ma2', N'Online', 1)
GO
INSERT [dbo].[HOADON] ([id], [idNhanVien], [idHTTT], [idKhachHang], [maNV], [tenNV], [maHD], [maSp], [tenXe], [soLuong], [donGia], [tenKH], [soTienGiam], [tongTien], [khachTra], [ngayTao], [ngayThanhToan], [SĐTNguoiNhan], [diaChi], [trangThai], [note]) VALUES (N'f3973995-6781-43ed-9c35-288b9e73658e', N'0647f1a9-c4d0-4fb1-a0bb-090a96673e69', N'a02cf4c6-a2be-42c7-b0ef-1a94c25ec39f', N'66a23ff1-112e-4fe8-8094-e7d542a545de', N'maNv15', N'Phạm Quỳnh Diễm', N'maHD6', N'ma6', N'HonDa City', 1, CAST(720000000 AS Decimal(25, 0)), N'Phạm Ngọc Hà', CAST(2000000 AS Decimal(20, 0)), CAST(728000000 AS Decimal(25, 0)), CAST(72000000 AS Decimal(25, 0)), CAST(N'2021-12-01' AS Date), CAST(N'2021-12-01' AS Date), N'0734832473', N'Hà Nội', 1, N'Không')
INSERT [dbo].[HOADON] ([id], [idNhanVien], [idHTTT], [idKhachHang], [maNV], [tenNV], [maHD], [maSp], [tenXe], [soLuong], [donGia], [tenKH], [soTienGiam], [tongTien], [khachTra], [ngayTao], [ngayThanhToan], [SĐTNguoiNhan], [diaChi], [trangThai], [note]) VALUES (N'78329df0-4c57-469e-8f43-547ebf1ff0fc', N'52de004d-54e4-49d2-9154-5348da560ad8', N'a02cf4c6-a2be-42c7-b0ef-1a94c25ec39f', N'3b0a214f-e4b4-477d-aade-4b3a66ed89b4', N'maKH7', N'Nguyễn Văn Minh', N'maHD2', N'ma1', N'KIA Carens', 1, CAST(950000000 AS Decimal(25, 0)), N'Trần Thị Xuân', CAST(5000000 AS Decimal(20, 0)), CAST(955000000 AS Decimal(25, 0)), CAST(950000000 AS Decimal(25, 0)), CAST(N'2022-09-03' AS Date), CAST(N'2022-09-03' AS Date), N'0343242434', N'Thái Bình', 1, N'Không')
INSERT [dbo].[HOADON] ([id], [idNhanVien], [idHTTT], [idKhachHang], [maNV], [tenNV], [maHD], [maSp], [tenXe], [soLuong], [donGia], [tenKH], [soTienGiam], [tongTien], [khachTra], [ngayTao], [ngayThanhToan], [SĐTNguoiNhan], [diaChi], [trangThai], [note]) VALUES (N'b19ff789-13e9-4e43-9201-65910daa815f', N'af24dc07-d392-4514-8ec1-0127593b1374', N'bc4a7d2d-0018-406e-9622-9b2abdef9e5b', N'000966a8-ae31-4568-b2db-32934155b2ad', N'maNv1', N'Phạm Khương Duy', N'maHD1', N'ma2', N'Lexus ES250', 1, CAST(1100000000 AS Decimal(25, 0)), N'Dũng', CAST(25000000 AS Decimal(20, 0)), CAST(1085000000 AS Decimal(25, 0)), CAST(1080000000 AS Decimal(25, 0)), CAST(N'2021-09-01' AS Date), CAST(N'2021-09-01' AS Date), N'0961745487', N'Hà Nội', 1, N'Không')
INSERT [dbo].[HOADON] ([id], [idNhanVien], [idHTTT], [idKhachHang], [maNV], [tenNV], [maHD], [maSp], [tenXe], [soLuong], [donGia], [tenKH], [soTienGiam], [tongTien], [khachTra], [ngayTao], [ngayThanhToan], [SĐTNguoiNhan], [diaChi], [trangThai], [note]) VALUES (N'fe5fb04f-6329-4659-8855-70d1f1341fdf', N'c5f34fd0-e440-4b67-a9c1-879e23ab3480', N'a02cf4c6-a2be-42c7-b0ef-1a94c25ec39f', N'83f54c1a-aa6d-4ced-b0ec-25ee402c6558', N'maNv13', N'Phạm Đặng Quỳnh Trang', N'maHD7', N'ma7', N'Toyota SUV', 1, CAST(850000000 AS Decimal(25, 0)), N'Phí Minh Châu', CAST(0 AS Decimal(20, 0)), CAST(860000000 AS Decimal(25, 0)), CAST(850000000 AS Decimal(25, 0)), CAST(N'2022-10-21' AS Date), CAST(N'2022-10-21' AS Date), N'0345823472', N'Thanh Hóa', 1, N'Không')
INSERT [dbo].[HOADON] ([id], [idNhanVien], [idHTTT], [idKhachHang], [maNV], [tenNV], [maHD], [maSp], [tenXe], [soLuong], [donGia], [tenKH], [soTienGiam], [tongTien], [khachTra], [ngayTao], [ngayThanhToan], [SĐTNguoiNhan], [diaChi], [trangThai], [note]) VALUES (N'bb1e6897-cf89-4da6-8d8b-82de1e7a60bc', N'24b9c5e6-bb50-4626-afd9-c42ab679bcf4', N'bc4a7d2d-0018-406e-9622-9b2abdef9e5b', N'b379287e-a625-47ba-8370-5d4ca14f32a5', N'maNv18', N'Nguyễn Văn Minh', N'maHD8', N'ma8', N'Porsche V5', 1, CAST(4650000000 AS Decimal(25, 0)), N'Chống Thiện Mỹ', CAST(50000000 AS Decimal(20, 0)), CAST(4610000000 AS Decimal(25, 0)), CAST(4600000000 AS Decimal(25, 0)), CAST(N'2020-10-22' AS Date), CAST(N'2020-10-23' AS Date), N'0348234236', N'Hà Nội', 1, N'Không')
INSERT [dbo].[HOADON] ([id], [idNhanVien], [idHTTT], [idKhachHang], [maNV], [tenNV], [maHD], [maSp], [tenXe], [soLuong], [donGia], [tenKH], [soTienGiam], [tongTien], [khachTra], [ngayTao], [ngayThanhToan], [SĐTNguoiNhan], [diaChi], [trangThai], [note]) VALUES (N'9d7c02fa-6c66-4b4a-bacb-8a5ca7b7221a', N'7a31470b-41ab-4ebf-a4c3-990e185dbab8', N'bc4a7d2d-0018-406e-9622-9b2abdef9e5b', N'e4122e2d-3a01-4800-8514-c8cb5a6e9151', N'maNv2', N'Nguyễn Minh Anh', N'maHD4', N'ma4', N'Lambo', 1, CAST(16500000000 AS Decimal(25, 0)), N'Quang Thị Hà Trang', CAST(50000000 AS Decimal(20, 0)), CAST(16460000000 AS Decimal(25, 0)), CAST(16450000000 AS Decimal(25, 0)), CAST(N'2022-10-11' AS Date), CAST(N'2022-10-15' AS Date), N'0348234324', N'Cần Thơ', 1, N'Không')
INSERT [dbo].[HOADON] ([id], [idNhanVien], [idHTTT], [idKhachHang], [maNV], [tenNV], [maHD], [maSp], [tenXe], [soLuong], [donGia], [tenKH], [soTienGiam], [tongTien], [khachTra], [ngayTao], [ngayThanhToan], [SĐTNguoiNhan], [diaChi], [trangThai], [note]) VALUES (N'e2b8138a-03e4-48a1-8dc2-a4461c7c0ada', N'0eff7975-9be1-445f-9ddc-f82c74e3443b', N'b750a0e9-0711-4618-a161-af57031bf728', N'df39f893-e994-47e2-929a-f9c2d20e3523', N'maNv12', N'Lưu Thị Huế', N'maHD5', N'ma5', N'Ford Territory', 1, CAST(2500000000 AS Decimal(25, 0)), N'Nguyễn Quang Huy', CAST(23000000 AS Decimal(20, 0)), CAST(2487000000 AS Decimal(25, 0)), CAST(2480000000 AS Decimal(25, 0)), CAST(N'2020-09-03' AS Date), CAST(N'2020-09-05' AS Date), N'0348343743', N'Hà Nội', 1, N'Không')
INSERT [dbo].[HOADON] ([id], [idNhanVien], [idHTTT], [idKhachHang], [maNV], [tenNV], [maHD], [maSp], [tenXe], [soLuong], [donGia], [tenKH], [soTienGiam], [tongTien], [khachTra], [ngayTao], [ngayThanhToan], [SĐTNguoiNhan], [diaChi], [trangThai], [note]) VALUES (N'012bdd77-e258-455b-8711-e6264702fb2c', N'fd6e04fe-5814-4b3b-aa41-00ce816f202f', N'bc4a7d2d-0018-406e-9622-9b2abdef9e5b', N'000966a8-ae31-4568-b2db-32934155b2ad', N'maNv5', N'Lê Nga Hằng', N'maHD3', N'ma3', N'Hyundai MPV', 1, CAST(720000000 AS Decimal(25, 0)), N'Nguyễn Thị Bích', CAST(5000000 AS Decimal(20, 0)), CAST(2110000000 AS Decimal(25, 0)), CAST(2110000000 AS Decimal(25, 0)), CAST(N'2022-10-11' AS Date), CAST(N'2022-10-11' AS Date), N'0373645238', N'TP.Hồ Chí Minh', 1, N'Không')
GO
INSERT [dbo].[HOADONCT] ([id], [idCTSanPham], [idHoaDon], [maSp], [tenSp], [donGia], [soLuong], [tienThua], [trangThai]) VALUES (N'6b93eeb7-4cfc-4da7-ac8b-0c40ed611831', N'fa129196-e168-4e7c-a6ff-d43d827045af', N'78329df0-4c57-469e-8f43-547ebf1ff0fc', N'ma3', N'KIA Carens', CAST(950000000 AS Decimal(18, 0)), 1, CAST(5000000 AS Decimal(18, 0)), 1)
INSERT [dbo].[HOADONCT] ([id], [idCTSanPham], [idHoaDon], [maSp], [tenSp], [donGia], [soLuong], [tienThua], [trangThai]) VALUES (N'594001d9-c179-4993-84e5-2c8cf7b0291a', N'2faabe25-3b7a-4eac-9d5d-fcafcf38be3d', N'012bdd77-e258-455b-8711-e6264702fb2c', N'ma1', N'Hyundai MVP', CAST(7200000000 AS Decimal(18, 0)), 1, CAST(30000000 AS Decimal(18, 0)), 1)
INSERT [dbo].[HOADONCT] ([id], [idCTSanPham], [idHoaDon], [maSp], [tenSp], [donGia], [soLuong], [tienThua], [trangThai]) VALUES (N'7783a867-eedd-4167-b348-447e117f9d9e', N'9ec07b72-3104-4dd8-98b3-b5179afefbca', N'e2b8138a-03e4-48a1-8dc2-a4461c7c0ada', N'ma8', N'Ford Territory', CAST(2500000000 AS Decimal(18, 0)), 1, CAST(3000000 AS Decimal(18, 0)), 1)
INSERT [dbo].[HOADONCT] ([id], [idCTSanPham], [idHoaDon], [maSp], [tenSp], [donGia], [soLuong], [tienThua], [trangThai]) VALUES (N'aa0aa4d4-168d-4b29-bc9d-5e600c4e3005', N'bee94b5b-5837-4a46-9927-432b53701f9f', N'fe5fb04f-6329-4659-8855-70d1f1341fdf', N'ma5', N'Toyota SUV', CAST(850000000 AS Decimal(18, 0)), 1, CAST(0 AS Decimal(18, 0)), 1)
INSERT [dbo].[HOADONCT] ([id], [idCTSanPham], [idHoaDon], [maSp], [tenSp], [donGia], [soLuong], [tienThua], [trangThai]) VALUES (N'15262e9b-e30f-486f-a25c-c8c262d6bd0b', N'9bbaf029-ee51-473e-b280-b1cf5bdd3f2e', N'9d7c02fa-6c66-4b4a-bacb-8a5ca7b7221a', N'ma7', N'Lambo V6', CAST(16500000000 AS Decimal(18, 0)), 1, CAST(0 AS Decimal(18, 0)), 1)
INSERT [dbo].[HOADONCT] ([id], [idCTSanPham], [idHoaDon], [maSp], [tenSp], [donGia], [soLuong], [tienThua], [trangThai]) VALUES (N'48a1202d-1735-40c2-ba40-cea2d6158ed7', N'a71810e0-f5f9-4452-b396-41c59e5209fa', N'b19ff789-13e9-4e43-9201-65910daa815f', N'ma4', N'Lexus ES250', CAST(1100000000 AS Decimal(18, 0)), 1, CAST(5000000 AS Decimal(18, 0)), 1)
INSERT [dbo].[HOADONCT] ([id], [idCTSanPham], [idHoaDon], [maSp], [tenSp], [donGia], [soLuong], [tienThua], [trangThai]) VALUES (N'416c0458-f7fd-461c-91ac-dbd30b04196d', N'de362b2e-d80c-450c-aa50-8e03e3ff4af1', N'bb1e6897-cf89-4da6-8d8b-82de1e7a60bc', N'ma6', N'Porsche V5', CAST(4650000000 AS Decimal(18, 0)), 1, CAST(0 AS Decimal(18, 0)), 1)
INSERT [dbo].[HOADONCT] ([id], [idCTSanPham], [idHoaDon], [maSp], [tenSp], [donGia], [soLuong], [tienThua], [trangThai]) VALUES (N'3ee027d0-b307-479b-979d-f2152696e2d0', N'd7162fa1-2558-446e-b9f5-e1e37ca5d13d', N'f3973995-6781-43ed-9c35-288b9e73658e', N'ma2', N'HonDa City', CAST(720000000 AS Decimal(18, 0)), 1, CAST(2000000 AS Decimal(18, 0)), 1)
GO
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'fd6e04fe-5814-4b3b-aa41-00ce816f202f', N'maKH16', N'Nguyễn Phương Quỳnh Chi', CAST(N'2003-10-17' AS Date), 0, N'0982541258', N'Hà Nội', N'Việt Nam', 0)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'93a82d13-0271-43fc-a9da-1cd216727599', N'maKH13', N'Quản Thu Hà', CAST(N'2003-06-04' AS Date), 0, N'0342572452', N'Thái Bình', N'Việt Nam', 1)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'1ab1900f-bb7d-44b6-898f-1dcad47e6ac9', N'maKH14', N'Hà Ngọc Bảo Lam', CAST(N'2007-08-12' AS Date), 0, N'0926745642', N'Cao Bằng', N'Việt Nam', 1)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'd971b12f-3c90-4581-900d-2052d3f51a67', N'maKH11', N'Trần Thị Sao Băng', CAST(N'2004-10-12' AS Date), 0, N'0934732462', N'Thái Bình', N'Việt Nam', 0)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'83f54c1a-aa6d-4ced-b0ec-25ee402c6558', N'maKH18', N'Phí Minh Châu', CAST(N'2004-08-02' AS Date), 0, N'0478562874', N'Phú Thọ', N'Việt Nam', 0)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'bf84a499-b15d-46eb-8fc6-2dbaef4a2d83', N'maKH3', N'Hà Thị Hạnh', CAST(N'2000-10-25' AS Date), 0, N'0648362634', N'Thái Bình', N'Việt Nam', 1)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'000966a8-ae31-4568-b2db-32934155b2ad', N'maKH1', N'Bùi Đăng Dũng', CAST(N'1999-09-11' AS Date), 1, N'0961745487', N'Hà Nội', N'Việt Nam', 1)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'3b0a214f-e4b4-477d-aade-4b3a66ed89b4', N'maKH7', N'Trần Thị Xuân', CAST(N'2003-10-10' AS Date), 0, N'0493473742', N'Bến Tre', N'Việt Nam', 0)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'3d6754a0-eb10-497e-9e2a-5447e8782646', N'maKH4', N'Nguyễn Thị Kim anh', CAST(N'2003-01-22' AS Date), 0, N'0987654218', N'Phú Thọ', N'Việt Nam', 0)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'b379287e-a625-47ba-8370-5d4ca14f32a5', N'maKH15', N'Chống Thiện Mỹ', CAST(N'2003-12-12' AS Date), 0, N'0613471373', N'Bắc Giang', N'Việt Nam', 1)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'e399ad5d-b7d9-4a00-ab76-6c825d21fba0', N'maKh12', N'Vương Hoàng Dương', CAST(N'2006-09-12' AS Date), 0, N'0967254524', N'Phú Thọ', N'Việt Nam', 1)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'23e1c29d-1e6f-4ac5-b737-927f6974f16a', N'maKh8', N'Nguyễn Thùy Trang', CAST(N'2002-04-12' AS Date), 0, N'0984652487', N'Hải Phòng', N'Việt Nam', 0)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'8edc5acd-dd0f-4e7e-8502-a0e80c08f0bd', N'maKH2', N'Bùi Hồng Bich', CAST(N'1998-01-15' AS Date), 0, N'0373645238', N'TP.Hồ Chí Minh', N'Việt Nam', 0)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'0e1170ad-7e8d-4dcb-af40-a45d943c1c1c', N'maKH17', N'Trần Thị Tú Đào', CAST(N'2003-06-02' AS Date), 0, N'0934542534', N'Quảng Ninh', N'Việt Nam', 0)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'307e0076-a14c-48e9-80eb-a7b7baa80e3d', N'maKH9', N'Nguyễn Phương Yến', CAST(N'2000-04-26' AS Date), 0, N'0348324743', N'TP.Hồ Chí Minh', N'Việt Nam', 1)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'e4122e2d-3a01-4800-8514-c8cb5a6e9151', N'maKH20', N'Quang Thị Hà Trang', CAST(N'2003-03-17' AS Date), 0, N'0976274824', N'Nghệ An', N'Việt Nam', 1)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'0b46e32f-fb9a-4e35-827b-ced1889cb0b1', N'maKH19', N'Phạm Khánh Linh', CAST(N'2003-12-02' AS Date), 0, N'0943784237', N'Thái Bình', N'Việt Nam', 1)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'66a23ff1-112e-4fe8-8094-e7d542a545de', N'maKH10 ', N'Phạm Ngọc Hà', CAST(N'2005-12-06' AS Date), 0, N'0952654122', N'Phú Thọ', N'Việt Nam', 1)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'6ecc9fc0-b840-4e0b-816a-f0277ce50651', N'mahH5', N'Nguyễn Phương Thanh', CAST(N'2004-09-02' AS Date), 0, N'0965267518', N'Hải Phòng', N'Việt Nam', 1)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'df39f893-e994-47e2-929a-f9c2d20e3523', N'maKH6', N'Nguyễn Quang Huy', CAST(N'2003-09-19' AS Date), 1, N'0982124581', N'Quảng Nam', N'Việt Nam', 0)
GO
INSERT [dbo].[KHUYENMAI] ([id], [ma], [ten], [giamGia], [ngayBD], [ngayKT], [trangThai]) VALUES (N'954fa502-b5a4-468b-9faa-18db32f6acee', N'ma6', N'ten6', 300000, CAST(N'2022-11-25' AS Date), CAST(N'2022-12-30' AS Date), 1)
INSERT [dbo].[KHUYENMAI] ([id], [ma], [ten], [giamGia], [ngayBD], [ngayKT], [trangThai]) VALUES (N'c850e5ae-e624-41ff-9088-32343be6b4a5', N'ma10', N'ten10', 450000, CAST(N'2022-11-25' AS Date), CAST(N'2022-12-31' AS Date), 1)
INSERT [dbo].[KHUYENMAI] ([id], [ma], [ten], [giamGia], [ngayBD], [ngayKT], [trangThai]) VALUES (N'e33f957c-1ed0-423c-83e3-7067824b398f', N'ma4', N'ten4', 300000, CAST(N'2022-11-25' AS Date), CAST(N'2022-04-20' AS Date), 1)
INSERT [dbo].[KHUYENMAI] ([id], [ma], [ten], [giamGia], [ngayBD], [ngayKT], [trangThai]) VALUES (N'3b28858b-5a62-4dfc-8cc7-886f1dc310a9', N'ma5', N'ten5', 100000, CAST(N'2022-11-25' AS Date), CAST(N'2022-06-30' AS Date), 0)
INSERT [dbo].[KHUYENMAI] ([id], [ma], [ten], [giamGia], [ngayBD], [ngayKT], [trangThai]) VALUES (N'0800b114-3df3-45b6-b40a-8f5462562edc', N'ma2', N'ten2', 200000, CAST(N'2022-12-02' AS Date), CAST(N'2022-12-25' AS Date), 0)
INSERT [dbo].[KHUYENMAI] ([id], [ma], [ten], [giamGia], [ngayBD], [ngayKT], [trangThai]) VALUES (N'6e99691e-972b-400b-8da3-91cdf876f611', N'ma1', N'ten1', 150000, CAST(N'2022-12-01' AS Date), CAST(N'2022-12-20' AS Date), 1)
INSERT [dbo].[KHUYENMAI] ([id], [ma], [ten], [giamGia], [ngayBD], [ngayKT], [trangThai]) VALUES (N'ea601333-44d9-4260-98b6-99637f2af251', N'ma3', N'ten3', 250000, CAST(N'2022-11-25' AS Date), CAST(N'2022-12-15' AS Date), 1)
INSERT [dbo].[KHUYENMAI] ([id], [ma], [ten], [giamGia], [ngayBD], [ngayKT], [trangThai]) VALUES (N'021286f0-c8eb-4202-9384-d06e98f1dbdf', N'ma7', N'ten7', 400000, CAST(N'2022-11-25' AS Date), CAST(N'2022-12-30' AS Date), 1)
INSERT [dbo].[KHUYENMAI] ([id], [ma], [ten], [giamGia], [ngayBD], [ngayKT], [trangThai]) VALUES (N'a3430302-b6fc-446c-a39a-e00cc6217cac', N'ma9', N'ten9', 420000, CAST(N'2022-11-25' AS Date), CAST(N'2022-12-31' AS Date), 1)
INSERT [dbo].[KHUYENMAI] ([id], [ma], [ten], [giamGia], [ngayBD], [ngayKT], [trangThai]) VALUES (N'f879c60d-3c38-45cf-83c3-e38d83b92dcf', N'ma8', N'ten8', 350000, CAST(N'2022-11-25' AS Date), CAST(N'2022-12-31' AS Date), 1)
GO
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'fd6e04fe-5814-4b3b-aa41-00ce816f202f', N'maNv9', N'Chống Thiện Mỹ', 0, CAST(N'2003-12-12' AS Date), 1, N'0938372422', N'myctph2222@fpt.edu.vn', N'Thái Bình', N'2.jpg', N'9', 0)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'af24dc07-d392-4514-8ec1-0127593b1374', N'maNv1', N'Phạm Khương Duy', 0, CAST(N'2003-07-22' AS Date), 0, N'0961745487', N'duypkph22349@fpt.edu.vn', N'Hà Nội', N'7.jpg', N'9', 0)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'0647f1a9-c4d0-4fb1-a0bb-090a96673e69', N'maNv15', N'Phạm Quỳnh Diễm', 1, CAST(N'2011-03-22' AS Date), 0, N'0429342743', N'diempd2323@fpt.edu.vn', N'Thái Bình', N'1.jpg', N'7', 1)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'fd4d696e-c3e6-4b95-a256-0d0361e16ce9', N'maNv7', N'Bùi Thị Hạnh', 0, CAST(N'2003-09-12' AS Date), 1, N'0743734843', N'hanhpt@fpt.edu.vn', N'Bắc Giang', N'3.jpg', N'9', 1)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'40fbae3a-22ec-4b9e-b7a4-0dfc02695ae8', N'maNv20', N'Minh Văn Hà', 1, CAST(N'2001-12-22' AS Date), 1, N'0348342743', N'havan@fpt.edu.vn', N'Hà Nội', N'4.jpg', N'7', 1)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'0d3c9509-9906-4100-94cf-2d2b254239f9', N'maNv6', N'Vũ Minh Hà', 1, CAST(N'2002-03-23' AS Date), 1, N'0483463463', N'minhpv@fpt.edu.vn', N'Nam Định', N'5.jpg', N'6', 0)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'37a92c43-6ccf-4757-9474-37da1b465a8b', N'maNv4', N'Lê Nga Hằng', 1, CAST(N'2001-01-01' AS Date), 1, N'0324834234', N'quanph22123@fpt.edu.vn', N'Thái Bình', N'6.jpg', N'7', 1)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'7d9d8c6c-95c5-40bb-b1d9-3be682ed8a36', N'MaNv2', N'Duy Phạm', 0, CAST(N'2022-01-01' AS Date), 1, N'0938372422', N'duy@fpt.edu.vn', N'Thái Bình', N'10.jpg', N'9', 0)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'e1499d87-1fd9-4de2-b789-3f84cf206c95', N'maNv5', N'Nguyễn Văn Minh', 1, CAST(N'2000-10-11' AS Date), 0, N'0671264648', N'dungpd22@fpt.edu.vn', N'Thái Nguyên', N'4.jpg', N'7', 1)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'52de004d-54e4-49d2-9154-5348da560ad8', N'maNv17', N'Trần Minh Hà', 1, CAST(N'2003-11-20' AS Date), 0, N'0342342343', N'haminhtran@gmail.com', N'Hà Nội', N'6.jpg', N'4', 1)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'9138935e-a3a8-4dc9-8562-700d9f284c08', N'maVn8 ', N'Nguyễn Ngọc Lan', 0, CAST(N'2004-09-09' AS Date), 0, N'0746674255', N'ngoclan@gmail.com', N'Cao Bằng', N'10.jpg', N'6', 0)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'c5f34fd0-e440-4b67-a9c1-879e23ab3480', N'maNv13', N'Phạm Đặng Quỳnh Trang', 1, CAST(N'2005-03-06' AS Date), 0, N'0964756242', N'quyTrang@gmail.com', N'Vinh', N'7.jpg', N'7', 0)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'f4bdd85b-eb43-4aee-ae73-932d8610be19', N'maNv11', N'Nguyễn Khánh Ly', 0, CAST(N'2005-08-01' AS Date), 0, N'0467256484', N'khly@gmail.com', N'Phú Thọ', N'5.jpg', N'8', 1)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'7a31470b-41ab-4ebf-a4c3-990e185dbab8', N'maNv10', N'Nguyễn Minh Anh', 1, CAST(N'2003-03-20' AS Date), 0, N'0349342427', N'anhmn@fpt.edu.vn', N'Hà Nội', N'2.jpg', N'8', 1)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'24b9c5e6-bb50-4626-afd9-c42ab679bcf4', N'maNv18', N'Nguyễn Văn Minh', 1, CAST(N'2003-09-02' AS Date), 1, N'0438437424', N'minhVan22@fpt.edu.vn', N'Hà Nội', N'10.jpg', N'4', 1)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'547ccf52-e570-4e6e-a8dd-d96435a9d6fc', N'maNv3', N'Phạm Văn Đức', 1, CAST(N'2004-12-05' AS Date), 1, N'0734636434', N'ducvp2323@fpt.edu.vn', N'Hà Nội', N'1.jpg', N'6', 1)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'a58a4c00-72b9-4d46-bb08-df153d10d416', N'manv14', N'Nguyễn Thị Nguyệt Hà', 1, CAST(N'2003-11-12' AS Date), 0, N'0267456453', N'nguyHa@gmail.com', N'Hà Nội', N'6.jpg', N'8', 0)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'0eff7975-9be1-445f-9ddc-f82c74e3443b', N'maNv12', N'Lưu Thị Huế', 0, CAST(N'2003-11-03' AS Date), 1, N'0549574544', N'dsaffjfh@fpt.edu.vn', N'Hà Nội', N'10.jpg', N'5', 1)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'a5619c4f-25e5-49e3-96f7-fcf90f18ddbc', N'maNv16', N'Nguyễn Thị Thúy Hằng', 1, CAST(N'2004-05-03' AS Date), 0, N'0874656733', N'nguyHang@gmail.com', N'Phú Thọ', N'5.jpg', N'9', 1)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'02bd60c3-1ab2-4eac-acdc-fdbf9b79bf9b', N'maNv19', N'Trần Thúy Linh', 0, CAST(N'2000-03-22' AS Date), 1, N'0348423744', N'linhthuytran@fpt.edu.vn', N'Hà Nội', N'1.jpg', N'1', 1)
GO
INSERT [dbo].[SANPHAM] ([id], [ma], [ten], [anh]) VALUES (N'0b9e8a3e-8920-409e-875f-10e2e494551a', N'ma1', N'Camry', N'Aston.jpg')
INSERT [dbo].[SANPHAM] ([id], [ma], [ten], [anh]) VALUES (N'709f0874-26ec-451d-b041-5178bf650933', N'ma4', N'Morning', N'Oto2.jpg')
INSERT [dbo].[SANPHAM] ([id], [ma], [ten], [anh]) VALUES (N'e103c027-7ee4-46f8-a357-5852116c5501', N'SP466', N'Buti', N'Bugatti.jpg')
INSERT [dbo].[SANPHAM] ([id], [ma], [ten], [anh]) VALUES (N'322439ef-2a7f-4d0c-accf-69cb8fffa3e3', N'SP54', N'Royll', N'Rolls.jpg')
INSERT [dbo].[SANPHAM] ([id], [ma], [ten], [anh]) VALUES (N'e79dfcc2-f163-4e46-af89-86ac744edf76', N'ma5', N'LS 500', N'lamborghini.jpg')
INSERT [dbo].[SANPHAM] ([id], [ma], [ten], [anh]) VALUES (N'e89d3bd3-0aa9-4b02-93c3-b9c5685f8ca9', N'ma2', N'HonDa City', N'Rolls.jpg')
INSERT [dbo].[SANPHAM] ([id], [ma], [ten], [anh]) VALUES (N'6511c24d-061b-4d99-bfa2-c3b0c9ef8a3e', N'SP153', N'Lambo', N'Oto2.jpg')
INSERT [dbo].[SANPHAM] ([id], [ma], [ten], [anh]) VALUES (N'99ec6793-d597-4742-88a8-e756b0962891', N'ma6', N'Ford Ranger', N'Aston.jpg')
INSERT [dbo].[SANPHAM] ([id], [ma], [ten], [anh]) VALUES (N'76ff9ebc-f1a2-4f00-a1aa-fe4197c6ee8b', N'ma3', N'Toyota Vios', N'Ferrari.jpg')
GO
INSERT [dbo].[USERNAME] ([id], [userName], [password], [email], [comfirmPassword], [vaiTro]) VALUES (N'79b41b65-1639-4edf-a342-22dbdd8c586e', N'a5', N'123', N'duypkph22349@fpt.edu.vn', N'123', 1)
INSERT [dbo].[USERNAME] ([id], [userName], [password], [email], [comfirmPassword], [vaiTro]) VALUES (N'9e7ccc4f-9d0e-4e68-b0ae-2c099f754158', N'a2', N'2', N'thinhndph22453@fpt.edu.vn', N'2', 0)
INSERT [dbo].[USERNAME] ([id], [userName], [password], [email], [comfirmPassword], [vaiTro]) VALUES (N'c1a549e2-1843-456f-a150-2d8ed1c661b2', N'a7', N'7', N'duypkph22349@fpt.edu.vn', N'7', 0)
INSERT [dbo].[USERNAME] ([id], [userName], [password], [email], [comfirmPassword], [vaiTro]) VALUES (N'85173d65-e6a1-40eb-9e66-3ff0dc88f974', N'a1', N'11', N'duypkph22349@fpt.edu.vn', N'1', 1)
GO
ALTER TABLE [dbo].[CHITIETSP] ADD  CONSTRAINT [DF_CHITIETSP_id]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[DICHVU] ADD  CONSTRAINT [DF_DICHVU_id]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[HINHTHUCTT] ADD  CONSTRAINT [DF_HINHTHUCTT_id]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[HOADON] ADD  CONSTRAINT [DF_HOPDONGCT_id]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[HOADONCT] ADD  CONSTRAINT [DF_HOADONCT_id]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[KHACHHANG] ADD  CONSTRAINT [DF_KHACHHANG_id]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[KHUYENMAI] ADD  CONSTRAINT [DF_VOUCHER_id]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[NHANVIEN] ADD  CONSTRAINT [DF_NhanVien_id]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[SANPHAM] ADD  CONSTRAINT [DF_XECHOTHUE_id]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[SPKHUYENMAI] ADD  CONSTRAINT [DF_SPKHUYENMAI_id]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[SPKHUYENMAI] ADD  CONSTRAINT [DF_SanPhamVoucher_idVoucher]  DEFAULT (newid()) FOR [idVoucher]
GO
ALTER TABLE [dbo].[USERNAME] ADD  CONSTRAINT [DF_TAIKHOAN_id]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[CHITIETSP]  WITH CHECK ADD  CONSTRAINT [FK_CHITIETSP_SANPHAM] FOREIGN KEY([idSP])
REFERENCES [dbo].[SANPHAM] ([id])
GO
ALTER TABLE [dbo].[CHITIETSP] CHECK CONSTRAINT [FK_CHITIETSP_SANPHAM]
GO
ALTER TABLE [dbo].[DICHVU]  WITH CHECK ADD  CONSTRAINT [FK_DICHVU_HOADON] FOREIGN KEY([idHoaDon])
REFERENCES [dbo].[HOADON] ([id])
GO
ALTER TABLE [dbo].[DICHVU] CHECK CONSTRAINT [FK_DICHVU_HOADON]
GO
ALTER TABLE [dbo].[DICHVU]  WITH CHECK ADD  CONSTRAINT [FK_DICHVU_KHACHHANG] FOREIGN KEY([idKhachHang])
REFERENCES [dbo].[KHACHHANG] ([id])
GO
ALTER TABLE [dbo].[DICHVU] CHECK CONSTRAINT [FK_DICHVU_KHACHHANG]
GO
ALTER TABLE [dbo].[DICHVU]  WITH CHECK ADD  CONSTRAINT [FK_DICHVU_NHANVIEN] FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[NHANVIEN] ([id])
GO
ALTER TABLE [dbo].[DICHVU] CHECK CONSTRAINT [FK_DICHVU_NHANVIEN]
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD  CONSTRAINT [FK_HOADON_HINHTHUCTT] FOREIGN KEY([idHTTT])
REFERENCES [dbo].[HINHTHUCTT] ([id])
GO
ALTER TABLE [dbo].[HOADON] CHECK CONSTRAINT [FK_HOADON_HINHTHUCTT]
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD  CONSTRAINT [FK_HOADON_NHANVIEN] FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[NHANVIEN] ([id])
GO
ALTER TABLE [dbo].[HOADON] CHECK CONSTRAINT [FK_HOADON_NHANVIEN]
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD  CONSTRAINT [FK_HOPDONG_KHACHHANG] FOREIGN KEY([idKhachHang])
REFERENCES [dbo].[KHACHHANG] ([id])
GO
ALTER TABLE [dbo].[HOADON] CHECK CONSTRAINT [FK_HOPDONG_KHACHHANG]
GO
ALTER TABLE [dbo].[HOADONCT]  WITH CHECK ADD  CONSTRAINT [FK_HOADONCT_CHITIETSP] FOREIGN KEY([idCTSanPham])
REFERENCES [dbo].[CHITIETSP] ([id])
GO
ALTER TABLE [dbo].[HOADONCT] CHECK CONSTRAINT [FK_HOADONCT_CHITIETSP]
GO
ALTER TABLE [dbo].[HOADONCT]  WITH CHECK ADD  CONSTRAINT [FK_HOADONCT_HOADON] FOREIGN KEY([idHoaDon])
REFERENCES [dbo].[HOADON] ([id])
GO
ALTER TABLE [dbo].[HOADONCT] CHECK CONSTRAINT [FK_HOADONCT_HOADON]
GO
ALTER TABLE [dbo].[SPKHUYENMAI]  WITH CHECK ADD  CONSTRAINT [FK_SPKHUYENMAI_KHUYENMAI] FOREIGN KEY([idVoucher])
REFERENCES [dbo].[KHUYENMAI] ([id])
GO
ALTER TABLE [dbo].[SPKHUYENMAI] CHECK CONSTRAINT [FK_SPKHUYENMAI_KHUYENMAI]
GO
ALTER TABLE [dbo].[SPKHUYENMAI]  WITH CHECK ADD  CONSTRAINT [FK_SPKHUYENMAI_SANPHAM] FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SANPHAM] ([id])
GO
ALTER TABLE [dbo].[SPKHUYENMAI] CHECK CONSTRAINT [FK_SPKHUYENMAI_SANPHAM]
GO
USE [master]
GO
ALTER DATABASE [DUAN1] SET  READ_WRITE 
GO

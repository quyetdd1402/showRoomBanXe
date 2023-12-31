USE [master]
GO
/****** Object:  Database [DUAN1]    Script Date: 28/11/2022 6:43:31 CH ******/
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
/****** Object:  Table [dbo].[CHITIETSP]    Script Date: 28/11/2022 6:43:31 CH ******/
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
/****** Object:  Table [dbo].[DICHVU]    Script Date: 28/11/2022 6:43:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DICHVU](
	[id] [uniqueidentifier] NOT NULL,
	[idNhanVien] [uniqueidentifier] NOT NULL,
	[idKhachHang] [uniqueidentifier] NOT NULL,
	[idHoaDon] [uniqueidentifier] NOT NULL,
	[baoHiem] [int] NULL,
	[lamBien] [int] NULL,
 CONSTRAINT [PK_DICHVU] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HINHTHUCTT]    Script Date: 28/11/2022 6:43:31 CH ******/
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
/****** Object:  Table [dbo].[HOADON]    Script Date: 28/11/2022 6:43:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADON](
	[id] [uniqueidentifier] NOT NULL,
	[idNhanVien] [uniqueidentifier] ROWGUIDCOL  NULL,
	[idHTTT] [uniqueidentifier] NULL,
	[idKhachHang] [uniqueidentifier] NULL,
	[ma] [nvarchar](20) NULL,
	[tenXe] [nvarchar](50) NULL,
	[tenNV] [nvarchar](50) NULL,
	[tenKH] [nvarchar](50) NULL,
	[ngayTao] [date] NULL,
	[ngayThanhToan] [date] NULL,
	[ngayHenLayXe] [date] NULL,
	[tongTien] [decimal](25, 0) NULL,
	[soTienGiam] [decimal](20, 0) NULL,
	[SĐTNguoiNhan] [nvarchar](10) NULL,
	[diaChi] [nvarchar](50) NULL,
	[trangThai] [int] NULL,
 CONSTRAINT [PK_HOPDONGCT] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOADONCT]    Script Date: 28/11/2022 6:43:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADONCT](
	[id] [uniqueidentifier] NOT NULL,
	[idCTSanPham] [uniqueidentifier] NOT NULL,
	[idHoaDon] [uniqueidentifier] NOT NULL,
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
/****** Object:  Table [dbo].[KHACHHANG]    Script Date: 28/11/2022 6:43:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHACHHANG](
	[id] [uniqueidentifier] ROWGUIDCOL  NOT NULL,
	[maKH] [nvarchar](5) NULL,
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
/****** Object:  Table [dbo].[KHUYENMAI]    Script Date: 28/11/2022 6:43:31 CH ******/
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
/****** Object:  Table [dbo].[NHANVIEN]    Script Date: 28/11/2022 6:43:31 CH ******/
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
/****** Object:  Table [dbo].[SANPHAM]    Script Date: 28/11/2022 6:43:31 CH ******/
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
/****** Object:  Table [dbo].[SPKHUYENMAI]    Script Date: 28/11/2022 6:43:31 CH ******/
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
/****** Object:  Table [dbo].[USERNAME]    Script Date: 28/11/2022 6:43:31 CH ******/
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
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'9924444e-c2f4-4a26-b239-2e61869edc44', N'e89d3bd3-0aa9-4b02-93c3-b9c5685f8ca9', N'5F84922E-52AA-46ED-A92E-B77255E334ED', N'48BD55E4-528E-4BA9-BAB7-3303711F9CFF', N'E2D016DB-FC49-4966-B3B3-3EBB99C114A3', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2020, 5, CAST(950000000 AS Decimal(18, 0)), N'New', 1)
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'bee94b5b-5837-4a46-9927-432b53701f9f', N'e79dfcc2-f163-4e46-af89-86ac744edf76', N'387CF7E0-935A-4141-A1BC-943693BA40CA', N'9E6963EE-AF01-40D3-8272-6C50A5C431F6', N'B8D01783-1505-44C0-A7A3-29613F541A47', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2022, 2, CAST(850000000 AS Decimal(18, 0)), N'New', 0)
INSERT [dbo].[CHITIETSP] ([id], [idSP], [HangSP], [KieuDang], [MauSac], [NhienLieu], [DongXe], [HopSo], [DongCo], [ChoNgoi], [PhanKhuc], [XuatXu], [NamSX], [SoLuongTon], [GiaBan], [MoTa], [trangThai]) VALUES (N'd7162fa1-2558-446e-b9f5-e1e37ca5d13d', N'76ff9ebc-f1a2-4f00-a1aa-fe4197c6ee8b', N'D7B175BD-5636-4F85-8D36-3C0B98045C77', N'9E6963EE-AF01-40D3-8272-6C50A5C431F6', N'14A1444D-46A3-403A-8005-5F5B8838DAFC', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2021, 15, CAST(720000000 AS Decimal(18, 0)), N'New', 0)
GO
INSERT [dbo].[HINHTHUCTT] ([id], [ma], [ten], [trangThai]) VALUES (N'bd41a4d3-d9e3-465c-8539-1113b00f6f00', N'ma1', N'Online', 0)
INSERT [dbo].[HINHTHUCTT] ([id], [ma], [ten], [trangThai]) VALUES (N'a02cf4c6-a2be-42c7-b0ef-1a94c25ec39f', N'ma4', N'Offline', 0)
INSERT [dbo].[HINHTHUCTT] ([id], [ma], [ten], [trangThai]) VALUES (N'bc4a7d2d-0018-406e-9622-9b2abdef9e5b', N'ma3', N'Offline', 1)
INSERT [dbo].[HINHTHUCTT] ([id], [ma], [ten], [trangThai]) VALUES (N'b750a0e9-0711-4618-a161-af57031bf728', N'ma2', N'Online', 1)
GO
INSERT [dbo].[HOADON] ([id], [idNhanVien], [idHTTT], [idKhachHang], [ma], [tenXe], [tenNV], [tenKH], [ngayTao], [ngayThanhToan], [ngayHenLayXe], [tongTien], [soTienGiam], [SĐTNguoiNhan], [diaChi], [trangThai]) VALUES (N'b19ff789-13e9-4e43-9201-65910daa815f', N'af24dc07-d392-4514-8ec1-0127593b1374', N'bc4a7d2d-0018-406e-9622-9b2abdef9e5b', N'000966a8-ae31-4568-b2db-32934155b2ad', N'ma2', N'Vios', N'Duy', N'Dũng', CAST(N'2022-09-01' AS Date), CAST(N'2022-09-01' AS Date), CAST(N'2022-09-01' AS Date), NULL, NULL, N'0961745487', N'Hà Nội', NULL)
INSERT [dbo].[HOADON] ([id], [idNhanVien], [idHTTT], [idKhachHang], [ma], [tenXe], [tenNV], [tenKH], [ngayTao], [ngayThanhToan], [ngayHenLayXe], [tongTien], [soTienGiam], [SĐTNguoiNhan], [diaChi], [trangThai]) VALUES (N'012bdd77-e258-455b-8711-e6264702fb2c', N'fd6e04fe-5814-4b3b-aa41-00ce816f202f', N'bc4a7d2d-0018-406e-9622-9b2abdef9e5b', N'000966a8-ae31-4568-b2db-32934155b2ad', N'ma1', N'Civic', N'Thịnh', N'Bích', CAST(N'2022-10-11' AS Date), CAST(N'2022-10-11' AS Date), CAST(N'2022-10-12' AS Date), NULL, NULL, N'0373645238', N'TP.Hồ Chí Minh', NULL)
GO
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'bf84a499-b15d-46eb-8fc6-2dbaef4a2d83', N'maKH3', N'Hạnh', CAST(N'2000-10-25' AS Date), 0, N'0648362634', N'Thái Bình', N'Việt Nam', 1)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'000966a8-ae31-4568-b2db-32934155b2ad', N'maKH1', N'Dũng', CAST(N'1999-09-11' AS Date), 1, N'0961745487', N'Hà Nội', N'Việt Nam', 1)
INSERT [dbo].[KHACHHANG] ([id], [maKH], [hoTenKH], [ngaySinh], [gioiTinh], [SĐT], [diaChi], [quocGia], [trangThai]) VALUES (N'8edc5acd-dd0f-4e7e-8502-a0e80c08f0bd', N'maKH2', N'Bích', CAST(N'1998-01-15' AS Date), 0, N'0373645238', N'TP.Hồ Chí Minh', N'Việt Nam', 0)
GO
INSERT [dbo].[KHUYENMAI] ([id], [ma], [ten], [giamGia], [ngayBD], [ngayKT], [trangThai]) VALUES (N'0800b114-3df3-45b6-b40a-8f5462562edc', N'ma2', N'ten2', 2000, CAST(N'2022-12-02' AS Date), CAST(N'2022-12-25' AS Date), 0)
INSERT [dbo].[KHUYENMAI] ([id], [ma], [ten], [giamGia], [ngayBD], [ngayKT], [trangThai]) VALUES (N'6e99691e-972b-400b-8da3-91cdf876f611', N'ma1', N'ten1', 1500, CAST(N'2022-12-01' AS Date), CAST(N'2022-12-20' AS Date), 1)
INSERT [dbo].[KHUYENMAI] ([id], [ma], [ten], [giamGia], [ngayBD], [ngayKT], [trangThai]) VALUES (N'ea601333-44d9-4260-98b6-99637f2af251', N'ma3', N'ten3', 2500, CAST(N'2022-11-25' AS Date), CAST(N'2022-12-15' AS Date), 1)
GO
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'fd6e04fe-5814-4b3b-aa41-00ce816f202f', N'MaNv9', N'Chống Thiện Mỹ', 0, CAST(N'2003-12-12' AS Date), 1, N'0938372422', N'myctph2222@fpt.edu.vn', N'Thái Bình', N'2.jpg', N'9', 0)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'af24dc07-d392-4514-8ec1-0127593b1374', N'maNv1', N'Phạm Khương Duy', 0, CAST(N'2003-07-22' AS Date), 0, N'0961745487', N'duypkph22349@fpt.edu.vn', N'Hà Nội', N'7.jpg', N'9', 0)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'fd4d696e-c3e6-4b95-a256-0d0361e16ce9', N'maNv7', N'Bùi Thị Hạnh', 0, CAST(N'2003-09-12' AS Date), 1, N'0743734843', N'hanhpt@fpt.edu.vn', N'Bắc Giang', N'3.jpg', N'9', 1)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'0d3c9509-9906-4100-94cf-2d2b254239f9', N'maNv6', N'Vũ Minh Hà', 1, CAST(N'2002-03-23' AS Date), 1, N'0483463463', N'minhpv@fpt.edu.vn', N'Nam Định', N'5.jpg', N'6', 0)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'37a92c43-6ccf-4757-9474-37da1b465a8b', N'maNv4', N'Lê Nga Hằng', 1, CAST(N'2001-01-01' AS Date), 1, N'0324834234', N'quanph22123@fpt.edu.vn', N'Thái Bình', N'6.jpg', N'7', 1)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'7d9d8c6c-95c5-40bb-b1d9-3be682ed8a36', N'MaNv2', N'Duy Phạm', 0, CAST(N'2022-01-01' AS Date), 1, N'0938372422', N'duy@fpt.edu.vn', N'Thái Bình', N'10.jpg', N'9', 0)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'e1499d87-1fd9-4de2-b789-3f84cf206c95', N'maNv5', N'Nguyễn Văn Minh', 1, CAST(N'2000-10-11' AS Date), 0, N'0671264648', N'dungpd22@fpt.edu.vn', N'Thái Nguyên', N'4.jpg', N'7', 1)
INSERT [dbo].[NHANVIEN] ([id], [maNV], [hoTenNv], [vaiTro], [ngaySinh], [gioiTinh], [SĐT], [email], [diaChi], [anh], [luong], [trangThai]) VALUES (N'547ccf52-e570-4e6e-a8dd-d96435a9d6fc', N'maNv3', N'Phạm Văn Đức', 1, CAST(N'2004-12-05' AS Date), 1, N'0734636434', N'ducvp2323@fpt.edu.vn', N'Hà Nội', N'1.jpg', N'6', 1)
GO
INSERT [dbo].[SANPHAM] ([id], [ma], [ten], [anh]) VALUES (N'0b9e8a3e-8920-409e-875f-10e2e494551a', N'ma1', N'Camry', NULL)
INSERT [dbo].[SANPHAM] ([id], [ma], [ten], [anh]) VALUES (N'709f0874-26ec-451d-b041-5178bf650933', N'ma4', N'Morning', NULL)
INSERT [dbo].[SANPHAM] ([id], [ma], [ten], [anh]) VALUES (N'e79dfcc2-f163-4e46-af89-86ac744edf76', N'ma5', N'LS 500', NULL)
INSERT [dbo].[SANPHAM] ([id], [ma], [ten], [anh]) VALUES (N'e89d3bd3-0aa9-4b02-93c3-b9c5685f8ca9', N'ma2', N'HonDa City', NULL)
INSERT [dbo].[SANPHAM] ([id], [ma], [ten], [anh]) VALUES (N'99ec6793-d597-4742-88a8-e756b0962891', N'ma6', N'Ford Ranger', NULL)
INSERT [dbo].[SANPHAM] ([id], [ma], [ten], [anh]) VALUES (N'76ff9ebc-f1a2-4f00-a1aa-fe4197c6ee8b', N'ma3', N'Toyota Vios', NULL)
GO
INSERT [dbo].[USERNAME] ([id], [userName], [password], [email], [comfirmPassword]) VALUES (N'9e7ccc4f-9d0e-4e68-b0ae-2c099f754158', N'a2', N'2', N'thinhndph22453@fpt.edu.vn', N'2')
INSERT [dbo].[USERNAME] ([id], [userName], [password], [email], [comfirmPassword]) VALUES (N'fc42ce58-4bb5-4ae0-965b-ba0cc1f9e492', N'a1', N'1', N'duypkph22349@fpt.edu.vn', N'1')
GO
ALTER TABLE [dbo].[CHITIETSP] ADD  CONSTRAINT [DF_CHITIETSP_id]  DEFAULT (newid()) FOR [id]
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

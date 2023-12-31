USE [master]
GO
/****** Object:  Database [QLSanPham]    Script Date: 21/10/2019 8:37:27 AM ******/
CREATE DATABASE [QLSanPham]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLSanPham', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\QLSanPham.mdf' , SIZE = 3136KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QLSanPham_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\QLSanPham_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QLSanPham] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLSanPham].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLSanPham] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLSanPham] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLSanPham] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLSanPham] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLSanPham] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLSanPham] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLSanPham] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [QLSanPham] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLSanPham] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLSanPham] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLSanPham] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLSanPham] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLSanPham] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLSanPham] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLSanPham] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLSanPham] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QLSanPham] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLSanPham] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLSanPham] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLSanPham] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLSanPham] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLSanPham] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLSanPham] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLSanPham] SET RECOVERY FULL 
GO
ALTER DATABASE [QLSanPham] SET  MULTI_USER 
GO
ALTER DATABASE [QLSanPham] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLSanPham] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLSanPham] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLSanPham] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'QLSanPham', N'ON'
GO
USE [QLSanPham]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 21/10/2019 8:37:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaChiTietHD] [int] IDENTITY(1,1) NOT NULL,
	[MaHD] [int] NOT NULL,
	[IDSanPham] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[ThanhTien] [money] NOT NULL,
	[GhiChu] [nvarchar](200) NULL,
 CONSTRAINT [FK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[MaChiTietHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 21/10/2019 8:37:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [int] IDENTITY(1,1) NOT NULL,
	[SoHoaDon] [varchar](15) NOT NULL,
	[NgayTaoHD] [date] NOT NULL,
	[MaNhanVien] [int] NOT NULL,
	[MaKhachHang] [int] NOT NULL,
	[TongTien] [money] NOT NULL,
	[GhiChu] [nvarchar](250) NULL,
 CONSTRAINT [FK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 21/10/2019 8:37:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [int] IDENTITY(1,1) NOT NULL,
	[TenKhachHang] [nvarchar](100) NULL,
	[DiaChi] [nvarchar](255) NULL,
	[GioiTinh] [bit] NULL,
	[SoDienThoai] [varchar](11) NULL,
	[LoaiKhachHang] [nvarchar](40) NOT NULL,
	[GhiChu] [nvarchar](250) NULL,
 CONSTRAINT [FK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 21/10/2019 8:37:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[MaLoaiSP] [int] IDENTITY(1,1) NOT NULL,
	[TenLoai] [nvarchar](60) NOT NULL,
	[MoTa] [nvarchar](255) NULL,
 CONSTRAINT [FK_LoaiSanPham] PRIMARY KEY CLUSTERED 
(
	[MaLoaiSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 21/10/2019 8:37:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [int] IDENTITY(1,1) NOT NULL,
	[TenNhanVien] [nvarchar](80) NOT NULL,
	[DiaChi] [nvarchar](255) NULL,
	[SoDienThoai] [varchar](11) NULL,
	[GioiTinh] [bit] NULL,
	[ChucVu] [nvarchar](30) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[NgayVaoLam] [date] NOT NULL,
 CONSTRAINT [FK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 21/10/2019 8:37:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SanPham](
	[IDSanPham] [int] IDENTITY(1,1) NOT NULL,
	[MaSP] [varchar](10) NOT NULL,
	[TenSP] [nvarchar](60) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[DonViTinh] [nvarchar](15) NULL,
	[GiaNhap] [money] NOT NULL,
	[GiaBan] [money] NOT NULL,
	[MaLoaiSP] [int] NOT NULL,
	[MoTa] [nvarchar](255) NULL,
 CONSTRAINT [FK_SanPham] PRIMARY KEY CLUSTERED 
(
	[IDSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] ON 

INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHD], [IDSanPham], [SoLuong], [ThanhTien], [GhiChu]) VALUES (6, 11, 4, 3, 39000000.0000, N'')
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaHD], [IDSanPham], [SoLuong], [ThanhTien], [GhiChu]) VALUES (7, 11, 5, 3, 150000.0000, N'')
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] OFF
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([MaHD], [SoHoaDon], [NgayTaoHD], [MaNhanVien], [MaKhachHang], [TongTien], [GhiChu]) VALUES (11, N'191020005', CAST(0x47400B00 AS Date), 2, 2, 39150000.0000, N'')
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([MaKH], [TenKhachHang], [DiaChi], [GioiTinh], [SoDienThoai], [LoaiKhachHang], [GhiChu]) VALUES (1, N'Nguyễn Thanh Duy', N'88 Hàng Xanh, Tp.Hồ Chí Minh', 1, N'090000398', N'VIP', NULL)
INSERT [dbo].[KhachHang] ([MaKH], [TenKhachHang], [DiaChi], [GioiTinh], [SoDienThoai], [LoaiKhachHang], [GhiChu]) VALUES (2, N'Huỳnh Văn Trung', N'145 Lý Thường Kiệt, Tp.BMT', 1, N'092929292', N'Thường xuyên', NULL)
INSERT [dbo].[KhachHang] ([MaKH], [TenKhachHang], [DiaChi], [GioiTinh], [SoDienThoai], [LoaiKhachHang], [GhiChu]) VALUES (3, N'Trần Đình Nguyên', N'105 Lý Thường Kiệt, Tp.BMT', 0, N'028299383', N'Bình thường', NULL)
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
SET IDENTITY_INSERT [dbo].[LoaiSanPham] ON 

INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoai], [MoTa]) VALUES (1, N'Điện thoại', N'Các sản phẩm điện thoại')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoai], [MoTa]) VALUES (2, N'Laptop', N'Các sản phẩm Laptop')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoai], [MoTa]) VALUES (3, N'Linh kiện', N'Các loại linh kiện điện thoại')
SET IDENTITY_INSERT [dbo].[LoaiSanPham] OFF
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [DiaChi], [SoDienThoai], [GioiTinh], [ChucVu], [NgaySinh], [NgayVaoLam]) VALUES (1, N'Vi Văn Thành', N'73 Trường Chinh, Tp.BMT, DakLak', N'090000398', 0, N'Kỹ thuật viên', CAST(0xB11C0B00 AS Date), CAST(0x44390B00 AS Date))
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [DiaChi], [SoDienThoai], [GioiTinh], [ChucVu], [NgaySinh], [NgayVaoLam]) VALUES (2, N'Điền Đức Hoàng', N'72 Trường Chinh, Tp.BMT, DakLak', N'01234567890', 1, N'Nhân viên IT', CAST(0x441B0B00 AS Date), CAST(0x44390B00 AS Date))
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [DiaChi], [SoDienThoai], [GioiTinh], [ChucVu], [NgaySinh], [NgayVaoLam]) VALUES (3, N'Hoàng Quốc Dũng', N'69 Hai Bà Trưng, Tp.Hồ Chí Minh', N'090000398', 1, N'Bảo vệ', CAST(0xD7190B00 AS Date), CAST(0x44390B00 AS Date))
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([IDSanPham], [MaSP], [TenSP], [SoLuong], [DonViTinh], [GiaNhap], [GiaBan], [MaLoaiSP], [MoTa]) VALUES (1, N'DT01', N'Zenfone 2', 10, N'Cái', 7000000.0000, 9000000.0000, 1, NULL)
INSERT [dbo].[SanPham] ([IDSanPham], [MaSP], [TenSP], [SoLuong], [DonViTinh], [GiaNhap], [GiaBan], [MaLoaiSP], [MoTa]) VALUES (2, N'DT02', N'Zenfone 6', 19, N'Cái', 4000000.0000, 5000000.0000, 1, NULL)
INSERT [dbo].[SanPham] ([IDSanPham], [MaSP], [TenSP], [SoLuong], [DonViTinh], [GiaNhap], [GiaBan], [MaLoaiSP], [MoTa]) VALUES (3, N'LT01', N'Acer 511', 9, N'Cái', 17000000.0000, 19000000.0000, 2, NULL)
INSERT [dbo].[SanPham] ([IDSanPham], [MaSP], [TenSP], [SoLuong], [DonViTinh], [GiaNhap], [GiaBan], [MaLoaiSP], [MoTa]) VALUES (4, N'LT02', N'Dell Inspiron 3537', 4, N'Cái', 11000000.0000, 13000000.0000, 2, NULL)
INSERT [dbo].[SanPham] ([IDSanPham], [MaSP], [TenSP], [SoLuong], [DonViTinh], [GiaNhap], [GiaBan], [MaLoaiSP], [MoTa]) VALUES (5, N'LK01', N'Bao da IPhone 7', 29, N'Cái', 10000.0000, 50000.0000, 3, NULL)
INSERT [dbo].[SanPham] ([IDSanPham], [MaSP], [TenSP], [SoLuong], [DonViTinh], [GiaNhap], [GiaBan], [MaLoaiSP], [MoTa]) VALUES (6, N'LK02', N'Miếng dán keo', 50, N'Miếng', 20000.0000, 60000.0000, 3, NULL)
SET IDENTITY_INSERT [dbo].[SanPham] OFF
ALTER TABLE [dbo].[ChiTietHoaDon] ADD  DEFAULT ((1)) FOR [SoLuong]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (getdate()) FOR [NgayTaoHD]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [TongTien]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT ((1)) FOR [GioiTinh]
GO
ALTER TABLE [dbo].[LoaiSanPham] ADD  CONSTRAINT [DF_LoaiSanPham_MoTa]  DEFAULT ('ko co') FOR [MoTa]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT ((0)) FOR [GioiTinh]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT ((1)) FOR [SoLuong]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT ((0)) FOR [GiaNhap]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT ((0)) FOR [GiaBan]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_SanPham] FOREIGN KEY([IDSanPham])
REFERENCES [dbo].[SanPham] ([IDSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_SanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKhachHang])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_LoaiSanPham] FOREIGN KEY([MaLoaiSP])
REFERENCES [dbo].[LoaiSanPham] ([MaLoaiSP])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_LoaiSanPham]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [CK_SanPham_GiaBan_LonHon_GiaNhap] CHECK  (([GiaBan]>[GiaNhap]))
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [CK_SanPham_GiaBan_LonHon_GiaNhap]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [CK_SanPham_GiaNhapPhaiDuong] CHECK  (([GiaNhap]>=(0)))
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [CK_SanPham_GiaNhapPhaiDuong]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [CK_SanPham_SoLuong_PhaiLonHonHoacBang_0] CHECK  (([SoLuong]>=(0)))
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [CK_SanPham_SoLuong_PhaiLonHonHoacBang_0]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'So luong phai lon hon hoac bang 0' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'SanPham', @level2type=N'CONSTRAINT',@level2name=N'CK_SanPham_SoLuong_PhaiLonHonHoacBang_0'
GO
USE [master]
GO
ALTER DATABASE [QLSanPham] SET  READ_WRITE 
GO

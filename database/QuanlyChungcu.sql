USE [QL_Chungcu]
GO
/****** Object:  Table [dbo].[canho]    Script Date: 12/28/2017 11:35:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[canho](
	[id_canho] [int] IDENTITY(1,1) NOT NULL,
	[id_toanha] [int] NOT NULL,
	[so_nha] [char](10) NOT NULL,
	[dientich] [int] NOT NULL,
	[sophong] [int] NOT NULL,
	[gia_ban] [float] NULL,
	[gia_thue] [float] NULL,
	[mota] [nchar](10) NULL,
 CONSTRAINT [PK_canho] PRIMARY KEY CLUSTERED 
(
	[id_canho] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[chitiet_giaodich]    Script Date: 12/28/2017 11:35:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chitiet_giaodich](
	[id_giaodich] [int] NOT NULL,
	[id_canho] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[chungcu]    Script Date: 12/28/2017 11:35:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chungcu](
	[id_chungcu] [int] IDENTITY(1,1) NOT NULL,
	[ten_chungcu] [nchar](255) NOT NULL,
	[so_toanha] [int] NOT NULL,
	[tong_dientich] [int] NOT NULL,
	[diachi] [nchar](255) NOT NULL,
	[chu_dautu] [nchar](255) NOT NULL,
	[mota] [nchar](1000) NULL,
 CONSTRAINT [PK_chungcu] PRIMARY KEY CLUSTERED 
(
	[id_chungcu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[giaodich]    Script Date: 12/28/2017 11:35:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[giaodich](
	[id_giaodich] [int] IDENTITY(1,1) NOT NULL,
	[loai_giaodich] [int] NULL,
	[soluong] [int] NULL,
	[tong_gia] [int] NULL,
	[ngaylap_giaodich] [date] NULL,
	[id_nhanvien] [int] NULL,
	[id_khachhang] [int] NULL,
	[mota] [nchar](10) NULL,
 CONSTRAINT [PK_giaodich] PRIMARY KEY CLUSTERED 
(
	[id_giaodich] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[khachhang]    Script Date: 12/28/2017 11:35:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khachhang](
	[id_khachhang] [int] IDENTITY(1,1) NOT NULL,
	[hoten] [nchar](255) NOT NULL,
	[diachi] [nchar](255) NOT NULL,
	[sdt] [nchar](12) NOT NULL,
	[email] [nchar](255) NOT NULL,
	[cmnd] [nchar](20) NULL,
	[ngay_sinh] [date] NULL,
	[gioitinh] [tinyint] NOT NULL,
	[tongtien_giaodich] [float] NOT NULL,
	[mota] [nchar](1000) NULL,
 CONSTRAINT [PK_khachhang] PRIMARY KEY CLUSTERED 
(
	[id_khachhang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[nhanvien]    Script Date: 12/28/2017 11:35:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhanvien](
	[id_nhanvien] [int] IDENTITY(1,1) NOT NULL,
	[hoten] [nchar](255) NOT NULL,
	[diachi] [nchar](1000) NOT NULL,
	[sdt] [nchar](20) NOT NULL,
	[ngaysinh] [date] NOT NULL,
	[cmnd] [nchar](20) NOT NULL,
	[luong] [float] NOT NULL,
	[ngay_batdau] [date] NOT NULL,
	[mota] [nchar](1000) NULL,
	[id_toanha] [int] NOT NULL,
 CONSTRAINT [PK_nhanvien] PRIMARY KEY CLUSTERED 
(
	[id_nhanvien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[toanha]    Script Date: 12/28/2017 11:35:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[toanha](
	[id_toanha] [int] IDENTITY(1,1) NOT NULL,
	[ten_toanha] [nchar](255) NOT NULL,
	[diachi] [nchar](255) NOT NULL,
	[sdt_quanly] [nchar](255) NOT NULL,
	[so_tang] [int] NOT NULL,
	[so_canho] [int] NOT NULL,
	[tong_dientich] [int] NOT NULL,
	[ngay_xaydung] [date] NOT NULL,
	[ngay_hoanthanh] [date] NOT NULL,
	[mota] [nchar](1000) NULL,
	[id_chungcu] [int] NOT NULL,
 CONSTRAINT [PK_toanha] PRIMARY KEY CLUSTERED 
(
	[id_toanha] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[canho] ON 

INSERT [dbo].[canho] ([id_canho], [id_toanha], [so_nha], [dientich], [sophong], [gia_ban], [gia_thue], [mota]) VALUES (1, 1, N'01-B1     ', 60, 4, 1000000, 5000, N'rộng rãi  ')
INSERT [dbo].[canho] ([id_canho], [id_toanha], [so_nha], [dientich], [sophong], [gia_ban], [gia_thue], [mota]) VALUES (2, 3, N'A2-01-B1  ', 70, 5, 1200000, 6000, N'rộng      ')
SET IDENTITY_INSERT [dbo].[canho] OFF
INSERT [dbo].[chitiet_giaodich] ([id_giaodich], [id_canho]) VALUES (1, 1)
SET IDENTITY_INSERT [dbo].[chungcu] ON 

INSERT [dbo].[chungcu] ([id_chungcu], [ten_chungcu], [so_toanha], [tong_dientich], [diachi], [chu_dautu], [mota]) VALUES (1, N'Hoàng Gia 1                                                                                                                                                                                                                                                    ', 4, 3000, N'Số 1 Nguyễn Trãi, Thanh Xuân, Hà Nội                                                                                                                                                                                                                           ', N'VinCom                                                                                                                                                                                                                                                         ', N'Rỗng rãi, thoáng mát, đầy đủ tiện nghi cao cấp                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ')
INSERT [dbo].[chungcu] ([id_chungcu], [ten_chungcu], [so_toanha], [tong_dientich], [diachi], [chu_dautu], [mota]) VALUES (2, N'Hoàng Gia 2                                                                                                                                                                                                                                                    ', 5, 4000, N'Số 2 Cầu Giấy, Hà Nội                                                                                                                                                                                                                                          ', N'VinCom                                                                                                                                                                                                                                                         ', N'Đẹp                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ')
SET IDENTITY_INSERT [dbo].[chungcu] OFF
SET IDENTITY_INSERT [dbo].[giaodich] ON 

INSERT [dbo].[giaodich] ([id_giaodich], [loai_giaodich], [soluong], [tong_gia], [ngaylap_giaodich], [id_nhanvien], [id_khachhang], [mota]) VALUES (1, 1, 1, 1000000, CAST(0xA23D0B00 AS Date), 1, 1, N'Mua nhà   ')
SET IDENTITY_INSERT [dbo].[giaodich] OFF
SET IDENTITY_INSERT [dbo].[khachhang] ON 

INSERT [dbo].[khachhang] ([id_khachhang], [hoten], [diachi], [sdt], [email], [cmnd], [ngay_sinh], [gioitinh], [tongtien_giaodich], [mota]) VALUES (1, N'Bùi Trần Tiến                                                                                                                                                                                                                                                  ', N'Sơn Tây, Hà Nội                                                                                                                                                                                                                                                ', N'0987654321  ', N'trantien@gmailc.om                                                                                                                                                                                                                                             ', N'574632421423        ', CAST(0x0B1A0B00 AS Date), 1, 2000000, N'Siêu giàu                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ')
INSERT [dbo].[khachhang] ([id_khachhang], [hoten], [diachi], [sdt], [email], [cmnd], [ngay_sinh], [gioitinh], [tongtien_giaodich], [mota]) VALUES (2, N'Nguyễn Thành Chí                                                                                                                                                                                                                                               ', N'Đan Phượng, hà Nội                                                                                                                                                                                                                                             ', N'0984522324  ', N'thanhchi@gmailc.om                                                                                                                                                                                                                                             ', N'21343423423         ', CAST(0xA10E0B00 AS Date), 1, 2234234, N'Thương gia                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ')
SET IDENTITY_INSERT [dbo].[khachhang] OFF
SET IDENTITY_INSERT [dbo].[nhanvien] ON 

INSERT [dbo].[nhanvien] ([id_nhanvien], [hoten], [diachi], [sdt], [ngaysinh], [cmnd], [luong], [ngay_batdau], [mota], [id_toanha]) VALUES (1, N'Nguyễn Văn A                                                                                                                                                                                                                                                   ', N'Cầy giấy, Hà Nội                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ', N'9821379111          ', CAST(0x07F90A00 AS Date), N'102838123801        ', 10000, CAST(0xDB3A0B00 AS Date), N'Cẩn thận                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ', 1)
INSERT [dbo].[nhanvien] ([id_nhanvien], [hoten], [diachi], [sdt], [ngaysinh], [cmnd], [luong], [ngay_batdau], [mota], [id_toanha]) VALUES (3, N'Nguyễn Văn B                                                                                                                                                                                                                                                   ', N'Mỹ Đình, hà Nội                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         ', N'0129831283          ', CAST(0xA4150B00 AS Date), N'0123827439827       ', 8000, CAST(0x543C0B00 AS Date), NULL, 3)
SET IDENTITY_INSERT [dbo].[nhanvien] OFF
SET IDENTITY_INSERT [dbo].[toanha] ON 

INSERT [dbo].[toanha] ([id_toanha], [ten_toanha], [diachi], [sdt_quanly], [so_tang], [so_canho], [tong_dientich], [ngay_xaydung], [ngay_hoanthanh], [mota], [id_chungcu]) VALUES (1, N'Tòa A1                                                                                                                                                                                                                                                         ', N'Tòa A1, Hoàng Gia 1                                                                                                                                                                                                                                            ', N'0987654321                                                                                                                                                                                                                                                     ', 30, 300, 3000, CAST(0x163C0B00 AS Date), CAST(0x833D0B00 AS Date), N'Đẹp                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ', 1)
INSERT [dbo].[toanha] ([id_toanha], [ten_toanha], [diachi], [sdt_quanly], [so_tang], [so_canho], [tong_dientich], [ngay_xaydung], [ngay_hoanthanh], [mota], [id_chungcu]) VALUES (3, N'Tòa A2                                                                                                                                                                                                                                                         ', N'Tòa A1, Hoàng Gia 1                                                                                                                                                                                                                                            ', N'0987654321                                                                                                                                                                                                                                                     ', 20, 250, 3000, CAST(0x163C0B00 AS Date), CAST(0x813D0B00 AS Date), NULL, 1)
SET IDENTITY_INSERT [dbo].[toanha] OFF
ALTER TABLE [dbo].[canho]  WITH CHECK ADD  CONSTRAINT [FK_canho_toanha] FOREIGN KEY([id_toanha])
REFERENCES [dbo].[toanha] ([id_toanha])
GO
ALTER TABLE [dbo].[canho] CHECK CONSTRAINT [FK_canho_toanha]
GO
ALTER TABLE [dbo].[chitiet_giaodich]  WITH CHECK ADD  CONSTRAINT [FK_chitiet_giaodich_canho] FOREIGN KEY([id_canho])
REFERENCES [dbo].[canho] ([id_canho])
GO
ALTER TABLE [dbo].[chitiet_giaodich] CHECK CONSTRAINT [FK_chitiet_giaodich_canho]
GO
ALTER TABLE [dbo].[chitiet_giaodich]  WITH CHECK ADD  CONSTRAINT [FK_chitiet_giaodich_giaodich] FOREIGN KEY([id_giaodich])
REFERENCES [dbo].[giaodich] ([id_giaodich])
GO
ALTER TABLE [dbo].[chitiet_giaodich] CHECK CONSTRAINT [FK_chitiet_giaodich_giaodich]
GO
ALTER TABLE [dbo].[giaodich]  WITH CHECK ADD  CONSTRAINT [FK_giaodich_khachhang] FOREIGN KEY([id_khachhang])
REFERENCES [dbo].[khachhang] ([id_khachhang])
GO
ALTER TABLE [dbo].[giaodich] CHECK CONSTRAINT [FK_giaodich_khachhang]
GO
ALTER TABLE [dbo].[giaodich]  WITH CHECK ADD  CONSTRAINT [FK_giaodich_nhanvien] FOREIGN KEY([id_nhanvien])
REFERENCES [dbo].[nhanvien] ([id_nhanvien])
GO
ALTER TABLE [dbo].[giaodich] CHECK CONSTRAINT [FK_giaodich_nhanvien]
GO
ALTER TABLE [dbo].[nhanvien]  WITH CHECK ADD  CONSTRAINT [FK_nhanvien_toanha] FOREIGN KEY([id_toanha])
REFERENCES [dbo].[toanha] ([id_toanha])
GO
ALTER TABLE [dbo].[nhanvien] CHECK CONSTRAINT [FK_nhanvien_toanha]
GO
ALTER TABLE [dbo].[toanha]  WITH CHECK ADD  CONSTRAINT [FK_toanha_chungcu] FOREIGN KEY([id_chungcu])
REFERENCES [dbo].[chungcu] ([id_chungcu])
GO
ALTER TABLE [dbo].[toanha] CHECK CONSTRAINT [FK_toanha_chungcu]
GO

USE [master]
GO
/****** Object:  Database [Quan_ly_thu_vien_1]    Script Date: 8/22/2021 12:02:46 PM ******/
CREATE DATABASE [Quan_ly_thu_vien_1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Quan_ly_thu_vien', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Quan_ly_thu_vien_1.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Quan_ly_thu_vien_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Quan_ly_thu_vien_1_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Quan_ly_thu_vien_1].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET ARITHABORT OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET  MULTI_USER 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Quan_ly_thu_vien_1', N'ON'
GO
USE [Quan_ly_thu_vien_1]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 8/22/2021 12:02:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[AdminName] [nvarchar](30) NOT NULL,
	[AdminPass] [nvarchar](30) NOT NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[AdminName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Book]    Script Date: 8/22/2021 12:02:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Book](
	[BookID] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[BookName] [nvarchar](50) NOT NULL,
	[GroupBookID] [tinyint] NULL,
	[PubID] [smallint] NULL,
	[CateID] [numeric](18, 0) NULL,
	[Author] [nvarchar](30) NOT NULL,
	[MaxNum] [smallint] NOT NULL,
	[Count] [smallint] NOT NULL,
	[Date] [smallint] NOT NULL,
 CONSTRAINT [PK_Book] PRIMARY KEY CLUSTERED 
(
	[BookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 8/22/2021 12:02:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CateID] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[CateName] [nvarchar](30) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[CateID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GroupBook]    Script Date: 8/22/2021 12:02:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GroupBook](
	[GroupBookID] [tinyint] IDENTITY(1,1) NOT NULL,
	[GroupBookName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_GroupBook] PRIMARY KEY CLUSTERED 
(
	[GroupBookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Librarian]    Script Date: 8/22/2021 12:02:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Librarian](
	[AccID] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[NameAcc] [int] NOT NULL,
	[PassAcc] [nvarchar](20) NOT NULL,
	[NameUser] [varchar](20) NOT NULL,
	[Email] [nvarchar](30) NULL,
	[PhoneNum] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_Librarian] PRIMARY KEY CLUSTERED 
(
	[AccID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Publisher]    Script Date: 8/22/2021 12:02:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Publisher](
	[PubID] [smallint] IDENTITY(1,1) NOT NULL,
	[PubName] [nvarchar](30) NOT NULL,
 CONSTRAINT [PK_Publisher] PRIMARY KEY CLUSTERED 
(
	[PubID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Reader]    Script Date: 8/22/2021 12:02:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reader](
	[ReaderID] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[NameAcc] [int] NOT NULL,
	[PassAcc] [nvarchar](20) NOT NULL,
	[NameUser] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](30) NULL,
	[PhoneNum] [nvarchar](10) NOT NULL,
	[MaxBook] [smallint] NOT NULL,
	[BookBorrow] [smallint] NOT NULL,
	[DateReader] [datetime] NOT NULL,
	[StatusReader] [smallint] NOT NULL,
	[Remain] [smallint] NOT NULL,
 CONSTRAINT [PK_Reader] PRIMARY KEY CLUSTERED 
(
	[ReaderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StaffLib]    Script Date: 8/22/2021 12:02:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StaffLib](
	[AccID] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[NameAcc] [int] NOT NULL,
	[PassAcc] [nvarchar](20) NOT NULL,
	[NameUser] [nvarchar](30) NOT NULL,
	[Email] [nvarchar](30) NOT NULL,
	[PhoneNum] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_StaffLib] PRIMARY KEY CLUSTERED 
(
	[AccID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ticket]    Script Date: 8/22/2021 12:02:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ticket](
	[TicketID] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[ReaderID] [numeric](18, 0) NOT NULL,
	[BookID] [numeric](18, 0) NOT NULL,
	[StatusTicket] [smallint] NOT NULL,
	[DateBorrow] [datetime] NOT NULL,
	[DatePay] [datetime] NULL,
	[deadline] [datetime] NULL,
 CONSTRAINT [PK_Ticket] PRIMARY KEY CLUSTERED 
(
	[TicketID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Admin] ([AdminName], [AdminPass]) VALUES (N'admin', N'admin')
GO
SET IDENTITY_INSERT [dbo].[Book] ON 

INSERT [dbo].[Book] ([BookID], [BookName], [GroupBookID], [PubID], [CateID], [Author], [MaxNum], [Count], [Date]) VALUES (CAST(2 AS Numeric(18, 0)), N'Giải tích 4', 2, 1, CAST(2 AS Numeric(18, 0)), N'Nguyễn Xuân Thảo ', 9, 4, 15)
INSERT [dbo].[Book] ([BookID], [BookName], [GroupBookID], [PubID], [CateID], [Author], [MaxNum], [Count], [Date]) VALUES (CAST(3 AS Numeric(18, 0)), N'Giải tích 2 ', 2, 1, CAST(2 AS Numeric(18, 0)), N'Bùi Xuân Diệu', 10, 5, 15)
INSERT [dbo].[Book] ([BookID], [BookName], [GroupBookID], [PubID], [CateID], [Author], [MaxNum], [Count], [Date]) VALUES (CAST(4 AS Numeric(18, 0)), N'Lập trình mạng', 1, 2, CAST(5 AS Numeric(18, 0)), N'Nguyễn Văn An', 6, 2, 10)
INSERT [dbo].[Book] ([BookID], [BookName], [GroupBookID], [PubID], [CateID], [Author], [MaxNum], [Count], [Date]) VALUES (CAST(6 AS Numeric(18, 0)), N'Nguyên lý cơ bản của chủ nghĩa Mac-Lênin', 2, 1, CAST(4 AS Numeric(18, 0)), N'Nguyễn Văn A', 13, 11, 9)
SET IDENTITY_INSERT [dbo].[Book] OFF
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([CateID], [CateName]) VALUES (CAST(1 AS Numeric(18, 0)), N'Tiểu Thuyết')
INSERT [dbo].[Category] ([CateID], [CateName]) VALUES (CAST(2 AS Numeric(18, 0)), N'Toán học ')
INSERT [dbo].[Category] ([CateID], [CateName]) VALUES (CAST(3 AS Numeric(18, 0)), N'Văn học ')
INSERT [dbo].[Category] ([CateID], [CateName]) VALUES (CAST(4 AS Numeric(18, 0)), N'Triết học ')
INSERT [dbo].[Category] ([CateID], [CateName]) VALUES (CAST(5 AS Numeric(18, 0)), N'Mạng máy tính ')
INSERT [dbo].[Category] ([CateID], [CateName]) VALUES (CAST(6 AS Numeric(18, 0)), N'')
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
SET IDENTITY_INSERT [dbo].[GroupBook] ON 

INSERT [dbo].[GroupBook] ([GroupBookID], [GroupBookName]) VALUES (1, N'Chuyên ngành CNTT ')
INSERT [dbo].[GroupBook] ([GroupBookID], [GroupBookName]) VALUES (2, N'Đại cương ')
INSERT [dbo].[GroupBook] ([GroupBookID], [GroupBookName]) VALUES (3, N'Kĩ năng mềm ')
SET IDENTITY_INSERT [dbo].[GroupBook] OFF
GO
SET IDENTITY_INSERT [dbo].[Librarian] ON 

INSERT [dbo].[Librarian] ([AccID], [NameAcc], [PassAcc], [NameUser], [Email], [PhoneNum]) VALUES (CAST(1 AS Numeric(18, 0)), 20183772, N'123', N'khang', N'khang.nv@gmail.com', N'0123456789')
INSERT [dbo].[Librarian] ([AccID], [NameAcc], [PassAcc], [NameUser], [Email], [PhoneNum]) VALUES (CAST(2 AS Numeric(18, 0)), 20183766, N'123', N'huy', N'huy.dq@gmail.com', N'0987666888')
INSERT [dbo].[Librarian] ([AccID], [NameAcc], [PassAcc], [NameUser], [Email], [PhoneNum]) VALUES (CAST(3 AS Numeric(18, 0)), 20183780, N'123', N'lâm', N'lam.lh@gmail.com', N'0888666888')
INSERT [dbo].[Librarian] ([AccID], [NameAcc], [PassAcc], [NameUser], [Email], [PhoneNum]) VALUES (CAST(4 AS Numeric(18, 0)), 2, N'123', N'Nguy?n A', N'a@gmail.com', N'0123654987')
SET IDENTITY_INSERT [dbo].[Librarian] OFF
GO
SET IDENTITY_INSERT [dbo].[Publisher] ON 

INSERT [dbo].[Publisher] ([PubID], [PubName]) VALUES (1, N'NXB Bách Khoa')
INSERT [dbo].[Publisher] ([PubID], [PubName]) VALUES (2, N'NXB ĐHQG')
INSERT [dbo].[Publisher] ([PubID], [PubName]) VALUES (3, N'NXB Giáo dục')
INSERT [dbo].[Publisher] ([PubID], [PubName]) VALUES (4, N'NXB Kim Đồng')
SET IDENTITY_INSERT [dbo].[Publisher] OFF
GO
SET IDENTITY_INSERT [dbo].[Reader] ON 

INSERT [dbo].[Reader] ([ReaderID], [NameAcc], [PassAcc], [NameUser], [Email], [PhoneNum], [MaxBook], [BookBorrow], [DateReader], [StatusReader], [Remain]) VALUES (CAST(1 AS Numeric(18, 0)), 20183772, N'123', N'khang', N'khang.nv@gmail.com', N'0999888777', 10, 3, CAST(N'2021-08-17T00:00:00.000' AS DateTime), 1, 90)
INSERT [dbo].[Reader] ([ReaderID], [NameAcc], [PassAcc], [NameUser], [Email], [PhoneNum], [MaxBook], [BookBorrow], [DateReader], [StatusReader], [Remain]) VALUES (CAST(2 AS Numeric(18, 0)), 20183766, N'123', N'huy', N'huy.dq@gmail.com', N'0888999777', 15, 3, CAST(N'2021-08-16T00:00:00.000' AS DateTime), 1, 20)
INSERT [dbo].[Reader] ([ReaderID], [NameAcc], [PassAcc], [NameUser], [Email], [PhoneNum], [MaxBook], [BookBorrow], [DateReader], [StatusReader], [Remain]) VALUES (CAST(3 AS Numeric(18, 0)), 20183780, N'123', N'Lương Hoàng Lâm', N'lam.lh@gmail.com', N'0999666888', 10, 1, CAST(N'2021-08-15T00:00:00.000' AS DateTime), 0, 30)
INSERT [dbo].[Reader] ([ReaderID], [NameAcc], [PassAcc], [NameUser], [Email], [PhoneNum], [MaxBook], [BookBorrow], [DateReader], [StatusReader], [Remain]) VALUES (CAST(4 AS Numeric(18, 0)), 2018372, N'123', N'khang1', N'kk@gmail.com', N'0999999999', 10, 2, CAST(N'2021-07-10T00:00:00.000' AS DateTime), 1, 60)
INSERT [dbo].[Reader] ([ReaderID], [NameAcc], [PassAcc], [NameUser], [Email], [PhoneNum], [MaxBook], [BookBorrow], [DateReader], [StatusReader], [Remain]) VALUES (CAST(5 AS Numeric(18, 0)), 2018373, N'123', N'khang2', N'kk@gmail.com', N'0999999999', 5, 5, CAST(N'2021-08-15T00:00:00.000' AS DateTime), 1, 30)
SET IDENTITY_INSERT [dbo].[Reader] OFF
GO
SET IDENTITY_INSERT [dbo].[StaffLib] ON 

INSERT [dbo].[StaffLib] ([AccID], [NameAcc], [PassAcc], [NameUser], [Email], [PhoneNum]) VALUES (CAST(2 AS Numeric(18, 0)), 20183772, N'123', N'khang', N'khang@gmail.com', N'0999999999')
INSERT [dbo].[StaffLib] ([AccID], [NameAcc], [PassAcc], [NameUser], [Email], [PhoneNum]) VALUES (CAST(4 AS Numeric(18, 0)), 2, N'123', N'Phạm Văn B ', N'b@gmail.com', N'0123654987')
INSERT [dbo].[StaffLib] ([AccID], [NameAcc], [PassAcc], [NameUser], [Email], [PhoneNum]) VALUES (CAST(5 AS Numeric(18, 0)), 23, N'123', N'Phạm Văn B', N'b@gmail.com', N'0123654789')
INSERT [dbo].[StaffLib] ([AccID], [NameAcc], [PassAcc], [NameUser], [Email], [PhoneNum]) VALUES (CAST(6 AS Numeric(18, 0)), 23, N'123', N'Phạm Văn B', N'b@gmail.com', N'0123654789')
INSERT [dbo].[StaffLib] ([AccID], [NameAcc], [PassAcc], [NameUser], [Email], [PhoneNum]) VALUES (CAST(7 AS Numeric(18, 0)), 20183775, N'123', N'Nguyễn Văn Khang', N'ggg@gmail.com', N'012222222')
SET IDENTITY_INSERT [dbo].[StaffLib] OFF
GO
SET IDENTITY_INSERT [dbo].[Ticket] ON 

INSERT [dbo].[Ticket] ([TicketID], [ReaderID], [BookID], [StatusTicket], [DateBorrow], [DatePay], [deadline]) VALUES (CAST(4 AS Numeric(18, 0)), CAST(1 AS Numeric(18, 0)), CAST(4 AS Numeric(18, 0)), 0, CAST(N'2021-08-10T00:00:00.000' AS DateTime), NULL, CAST(N'2021-08-28T00:00:00.000' AS DateTime))
INSERT [dbo].[Ticket] ([TicketID], [ReaderID], [BookID], [StatusTicket], [DateBorrow], [DatePay], [deadline]) VALUES (CAST(7 AS Numeric(18, 0)), CAST(4 AS Numeric(18, 0)), CAST(2 AS Numeric(18, 0)), 1, CAST(N'2021-08-11T00:00:00.000' AS DateTime), NULL, CAST(N'2021-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[Ticket] ([TicketID], [ReaderID], [BookID], [StatusTicket], [DateBorrow], [DatePay], [deadline]) VALUES (CAST(8 AS Numeric(18, 0)), CAST(3 AS Numeric(18, 0)), CAST(6 AS Numeric(18, 0)), 1, CAST(N'2021-08-06T00:00:00.000' AS DateTime), NULL, CAST(N'2021-08-29T00:00:00.000' AS DateTime))
INSERT [dbo].[Ticket] ([TicketID], [ReaderID], [BookID], [StatusTicket], [DateBorrow], [DatePay], [deadline]) VALUES (CAST(9 AS Numeric(18, 0)), CAST(1 AS Numeric(18, 0)), CAST(6 AS Numeric(18, 0)), 1, CAST(N'2021-08-12T00:00:00.000' AS DateTime), NULL, CAST(N'2021-08-19T00:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[Ticket] OFF
GO
ALTER TABLE [dbo].[Book]  WITH CHECK ADD  CONSTRAINT [FK_Book_Category] FOREIGN KEY([CateID])
REFERENCES [dbo].[Category] ([CateID])
GO
ALTER TABLE [dbo].[Book] CHECK CONSTRAINT [FK_Book_Category]
GO
ALTER TABLE [dbo].[Book]  WITH CHECK ADD  CONSTRAINT [FK_Book_GroupBook] FOREIGN KEY([GroupBookID])
REFERENCES [dbo].[GroupBook] ([GroupBookID])
GO
ALTER TABLE [dbo].[Book] CHECK CONSTRAINT [FK_Book_GroupBook]
GO
ALTER TABLE [dbo].[Book]  WITH CHECK ADD  CONSTRAINT [FK_Book_Publisher] FOREIGN KEY([PubID])
REFERENCES [dbo].[Publisher] ([PubID])
GO
ALTER TABLE [dbo].[Book] CHECK CONSTRAINT [FK_Book_Publisher]
GO
ALTER TABLE [dbo].[Ticket]  WITH CHECK ADD  CONSTRAINT [FK_Ticket_Book] FOREIGN KEY([BookID])
REFERENCES [dbo].[Book] ([BookID])
GO
ALTER TABLE [dbo].[Ticket] CHECK CONSTRAINT [FK_Ticket_Book]
GO
ALTER TABLE [dbo].[Ticket]  WITH CHECK ADD  CONSTRAINT [FK_Ticket_Reader] FOREIGN KEY([ReaderID])
REFERENCES [dbo].[Reader] ([ReaderID])
GO
ALTER TABLE [dbo].[Ticket] CHECK CONSTRAINT [FK_Ticket_Reader]
GO
USE [master]
GO
ALTER DATABASE [Quan_ly_thu_vien_1] SET  READ_WRITE 
GO

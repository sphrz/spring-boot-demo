/*
 Navicat Premium Data Transfer

 Source Server         : [SQL Server]127.0.0.1
 Source Server Type    : SQL Server
 Source Server Version : 14001000
 Source Host           : 127.0.0.1:1433
 Source Catalog        : xsk_demo_local
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 14001000
 File Encoding         : 65001

 Date: 11/09/2020 14:30:24
*/


-- ----------------------------
-- Table structure for datasource_config
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[datasource_config]') AND type IN ('U'))
	DROP TABLE [dbo].[datasource_config]
GO

CREATE TABLE [dbo].[datasource_config] (
  [id] varchar(36) COLLATE Chinese_PRC_CS_AS_WS  NOT NULL,
  [host] varchar(100) COLLATE Chinese_PRC_CS_AS_WS  NULL,
  [port] varchar(100) COLLATE Chinese_PRC_CS_AS_WS  NULL,
  [username] varchar(100) COLLATE Chinese_PRC_CS_AS_WS  NULL,
  [password] varchar(100) COLLATE Chinese_PRC_CS_AS_WS  NULL,
  [db_name] varchar(200) COLLATE Chinese_PRC_CS_AS_WS  NULL
)
GO

ALTER TABLE [dbo].[datasource_config] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'主键ID',
'SCHEMA', N'dbo',
'TABLE', N'datasource_config',
'COLUMN', N'id'
GO

EXEC sp_addextendedproperty
'MS_Description', N'数据库地址',
'SCHEMA', N'dbo',
'TABLE', N'datasource_config',
'COLUMN', N'host'
GO

EXEC sp_addextendedproperty
'MS_Description', N'数据库端口',
'SCHEMA', N'dbo',
'TABLE', N'datasource_config',
'COLUMN', N'port'
GO

EXEC sp_addextendedproperty
'MS_Description', N'数据库用户名',
'SCHEMA', N'dbo',
'TABLE', N'datasource_config',
'COLUMN', N'username'
GO

EXEC sp_addextendedproperty
'MS_Description', N'数据库密码',
'SCHEMA', N'dbo',
'TABLE', N'datasource_config',
'COLUMN', N'password'
GO

EXEC sp_addextendedproperty
'MS_Description', N'数据库名称',
'SCHEMA', N'dbo',
'TABLE', N'datasource_config',
'COLUMN', N'db_name'
GO


-- ----------------------------
-- Records of datasource_config
-- ----------------------------
INSERT INTO [dbo].[datasource_config]  VALUES (N'10000000-0000-0000-0000-000000000001', N'127.0.0.1', N'1433', N'sa', N'sasa', N'xsk_demo_local_01')
GO


-- ----------------------------
-- Primary Key structure for table datasource_config
-- ----------------------------
ALTER TABLE [dbo].[datasource_config] ADD CONSTRAINT [PK__datasour__3213E83F27AD90E2] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
ON [PRIMARY]
GO


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

 Date: 11/09/2020 14:31:14
*/


-- ----------------------------
-- Table structure for test_user
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[test_user]') AND type IN ('U'))
	DROP TABLE [dbo].[test_user]
GO

CREATE TABLE [dbo].[test_user] (
  [id] varchar(36) COLLATE Chinese_PRC_CS_AS_WS  NOT NULL,
  [name] varchar(255) COLLATE Chinese_PRC_CS_AS_WS  NULL
)
GO

ALTER TABLE [dbo].[test_user] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of test_user
-- ----------------------------
INSERT INTO [dbo].[test_user]  VALUES (N'1', N'master-user')
GO

INSERT INTO [dbo].[test_user]  VALUES (N'2', N'master-user')
GO


-- ----------------------------
-- Primary Key structure for table test_user
-- ----------------------------
ALTER TABLE [dbo].[test_user] ADD CONSTRAINT [PK__user__3213E83F28AFA377] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
ON [PRIMARY]
GO


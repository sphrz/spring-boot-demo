CREATE TABLE [dbo].[datasource_config] (
  [id] varchar(36) COLLATE Chinese_PRC_CS_AS_WS  NOT NULL,
  [host] varchar(100) COLLATE Chinese_PRC_CS_AS_WS  NULL,
  [port] varchar(100) COLLATE Chinese_PRC_CS_AS_WS  NULL,
  [username] varchar(100) COLLATE Chinese_PRC_CS_AS_WS  NULL,
  [password] varchar(100) COLLATE Chinese_PRC_CS_AS_WS  NULL,
  [db_name] varchar(200) COLLATE Chinese_PRC_CS_AS_WS  NULL,
  CONSTRAINT [PK__datasour__3213E83F27AD90E2] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
ON [PRIMARY]
)
ON [PRIMARY]
GO

ALTER TABLE [dbo].[datasource_config] SET (LOCK_ESCALATION = TABLE)

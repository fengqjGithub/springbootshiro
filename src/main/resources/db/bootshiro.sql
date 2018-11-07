/*
Navicat SQL Server Data Transfer

Source Server         : localhostsqlserver
Source Server Version : 105000
Source Host           : localhost:1433
Source Database       : gktj
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 105000
File Encoding         : 65001

Date: 2018-11-07 16:08:59
*/


-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE [dbo].[sys_permission]
GO
CREATE TABLE [dbo].[sys_permission] (
[id] int NOT NULL ,
[parentId] int NOT NULL DEFAULT ((0)) ,
[name] varchar(50) NOT NULL ,
[css] varchar(30) NULL DEFAULT NULL ,
[href] varchar(1000) NULL DEFAULT NULL ,
[pertype] int NOT NULL DEFAULT ((0)) ,
[permission] varchar(50) NULL DEFAULT NULL ,
[sort] int NOT NULL DEFAULT ((0)) 
)


GO

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'1', N'0', N'用户管理', N'fa-users', N'pages/user/userList.html', N'1', N'', N'1')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'2', N'1', N'用户查询', N'fa-user', N'pages/user/userList.html', N'1', N'', N'2')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'3', N'2', N'查询', N'', N'', N'2', N'sys:user:query', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'4', N'2', N'新增', N'', N'', N'2', N'sys:user:add', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'6', N'0', N'修改密码', N'fa-pencil-square-o', N'pages/user/changePassword.html', N'1', N'sys:user:password', N'4')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'7', N'0', N'系统设置', N'fa-gears', N'', N'1', N'', N'5')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'8', N'7', N'菜单', N'fa-cog', N'pages/menu/menuList.html', N'1', N'', N'6')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'9', N'8', N'查询', N'', N'', N'2', N'sys:menu:query', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'10', N'8', N'新增', N'', N'', N'2', N'sys:menu:add', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'11', N'8', N'删除', N'', N'', N'2', N'sys:menu:del', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'12', N'7', N'角色', N'fa-user-secret', N'pages/role/roleList.html', N'1', N'', N'7')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'13', N'12', N'查询', N'', N'', N'2', N'sys:role:query', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'14', N'12', N'新增', N'', N'', N'2', N'sys:role:add', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'15', N'12', N'删除', N'', N'', N'2', N'sys:role:del', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'16', N'0', N'文件管理', N'fa-folder-open', N'pages/file/fileList.html', N'1', N'', N'8')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'17', N'16', N'查询', N'', N'', N'2', N'sys:file:query', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'18', N'16', N'删除', N'', N'', N'2', N'sys:file:del', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'19', N'0', N'数据源监控', N'fa-eye', N'druid/index.html', N'1', N'', N'9')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'20', N'0', N'接口swagger', N'fa-file-pdf-o', N'swagger-ui.html', N'1', N'', N'10')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'21', N'0', N'代码生成', N'fa-wrench', N'pages/generate/edit.html', N'1', N'generate:edit', N'11')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'22', N'0', N'公告管理', N'fa-book', N'pages/notice/noticeList.html', N'1', N'', N'12')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'23', N'22', N'查询', N'', N'', N'2', N'notice:query', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'24', N'22', N'添加', N'', N'', N'2', N'notice:add', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'25', N'22', N'删除', N'', N'', N'2', N'notice:del', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'26', N'0', N'日志查询', N'fa-reorder', N'pages/log/logList.html', N'1', N'sys:log:query', N'13')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'27', N'0', N'邮件管理', N'fa-envelope', N'pages/mail/mailList.html', N'1', N'', N'14')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'28', N'27', N'发送邮件', N'', N'', N'2', N'mail:send', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'29', N'27', N'查询', N'', N'', N'2', N'mail:all:query', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'30', N'0', N'定时任务管理', N'fa-tasks', N'pages/job/jobList.html', N'1', N'', N'15')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'31', N'30', N'查询', N'', N'', N'2', N'job:query', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'32', N'30', N'新增', N'', N'', N'2', N'job:add', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'33', N'30', N'删除', N'', N'', N'2', N'job:del', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'34', N'0', N'excel导出', N'fa-arrow-circle-down', N'pages/excel/sql.html', N'1', N'', N'16')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'35', N'34', N'导出', N'', N'', N'2', N'excel:down', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'36', N'34', N'页面显示数据', N'', N'', N'2', N'excel:show:datas', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'37', N'0', N'字典管理', N'fa-reddit', N'pages/dict/dictList.html', N'1', N'', N'17')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'38', N'37', N'查询', N'', N'', N'2', N'dict:query', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'39', N'37', N'新增', N'', N'', N'2', N'dict:add', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'40', N'37', N'删除', N'', N'', N'2', N'dict:del', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'41', N'37', N'测试1', N'', N'/test188', N'2', N'test:test1', N'100')
GO
GO
INSERT INTO [dbo].[sys_permission] ([id], [parentId], [name], [css], [href], [pertype], [permission], [sort]) VALUES (N'42', N'37', N'测试2', N'', N'/test288888', N'2', N'test:test2', N'100')
GO
GO

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE [dbo].[sys_role]
GO
CREATE TABLE [dbo].[sys_role] (
[id] int NOT NULL ,
[name] varchar(50) NOT NULL ,
[roledescription] varchar(100) NULL DEFAULT NULL ,
[createTime] datetime NOT NULL ,
[updateTime] datetime NOT NULL 
)


GO

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO [dbo].[sys_role] ([id], [name], [roledescription], [createTime], [updateTime]) VALUES (N'1', N'ADMIN', N'管理员', N'2017-05-01 13:25:39.000', N'2017-10-05 21:59:18.000')
GO
GO
INSERT INTO [dbo].[sys_role] ([id], [name], [roledescription], [createTime], [updateTime]) VALUES (N'2', N'USER', N'', N'2017-08-01 21:47:31.000', N'2017-10-05 21:59:26.000')
GO
GO

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE [dbo].[sys_role_permission]
GO
CREATE TABLE [dbo].[sys_role_permission] (
[roleId] int NOT NULL ,
[permissionId] int NOT NULL 
)


GO

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'1')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'2')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'3')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'4')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'6')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'7')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'8')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'9')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'10')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'11')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'12')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'13')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'14')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'15')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'16')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'17')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'18')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'19')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'20')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'21')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'22')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'23')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'24')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'25')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'26')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'27')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'28')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'29')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'30')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'31')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'32')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'33')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'34')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'35')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'36')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'37')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'38')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'39')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'1', N'40')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'1')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'2')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'3')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'4')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'6')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'7')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'8')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'9')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'10')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'11')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'12')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'13')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'14')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'15')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'16')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'17')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'18')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'19')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'20')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'21')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'22')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'23')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'24')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'25')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'30')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'31')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'34')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'36')
GO
GO
INSERT INTO [dbo].[sys_role_permission] ([roleId], [permissionId]) VALUES (N'2', N'41')
GO
GO

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE [dbo].[sys_role_user]
GO
CREATE TABLE [dbo].[sys_role_user] (
[userId] int NOT NULL ,
[roleId] int NOT NULL 
)


GO

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO [dbo].[sys_role_user] ([userId], [roleId]) VALUES (N'1', N'1')
GO
GO
INSERT INTO [dbo].[sys_role_user] ([userId], [roleId]) VALUES (N'2', N'2')
GO
GO

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE [dbo].[sys_user]
GO
CREATE TABLE [dbo].[sys_user] (
[id] int NOT NULL ,
[username] varchar(50) NOT NULL ,
[password] varchar(32) NOT NULL ,
[salt] varchar(32) NOT NULL ,
[nickname] varchar(255) NULL DEFAULT NULL ,
[headImgUrl] varchar(255) NULL DEFAULT NULL ,
[phone] varchar(11) NULL DEFAULT NULL ,
[telephone] varchar(30) NULL DEFAULT NULL ,
[email] varchar(50) NULL DEFAULT NULL ,
[birthday] date NULL DEFAULT NULL ,
[sex] int NULL DEFAULT NULL ,
[status] int NOT NULL DEFAULT ('1') ,
[createTime] datetime NOT NULL ,
[updateTime] datetime NOT NULL 
)


GO

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO [dbo].[sys_user] ([id], [username], [password], [salt], [nickname], [headImgUrl], [phone], [telephone], [email], [birthday], [sex], [status], [createTime], [updateTime]) VALUES (N'1', N'admin', N'1015ed3b5f1345911198c995f9ad097e', N'87e03afa1f0122531f729c9a7453f475', N'管理员', null, N'', N'', N'', N'1998-07-01', N'0', N'1', N'2017-04-10 15:21:38.000', N'2017-07-06 09:20:19.000')
GO
GO
INSERT INTO [dbo].[sys_user] ([id], [username], [password], [salt], [nickname], [headImgUrl], [phone], [telephone], [email], [birthday], [sex], [status], [createTime], [updateTime]) VALUES (N'2', N'user', N'72c2e62dba72e5f178542313803f33d1', N'143292269df8c63e2da1a9ba2aeff43c', N'用户', null, N'', N'', N'', null, N'1', N'1', N'2017-08-01 21:47:18.000', N'2017-08-01 21:47:18.000')
GO
GO

-- ----------------------------
-- Table structure for sysdiagrams
-- ----------------------------
DROP TABLE [dbo].[sysdiagrams]
GO
CREATE TABLE [dbo].[sysdiagrams] (
[name] sysname NOT NULL ,
[principal_id] int NOT NULL ,
[diagram_id] int NOT NULL IDENTITY(1,1) ,
[version] int NULL ,
[definition] varbinary(MAX) NULL 
)


GO

-- ----------------------------
-- Records of sysdiagrams
-- ----------------------------
SET IDENTITY_INSERT [dbo].[sysdiagrams] ON
GO
SET IDENTITY_INSERT [dbo].[sysdiagrams] OFF
GO

-- ----------------------------
-- Indexes structure for table sys_permission
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table sys_permission
-- ----------------------------
ALTER TABLE [dbo].[sys_permission] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table sys_role
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table sys_role
-- ----------------------------
ALTER TABLE [dbo].[sys_role] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table sys_role_permission
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table sys_role_permission
-- ----------------------------
ALTER TABLE [dbo].[sys_role_permission] ADD PRIMARY KEY ([roleId], [permissionId])
GO

-- ----------------------------
-- Indexes structure for table sys_role_user
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table sys_role_user
-- ----------------------------
ALTER TABLE [dbo].[sys_role_user] ADD PRIMARY KEY ([userId], [roleId])
GO

-- ----------------------------
-- Indexes structure for table sys_user
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE [dbo].[sys_user] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table sysdiagrams
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table sysdiagrams
-- ----------------------------
ALTER TABLE [dbo].[sysdiagrams] ADD PRIMARY KEY ([diagram_id])
GO

-- ----------------------------
-- Uniques structure for table sysdiagrams
-- ----------------------------
ALTER TABLE [dbo].[sysdiagrams] ADD UNIQUE ([principal_id] ASC, [name] ASC)
GO

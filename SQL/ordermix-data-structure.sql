/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : ordermix

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 16/05/2023 15:11:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(0) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contact_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'hjy', '123', '大肚腩妹妹', '13579246811');
INSERT INTO `admin` VALUES (4, 'ljs', '123', '我爱打码', '12345678901');
INSERT INTO `admin` VALUES (5, 'ljh', '123', '无言的靓仔', '12345678998');
INSERT INTO `admin` VALUES (6, 'slw', '123', '没良心狗狗', NULL);
INSERT INTO `admin` VALUES (7, 'sxp', '123', '百宝袋被狗叼走了', NULL);
INSERT INTO `admin` VALUES (8, 'xjy', '123', '草莓味腊肉', NULL);

-- ----------------------------
-- Table structure for adshow
-- ----------------------------
DROP TABLE IF EXISTS `adshow`;
CREATE TABLE `adshow`  (
  `ad_id` int(0) NOT NULL,
  `ad_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ad_src` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ad_introduce` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ad_adminId` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`ad_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of adshow
-- ----------------------------
INSERT INTO `adshow` VALUES (1, '你有生之年见过的最优秀做作品', 'http://pic1.win4000.com/wallpaper/5/5565394b138e0_270_185.jpg', '全体成员呕心沥血历时100天惊天地作品，全学院无人超越。', 5);
INSERT INTO `adshow` VALUES (2, '登上学院展板的海报', 'https://ai.bdstatic.com/file/81FA641137F740F5849BC6FC1FD19984', '学院领导眼睛都瞎了', 5);
INSERT INTO `adshow` VALUES (3, '引领学院新风潮', 'https://5b0988e595225.cdn.sohucs.com/q_70,c_zoom,w_640/images/20200225/19d17e39309047c48e022091b982e497.jpeg', '哦', 5);
INSERT INTO `adshow` VALUES (4, '北苑下雪了', 'https://ss0.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3687837806,645327575&fm=15&gp=0.jpg', '', 5);

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`  (
  `item_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `finished_time` datetime(0) NULL DEFAULT NULL,
  `item_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `requirement` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `refuse_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contact_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contact_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_id` int(0) NULL DEFAULT NULL,
  `item_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `upload_address` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `download_address` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `item_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES (11, 1, '2022-03-09 12:41:19', '3922-10-20 00:00:00', NULL, 'ppt', '我想要精美的ppt', '185125', '小花', '13524855484', 1, 'refused', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', NULL, NULL);
INSERT INTO `item` VALUES (12, 1, '2022-03-09 12:41:20', '3922-10-20 00:00:00', '2022-04-01 02:10:33', 'ppt', '我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt', NULL, '小花', '13524855484', 1, 'finished', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', 'https://public-read-miracle-happen-bucket.oss-cn-guangzhou.aliyuncs.com/topavatar164874706085822077351228.png', NULL);
INSERT INTO `item` VALUES (13, 1, '2022-03-09 12:41:20', '3922-10-20 00:00:00', '2022-04-01 02:05:05', 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', 1, 'finished', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', 'https://public-read-miracle-happen-bucket.oss-cn-guangzhou.aliyuncs.com/Default16487291785659982248458.jpg', NULL);
INSERT INTO `item` VALUES (14, 1, '2022-03-09 12:41:20', '3922-10-20 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', 1, 'toBeFinished', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', NULL, NULL);
INSERT INTO `item` VALUES (15, 1, '2022-03-09 12:41:20', '3922-10-20 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', 4, 'toBeFinished', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', NULL, NULL);
INSERT INTO `item` VALUES (16, 1, '2022-03-09 12:41:20', '3922-10-20 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', NULL, NULL);
INSERT INTO `item` VALUES (17, 1, '2022-03-09 12:41:20', '3922-10-20 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', 4, 'toBeFinished', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', NULL, NULL);
INSERT INTO `item` VALUES (18, 1, '2022-03-09 12:41:20', '3922-10-20 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', NULL, NULL);
INSERT INTO `item` VALUES (19, 1, '2022-03-09 12:41:20', '3922-10-20 00:00:00', '2022-03-10 16:35:06', 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', 5, 'finished', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', 'www.baidu.com', NULL);
INSERT INTO `item` VALUES (20, 1, '2022-03-09 12:41:21', '3922-10-20 00:00:00', '2022-03-11 16:35:15', 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', 5, 'finished', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', 'www.baidu.com', NULL);
INSERT INTO `item` VALUES (21, 1, '2022-03-09 12:42:40', '1990-06-23 00:00:00', '2022-04-17 13:49:26', 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', 4, 'finished', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', 'https://public-read-miracle-happen-bucket.oss-cn-guangzhou.aliyuncs.com/Default165029059886397595998571.zip', NULL);
INSERT INTO `item` VALUES (22, 1, '2022-03-09 12:42:40', '1990-06-23 00:00:00', '2022-03-11 16:35:04', 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', 5, 'finished', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', 'www.baidu.com', NULL);
INSERT INTO `item` VALUES (23, 1, '2022-03-09 12:42:40', '1990-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', NULL, NULL);
INSERT INTO `item` VALUES (24, 1, '2022-03-09 12:42:40', '1990-06-23 00:00:00', '2022-03-11 16:35:05', 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', 5, 'finished', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', 'www.baidu.com', NULL);
INSERT INTO `item` VALUES (25, 1, '2022-03-09 12:42:40', '1990-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', NULL, NULL);
INSERT INTO `item` VALUES (26, 1, '2022-03-09 12:42:41', '1990-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', NULL, NULL);
INSERT INTO `item` VALUES (27, 1, '2022-03-09 12:42:41', '1990-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', NULL, NULL);
INSERT INTO `item` VALUES (28, 1, '2022-03-09 12:42:41', '1990-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', NULL, NULL);
INSERT INTO `item` VALUES (29, 1, '2022-03-09 12:42:41', '1990-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', NULL, NULL);
INSERT INTO `item` VALUES (30, 1, '2022-03-09 12:42:41', '1990-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx', NULL, NULL);
INSERT INTO `item` VALUES (31, 1, '2022-03-11 11:42:40', '2050-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'fileAddress', 'g', NULL);
INSERT INTO `item` VALUES (32, 1, '2022-03-11 11:42:41', '2050-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'fileAddress', 'g', NULL);
INSERT INTO `item` VALUES (33, 1, '2022-03-11 11:42:41', '2050-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'fileAddress', 'g', NULL);
INSERT INTO `item` VALUES (34, 1, '2022-03-11 11:42:41', '2050-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'fileAddress', 'g', NULL);
INSERT INTO `item` VALUES (35, 1, '2022-03-11 11:42:41', '2050-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'fileAddress', 'g', NULL);
INSERT INTO `item` VALUES (36, 1, '2022-03-11 11:42:41', '2050-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'fileAddress', 'g', NULL);
INSERT INTO `item` VALUES (37, 1, '2022-03-11 11:42:42', '2050-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'fileAddress', 'g', NULL);
INSERT INTO `item` VALUES (38, 1, '2022-03-11 11:42:42', '2050-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'fileAddress', 'g', NULL);
INSERT INTO `item` VALUES (39, 1, '2022-03-11 11:42:42', '2050-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'toBeSolved', 'fileAddress', 'g', NULL);
INSERT INTO `item` VALUES (40, 1, '2022-03-11 11:42:42', '2050-06-23 00:00:00', NULL, 'ppt', '我想要精美的ppt', NULL, '小花', '13524855484', NULL, 'finished', 'fileAddress', 'g', NULL);
INSERT INTO `item` VALUES (41, 7, '2022-04-02 09:27:54', '2022-03-22 00:00:00', NULL, '海报', 'asdsaddasdaxcaschsad', NULL, 'asdasdss', '123456789dd', NULL, 'refused', '', NULL, '项目名0');
INSERT INTO `item` VALUES (42, 7, '2022-04-11 09:27:49', '2022-04-08 00:00:00', NULL, '海报', '具体需求具体需求具体需求具体需求具体需求具体需求具体需求具体需求具体需求具体需求具体需求', NULL, '颤三', '13254168584984125+6', NULL, 'toBeSolved', 'https://pingke.oss-cn-guangzhou.aliyuncs.com/2022-03-31/2d2d8502-b4e5-4604-862c-8a08d9492800_p139016.png', NULL, '项目名');
INSERT INTO `item` VALUES (43, 7, '2022-04-09 09:27:45', '2022-04-08 00:00:00', NULL, '海报', '具体需求具体需求具体需求具体需求具体需求具体需求具体需求具体需求具体需求具体需求具体需求具体需求具体需求具体需求', NULL, '颤三', '13254168584984125+6', NULL, 'toBeFinished', 'https://pingke.oss-cn-guangzhou.aliyuncs.com/2022-03-31/2d2d8502-b4e5-4604-862c-8a08d9492800_p139016.png', NULL, '项目名');
INSERT INTO `item` VALUES (44, 7, '2022-04-20 09:27:39', '2022-04-08 00:00:00', NULL, 'PPT', '需求itemNameitemNameitemNameitemNamesacs', NULL, '6a5s4cv163a5s536c52', '123456789', NULL, 'toBeSolved', 'https://pingke.oss-cn-guangzhou.aliyuncs.com/2022-03-31/b556e52d-10b3-435c-8edf-b7233be51653_p139016.png', NULL, '测试2');
INSERT INTO `item` VALUES (45, 7, '2022-03-31 21:04:27', '2022-04-07 00:00:00', NULL, '其他', '不要停下来啊团长不要停下来啊团长不要停下来啊团长不要停下来啊团长不要停下来啊团长不要停下来啊团长不要停下来啊团长不要停下来啊团长不要停下来啊团长不要停下来啊团长不要停下来啊团长奥尔加', NULL, '张三', '3521651', NULL, 'finished', 'https://pingke.oss-cn-guangzhou.aliyuncs.com/2022-03-31/73302872-c382-46cf-884a-8c72e46204a0_topavatar.png', NULL, 'ceshiasd');
INSERT INTO `item` VALUES (46, 7, '2022-03-31 21:19:04', '2022-04-08 00:00:00', NULL, '海报', '不要停下来啊不要停下来啊不要停下来啊不要停下来啊不要停下来啊不要停下来啊不要停下来啊不要停下来啊不要停下来啊不要停下来啊不要停下来啊不要停下来啊', NULL, '张三', '1387744555', NULL, 'refused', 'https://pingke.oss-cn-guangzhou.aliyuncs.com/2022-03-31/3330e74d-b0d2-4020-8608-d669a6ad2d5d_topavatar.png', NULL, '测试5');
INSERT INTO `item` VALUES (47, 7, '2022-03-31 21:25:18', '2022-04-09 00:00:00', NULL, 'PPT', '按上次不卡斯基不可触及照本宣科', NULL, '爱说大话', '123456789', NULL, 'toBeSolved', 'https://pingke.oss-cn-guangzhou.aliyuncs.com/2022-03-31/745e18f5-57c4-43a2-81b7-d870fda75451_p139016.png', NULL, '测试6');
INSERT INTO `item` VALUES (48, 7, '2022-04-01 10:21:37', '2022-04-20 00:00:00', NULL, 'PPT', 'https://public-read-miracle-happen-bucket.oss-cn-guangzhou.aliyuncs.com/topavatar16487', NULL, '阿斯顿', '2126541', NULL, 'toBeSolved', '', NULL, '实打实的擦拭');
INSERT INTO `item` VALUES (49, 8, '2022-05-10 18:21:44', '2022-05-31 00:00:00', NULL, '海报', '的撒', NULL, '张三', '123456789', NULL, 'toBeSolved', 'https://pingke.oss-cn-guangzhou.aliyuncs.com/2022-05-10/2590ae0d-8df8-41e8-882e-25e5d2268219_SecurityGroupRule_20220504_list.7z', NULL, '我的第一个项目');
INSERT INTO `item` VALUES (50, 7, '2022-05-30 14:40:39', '2022-06-27 00:00:00', NULL, 'PPT', '略略略略略略略略略略略略略略略略略略略略略略略略略略略略略略略略略', NULL, '李四', '13688997564', NULL, 'toBeSolved', 'https://pingke.oss-cn-guangzhou.aliyuncs.com/2022-05-30/a30c68eb-3db1-43ff-8e38-9ee210536c43_191541216_李嘉伟_形势与政策.zip', NULL, '第二轮测试');
INSERT INTO `item` VALUES (51, 7, '2022-05-30 19:11:18', '2022-06-03 00:00:00', NULL, '其他', '巴黎巴拉巴拉巴拉', NULL, '张三', '1985547756', NULL, 'toBeSolved', 'https://pingke.oss-cn-guangzhou.aliyuncs.com/2022-05-30/9d6df9aa-1008-46f9-8ee2-6bbf994764c2_191541216_李嘉伟_形势与政策.zip', NULL, 'item2');
INSERT INTO `item` VALUES (52, 9, '2022-07-08 13:03:32', '2022-07-31 00:00:00', NULL, 'PPT', '', NULL, '王五', '19854556550', NULL, 'toBeSolved', 'https://pingke.oss-cn-guangzhou.aliyuncs.com/2022-07-08/672e96da-ecd3-492b-8197-4e42f32ec55c_简历模板.zip', NULL, '测试项目');
INSERT INTO `item` VALUES (53, 9, '2022-07-08 13:42:44', '2022-07-29 00:00:00', NULL, '海报', '做一个海报', NULL, '往往', '1235495165', NULL, 'toBeSolved', 'https://pingke.oss-cn-guangzhou.aliyuncs.com/2022-07-08/94aaca1e-a83f-44d3-8405-c5fcbb098795_Default.zip', NULL, '项目2');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单名称',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件路径',
  `visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2004 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (2000, '客服', '/service', '', '0', '0', 'customer:service', '#', '', NULL, '', NULL, '');
INSERT INTO `menu` VALUES (2001, '用户列表', '/userList', NULL, '0', '0', 'service:user:list', '#', '', NULL, '', NULL, '');
INSERT INTO `menu` VALUES (2002, '创建项目', '/createItem', NULL, '0', '0', 'customer:create:item', '#', '', NULL, '', NULL, '');
INSERT INTO `menu` VALUES (2003, '项目进度', '/itemProgress', NULL, '0', '0', 'custmer:item:progress', '#', '', NULL, '', NULL, '');
INSERT INTO `menu` VALUES (2004, '我的项目', '/myItem', NULL, '0', '0', 'customer:item:one', '#', '', NULL, '', NULL, '');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色权限字符串',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (100, '客户', 'customer', '0', '', NULL, '', NULL, NULL, '0');
INSERT INTO `role` VALUES (101, '客服', 'service', '0', '', NULL, '', NULL, NULL, '0');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `role_id` bigint(0) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(0) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (100, 2000);
INSERT INTO `role_menu` VALUES (100, 2002);
INSERT INTO `role_menu` VALUES (100, 2003);
INSERT INTO `role_menu` VALUES (100, 2004);
INSERT INTO `role_menu` VALUES (101, 2001);

-- ----------------------------
-- Table structure for rollad
-- ----------------------------
DROP TABLE IF EXISTS `rollad`;
CREATE TABLE `rollad`  (
  `img_id` int(0) NOT NULL AUTO_INCREMENT,
  `img_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`img_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rollad
-- ----------------------------
INSERT INTO `rollad` VALUES (1, 'http://cdn.linjsblog.top/wp-content/uploads/2022/04/滚动图2-2-副本.jpg');
INSERT INTO `rollad` VALUES (2, 'http://cdn.linjsblog.top/wp-content/uploads/2022/04/滚动图3.jpeg');
INSERT INTO `rollad` VALUES (3, 'http://cdn.linjsblog.top/wp-content/uploads/2022/04/滚动图3.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'user1', '$2a$10$nqSdpIDPyrR03cagKylTHeXCBkdtpPj6mOtzwEWk9bEvEuXEdjlAq', '124255', 'wayne', 'http://pingke.linjsblog.top/img/head/default_avatar.png');
INSERT INTO `user` VALUES (3, 'user2', '$2a$10$r4iJqAC6cEpFFCAxvX6r6eerk51J33oLVHUVicJXiTjCGP7Z9n0KO', '191541221', '张三', 'http://pingke.linjsblog.top/img/head/default_avatar.png');
INSERT INTO `user` VALUES (4, 'user5', '$2a$10$gwxMqjmiDZeY0tNhJF2STuQnaKcXN9pesL.VcXkOZTv8ja/Xr9rHa', '191541221', '李四', 'http://pingke.linjsblog.top/img/head/default_avatar.png');
INSERT INTO `user` VALUES (5, 'register-test', '$2a$10$ygZKpAcOkcy9Ca30z5Hr/e1vddjkiasTHHSivZDVsKwtxTUgytPMm', '191541221', '张三', 'http://pingke.linjsblog.top/img/head/default_avatar.png');
INSERT INTO `user` VALUES (6, 'register-test02', '$2a$10$mtasd3dnYlOTf3Y2L0/souAtXTqPzyqGxw/.LTtmZi6rd82Ldp77W', '', '', 'http://pingke.linjsblog.top/img/head/default_avatar.png');
INSERT INTO `user` VALUES (7, 'user-test1', '$2a$10$qLEKD5vpUQWRx3GSKGehleaVTs.b0aJjWyje3zY6qQHWe7X58K.I.', '18666666', '张三', 'http://cdn.linjsblog.top/wp-content/uploads/2022/01/头像01-1.jpg');
INSERT INTO `user` VALUES (8, 'myusertest', '$2a$10$H8scX8h/AtXsewC2murnget9A4kCZ4oWMgReXfZudJvc4GNbpo67S', '1915412', '林敬舒', 'http://pingke.linjsblog.top/img/head/default_avatar.png');
INSERT INTO `user` VALUES (9, 'ljs-user', '$2a$10$OwigZOP4WGx9ZLu0UvA26ubbnUcJ4ipDMZVUR3ap4RCrBwRsci8Oa', '191541219', '林敬舒', 'http://pingke.linjsblog.top/img/head/default_avatar.png');
INSERT INTO `user` VALUES (10, 'user-test03', '$2a$10$N2nBph3A00eZ8awPQyq6U.43hHO1JlNzPlTpZerxo5x0xVpBpZiTm', '191541219', 'huash', 'http://pingke.linjsblog.top/img/head/default_avatar.png');
INSERT INTO `user` VALUES (11, 'user_user', '$2a$10$xvtVBM2oY9bTtxz8jbapvOKaOV3w4mqTnRiLY6LzoGZeYd/7dp1lm', '1915411', 'ljs', 'http://pingke.linjsblog.top/img/head/default_avatar.png');
INSERT INTO `user` VALUES (12, 'user-user', '$2a$10$XEYEFkMtRSAvmYAVDxadnuXX1d6LKF8c57xBujdbF/S8VM3RjVxL2', '19154111', 'sssssss', 'http://pingke.linjsblog.top/img/head/default_avatar.png');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(0) NOT NULL,
  `role_id` bigint(0) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 100);
INSERT INTO `user_role` VALUES (3, 100);
INSERT INTO `user_role` VALUES (4, 100);
INSERT INTO `user_role` VALUES (5, 100);
INSERT INTO `user_role` VALUES (6, 100);
INSERT INTO `user_role` VALUES (7, 100);

SET FOREIGN_KEY_CHECKS = 1;

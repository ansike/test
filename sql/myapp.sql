/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : myapp

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-05-29 11:13:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '书ID',
  `book_name` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '书名字',
  `book_author` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '书的作者',
  `isupdate` timestamp NOT NULL COMMENT '书是否已更新',
  `cover_pic` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '封面',
  `info` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '详情',
  `state` int(5) NOT NULL DEFAULT 1 COMMENT '状态',
  `font_num` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `book_url` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '书籍的默认路径',
  `chapter` int(10) NOT NULL COMMENT '章节名字前面自动补全0，共4位，文件后缀为txt',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '微微一笑很倾城', '顾漫', '2017-03-09 00:00:00.0000', '/static/img/微微一笑很倾城.jpg', '男人对女人一见钟情的是什么？容貌？气质？身家？NO，校园王子+游戏高高手肖奈同学一见微微，钟情的并非她逼人的艳色，而是她那飞舞在键盘上的纤纤玉手和她镇定自若的气势！！！囧掉了吧？同是网游高手的贝微微，彼时彼刻正在电脑前有条不紊地指挥着帮战，打了一场完美的以弱胜强的辉煌战役，完全没意识到爱神小天使近在己侧……随后，篮球游泳全能优等生与游戏公司总策划人等身的肖奈大神开始了网上网下全方位地捕猎美人心……于是，一场爱情，就在一朵花开的时间里，悄然萌生了。', '1', '120万字', '/static/books/0003/', '51');
INSERT INTO `book` VALUES ('2', '何以笙箫默', '顾漫', '2017-03-09 00:00:01.0000', '/static/img/何以笙箫默.jpg', '一段年少时的爱恋，牵出一生的纠缠。大学时代的赵默笙阳光灿烂，对法学系大才子何以琛一见倾心，开朗直率的她拔足倒追，终于使才气出众的他为她停留驻足', '1', '50万字', '/static/books/0002/', '210');
INSERT INTO `book` VALUES ('3', '花千骨', 'Fresh骨骨', '2017-03-09 00:00:01.0000', '/static/img/花千骨.jpg', '瑶池初见，他是高高在上的长留上仙，而她偷偷混入，变作小虫趴在树上，却被风吹落于他的酒盏之中。　“不小心掉下来了吗？”　他的笑淡然而又慈悲，那是她此生唯一一次见到，却是对着一条小虫。', '0', '60万字', '/static/books/0001/', '1653');
INSERT INTO `book` VALUES ('4', '三生三世十里桃花', '唐七公子', '2017-03-09 00:00:01.0000', '/static/img/三生三世十里桃花.jpg', '前世今生系列之一。\r\n你若敢死，我立刻便去找折颜要药水，把你忘得干干净净\r\n他的身子一颤，半晌，扯出一个笑来，他说：那样也好。\r\n他在这世上，留给我的最后一句话是，那样也好。\r\n你有没有爱过一个人？你有没有恨过一个人？\r\n三百年前，诛仙台上的她绝然转身跳下，让铜镜那边的他亲眼见她隔世永别。', '1', '50万字', '/static/books/0001/', '1');
INSERT INTO `book` VALUES ('5', '醉玲珑', '十四夜', '2017-03-09 00:00:01.0000', '/static/img/醉玲珑.jpg', '一个帝王的驾崩之谜，一脉皇族的混乱血统，一件上古巫族的镇族之宝，江湖与庙堂的纷争，是什么原因，偏偏将一个相隔千万年的现代女子卷入其中？', '1', '50万字', '/static/books/0001/', '1');
INSERT INTO `book` VALUES ('6', '特工皇妃楚天传', '潇湘冬儿', '2017-03-09 00:00:01.0000', '/static/img/特工皇妃楚乔传.jpg', '她，是国安局军情11处最为惊才艳绝的王牌军师，收集情报，策划部署，进不友好国家布置暗杀任务，运筹帷幄之中，决胜于千里之外。 \r\n　　堪称军情局威威大厦的定海神针。 \r\n　　他，是大夏皇朝最为才华横溢却又隐忍不发的淡漠藩王，暗中部署，多年筹谋，煌煌盛世之下，到处都隐藏着他的人马暗桩，一朝躁动，百万横尸。堪称帝国上位者的心腹大患。 \r\n　　现代高端特种兵，遭遇奴隶制度的极度压迫。 \r\n　　惊才艳绝燕世子，突奉家破人亡的滔天灾祸。 \r\n　　他们是否该举起刀剑，并肩杀出一条血路？ ', '1', '50万字', '/static/books/0001/', '1');
INSERT INTO `book` VALUES ('7', '欢乐颂', '阿耐', '2017-03-09 00:00:01.0000', '/static/img/欢乐颂.jpg', '在时代里，他和她不期而遇。\r\n在人生里，你和我都是邻居。\r\n悲喜交织的心事，奋斗独立的姿势，破茧成蝶的未知。\r\n五个女人各自携带过往和憧憬先后搬来欢乐颂小区22楼，这样的交集，竟改变了生活的轨迹。\r\n她们齐心协力地解决了安迪的身世之痛的问题、曲筱绡与同父异母的两个哥哥争家产的问题、樊胜美沉重的家庭负担的问题、邱莹莹的有处女情节的男朋友的问题、关睢尔的警察男友是不是在家庭背景上撒了谎的问题……生活虽然一地鸡毛，但仍要欢歌高进，成长之路虽有玫瑰有荆棘，但什么都不能阻挡坚强的心。', '0', '50万字', '/static/books/0001/', '1');
INSERT INTO `book` VALUES ('8', '斗破苍穹', '天蚕土豆', '2017-04-23 18:25:01.0000', '/static/img/斗破苍穹.jpg', '这里是属于斗气的世界,没有花俏艳丽的魔法,有的,仅仅是繁衍到巅峰的斗气!新书等级制度:斗者,斗师,大斗师,斗灵,斗王,斗皇,斗宗,斗尊,斗圣,斗帝。', '1', '1000万字', '/static/books/0001/', '1653');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `tag_id` int(10) NOT NULL AUTO_INCREMENT,
  `tag_value` varchar(225) NOT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT "创建时间",
  `update_by` varchar(20) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新时间",
  `tag_pic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('1', '武侠', 'ask', '2017-04-17 10:01:31', null, '2017-04-17 10:01:31', '/static/img/武侠.jpg');
INSERT INTO `tag` VALUES ('2', '修真', 'ask', '2017-04-17 10:01:26', null, '2017-04-17 10:01:26', '/static/img/修真.jpg');
INSERT INTO `tag` VALUES ('3', '都市', 'ask', '2017-04-17 10:01:21', null, '2017-04-17 10:01:21', '/static/img/都市.jpg');
INSERT INTO `tag` VALUES ('4', '校园', 'ask', '2017-04-17 10:00:28', null, '2017-04-17 10:00:28', '/static/img/校园.jpg');
INSERT INTO `tag` VALUES ('5', '男生', 'ask', '2017-04-17 10:00:43', null, '2017-04-17 10:00:43', '/static/img/男生.jpg');
INSERT INTO `tag` VALUES ('6', '女生', 'ask', '2017-04-17 10:00:36', null, '2017-04-17 10:00:36', '/static/img/女生.jpg');
INSERT INTO `tag` VALUES ('7', '历史', 'ask', '2017-04-17 10:00:50', null, '2017-04-17 10:00:50', '/static/img/历史.jpg');
INSERT INTO `tag` VALUES ('8', '网游', 'ask', '2017-04-17 10:01:15', null, '2017-04-17 10:01:15', '/static/img/网游.jpg');
INSERT INTO `tag` VALUES ('9', '科幻', 'ask', '2017-04-17 10:00:58', null, '2017-04-17 10:00:58', '/static/img/科幻.jpg');
INSERT INTO `tag` VALUES ('10', '推理', 'ask', '2017-04-17 10:01:08', null, '2017-04-17 10:01:08', '/static/img/推理.jpg');

-- ----------------------------
-- Table structure for tag_book
-- ----------------------------
DROP TABLE IF EXISTS `tag_book`;
CREATE TABLE `tag_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `create_by` varchar(25) DEFAULT NULL,
  `create_time` datetime COMMENT "创建时间",
  `update_by` varchar(20) DEFAULT NULL,
  `update_time` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新时间",
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag_book
-- ----------------------------
INSERT INTO `tag_book` VALUES ('1', '5', '1', 'ask', '2017-03-09 15:03:07', null, '2017-03-09 15:03:07');
INSERT INTO `tag_book` VALUES ('2', '5', '2', 'asd', '2017-03-09 15:03:07', null, '2017-03-09 15:03:07');
INSERT INTO `tag_book` VALUES ('3', '5', '3', 'ss', '2017-03-09 15:03:07', null, '2017-03-09 15:03:07');
INSERT INTO `tag_book` VALUES ('4', '5', '4', 'ss', '2017-03-09 15:03:07', null, '2017-03-09 15:03:07');
INSERT INTO `tag_book` VALUES ('5', '5', '5', null, '2017-03-09 15:03:07', null, '2017-03-09 15:03:07');
INSERT INTO `tag_book` VALUES ('6', '6', '6', null, '2017-03-09 15:03:43', null, '2017-03-09 15:03:43');
INSERT INTO `tag_book` VALUES ('7', '6', '7', null, '2017-03-09 15:03:44', null, '2017-03-09 15:03:44');
INSERT INTO `tag_book` VALUES ('8', '6', '8', null, '2017-03-09 15:03:44', null, '2017-03-09 15:03:44');
INSERT INTO `tag_book` VALUES ('9', '6', '9', null, '2017-03-09 15:03:45', null, '2017-03-09 15:03:45');
INSERT INTO `tag_book` VALUES ('10', '6', '10', null, '2017-03-09 15:03:46', null, '2017-03-09 15:03:46');
INSERT INTO `tag_book` VALUES ('11', '1', '1', null, '2017-03-16 15:05:45', null, '2017-03-16 15:05:45');
INSERT INTO `tag_book` VALUES ('12', '2', '1', null, '2017-03-16 15:05:52', null, '2017-03-16 15:05:52');
INSERT INTO `tag_book` VALUES ('13', '1', '3', null, '2017-03-09 15:08:49', null, '2017-03-09 15:08:49');
INSERT INTO `tag_book` VALUES ('14', '4', '6', null, '2017-03-16 14:51:04', null, '2017-03-16 14:51:01');
INSERT INTO `tag_book` VALUES ('15', '4', '7', null, '2017-03-09 15:09:07', null, '2017-03-09 15:09:07');
INSERT INTO `tag_book` VALUES ('16', '4', '8', null, '2017-03-09 15:25:13', null, '2017-03-09 15:25:13');
INSERT INTO `tag_book` VALUES ('17', '1', '6', null, '2017-03-16 14:57:02', null, '2017-03-16 14:57:05');
INSERT INTO `tag_book` VALUES ('18', '2', '8', null, '2017-03-16 14:56:14', null, '2017-03-16 14:56:14');
INSERT INTO `tag_book` VALUES ('19', '3', '8', null, '2017-03-16 14:56:19', null, '2017-03-16 14:56:19');
INSERT INTO `tag_book` VALUES ('20', '1', '7', null, '2017-03-16 14:56:57', null, '2017-03-16 14:57:00');
INSERT INTO `tag_book` VALUES ('21', '2', '2', null, '2017-03-16 15:17:09', null, '2017-03-16 15:17:09');
INSERT INTO `tag_book` VALUES ('22', '3', '4', null, '2017-03-16 15:16:36', null, '2017-03-16 15:16:39');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`userId`,`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('17', '18835112829', '81ED749EC65CEED79F59742615ACEEE6');
INSERT INTO `user` VALUES ('18', '18235833060', '6F3A62B8A981F78753BA6B50CE67E972');

-- ----------------------------
-- Table structure for user_book
-- ----------------------------
DROP TABLE IF EXISTS `user_book`;
CREATE TABLE `user_book` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `book_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `status` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user_book
-- ----------------------------
INSERT INTO `user_book` VALUES ('1', '1', '12', null);
INSERT INTO `user_book` VALUES ('2', '2', '12', null);
INSERT INTO `user_book` VALUES ('3', '3', '12', null);
INSERT INTO `user_book` VALUES ('4', '4', '12', null);
INSERT INTO `user_book` VALUES ('5', '5', '12', null);
INSERT INTO `user_book` VALUES ('6', '6', '12', null);
INSERT INTO `user_book` VALUES ('7', '7', '12', null);

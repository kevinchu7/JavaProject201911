/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50642
Source Host           : localhost:3306
Source Database       : zijinquestionbank

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2019-12-8 15:16:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `aid` varchar(20) NOT NULL,
  `aname` varchar(8) NOT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `pwd` varchar(20) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('000000', '2', '男', '000000', '2', '2', '2019-10-03', '32@qq.com');

-- ----------------------------
-- Table structure for choicequestion
-- ----------------------------
DROP TABLE IF EXISTS `choicequestion`;
CREATE TABLE `choicequestion` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_question` varchar(200) NOT NULL,
  `c_choiceA` varchar(100) NOT NULL,
  `c_choiceB` varchar(100) NOT NULL,
  `c_choiceC` varchar(100) NOT NULL,
  `c_choiceD` varchar(100) NOT NULL,
  `c_answer` varchar(2) NOT NULL,
  `c_subjectid` int(11) NOT NULL,
  PRIMARY KEY (`c_id`),
  KEY `choicequestion_ibfk_1` (`c_subjectid`),
  CONSTRAINT `choicequestion_ibfk_1` FOREIGN KEY (`c_subjectid`) REFERENCES `subject` (`subjectid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of choicequestion
-- ----------------------------
INSERT INTO `choicequestion` VALUES ('85', '增量模型本质是一种？', '线性顺序模型', '整体开发模型', '非整体开发模型', '螺旋模型', 'C', '1');
INSERT INTO `choicequestion` VALUES ('86', '软件过程是？', '特定的开发模型','一种软件求解的计算逻辑','软件开发活动的集合','软件生命周期模型', 'C', '1');
INSERT INTO `choicequestion` VALUES ('87', '软件生命周期模型不包括？', '瀑布模型', '用例模型', '增量模型', '喷泉模型', 'B', '1');
INSERT INTO `choicequestion` VALUES ('88', '包含风险分析的软件工程模型是？', '螺旋模型', '瀑布模型', '增量模型', '喷泉模型', 'A', '1');
INSERT INTO `choicequestion` VALUES ('89', '螺旋模型综合了哪些优点，并增加了风险分析？', '增量模型和喷泉模型', '瀑布模型和快速原型模型', '瀑布模型和喷泉模型', '快速原型和喷泉模型', 'B', '1');
INSERT INTO `choicequestion` VALUES ('90', '下列说法中正确的是？', '20世纪50年代提出了软件工程的概念', '20世纪70年代提出了软件工程概念', '20世纪70年代出现了客户/服务器技术', '20世纪80年代软件工程学科达到成熟', 'B', '1');
INSERT INTO `choicequestion` VALUES ('91', '软件危机的主要原因是？', '软件工具落后', '软件生产能力', '执行严格的产品控制', '软件本身的特点及开发方法', 'D', '1');
INSERT INTO `choicequestion` VALUES ('92', '软件工程的三要素？', '技术方法和工具', '方法对象类', '方法工具过程', '过程模型方法', 'C', '1');
INSERT INTO `choicequestion` VALUES ('93', '下面选下中不属于软件工程学科所研究的基本内容是', '软件工程材料', '软件工程方法', '软件工程原理', '软件工程过程', 'A', '1');
INSERT INTO `choicequestion` VALUES ('94', '进行需求分析可使用多种工具？', '数据流图', 'PAD', '状态转换图', '数据词典', 'B', '1');
INSERT INTO `choicequestion` VALUES ('95', '结构化方法的基本思想是？', '自底向上逐步分解 ', '自顶向下逐步分解', '自底向上逐步抽象', '自底向下逐步抽象', 'B', '1');
INSERT INTO `choicequestion` VALUES ('96', '在E-R图中，包含以下基本成分？', '数据、对象、实体', '控制、关系、对象', '实体、关系、控制', '实体、属性、关系', 'D', '1');
INSERT INTO `choicequestion` VALUES ('97', '关联是建立（     ）之间关系的一种手段？', '对象', '类', '功能', '属性', 'B', '1');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `classid` int(11) NOT NULL AUTO_INCREMENT,
  `classname` varchar(20) NOT NULL,
  `major` varchar(20) NOT NULL,
  `college` varchar(20) NOT NULL,
  `grade` varchar(10) NOT NULL,
  PRIMARY KEY (`classid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('3', '计算机1班', '计算机科学与技术', '计算机学院', '2016');
INSERT INTO `class` VALUES ('4', '专英1班', '专英英语', '外国语学院', '2017');
INSERT INTO `class` VALUES ('5', '经济管理2班', '会计', '经管学院', '2014');
INSERT INTO `class` VALUES ('6', '法学3班', '法学', '人文学院', '2016');
INSERT INTO `class` VALUES ('10', '电气1班', '电气', '电气工程学院', '2015');
INSERT INTO `class` VALUES ('11', '软件2班', '软件工程', '软件学院', '2015');

-- ----------------------------
-- Table structure for fillquestion
-- ----------------------------
DROP TABLE IF EXISTS `fillquestion`;
CREATE TABLE `fillquestion` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_question` varchar(200) NOT NULL,
  `f_answer` varchar(50) NOT NULL,
  `f_subjectid` int(11) NOT NULL,
  PRIMARY KEY (`f_id`),
  KEY `fillquestion_ibfk_1` (`f_subjectid`),
  CONSTRAINT `fillquestion_ibfk_1` FOREIGN KEY (`f_subjectid`) REFERENCES `subject` (`subjectid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fillquestion
-- ----------------------------
INSERT INTO `fillquestion` VALUES ('39', '汽车有一个发动机，汽车和发动机之间的关系是_____?', '整体部分关系', '1');
INSERT INTO `fillquestion` VALUES ('40', '面向对象的主要特征除了对象的唯一性、封装性、继承外，还有_____?', '多态性', '1');
INSERT INTO `fillquestion` VALUES ('41', '所有的对象可以成为各种对象类，每个对象类都定义了一组_____?', '方法', '1');
INSERT INTO `fillquestion` VALUES ('42', '通过执行对象的操作改变对象属性,但它必须通过______的传递?', '消息', '1');
INSERT INTO `fillquestion` VALUES ('43', '_______是从用户使用系统的角度描述系统功能的图形表达方法', '用例图', '1');
INSERT INTO `fillquestion` VALUES ('44', '面向对象分析的首要工作是建立______?', '问题的对象模型', '1');
INSERT INTO `fillquestion` VALUES ('45', '对象模型的描述工具_____?', '对象图', '1');
INSERT INTO `fillquestion` VALUES ('46', '_____描述了一组交互对象间的动态协作关系，它表示完成某项行为的对象和这些对象之间传递消息的时间顺序', '顺序图', '1');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(20) NOT NULL,
  `paperid` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`gid`),
  KEY `grade_ibfk_1` (`paperid`),
  KEY `grade_ibfk_2` (`sid`),
  CONSTRAINT `grade_ibfk_1` FOREIGN KEY (`paperid`) REFERENCES `paper` (`paperid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `grade_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('32', '000000', '94', '90');
INSERT INTO `grade` VALUES ('33', '20152401', '94', '85');
INSERT INTO `grade` VALUES ('34', '000000', '95', '70');

-- ----------------------------
-- Table structure for judgequestion
-- ----------------------------
DROP TABLE IF EXISTS `judgequestion`;
CREATE TABLE `judgequestion` (
  `j_id` int(11) NOT NULL AUTO_INCREMENT,
  `j_question` varchar(200) NOT NULL,
  `j_answer` int(11) NOT NULL,
  `j_subjectid` int(11) NOT NULL,
  PRIMARY KEY (`j_id`),
  KEY `judgequestion_ibfk_1` (`j_subjectid`),
  CONSTRAINT `judgequestion_ibfk_1` FOREIGN KEY (`j_subjectid`) REFERENCES `subject` (`subjectid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of judgequestion
-- ----------------------------
INSERT INTO `judgequestion` VALUES ('28', '在面向对象的设计中，应遵循的设计准则除了模块化、抽象、低耦合、高内聚以外，还有信息隐藏。', '1', '1');
INSERT INTO `judgequestion` VALUES ('29', '面向对象分析和设计活动是一个多次反复的过程。', '1', '1');
INSERT INTO `judgequestion` VALUES ('30', '关系数据库可以完全支持面向对象的概念，面向对象设计中的类可以直接对应到关系数据库中的表。', '0', '1');
INSERT INTO `judgequestion` VALUES ('31', '面向对象设计实在分析模型的基础上，运用面向对象技术生成软件实现环境下的设计模型。', '1', '1');
INSERT INTO `judgequestion` VALUES ('32', '现代程序员组中，技术组长即对技术工作负责，又负责非技术事务。', '0', '1');
INSERT INTO `judgequestion` VALUES ('33', '文档是影响软件可维护性的决定因素。', '1', '1');
INSERT INTO `judgequestion` VALUES ('34', '软件质量保证的措施主要有：基于非执行的测试（也称为复审）、基于执行的测试和程序正确性证明。', '1', '1');
INSERT INTO `judgequestion` VALUES ('35', '功能点技术依据对软件信息域特性和软件复杂性的评估结果，估算软件规模。', '1', '1');

-- ----------------------------
-- Table structure for mistakes
-- ----------------------------
DROP TABLE IF EXISTS `mistakes`;
CREATE TABLE `mistakes` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(20) NOT NULL,
  `questiontype` int(11) NOT NULL,
  `qid` int(11) NOT NULL,
  `misanswer` varchar(30) DEFAULT NULL,
  `paperid` int(11) NOT NULL,
  PRIMARY KEY (`mid`),
  KEY `mistakes_ibfk_1` (`paperid`),
  KEY `mistakes_ibfk_2` (`sid`),
  CONSTRAINT `mistakes_ibfk_1` FOREIGN KEY (`paperid`) REFERENCES `paper` (`paperid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mistakes_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=249 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mistakes
-- ----------------------------
INSERT INTO `mistakes` VALUES ('238', '000000', '0', '87', 'D', '94');
INSERT INTO `mistakes` VALUES ('239', '000000', '0', '90', 'C', '94');
INSERT INTO `mistakes` VALUES ('240', '20152401', '0', '87', 'D', '94');
INSERT INTO `mistakes` VALUES ('241', '20152401', '2', '31', '0', '94');
INSERT INTO `mistakes` VALUES ('242', '20152401', '2', '32', '1', '94');
INSERT INTO `mistakes` VALUES ('243', '000000', '0', '87', 'D', '95');
INSERT INTO `mistakes` VALUES ('244', '000000', '0', '90', 'C', '95');
INSERT INTO `mistakes` VALUES ('245', '000000', '1', '40', '多样性', '95');
INSERT INTO `mistakes` VALUES ('246', '000000', '1', '41', '对象', '95');
INSERT INTO `mistakes` VALUES ('247', '000000', '1', '42', '信息', '95');
INSERT INTO `mistakes` VALUES ('248', '000000', '1', '43', 'E-R图', '95');

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `paperid` int(11) NOT NULL AUTO_INCREMENT,
  `starttime` datetime NOT NULL,
  `endtime` datetime NOT NULL,
  `subjectid` int(11) NOT NULL,
  `papername` varchar(30) NOT NULL,
  `c1` int(11) NOT NULL,
  `c2` int(11) NOT NULL,
  `c3` int(11) NOT NULL,
  `c4` int(11) NOT NULL,
  `c5` int(11) NOT NULL,
  `c6` int(11) NOT NULL,
  `c7` int(11) NOT NULL,
  `c8` int(11) NOT NULL,
  `c9` int(11) NOT NULL,
  `c10` int(11) NOT NULL,
  `f1` int(11) NOT NULL,
  `f2` int(11) NOT NULL,
  `f3` int(11) NOT NULL,
  `f4` int(11) NOT NULL,
  `f5` int(11) NOT NULL,
  `j1` int(11) NOT NULL,
  `j2` int(11) NOT NULL,
  `j3` int(11) NOT NULL,
  `j4` int(11) NOT NULL,
  `j5` int(11) NOT NULL,
  `tid` varchar(20) NOT NULL,
  `classid` int(11) NOT NULL,
  PRIMARY KEY (`paperid`),
  KEY `c1` (`c1`),
  KEY `c2` (`c2`),
  KEY `c3` (`c3`),
  KEY `c4` (`c4`),
  KEY `c5` (`c5`),
  KEY `c6` (`c6`),
  KEY `c7` (`c7`),
  KEY `paper_ibfk_30` (`c8`),
  KEY `c9` (`c9`),
  KEY `c10` (`c10`),
  KEY `f1` (`f1`),
  KEY `f2` (`f2`),
  KEY `f3` (`f3`),
  KEY `f4` (`f4`),
  KEY `f5` (`f5`),
  KEY `j1` (`j1`),
  KEY `j2` (`j2`),
  KEY `j3` (`j3`),
  KEY `j4` (`j4`),
  KEY `j5` (`j5`),
  KEY `paper_ibfk_21` (`tid`),
  KEY `paper_ibfk_22` (`classid`),
  KEY `paper_ibfk_23` (`subjectid`),
  CONSTRAINT `paper_ibfk_21` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `paper_ibfk_22` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `paper_ibfk_23` FOREIGN KEY (`subjectid`) REFERENCES `subject` (`subjectid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `paper_ibfk_24` FOREIGN KEY (`c1`) REFERENCES `choicequestion` (`c_id`),
  CONSTRAINT `paper_ibfk_25` FOREIGN KEY (`c2`) REFERENCES `choicequestion` (`c_id`),
  CONSTRAINT `paper_ibfk_26` FOREIGN KEY (`c3`) REFERENCES `choicequestion` (`c_id`),
  CONSTRAINT `paper_ibfk_27` FOREIGN KEY (`c4`) REFERENCES `choicequestion` (`c_id`),
  CONSTRAINT `paper_ibfk_28` FOREIGN KEY (`c5`) REFERENCES `choicequestion` (`c_id`),
  CONSTRAINT `paper_ibfk_29` FOREIGN KEY (`c6`) REFERENCES `choicequestion` (`c_id`),
  CONSTRAINT `paper_ibfk_30` FOREIGN KEY (`c8`) REFERENCES `choicequestion` (`c_id`),
  CONSTRAINT `paper_ibfk_31` FOREIGN KEY (`c7`) REFERENCES `choicequestion` (`c_id`),
  CONSTRAINT `paper_ibfk_32` FOREIGN KEY (`c9`) REFERENCES `choicequestion` (`c_id`),
  CONSTRAINT `paper_ibfk_33` FOREIGN KEY (`c10`) REFERENCES `choicequestion` (`c_id`),
  CONSTRAINT `paper_ibfk_34` FOREIGN KEY (`f1`) REFERENCES `fillquestion` (`f_id`),
  CONSTRAINT `paper_ibfk_35` FOREIGN KEY (`f2`) REFERENCES `fillquestion` (`f_id`),
  CONSTRAINT `paper_ibfk_36` FOREIGN KEY (`f3`) REFERENCES `fillquestion` (`f_id`),
  CONSTRAINT `paper_ibfk_37` FOREIGN KEY (`f4`) REFERENCES `fillquestion` (`f_id`),
  CONSTRAINT `paper_ibfk_38` FOREIGN KEY (`f5`) REFERENCES `fillquestion` (`f_id`),
  CONSTRAINT `paper_ibfk_39` FOREIGN KEY (`j1`) REFERENCES `judgequestion` (`j_id`),
  CONSTRAINT `paper_ibfk_40` FOREIGN KEY (`j2`) REFERENCES `judgequestion` (`j_id`),
  CONSTRAINT `paper_ibfk_41` FOREIGN KEY (`j3`) REFERENCES `judgequestion` (`j_id`),
  CONSTRAINT `paper_ibfk_42` FOREIGN KEY (`j4`) REFERENCES `judgequestion` (`j_id`),
  CONSTRAINT `paper_ibfk_43` FOREIGN KEY (`j5`) REFERENCES `judgequestion` (`j_id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('94', '2019-11-11 15:55:00', '2019-04-11 16:10:00', '1', '软件工程方法学期中考试', '85', '86', '87', '88', '89', '90', '91', '92', '93', '94', '39', '41', '42', '43', '44', '28', '29', '31', '32', '33', '000000', '3');
INSERT INTO `paper` VALUES ('95', '2019-11-12 14:55:00', '2019-04-12 15:55:00', '1', '软件工程方法学二次考试', '86', '87', '88', '89', '90', '91', '92', '93', '94', '95', '39', '40', '41', '42', '43', '28', '29', '30', '31', '32', '000000', '3');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` varchar(20) NOT NULL,
  `sname` varchar(8) NOT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `classid` int(11) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `student_ibfk_1` (`classid`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('000000', '小高', '女', '3', '000000', '17876253523', '肇庆学院1', '2019-04-18', '123@qq.ocm');
INSERT INTO `student` VALUES ('20152401', '张居', null, '3', '000000', null, null, null, null);
INSERT INTO `student` VALUES ('20152402', '程同学', null, '11', '000000', null, null, null, null);
INSERT INTO `student` VALUES ('20152403', '好好', null, '11', '000000', null, null, null, null);
INSERT INTO `student` VALUES ('20152404', '梁静茹', null, '11', '000000', null, null, null, null);
INSERT INTO `student` VALUES ('20152405', '周杰伦', null, '11', '000000', null, null, null, null);

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subjectid` int(11) NOT NULL AUTO_INCREMENT,
  `subjectname` varchar(30) NOT NULL,
  PRIMARY KEY (`subjectid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('1', '软件工程方法学');
INSERT INTO `subject` VALUES ('3', '高等数学');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` varchar(20) NOT NULL,
  `tname` varchar(8) NOT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `pwd` varchar(20) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('000000', '李老师', '女', '000000', '17876253523', '紫金学院', '2017-04-17', '33@qq.com');
INSERT INTO `teacher` VALUES ('111111', '刘老师', null, '000000', null, null, null, null);

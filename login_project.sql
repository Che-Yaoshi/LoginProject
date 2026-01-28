/*
  数据库初始化脚本
*/

-- 创建数据库（如果不存在才创建）
CREATE DATABASE IF NOT EXISTS mydb1 DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci;
USE mydb1;

-- 表结构,使用IF EXISTS
DROP TABLE IF EXISTS user; 
CREATE TABLE user(
    id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    name VARCHAR(50) NOT NULL COMMENT '用户名',
    password VARCHAR(100) NOT NULL COMMENT '密码',
    PRIMARY KEY (id),
    -- 防止用户名重复
    UNIQUE KEY `uk_name` (`name`) USING BTREE COMMENT '用户名唯一索引'
) COMMENT '用户表' ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 测试数据
INSERT INTO user(name, password) VALUES ('cheyaoshi','123456');
INSERT INTO user(name, password) VALUES ('yuli','1234567');
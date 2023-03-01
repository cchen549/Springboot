USE `mybatis`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
                        `username` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '账号',
                        `password` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
                        `email` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `idx_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

insert  into `user`(`id`,`username`,`password`,`email`) values (1,'alice','12345','123456@163.com'),(2,'tom','45678','tomawesome@qq.com'),(3,'ace','abcde','191523@163.com');
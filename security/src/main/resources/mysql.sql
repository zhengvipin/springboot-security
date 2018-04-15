-- 角色表
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)

-- 用户表
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8

-- 用户角色表
CREATE TABLE `sys_user_roles` (
  `sys_user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  KEY `FKdpvc6d7xqpqr43dfuk1s27cqh` (`roles_id`),
  KEY `FKd0ut7sloes191bygyf7a3pk52` (`sys_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8

-- 初始化数据
insert  into `sys_role`(`id`,`name`) values (1,'ROLE_ADMIN'),(2,'ROLE_USER');
insert  into `sys_user`(`id`,`password`,`username`)
    values (1,'$2a$10$Vhn9hXSA8fPM.Yi2tZZvUeRS/zVWz9F0q7HMMuBGypicdaw5COUaK','root'),
           (2,'sa$2a$10$dcXWea6M57BjRaHVYdotGuydVprwZokl6wtLhmlUycPvwRHXx4TR2ng','sang');
insert  into `sys_user_roles`(`sys_user_id`,`roles_id`) values (1,1),(2,2);
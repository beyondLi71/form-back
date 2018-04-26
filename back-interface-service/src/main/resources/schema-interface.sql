----------------------------
-----------user(用户表)
---------------------------
CREATE TABLE IF NOT EXISTS `funds` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `age` int(20) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

---接口管理主表
CREATE TABLE IF NOT EXISTS `sys_interface_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `interface_name` varchar(255) NOT NULL COMMENT '接口名称',
  `method_name` varchar(255) NOT NULL COMMENT '方法名称',
  `type` varchar(255) NOT NULL COMMENT '接口类型',
  `status` varchar(255) NOT NULL COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
   `create_by` varchar(255) NOT NULL COMMENT '创建人',
  `update_by` varchar(255) NOT NULL COMMENT '修改人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `mark` varchar(255) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

---接口管理主表
CREATE TABLE IF NOT EXISTS `sys_interface_manager_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `manager_id` int(11) NOT NULL COMMENT '方法id',
  `time` varchar(255) NOT NULL COMMENT '耗时毫秒数',
  `ip` varchar(255) NOT NULL COMMENT '客户端ip',
  `status` varchar(255) NOT NULL COMMENT '状态',
  `request` varchar(255) NOT NULL COMMENT '请求参数',
  `inface_url` varchar(255) NOT NULL COMMENT '接口地址',
  `start_time` datetime NOT NULL COMMENT '调用时间',
  `response` text NOT NULL COMMENT '返回结果',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
   `create_by` varchar(255) NOT NULL COMMENT '创建人',
  `update_by` varchar(255) NOT NULL COMMENT '修改人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `mark` varchar(255) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

---白名单
CREATE TABLE IF NOT EXISTS `sys_whitename_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `url_start` varchar(255) NOT NULL COMMENT 'url起始',
  `url_end` varchar(255) NOT NULL COMMENT 'url结束',
  `status` varchar(255) NOT NULL COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
   `create_by` varchar(255) NOT NULL COMMENT '创建人',
  `update_by` varchar(255) NOT NULL COMMENT '修改人',
  `remark` varchar(255)  NOT NULL COMMENT '备注',
  `mark` varchar(255) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
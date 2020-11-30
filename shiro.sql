DROP TABLE IF EXISTS resources;
CREATE TABLE
    resources
    (
        id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
        url VARCHAR(100) NOT NULL COMMENT '资源路径',
        parent_url VARCHAR(100) NOT NULL COMMENT '资源父级路径',
        rlevel TINYINT UNSIGNED NOT NULL COMMENT '资源层级',
        description VARCHAR(255) COMMENT '描述',
        PRIMARY KEY (id),
        UNIQUE KEY idx_uk_resources_01 (url)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表';

DROP TABLE IF EXISTS permissions;
CREATE TABLE
    permissions
    (
        id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
        permission_name VARCHAR(100) NOT NULL COMMENT '权限名',
        description VARCHAR(255) COMMENT '描述',
        PRIMARY KEY (id),
        UNIQUE KEY idx_uk_permissions_01 (permission_name)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';  

DROP TABLE IF EXISTS roles;
CREATE TABLE
    roles
    (
        id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
        role_name VARCHAR(100) NOT NULL COMMENT '角色名',
        description VARCHAR(255) COMMENT '描述',
        PRIMARY KEY (id),
        UNIQUE KEY idx_uk_roles_01 (role_name)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';
    
DROP TABLE IF EXISTS users;
CREATE TABLE
    users
    (
        id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
        user_name VARCHAR(100) NOT NULL COMMENT '用户名',
        email VARCHAR(100) COMMENT '邮箱',
        password VARCHAR(255) NOT NULL COMMENT '密码',
        PRIMARY KEY (id),
        UNIQUE KEY idx_uk_users_01 (user_name)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

DROP TABLE IF EXISTS permissions_resources;
CREATE TABLE
    permissions_resources
    (
        p_id BIGINT UNSIGNED NOT NULL COMMENT '权限ID',
        re_id BIGINT UNSIGNED NOT NULL COMMENT '资源ID',
        KEY idx_roles_permissions_01(p_id),
        KEY idx_roles_permissions_02(re_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限映射表';

DROP TABLE IF EXISTS roles_permissions;
CREATE TABLE
    roles_permissions
    (
        ro_id BIGINT UNSIGNED NOT NULL COMMENT '角色ID',
        p_id BIGINT UNSIGNED NOT NULL COMMENT '权限ID',
        KEY idx_roles_permissions_01(ro_id),
        KEY idx_roles_permissions_02(p_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限映射表';
    
DROP TABLE IF EXISTS users_roles;
CREATE TABLE
    users_roles
    (
        u_id BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
        ro_id BIGINT UNSIGNED NOT NULL COMMENT '角色ID',
        KEY idx_users_roles_01(u_id),
        KEY idx_users_roles_02(ro_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色映射表';
    
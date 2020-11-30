DROP TABLE IF EXISTS resources;
CREATE TABLE
    resources
    (
        id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '��������',
        url VARCHAR(100) NOT NULL COMMENT '��Դ·��',
        parent_url VARCHAR(100) NOT NULL COMMENT '��Դ����·��',
        rlevel TINYINT UNSIGNED NOT NULL COMMENT '��Դ�㼶',
        description VARCHAR(255) COMMENT '����',
        PRIMARY KEY (id),
        UNIQUE KEY idx_uk_resources_01 (url)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��Դ��';

DROP TABLE IF EXISTS permissions;
CREATE TABLE
    permissions
    (
        id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '��������',
        permission_name VARCHAR(100) NOT NULL COMMENT 'Ȩ����',
        description VARCHAR(255) COMMENT '����',
        PRIMARY KEY (id),
        UNIQUE KEY idx_uk_permissions_01 (permission_name)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Ȩ�ޱ�';  

DROP TABLE IF EXISTS roles;
CREATE TABLE
    roles
    (
        id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '��������',
        role_name VARCHAR(100) NOT NULL COMMENT '��ɫ��',
        description VARCHAR(255) COMMENT '����',
        PRIMARY KEY (id),
        UNIQUE KEY idx_uk_roles_01 (role_name)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��ɫ��';
    
DROP TABLE IF EXISTS users;
CREATE TABLE
    users
    (
        id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '��������',
        user_name VARCHAR(100) NOT NULL COMMENT '�û���',
        email VARCHAR(100) COMMENT '����',
        password VARCHAR(255) NOT NULL COMMENT '����',
        PRIMARY KEY (id),
        UNIQUE KEY idx_uk_users_01 (user_name)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���';

DROP TABLE IF EXISTS permissions_resources;
CREATE TABLE
    permissions_resources
    (
        p_id BIGINT UNSIGNED NOT NULL COMMENT 'Ȩ��ID',
        re_id BIGINT UNSIGNED NOT NULL COMMENT '��ԴID',
        KEY idx_roles_permissions_01(p_id),
        KEY idx_roles_permissions_02(re_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��ɫȨ��ӳ���';

DROP TABLE IF EXISTS roles_permissions;
CREATE TABLE
    roles_permissions
    (
        ro_id BIGINT UNSIGNED NOT NULL COMMENT '��ɫID',
        p_id BIGINT UNSIGNED NOT NULL COMMENT 'Ȩ��ID',
        KEY idx_roles_permissions_01(ro_id),
        KEY idx_roles_permissions_02(p_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��ɫȨ��ӳ���';
    
DROP TABLE IF EXISTS users_roles;
CREATE TABLE
    users_roles
    (
        u_id BIGINT UNSIGNED NOT NULL COMMENT '�û�ID',
        ro_id BIGINT UNSIGNED NOT NULL COMMENT '��ɫID',
        KEY idx_users_roles_01(u_id),
        KEY idx_users_roles_02(ro_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���ɫӳ���';
    
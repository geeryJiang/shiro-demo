package com.test.shiro.service.impl;

import com.test.shiro.dao.ResourcesMapper;
import com.test.shiro.service.IResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ResourcesService
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/11/30 17:40
 * @Version: 1.0
 */
@Service
public class ResourcesService implements IResourcesService {

    @Autowired
    ResourcesMapper resourcesMapper;

    @Override
    public List<Map> selectAllResourceAndPermission() {
        return resourcesMapper.selectAllResourceAndPermission();
    }
}

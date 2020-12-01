package com.test.shiro.service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: IResourcesService
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/11/30 17:40
 * @Version: 1.0
 */
public interface IResourcesService {

    List<Map> selectAllResourceAndPermission();

}

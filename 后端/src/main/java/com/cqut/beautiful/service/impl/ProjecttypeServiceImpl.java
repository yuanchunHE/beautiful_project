package com.cqut.beautiful.service.impl;

import com.cqut.beautiful.entity.Projecttype;
import com.cqut.beautiful.dao.ProjecttypeDao;
import com.cqut.beautiful.service.ProjecttypeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Projecttype)表服务实现类
 *
 * @author makejava
 * @since 2022-07-05 16:42:23
 */
@Service("projecttypeService")
public class ProjecttypeServiceImpl implements ProjecttypeService {
    @Resource
    private ProjecttypeDao projecttypeDao;

}

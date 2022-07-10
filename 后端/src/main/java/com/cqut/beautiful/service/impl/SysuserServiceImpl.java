package com.cqut.beautiful.service.impl;

import com.cqut.beautiful.entity.Sysuser;
import com.cqut.beautiful.dao.SysuserDao;
import com.cqut.beautiful.service.SysuserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Sysuser)表服务实现类
 *
 * @author makejava
 * @since 2022-07-05 16:42:35
 */
@Service("sysuserService")
public class SysuserServiceImpl implements SysuserService {
    @Resource
    private SysuserDao sysuserDao;

}

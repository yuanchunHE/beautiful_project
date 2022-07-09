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

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Sysuser queryById(Long id) {
        return this.sysuserDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param sysuser     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Sysuser> queryByPage(Sysuser sysuser, PageRequest pageRequest) {
        long total = this.sysuserDao.count(sysuser);
        return new PageImpl<>(this.sysuserDao.queryAllByLimit(sysuser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param sysuser 实例对象
     * @return 实例对象
     */
    @Override
    public Sysuser insert(Sysuser sysuser) {
        this.sysuserDao.insert(sysuser);
        return sysuser;
    }

    /**
     * 修改数据
     *
     * @param sysuser 实例对象
     * @return 实例对象
     */
    @Override
    public Sysuser update(Sysuser sysuser) {
        this.sysuserDao.update(sysuser);
        return this.queryById(sysuser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysuserDao.deleteById(id) > 0;
    }
}

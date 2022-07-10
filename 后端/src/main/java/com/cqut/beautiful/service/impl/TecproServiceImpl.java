package com.cqut.beautiful.service.impl;

import com.cqut.beautiful.dao.TecproDao;
import com.cqut.beautiful.dto.Projects;
import com.cqut.beautiful.entity.Tecpro;
import com.cqut.beautiful.service.TecproService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Tecpro)表服务实现类
 *
 * @author makejava
 * @since 2022-07-05 16:42:56
 */
@Service("tecproService")
public class TecproServiceImpl implements TecproService {
    @Resource
    private TecproDao tecproDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Tecpro queryById(Long id) {
        return this.tecproDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param tecpro 实例对象
     * @return 实例对象
     */
    @Override
    public Tecpro insert(Tecpro tecpro) {
        this.tecproDao.insert(tecpro);
        return tecpro;
    }

    /**
     * 修改数据
     *
     * @param tecpro 实例对象
     * @return 实例对象
     */
    @Override
    public Tecpro update(Tecpro tecpro) {
        this.tecproDao.update(tecpro);
        return this.queryById(tecpro.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tecproDao.deleteById(id) > 0;
    }

    /**
     * 通过技师id查找技师信息
     * @param id
     * @return
     */
    @Override
    public List<Projects> queryByTechId(Integer id) {

        return tecproDao.queryByTechId(id);

    }
}

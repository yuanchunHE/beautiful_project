package com.cqut.beautiful.service;

import com.cqut.beautiful.entity.Tecpro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Tecpro)表服务接口
 *
 * @author makejava
 * @since 2022-07-05 16:42:56
 */
public interface TecproService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Tecpro queryById(Long id);


    /**
     * 新增数据
     *
     * @param tecpro 实例对象
     * @return 实例对象
     */
    Tecpro insert(Tecpro tecpro);

    /**
     * 修改数据
     *
     * @param tecpro 实例对象
     * @return 实例对象
     */
    Tecpro update(Tecpro tecpro);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}

package com.cqut.beautiful.service;

import com.cqut.beautiful.entity.Business;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Business)表服务接口
 *
 * @author makejava
 * @since 2022-07-05 16:28:49
 */
public interface BusinessService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Business queryById(Long id);

    /**
     * 分页查询
     *
     * @param business    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Business> queryByPage(Business business, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param business 实例对象
     * @return 实例对象
     */
    Business insert(Business business);

    /**
     * 修改数据
     *
     * @param business 实例对象
     * @return 实例对象
     */
    Business update(Business business);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);




    /**
     * 通过id查询商家id
     * @param id
     * @return
     */
    String queryByBid(Integer id);
}

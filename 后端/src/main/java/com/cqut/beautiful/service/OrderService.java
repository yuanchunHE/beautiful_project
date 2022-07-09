package com.cqut.beautiful.service;

import com.cqut.beautiful.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.swing.text.StyledEditorKit;

/**
 * (Order)表服务接口
 *
 * @author makejava
 * @since 2022-07-05 16:36:59
 */
public interface OrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Order queryById(Long id);

    /**
     * 分页查询
     *
     * @param order       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Order> queryByPage(Order order, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Boolean insert(Order order);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order update(Order order);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}

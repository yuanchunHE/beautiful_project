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
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Boolean insert(Order order);

}

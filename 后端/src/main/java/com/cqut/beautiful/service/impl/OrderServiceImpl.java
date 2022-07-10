package com.cqut.beautiful.service.impl;

import com.cqut.beautiful.dao.OrderDao;
import com.cqut.beautiful.entity.Order;
import com.cqut.beautiful.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2022-07-05 16:36:59
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(Order order) {
        int i = orderDao.insert(order);
        if (i == 1)
            return true;
        else
            return false;
    }

    /**
     * 通过用户电话查找订单
     * @param phone
     * @return
     */
    @Override
    public List<Order> queryOrderByPhone(String phone) {
        return orderDao.queryOrderByPhone(phone);
    }

}

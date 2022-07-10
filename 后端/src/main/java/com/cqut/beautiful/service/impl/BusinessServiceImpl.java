package com.cqut.beautiful.service.impl;

import com.cqut.beautiful.entity.Business;
import com.cqut.beautiful.dao.BusinessDao;
import com.cqut.beautiful.service.BusinessService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Business)表服务实现类
 *
 * @author makejava
 * @since 2022-07-05 16:28:49
 */
@Service("businessService")
public class BusinessServiceImpl implements BusinessService {
    @Resource
    private BusinessDao businessDao;

    /**
     * 通过id查询商家
     * @param id
     * @return
     */
    @Override
    public String queryByBid(Integer id) {
        return businessDao.queryByBid(id);
    }
}

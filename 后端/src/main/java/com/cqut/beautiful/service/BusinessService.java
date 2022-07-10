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
     * 通过id查询商家id
     * @param id
     * @return
     */
    String queryByBid(Integer id);

}

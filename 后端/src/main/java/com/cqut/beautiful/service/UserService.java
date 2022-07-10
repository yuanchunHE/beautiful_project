package com.cqut.beautiful.service;

import com.cqut.beautiful.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-07-05 16:43:05
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryUserById(Long id);


    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    Boolean insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    boolean openidExists(String openid);


    User queryUserByOpenid(String openid);

    User queryUserByToken(String tokenid);
}

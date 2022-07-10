package com.cqut.beautiful.service.impl;

import com.cqut.beautiful.entity.User;
import com.cqut.beautiful.dao.UserDao;
import com.cqut.beautiful.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-07-05 16:43:05
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryUserById(Long id) {
        return this.userDao.queryUserById(id);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(User user) {
        int i = userDao.insert(user);
        if (i == 1)
            return true;
        else
            return false;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryUserById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userDao.deleteById(id) > 0;
    }

    @Override
    public boolean openidExists(String openid) {
        List<String> openidList = userDao.queryOpenidByOpenid(openid);
        if (openidList.isEmpty())
            return false;
        else
            return true;

    }

    @Override
    public User queryUserByOpenid(String openid) {

        return this.userDao.queryUserByOpenid(openid);
    }

    @Override
    public User queryUserByToken(String tokenid) {
        return this.userDao.queryUserByToken(tokenid);
    }
}

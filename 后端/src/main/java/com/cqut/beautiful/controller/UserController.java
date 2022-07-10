package com.cqut.beautiful.controller;

import com.cqut.beautiful.entity.User;
import com.cqut.beautiful.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-07-05 16:43:05
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

}


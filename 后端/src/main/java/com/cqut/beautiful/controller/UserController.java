package com.cqut.beautiful.controller;

import com.cqut.beautiful.dto.Projects;
import com.cqut.beautiful.entity.Order;
import com.cqut.beautiful.entity.User;
import com.cqut.beautiful.result.ResultCode;
import com.cqut.beautiful.result.ResultData;
import com.cqut.beautiful.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @ApiOperation(value = "queryUserById", notes = "通过id查询对应用户信息")
    @ApiImplicitParam(name = "name", value = "用户名")
    @GetMapping("/user/{id}")
    public ResultData queryUserById(@PathVariable Long id){
        User user = userService.queryUserById(id);

        ResultData resultData = new ResultData(ResultCode.SUCCESS, user);

        return resultData;
    }

    @ApiOperation(value = "insert", notes = "添加用户")
    @ApiImplicitParam(name = "user", value = "用户对象")
    @PostMapping("/add")
    public ResultData insert (@RequestBody User user){
        Boolean result = userService.insert(user);

        if(result)
            return new ResultData(ResultCode.SUCCESS);
        else
            return new ResultData(ResultCode.FAILED);
    }

    @ApiOperation(value = "queryUserByOpenid", notes = "通过openid查询对应用户信息")
    @ApiImplicitParam(name = "openid", value = "openid")
    @GetMapping("/user2/{openid}")
    public ResultData queryUserByOpenid(@PathVariable String openid){
        User user = userService.queryUserByOpenid(openid);

        ResultData resultData = new ResultData(ResultCode.SUCCESS, user);

        return resultData;
    }


    public ResultData openidExists(String openid){
        if(userService.openidExists(openid))
            return new ResultData(ResultCode.SUCCESS);
        else
            return new ResultData(ResultCode.FAILED);
    }
}


package com.cqut.beautiful.controller;

import com.cqut.beautiful.dto.Projects;
import com.cqut.beautiful.entity.HttpJava;
import com.cqut.beautiful.entity.Order;
import com.cqut.beautiful.entity.Tokens;
import com.cqut.beautiful.entity.User;
import com.cqut.beautiful.result.ResultCode;
import com.cqut.beautiful.result.ResultData;
import com.cqut.beautiful.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Queue;

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

    private String APPID  = "wxd452ef1f76c765a0";
    private String SECRET = "0ecde6c11f8212379f68849f192bbb0d";
    private Tokens token = Tokens.getInstance();

    @ApiOperation(value = "queryUserByToken", notes = "通过Token查询对应用户信息")
    @ApiImplicitParam(name = "tokenid", value = "token")
    @GetMapping("/check/token/{tokenid}")
    public ResultData queryUserByToken(@PathVariable String tokenid){

        User projects;
        if(token.checkToken(tokenid)){
            projects = userService.queryUserByToken(tokenid);
        }else{
            projects = new User();
        }

        ResultData resultData = new ResultData(ResultCode.SUCCESS, projects);
        return resultData;
    }

    /**
     * 注册函数
     *
     * @param code 主键
     * @return 单条数据
     */
    @GetMapping("/onLogin/{code}")
    public ResultData getLogin(@PathVariable String code) throws Exception {
        String Url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID +
                "&secret=" + SECRET +
                "&js_code="+code+"&grant_type=authorization_code";
        String json = HttpJava.sendGet(Url);
        JSONObject jsonObject = new JSONObject(json);

        String openid = jsonObject.getString("openid");
        String sessionKey = jsonObject.getString("session_key");
        Boolean result = true;
        User user = userService.queryUserByOpenid(openid);
        if(user == null){
            user = new User();
            String tokenid = token.addToToken();
            user.setOpenid(openid);
            user.setSessionkey(sessionKey);
            user.setToken(tokenid);
            result = userService.insert(user);
        }

        if(result)
            return new ResultData(ResultCode.SUCCESS, user);
        else
            return new ResultData(ResultCode.FAILED);
    }





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


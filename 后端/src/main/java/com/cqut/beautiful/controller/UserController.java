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
import io.swagger.annotations.ApiImplicitParams;
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


    @ApiOperation(value = "updateUser", notes = "设置用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tokenid", value = "token"),
            @ApiImplicitParam(name = "nickname", value = "昵称"),
            @ApiImplicitParam(name = "imageurl", value = "图片地址"),
            @ApiImplicitParam(name = "username", value = "用户名"),
            @ApiImplicitParam(name = "phone", value = "电话"),
            @ApiImplicitParam(name = "password", value = "密码"),
            @ApiImplicitParam(name = "sysToken", value = "系统token"),}
    )

    @GetMapping("/updateUser/{tokenid}/{nickname}/{imageurl}/{username}/{phone}/{password}/{sysToken}")
    public ResultData updateUser(@PathVariable String tokenid,
                                 @PathVariable String nickname,
                                 @PathVariable String imageurl,
                                 @PathVariable String username,
                                 @PathVariable String phone,
                                 @PathVariable String password,
                                 @PathVariable String sysToken
                                 ){
        System.out.println("############    UPDATE     #############");
        User projects;
        if(token.checkToken(tokenid)){
            System.out.println("has");
            projects = userService.queryUserByToken(tokenid);
        }
        else{
            System.out.println("dont have");
            projects = new User();
        }
        if(projects==null){
            System.out.println("NULL");
        }
        if (!nickname.equals("null")){
            projects.setNickname(nickname);
        }
        if (!imageurl.equals("null")){
            projects.setImageurl(imageurl);
        }
        if(!username.equals("null")) {
            projects.setUsername(username);
        }
        if (!phone.equals("null")){
            projects.setPhone(phone);
        }
        if(!password.equals("null")) {
            projects.setPassword(password);
        }
        if (!sysToken.equals("null")){
            projects.setSystoken(sysToken);
        }

        projects = userService.update(projects);
        System.out.println(projects.getPhone());
        System.out.println("########################################");
        return new ResultData(ResultCode.SUCCESS, projects);
    }


    @ApiOperation(value = "queryUserByToken", notes = "通过Token查询对应用户信息")
    @ApiImplicitParam(name = "tokenid", value = "token")
    @GetMapping("/check/token/{tokenid}")
    public ResultData queryUserByToken(@PathVariable String tokenid){

        User projects;
        System.out.println(tokenid);
        if(token.checkToken(tokenid)){
            System.out.println("TokenInList");
            projects = userService.queryUserByToken(tokenid);
        }else{
            System.out.println("TokenNotInList");
            projects = new User();
        }

        return new ResultData(ResultCode.SUCCESS, projects);
    }

    @ApiOperation(value = "getLogin", notes = "通过code查询user")
    @ApiImplicitParam(name = "code", value = "微信code")
    @GetMapping("/onLogin/{code}")
    public ResultData getLogin(@PathVariable String code) throws Exception {
        System.out.println("############   LOGIN   #################");
        String Url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID +
                "&secret=" + SECRET +
                "&js_code="+code+"&grant_type=authorization_code";
        String json = HttpJava.sendGet(Url);
        JSONObject jsonObject = new JSONObject(json);

        String openid = jsonObject.getString("openid");
        String sessionKey = jsonObject.getString("session_key");
        Boolean result = true;
        User user;
        String tokenid;
        tokenid = String.valueOf(token.generate());
        user = userService.queryUserByToken(tokenid);
        while (user!=null){
            tokenid = String.valueOf(token.generate());
            user = userService.queryUserByToken(tokenid);
        }
        token.add(Long.parseLong(tokenid));
        System.out.println("Token " + tokenid + " generated");

        user = userService.queryUserByOpenid(openid);
        if(user == null){
            System.out.println("New User");
            user = new User();
            user.setSessionkey(sessionKey);
            user.setOpenid(openid);
            user.setToken(tokenid);
            result = userService.insert(user);;
        }
        else{
            System.out.println("Update User");
            user.setToken(tokenid);
            /*bug?*/
            userService.update(user);
        }



        if(result){
            System.out.println("########################################");
            return new ResultData(ResultCode.SUCCESS, user);
        }

        else{
            System.out.println("########################################");
            return new ResultData(ResultCode.FAILED);
        }

    }





    @ApiOperation(value = "queryUserById", notes = "通过id查询对应用户信息")
    @ApiImplicitParam(name = "name", value = "用户名")
    @GetMapping("/user/{id}")
    public ResultData queryUserById(@PathVariable Long id){
        User user = userService.queryUserById(id);

        return new ResultData(ResultCode.SUCCESS, user);
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

        return new ResultData(ResultCode.SUCCESS, user);
    }


    public ResultData openidExists(String openid){
        if(userService.openidExists(openid))
            return new ResultData(ResultCode.SUCCESS);
        else
            return new ResultData(ResultCode.FAILED);
    }
}


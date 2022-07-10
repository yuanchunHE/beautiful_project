package com.cqut.beautiful.controller;

import com.cqut.beautiful.entity.Sysuser;
import com.cqut.beautiful.service.SysuserService;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Sysuser)表控制层
 *
 * @author makejava
 * @since 2022-07-05 16:42:34
 */
@RestController
@RequestMapping("sysuser")
@Api(tags = "管理员")
public class SysuserController {
    /**
     * 服务对象
     */
    @Resource
    private SysuserService sysuserService;

}


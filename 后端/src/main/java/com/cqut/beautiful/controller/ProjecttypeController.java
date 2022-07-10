package com.cqut.beautiful.controller;

import com.cqut.beautiful.entity.Projecttype;
import com.cqut.beautiful.service.ProjecttypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Projecttype)表控制层
 *
 * @author makejava
 * @since 2022-07-05 16:42:23
 */
@RestController
@RequestMapping("projecttype")
public class ProjecttypeController {
    /**
     * 服务对象
     */
    @Resource
    private ProjecttypeService projecttypeService;

}


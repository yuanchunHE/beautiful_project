package com.cqut.beautiful.controller;

import com.cqut.beautiful.entity.Tecpro;
import com.cqut.beautiful.service.TecproService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Tecpro)表控制层
 *
 * @author makejava
 * @since 2022-07-05 16:42:55
 */
@RestController
@RequestMapping("tecpro")
public class TecproController {
    /**
     * 服务对象
     */
    @Resource
    private TecproService tecproService;

}


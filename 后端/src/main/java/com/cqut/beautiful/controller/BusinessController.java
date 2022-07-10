package com.cqut.beautiful.controller;

import com.cqut.beautiful.entity.Business;
import com.cqut.beautiful.result.ResultCode;
import com.cqut.beautiful.result.ResultData;
import com.cqut.beautiful.service.BusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Business)表控制层
 *
 * @author makejava
 * @since 2022-07-05 16:28:48
 */
@RestController
@RequestMapping("business")
@Api(tags = "商家")
public class BusinessController {
    /**
     * 服务对象
     */
    @Resource
    private BusinessService businessService;


    /**
     * 通过id查找商家名
     * @param id
     * @return
     */
    @ApiOperation(value = "queryByBid", notes = "通过项目id查找商家名")
    @ApiImplicitParam(name = "id",value = "项目id")
    @GetMapping("/app/busname/{id}")
    public ResultData queryByBid(@PathVariable Integer id){
        String name = businessService.queryByBid(id);

        return new ResultData(ResultCode.SUCCESS,name);
    }



}


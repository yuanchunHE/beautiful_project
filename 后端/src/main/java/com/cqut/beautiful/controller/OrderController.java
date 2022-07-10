package com.cqut.beautiful.controller;

import com.cqut.beautiful.entity.Order;
import com.cqut.beautiful.result.ResultCode;
import com.cqut.beautiful.result.ResultData;
import com.cqut.beautiful.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2022-07-05 16:36:59
 */
@RestController
@RequestMapping("order")
@Api(tags = "订单")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;


    @ApiOperation(value = "insert", notes = "添加预约订单")
    @ApiImplicitParam(name = "order",value = "订单对象")
    @PostMapping("/app/order")
    public ResultData insert(@RequestBody Order order){

        Boolean result = orderService.insert(order);
        if (result)
            return new ResultData(ResultCode.SUCCESS);
        else
            return new ResultData(ResultCode.FAILED);
    }


}


package com.cqut.beautiful.controller;

import com.cqut.beautiful.entity.Order;
import com.cqut.beautiful.result.ResultCode;
import com.cqut.beautiful.result.ResultData;
import com.cqut.beautiful.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 通过用户电话查找订单
     * @param phone
     * @return
     */
    @ApiOperation(value = "queryOrderByPhone", notes = "通过电话查找预约订单")
    @ApiImplicitParam(name = "phone", value = "电话")
    @GetMapping("/app/order/{phone}")
    public ResultData queryOrderByPhone(@PathVariable String phone){

        //处理请求
        List<Order> order = orderService.queryOrderByPhone(phone);

        ResultData resultData = new ResultData(ResultCode.SUCCESS, order);

        return resultData;
    }

}


package com.cqut.beautiful.controller;

import com.cqut.beautiful.entity.Technician;
import com.cqut.beautiful.result.ResultCode;
import com.cqut.beautiful.result.ResultData;
import com.cqut.beautiful.service.TechnicianService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Technician)表控制层
 *
 * @author makejava
 * @since 2022-07-05 16:42:46
 */
@RestController
@RequestMapping("technician")
public class TechnicianController {
    /**
     * 服务对象
     */
    @Resource
    private TechnicianService technicianService;


    @ApiOperation(value = "queryObjects", notes = "通过技师名字查询技师信息")
    @ApiImplicitParam(name = "name", value = "技师名字")
    @GetMapping("/tech/{name}")
    public ResultData queryTechnicians(@PathVariable String name){

        List<Technician> technicians = technicianService.queryTechnicians(name);

        return new ResultData(ResultCode.SUCCESS,technicians);
    }



}


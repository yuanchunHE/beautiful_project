package com.cqut.beautiful.controller;

import com.cqut.beautiful.dto.Projects;
import com.cqut.beautiful.entity.Technician;
import com.cqut.beautiful.result.ResultCode;
import com.cqut.beautiful.result.ResultData;
import com.cqut.beautiful.service.TecproService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Tecpro)表控制层
 *
 * @author makejava
 * @since 2022-07-05 16:42:55
 */
@RestController
@RequestMapping("tecpro")
@Api(tags = "技师项目")
public class TecproController {
    /**
     * 服务对象
     */
    @Resource
    private TecproService tecproService;

    /**
     * 通过技师id查找技师信息
     * @param id
     * @return
     */
    @ApiOperation(value = "queryByTechId", notes = "通过技师id查找技师信息")
    @ApiImplicitParam(name = "id", value = "技师id")
    @GetMapping("/tech/{id}")
    public ResultData queryByTechId(@PathVariable Integer id){
        List<Projects> projects  =  tecproService.queryByTechId(id);

        return new ResultData(ResultCode.SUCCESS,projects);
    }

    /**
     * 通过项目id查找技师
     * @param pid
     * @return
     */
    @ApiOperation(value = "queryProjectByPid", notes = "通过项目id查找技师")
    @ApiImplicitParam(name = "pid", value = "项目id")
    @GetMapping("/techpro/{pid}")
    public ResultData queryProjectByPid(@PathVariable Integer pid){
        List<Technician> technician  =  tecproService.queryProjectByPid(pid);

        return new ResultData(ResultCode.SUCCESS,technician);
    }

}


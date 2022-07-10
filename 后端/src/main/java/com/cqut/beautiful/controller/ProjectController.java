package com.cqut.beautiful.controller;

import com.cqut.beautiful.dto.Projects;
import com.cqut.beautiful.entity.Project;
import com.cqut.beautiful.result.ResultCode;
import com.cqut.beautiful.result.ResultData;
import com.cqut.beautiful.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.util.List;

/**
 * (Project)表控制层
 *
 * @author makejava
 * @since 2022-07-05 16:41:54
 */
@RestController
@RequestMapping("project")
@Api(tags = "项目")
public class ProjectController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectService projectService;


    /**
     * 通过项目类型查询项目信息
     * @param name
     * @return
     */
    @ApiOperation(value = "queryObjects", notes = "通过项目导航栏的类型查询对应项目信息")
    @ApiImplicitParam(name = "name", value = "项目类型名")
    @GetMapping("/pro/{name}")
    public ResultData queryProjects(@PathVariable String name){

        //处理请求
        List<Projects> projects = projectService.queryProjects(name);

        ResultData resultData = new ResultData(ResultCode.SUCCESS, projects);

        return resultData;
    }

    /**
     * 通过项目的id查询项目信息
     * @param id
     * @return
     */
    @ApiOperation(value = "queryByPid", notes = "通过项目的id查询对应项目信息")
    @ApiImplicitParam(name = "id", value = "项目的id")
    @GetMapping("/detail/{id}")
    public ResultData queryByPid(@PathVariable Integer id){

        Projects projects = projectService.queryByPid(id);

        ResultData resultData = new ResultData(ResultCode.SUCCESS, projects);

        return resultData;
    }

}


package com.cqut.beautiful.controller;

import com.cqut.beautiful.entity.Image;
import com.cqut.beautiful.result.ResultCode;
import com.cqut.beautiful.result.ResultData;
import com.cqut.beautiful.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Image)表控制层
 *
 * @author makejava
 * @since 2022-07-05 16:36:47
 */
@RestController
@RequestMapping("image")
@Api(tags = "图片")
public class ImageController {

    /**
     * 服务层imageService对象
     */
    @Resource
    private ImageService imageService;


    /**
     * 通过图片类型查询轮播图
     * @param imageType
     * @return
     */
    @ApiOperation(value = "queryByType", notes = "通过图片类型查找图片信息")
    @ApiImplicitParam(name = "imagetype",value = "图片类型")
    @GetMapping("/{imageType}")
    public ResultData queryByType(@PathVariable String imageType){

        //处理请求 service层
        List<Image> images = imageService.queryByType(imageType);

        ResultData resultData = new ResultData(ResultCode.SUCCESS, images);

        return resultData;
    }


}


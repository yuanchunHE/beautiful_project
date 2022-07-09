package com.cqut.beautiful.controller;

import com.cqut.beautiful.entity.Image;
import com.cqut.beautiful.result.ResultCode;
import com.cqut.beautiful.result.ResultData;
import com.cqut.beautiful.service.ImageService;
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
    @GetMapping("/{imageType}")
    public ResultData queryByType(@PathVariable String imageType){

        //处理请求 service层
        List<Image> images = imageService.queryByType(imageType);

        ResultData resultData = new ResultData(ResultCode.SUCCESS, images);

        return resultData;
    }





///////////////自动生成
//    /**
//     * 服务对象
//     */
//    @Resource
//    private ImageService imageService;
//
//    /**
//     * 分页查询
//     *
//     * @param image       筛选条件
//     * @param pageRequest 分页对象
//     * @return 查询结果
//     */
//    @GetMapping
//    public ResponseEntity<Page<Image>> queryByPage(Image image, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.imageService.queryByPage(image, pageRequest));
//    }
//
//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("{id}")
//    public ResponseEntity<Image> queryById(@PathVariable("id") Long id) {
//        return ResponseEntity.ok(this.imageService.queryById(id));
//    }
//
//    /**
//     * 新增数据
//     *
//     * @param image 实体
//     * @return 新增结果
//     */
//    @PostMapping
//    public ResponseEntity<Image> add(Image image) {
//        return ResponseEntity.ok(this.imageService.insert(image));
//    }
//
//    /**
//     * 编辑数据
//     *
//     * @param image 实体
//     * @return 编辑结果
//     */
//    @PutMapping
//    public ResponseEntity<Image> edit(Image image) {
//        return ResponseEntity.ok(this.imageService.update(image));
//    }
//
//    /**
//     * 删除数据
//     *
//     * @param id 主键
//     * @return 删除是否成功
//     */
//    @DeleteMapping
//    public ResponseEntity<Boolean> deleteById(Long id) {
//        return ResponseEntity.ok(this.imageService.deleteById(id));
//    }

}


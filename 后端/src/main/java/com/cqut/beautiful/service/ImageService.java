package com.cqut.beautiful.service;

import com.cqut.beautiful.entity.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Image)表服务接口
 *
 * @author makejava
 * @since 2022-07-05 16:36:47
 */
public interface ImageService {


    /**
     * 通过图片类型imageType查询轮播图
     * @param imagetype
     * @return
     */
    List<Image> queryByType(String imagetype);
}

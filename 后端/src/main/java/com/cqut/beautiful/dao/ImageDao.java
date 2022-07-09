package com.cqut.beautiful.dao;

import com.cqut.beautiful.entity.Image;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Image)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-05 16:36:47
 */
public interface ImageDao {


    /**
     * 通过图片类型查询轮播图
     * @param imageType
     * @return List<Image>
     */
    List<Image> queryByType(String imageType);
}


package com.cqut.beautiful.service.impl;

import com.cqut.beautiful.entity.Image;
import com.cqut.beautiful.dao.ImageDao;
import com.cqut.beautiful.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Image)表服务实现类
 *
 * @author makejava
 * @since 2022-07-05 16:36:47
 */
@Service("imageService")
public class ImageServiceImpl implements ImageService {
    @Resource
    private ImageDao imageDao;


    /**
     * 通过图片类型查询轮播图
     * @param imageType
     * @return
     */
    @Override
    public List<Image> queryByType(String imageType) {

        //调用dao层
        List<Image> images = imageDao.queryByType(imageType);

        return images;
    }
}

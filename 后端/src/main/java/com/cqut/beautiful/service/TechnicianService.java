package com.cqut.beautiful.service;

import com.cqut.beautiful.entity.Technician;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Technician)表服务接口
 *
 * @author makejava
 * @since 2022-07-05 16:42:46
 */
public interface TechnicianService {

    /**
     * 通过技师名字查询技师信息
     * @param name
     * @return
     */
    List<Technician> queryTechnicians(String name);


    List<Technician> queryTechniciansById(Long id);
}

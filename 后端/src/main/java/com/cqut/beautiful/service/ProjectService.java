package com.cqut.beautiful.service;

import com.cqut.beautiful.dto.Projects;
import com.cqut.beautiful.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Project)表服务接口
 *
 * @author makejava
 * @since 2022-07-05 16:41:54
 */
public interface ProjectService {

    /**
     * 通过项目类型查询项目信息
     * @return
     */
    List<Projects> queryProjects(String name);


    /**
     * 通过项目id查询项目信息
     * @param id
     * @return
     */
    Projects queryByPid(Integer id);


}

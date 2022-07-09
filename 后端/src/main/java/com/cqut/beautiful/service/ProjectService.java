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
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Project queryById(Long id);

    /**
     * 分页查询
     *
     * @param project     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Project> queryByPage(Project project, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param project 实例对象
     * @return 实例对象
     */
    Project insert(Project project);

    /**
     * 修改数据
     *
     * @param project 实例对象
     * @return 实例对象
     */
    Project update(Project project);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);


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

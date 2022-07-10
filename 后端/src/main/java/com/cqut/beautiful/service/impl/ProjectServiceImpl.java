package com.cqut.beautiful.service.impl;

import com.cqut.beautiful.dao.ProjecttypeDao;
import com.cqut.beautiful.dto.Projects;
import com.cqut.beautiful.entity.Project;
import com.cqut.beautiful.dao.ProjectDao;
import com.cqut.beautiful.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Project)表服务实现类
 *
 * @author makejava
 * @since 2022-07-05 16:41:54
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectDao projectDao;

    @Resource
    private ProjecttypeDao projecttypeDao;

    /**
     * 通过项目类型查询项目信息
     * @return
     */
    @Override
    public List<Projects> queryProjects(String name) {

        List<Projects> projectsList = null;
        if (name != null && !name.equals("")){
            if (name.equals("推荐")){
                projectsList = projectDao.queryAll();

                return projectsList;
            }else {
                int tid = projecttypeDao.queryByName(name);
                projectsList = projectDao.queryByTid(tid);

                return projectsList;
            }
        }

        return null;
    }

    /**
     * 通过项目id查询项目信息
     * @param id
     * @return
     */
    @Override
    public Projects queryByPid(Integer id) {

        return projectDao.queryByPid(id);
    }
}

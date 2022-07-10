package com.cqut.beautiful.service.impl;

import com.cqut.beautiful.entity.Technician;
import com.cqut.beautiful.dao.TechnicianDao;
import com.cqut.beautiful.service.TechnicianService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Technician)表服务实现类
 *
 * @author makejava
 * @since 2022-07-05 16:42:46
 */
@Service("technicianService")
public class TechnicianServiceImpl implements TechnicianService {
    @Resource
    private TechnicianDao technicianDao;


    @Override
    public List<Technician> queryTechnicians(String name) {

        if (name != null && !name.equals("")){
            if (name.equals("全部")) {
                return technicianDao.queryAll();
            }
            else {
                return technicianDao.queryByName(name);
            }
        }
        return null;
    }

}

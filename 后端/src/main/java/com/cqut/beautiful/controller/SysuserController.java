package com.cqut.beautiful.controller;

import com.cqut.beautiful.entity.Sysuser;
import com.cqut.beautiful.service.SysuserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Sysuser)表控制层
 *
 * @author makejava
 * @since 2022-07-05 16:42:34
 */
@RestController
@RequestMapping("sysuser")
public class SysuserController {
    /**
     * 服务对象
     */
    @Resource
    private SysuserService sysuserService;

    /**
     * 分页查询
     *
     * @param sysuser     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Sysuser>> queryByPage(Sysuser sysuser, PageRequest pageRequest) {
        return ResponseEntity.ok(this.sysuserService.queryByPage(sysuser, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Sysuser> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.sysuserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysuser 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Sysuser> add(Sysuser sysuser) {
        return ResponseEntity.ok(this.sysuserService.insert(sysuser));
    }

    /**
     * 编辑数据
     *
     * @param sysuser 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Sysuser> edit(Sysuser sysuser) {
        return ResponseEntity.ok(this.sysuserService.update(sysuser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.sysuserService.deleteById(id));
    }

}


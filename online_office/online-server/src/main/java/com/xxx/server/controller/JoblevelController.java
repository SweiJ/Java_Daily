package com.xxx.server.controller;


import com.xxx.server.pojo.Joblevel;
import com.xxx.server.pojo.ResBean;
import com.xxx.server.service.IJoblevelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author swei
 * @since 2022-05-05
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {

    @Autowired
    private IJoblevelService joblevelService;

    @ApiOperation(value = "获取所有职称")
    @GetMapping("/")
    public List<Joblevel> getAllJoblevels() {
        return joblevelService.list();
    }

    @ApiOperation(value = "添加职称")
    @PostMapping("/")
    public ResBean addJoblevels(@RequestBody Joblevel joblevel) {
        if (joblevelService.save(joblevel)) {
            return ResBean.success("添加成功!");
        }
        return ResBean.error("添加失败!");
    }

    @ApiOperation(value = "更新职称")
    @PutMapping("/")
    public ResBean updateJoblevels(@RequestBody Joblevel joblevel) {
        if (joblevelService.updateById(joblevel)) {
            return ResBean.success("更新成功!");
        }
        return ResBean.error("更新失败!");
    }

    @ApiOperation(value = "删除职称")
    @DeleteMapping("/{id}")
    public ResBean deleteJoblevels(@PathVariable Integer id) {
        if (joblevelService.removeById(id)) {
            return ResBean.success("删除成功!");
        }
        return ResBean.error("删除失败!");
    }

    @ApiOperation(value = "批量删除职称")
    @DeleteMapping("/")
    public ResBean deleteJoblevelsByIds(Integer[] ids) {
        if (joblevelService.removeByIds(Arrays.asList(ids))) {
            return ResBean.success("批量删除成功!");
        }
        return ResBean.error("批量删除失败!");
    }
}

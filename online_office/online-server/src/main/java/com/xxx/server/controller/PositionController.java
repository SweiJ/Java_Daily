package com.xxx.server.controller;


import com.xxx.server.pojo.Position;
import com.xxx.server.pojo.ResBean;
import com.xxx.server.service.IPositionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Autowired
    private IPositionService positionService;

    @ApiOperation(value = "获取所有职位信息")
    @GetMapping("/")
    public List<Position> getAllPostition() {
        return positionService.list();
    }

    @ApiOperation(value = "添加职位信息")
    @PostMapping("/")
    public ResBean addPosition(@RequestBody Position position) {
        position.setCreateDate(LocalDateTime.now());
        if(positionService.save(position)) {
            return ResBean.success("添加成功!");
        }
        return ResBean.error("添加失败!");
    }

    @ApiOperation(value = "更新职位信息")
    @PutMapping("/")
    public ResBean updatePosition(@RequestBody Position position) {
        if(positionService.updateById(position)) {
            return ResBean.success("更新成功!");
        }
        return ResBean.error("更新失败!");
    }

    @ApiOperation(value = "删除职位信息")
    @DeleteMapping("/{id}")
    public ResBean deletePosition(@PathVariable Integer id) {
        if(positionService.removeById(id)) {
            return ResBean.success("删除成功!");
        }
        return ResBean.error("删除失败!");
    }

    @ApiOperation(value = "批量删除职位信息")
    @DeleteMapping("/")
    public ResBean deletePositionByIds(Integer[] ids) {
        if(positionService.removeByIds(Arrays.asList(ids))) {
            return ResBean.success("删除成功!");
        }
        return ResBean.error("删除失败!");
    }
}

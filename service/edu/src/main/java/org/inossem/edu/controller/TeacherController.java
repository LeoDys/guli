package org.inossem.edu.controller;


import org.inossem.edu.entity.Teacher;
import org.inossem.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2020-12-16
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {

    @Resource
    TeacherService teacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping
    public List<Teacher> getTeachers() {
        return teacherService.list(null);
    }

    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("{id}")
    public boolean delTea(@ApiParam(name = "id", value = "讲师id", required = true) @PathVariable String id) {
        return teacherService.removeById(id);
    }

}


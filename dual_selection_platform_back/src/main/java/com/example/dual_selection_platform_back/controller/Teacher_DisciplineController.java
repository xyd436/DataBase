package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.model.Teacher_Discipline;
import com.example.dual_selection_platform_back.service.Teacher_DisciplineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class Teacher_DisciplineController {

    @Autowired
    private Teacher_DisciplineService teacher_DisciplineService;

    @ApiOperation("获取导师-学科相关信息")
    @GetMapping("/getAllTeacherDiscipline")
    public List<Teacher_Discipline> getAllTeacherDiscipline() {
        return teacher_DisciplineService.getAllTeacherDiscipline();
    }

    @ApiOperation("更新导师招生指标")
    @PutMapping("/updateTeacherDiscipline_quota/{quota}/{teacher_number}/{disciplineName}")
    public void updateTeacherDiscipline_quota(@PathVariable int quota, @PathVariable String teacher_number, @PathVariable String disciplineName) {
        System.out.println("updateTeacherDiscipline_quota:"+quota+","+teacher_number+","+disciplineName);
        teacher_DisciplineService.updateTeacherDiscipline_quota(quota, teacher_number, disciplineName);
    }
}
package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.model.Teacher_Discipline;
import com.example.dual_selection_platform_back.service.Teacher_DisciplineService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "API接口")
@RestController
//Spring 中的一个注解，用于支持跨域请求
@CrossOrigin(origins = "*", maxAge = 3600)
public class Teacher_DisciplineController {

    @Autowired
    private Teacher_DisciplineService teacher_DisciplineService;

    @GetMapping("/getAllTeacherDiscipline")
    public List<Teacher_Discipline> getAllTeacherDiscipline() {
        return teacher_DisciplineService.getAllTeacherDiscipline();
    }
}
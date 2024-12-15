package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.model.TeacherFieldView;
import com.example.dual_selection_platform_back.service.TeacherFieldViewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class TeacherFieldViewController {
    @Autowired
    private TeacherFieldViewService teacherFieldViewService;

    @ApiOperation("由field_name查询导师")
    @GetMapping("/findTeabyFieldName/{field_name}")
    public List<TeacherFieldView> findTeabyFieldName(@PathVariable String field_name){
        System.out.println("由field_name查询导师："+teacherFieldViewService.findTeabyFieldName(field_name));
        return teacherFieldViewService.findTeabyFieldName(field_name);
    }
}

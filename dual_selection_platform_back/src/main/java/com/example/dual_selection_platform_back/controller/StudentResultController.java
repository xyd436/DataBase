package com.example.dual_selection_platform_back.controller;


import com.example.dual_selection_platform_back.model.Student;
import com.example.dual_selection_platform_back.model.StudentResult;
import com.example.dual_selection_platform_back.service.StudentResultService;
import com.example.dual_selection_platform_back.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class StudentResultController {
    @Autowired
    private StudentResultService studentResultService;

    @ApiOperation("由student_id查询学生结果")
    @GetMapping("/findResultbyStuId/{student_id}")
    public StudentResult findResultbyStuId(@PathVariable int student_id){
        System.out.println("由student_id查询到信息"+studentResultService.findResultbyStuId(student_id));
        return studentResultService.findResultbyStuId(student_id);
    }
}

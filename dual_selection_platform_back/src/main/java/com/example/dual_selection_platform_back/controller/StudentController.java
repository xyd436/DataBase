package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.model.Student;
import com.example.dual_selection_platform_back.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation("查询审核学生信息")
    @GetMapping("/findStuAll")
    public List<Student> findStuAll(){
        return studentService.findStuAll();
    }

    @ApiOperation("查询学生id")
    @GetMapping("/findStuId/{stuname}")
    public int findStuId(@PathVariable String stuname){
        return studentService.findStuId(stuname);
    }
}

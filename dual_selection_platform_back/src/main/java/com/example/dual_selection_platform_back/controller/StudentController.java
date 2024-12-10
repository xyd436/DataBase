package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.model.Student;
import com.example.dual_selection_platform_back.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("学生信息审核通过")
    @PutMapping("/updateAdmissionStatus_ok/{name}")
    public void updateAdmissionStatus_ok(@PathVariable String name){
        studentService.updateAdmissionStatus_ok(name);
    }

    @ApiOperation("学生信息审核驳回")
    @PutMapping("/updateAdmissionStatus_no/{name}")
    public void updateAdmissionStatus_no(@PathVariable String name){
        studentService.updateAdmissionStatus_no(name);
    }

}

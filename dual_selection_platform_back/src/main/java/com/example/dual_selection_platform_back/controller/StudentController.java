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

    @ApiOperation("更改学生状态")
    @PutMapping("/updateStudentAdmissionStatus/{stuname}/{admission_status}")
    public void updateStudentAdmissionStatus(@PathVariable String stuname,@PathVariable int admission_status){
        studentService.updateStudentAdmissionStatus(stuname,admission_status);
    }


    @ApiOperation("由user_id查询学生信息")
    @GetMapping("/findStubyUserId/{user_id}")
    public Student findStubyUserId(@PathVariable int user_id){
        System.out.println("由user_id查询到信息"+studentService.findStubyUserId(user_id));
        return studentService.findStubyUserId(user_id);
    }

    @ApiOperation("更新学生-个人材料")
    @PutMapping("/updateStudent/{user_id}/{gender}/{birth}/{tel}/{email}/{emergency_contact_number}/{introduction}")
    public boolean updateStudent(@PathVariable int user_id, @PathVariable String gender, @PathVariable String birth, @PathVariable String tel, @PathVariable String email, @PathVariable String emergency_contact_number, @PathVariable String introduction){
        if (studentService.updateStudent(user_id,gender, birth, tel, email, emergency_contact_number, introduction))
            System.out.println("更新学生个人材料成功！");
        return studentService.updateStudent(user_id,gender, birth, tel, email, emergency_contact_number, introduction);
    }

    @ApiOperation("更新学生-个人报考信息")
    @PutMapping("/updateStudent2/{user_id}/{undergraduate_school}/{undergraduate_college}/{undergraduate_major}/{directed_category}/{graduating_category}")
    public boolean updateStudent2(@PathVariable int user_id, @PathVariable String undergraduate_school, @PathVariable String undergraduate_college, @PathVariable String undergraduate_major, @PathVariable String directed_category, @PathVariable String graduating_category){
        if (studentService.updateStudent2(user_id,undergraduate_school, undergraduate_college, undergraduate_major, directed_category, graduating_category))
            System.out.println("更新学生个人报考信息成功！");
        return studentService.updateStudent2(user_id,undergraduate_school, undergraduate_college, undergraduate_major, directed_category, graduating_category);
    }

    @ApiOperation("更新学生-导师志愿")
    @PutMapping("/updateStudent3/{user_id}/{field_id}/{adjust_accepted}")
    public boolean updateStudent3(@PathVariable int user_id,@PathVariable int field_id, @PathVariable int adjust_accepted){
        if (studentService.updateStudent3(user_id,field_id, adjust_accepted))
            System.out.println("更新学生导师志愿信息成功！");
        return studentService.updateStudent3(user_id,field_id, adjust_accepted);
    }

}

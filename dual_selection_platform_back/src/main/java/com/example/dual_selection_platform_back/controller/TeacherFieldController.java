package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.service.FieldService;
import com.example.dual_selection_platform_back.service.Teacher_FieldService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "API接口")
@RestController
//Spring 中的一个注解，用于支持跨域请求
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeacherFieldController {

    @Autowired
    private Teacher_FieldService teacherFieldService;
    @Autowired
    private FieldService fieldService;

    @PutMapping ("/deleteTeacherField/{teacher_id}/{fieldname}")
    public String deleteTeacherField(@PathVariable int teacher_id, @PathVariable String fieldname) {
        System.out.println("deleteTeacherField:"+teacher_id+" "+fieldname);
        try {
            int field_id=fieldService.findByName(fieldname);
            System.out.println(field_id);
            teacherFieldService.deleteTeacherField(teacher_id, field_id);
            return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }
    }
}
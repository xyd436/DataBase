package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.mapper.TeacherMapper;
import com.example.dual_selection_platform_back.model.Teacher;
import com.example.dual_selection_platform_back.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @ApiOperation("获取导师id")
    @GetMapping("/findTeaId")
    public int findTeaId(String name){
        return teacherService.findTeaId(name);
    }

    @ApiOperation("导师遴选")
    @GetMapping("/findAllTeacher_identity")
    public List<Teacher> findAllTeacher_identity(){
        return teacherService.findAllTeacher_identity();
    }

    @ApiOperation("更新导师identity")
    @PutMapping("/updateIdentityByID/{teacher_number}/{identity}")
    public List<Teacher> updateIdentityByID(@PathVariable("teacher_number") String teacher_number, @PathVariable("identity") String identity) {
        try {
            System.out.println("updateIdentityByID:"+teacher_number+identity);
            teacherService.updateIdentityByID(teacher_number, identity);
            return teacherService.findAllTeacher_identity();
        } catch (Exception e) {
            return teacherService.findAllTeacher_identity();
        }
    }

    @ApiOperation("导师遴选")
    @GetMapping("/findAllTeachersAdmissionAbility")
    public List<Teacher> findAllTeacher_ability(){
        return teacherService.findAllTeachersAdmissionAbility();
    }
    @ApiOperation("导师遴选")
    @GetMapping("/findAllTeachersAdmissionAbility_true")
    public List<Teacher> findAllTeacher_ability_true(){
        return teacherService.findAllTeachersAdmissionAbility_true();
    }

    @ApiOperation("更新导师identity")
    @PutMapping("/updateAbilityByID/{teacher_number}/{admission_ability}")
    public List<Teacher> updateAbilityByID(@PathVariable("teacher_number") String teacher_number, @PathVariable("admission_ability") boolean admission_ability) {
        try {
            System.out.println("updateAbilityByID:"+teacher_number+admission_ability);
            teacherService.updateAbilityByID(teacher_number, admission_ability);
            return teacherService.findAllTeachersAdmissionAbility();
        } catch (Exception e) {
            return teacherService.findAllTeachersAdmissionAbility();
        }
    }


}

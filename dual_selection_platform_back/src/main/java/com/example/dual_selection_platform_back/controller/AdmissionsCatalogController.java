package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.model.AdmissionsCatalog;
import com.example.dual_selection_platform_back.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Api(tags = "API接口")
@RestController
//Spring 中的一个注解，用于支持跨域请求
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdmissionsCatalogController {
    @Autowired
    private AdmissionsCatalogService admissionsCatalogService;
    @Autowired
    private DisciplineService disciplineService;
    @Autowired
    private Teacher_DisciplineService teacherDisciplineService;
    @Autowired
    private Teacher_FieldService teacher_fieldService;



    @ApiOperation("查询信息")
    @GetMapping("/selectAllAdmissions")
    public List<AdmissionsCatalog> selectAllAdmissions() {
        return admissionsCatalogService.selectAllAdmissions();
    }

    @ApiOperation("查询学科号和学科")
    @GetMapping("/selectDistinctDiscipline")
    public List<Map<String,String>> selectDistinctDiscipline() {
        return admissionsCatalogService.selectDistinctDiscipline();
    }

    @ApiOperation("查询没有导师的招生目录信息")
    @GetMapping("selectAllAdmissionsCatalog_noTeacher")
    public List<AdmissionsCatalog> selectAllAdmissionsCatalog_noTeacher() {
        return admissionsCatalogService.selectAllAdmissionsCatalog_noTeacher();
    }

    @ApiOperation("更新招生目录")
    @PostMapping("/addAdmissionCatalog_teachers") // 修改为@PostMapping，因为我们通过请求体发送数据
    public List<AdmissionsCatalog> addAdmissionCatalog_teachers(@RequestBody AdmissionCatalogRequest request) {
        try {
            String disciplineName = request.getDisciplineName();
            String disciplineCode = request.getDisciplineCode();
            int teacherId = request.getTeacherId();
            int fieldId = request.getFieldId();
            System.out.println("addAdmissionCatalog_teachers:"+disciplineName+" "+disciplineCode+" "+teacherId+" "+fieldId);
            int disciplineID = disciplineService.selectDisciplineByCode(disciplineCode,disciplineName);
            // 写入
            teacher_fieldService.insertTeacherField(teacherId,fieldId);
            teacherDisciplineService.insertTeacherDiscipline(teacherId,disciplineID);

            return admissionsCatalogService.selectAllAdmissions();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}

class AdmissionCatalogRequest {
    private String disciplineCode;
    private String disciplineName;
    private Integer fieldId;
    private Integer teacherId;

    // Getters and Setters

    public String getDisciplineCode() { return disciplineCode; }
    public void setDisciplineCode(String disciplineCode) { this.disciplineCode = disciplineCode; }
    public String getDisciplineName() { return disciplineName; }
    public void setDisciplineName(String disciplineName) { this.disciplineName = disciplineName; }
    public Integer getFieldId() { return fieldId; }
    public void setFieldId(Integer fieldId) { this.fieldId = fieldId; }
    public Integer getTeacherId() { return teacherId; }
    public void setTeacherId(Integer teacherId) { this.teacherId = teacherId; }
}

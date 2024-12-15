package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.model.AdmissionsCatalog;
import com.example.dual_selection_platform_back.service.AdmissionsCatalogService;
import com.example.dual_selection_platform_back.service.DisciplineService;
import com.example.dual_selection_platform_back.service.FieldService;
import com.example.dual_selection_platform_back.service.Teacher_FieldService;
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
    private FieldService fieldService;
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

//    @ApiOperation("更新招生目录")
//    @PostMapping("addAdmissionCatalog")
//    public ResponseEntity addAdmissionCatalog(@RequestBody AdmissionsCatalog admissionsCatalog) {
//        try{
//
//            System.out.println("addAdmissionCatalog:"+admissionsCatalog);
//            String disciplineName = admissionsCatalog.getDisciplineName();
//            String disciplineCode = admissionsCatalog.getDisciplineCode();
//            String disciplineType = admissionsCatalog.getDisciplineType();
//            String note = admissionsCatalog.getNote();
//            String field = admissionsCatalog.getField();
//            List<String> course = Collections.singletonList(admissionsCatalog.getCourse());
//            List<String> mentorIds = admissionsCatalog.getMentor();
//            int recommendationQuota = admissionsCatalog.getRecommendationQuota();
//            int totalQuota = admissionsCatalog.getTotalQuota();
//            if(disciplineService.selectDisciplineByCode(code,name))
//            return null;
//        }
//        catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("更新招生目录失败: " + e.getMessage());
//        }
//    }
}

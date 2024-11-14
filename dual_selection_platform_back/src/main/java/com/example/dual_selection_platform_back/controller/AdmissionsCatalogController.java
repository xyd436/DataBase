package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.model.AdmissionsCatalog;
import com.example.dual_selection_platform_back.service.AdmissionsCatalogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "API接口")
@RestController
//Spring 中的一个注解，用于支持跨域请求
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdmissionsCatalogController {
    @Autowired
    private AdmissionsCatalogService admissionsCatalogService;

    @ApiOperation("查询信息")
    @GetMapping("/selectAllAdmissions")
    public List<AdmissionsCatalog> selectAllAdmissions() {
        return admissionsCatalogService.selectAllAdmissions();
    }
}

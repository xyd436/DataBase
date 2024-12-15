package com.example.dual_selection_platform_back.controller;
import com.example.dual_selection_platform_back.model.Field;
import com.example.dual_selection_platform_back.service.DisciplineService;
import com.example.dual_selection_platform_back.service.FieldService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)

public class FieldController {
    @Autowired
    private FieldService fieldService;
    @Autowired
    private DisciplineService disciplineService;

    @ApiOperation("查询研究方向")
    @GetMapping("/findByDisciplineCode/{disciplineCode}/{disciplineName}")
    public List<Field> findByDisciplineCode(@PathVariable String disciplineCode, @PathVariable String disciplineName) {
        System.out.println("disciplineCode+Name:"+disciplineCode+" "+disciplineName);
        int disciplineId = disciplineService.selectDisciplineByCode(disciplineCode, disciplineName);
        System.out.println("disciplineId:"+disciplineId);
        if (disciplineId > 0) {
            List<Field> fields = fieldService.findByDisciplineId(disciplineId);
            if (fields != null) {
                return fields;
            } else {
                // 处理fieldService.findByDisciplineId返回null的情况
                return Collections.emptyList(); // 或者其他适当的处理
            }
        } else {
            // 处理disciplineId不大于0的情况
            return Collections.emptyList(); // 或者其他适当的处理
        }
    }
}

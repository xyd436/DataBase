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

    @ApiOperation("由field_id查询研究方向")
    @GetMapping("/findFieldbyId/{field_id}")
    public Field findFieldbyId(@PathVariable int field_id){
        System.out.println("由field_id查询到研究方向："+fieldService.findFieldbyId(field_id));
        return fieldService.findFieldbyId(field_id);
    }

    @ApiOperation("由field_name查询研究方向id")
    @GetMapping("/findFieldbyName/{name}")
    public int findFieldbyName(@PathVariable String name){
        System.out.println("由field_name查询到研究方向id："+fieldService.findFieldbyName(name));
        return fieldService.findFieldbyName(name);
    }
}

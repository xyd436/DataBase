package com.example.dual_selection_platform_back.controller;
import com.example.dual_selection_platform_back.model.Discipline;
import com.example.dual_selection_platform_back.service.DisciplineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;

    @ApiOperation("查询所有学科")
    @GetMapping("/getAllDiscipline")
    public List<Discipline> getAllDiscipline() {
        return disciplineService.getAllDiscipline();
    }

//    @ApiOperation("通过学科代码查询学科id")
//    @GetMapping("/selectDisciplineByCode/{disciplineCode}")
//    public int selectDisciplineByCode(@PathVariable String disciplineCode,@PathVariable String disciplineName) {
//        return disciplineService.selectDisciplineByCode(disciplineCode,disciplineName);
//    }
}

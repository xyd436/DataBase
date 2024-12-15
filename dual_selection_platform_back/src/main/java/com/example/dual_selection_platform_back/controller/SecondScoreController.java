package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.model.SecondScore;
import com.example.dual_selection_platform_back.service.SecondScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class SecondScoreController {
    @Autowired
    private SecondScoreService secondScoreService;

    @ApiOperation("查询所有复试信息")
    @GetMapping("/findAllSecond")
    public List<SecondScore> findAllSecond() {
        return secondScoreService.findAllSecond();
    }

    @ApiOperation("更新复试信息")
    @PutMapping("/updateSecondInfo/{time}/{location}/{score}/{course}/{student_id}")
    public void updateSecondInfo(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")Date time, @PathVariable String location, @PathVariable String score, @PathVariable String course, @PathVariable int student_id) {
        secondScoreService.updateSecondInfo(time,location,score,course,student_id);
    }

    @ApiOperation("根据student_id查询复试信息")
    @GetMapping("/findScoreByStudentId/{student_id}")
    public List<SecondScore> findScoreByStudentId(@PathVariable int student_id) {
        System.out.println("根据student_id查询复试信息"+secondScoreService.findScoreByStudentId(student_id));
        return secondScoreService.findScoreByStudentId(student_id);
    }
}

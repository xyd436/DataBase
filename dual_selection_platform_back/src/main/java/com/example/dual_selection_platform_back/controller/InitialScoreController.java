package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.model.InitialScore;
import com.example.dual_selection_platform_back.service.InitialScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class InitialScoreController {
    @Autowired
    private InitialScoreService initialScoreService;

    @ApiOperation("查询所有信息")
    @GetMapping("/findAll")
    public List<InitialScore> findAll(){
        return initialScoreService.findAll();
    }

    @ApiOperation("更新初试成绩")
    @PutMapping("/updateScore/{score}/{student_id}/{course_id}")
    public void updateScore(@PathVariable double score,@PathVariable int student_id,@PathVariable int course_id) {
        initialScoreService.updateScore(score,student_id,course_id);
    }
}

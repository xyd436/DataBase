package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.model.SecondScore;
import com.example.dual_selection_platform_back.service.SecondScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @ApiOperation("更新复试成绩、时间地点")
    @PostMapping("/updateInfo")
    public void updateInfo(@RequestBody SecondScore secondScore) {
        secondScoreService.updateInfo(secondScore);
    }
}

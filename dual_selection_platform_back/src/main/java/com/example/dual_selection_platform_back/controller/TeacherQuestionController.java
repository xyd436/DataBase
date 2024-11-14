package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.model.TeacherQuestion;
import com.example.dual_selection_platform_back.service.TeacherQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class TeacherQuestionController {
    @Autowired
    private TeacherQuestionService teacherQuestionService;

    @ApiOperation("查询所有导师质疑信息")
    @GetMapping("/findQuestionAll")
    public List<TeacherQuestion> findQuestionAll(){
        return teacherQuestionService.findQuestionAll();
    }
}

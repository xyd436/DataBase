package com.example.dual_selection_platform_back.controller;
import com.example.dual_selection_platform_back.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class CourseController {
    @Autowired
    private CourseService courseService;

    @ApiOperation("查询课程id")
    @GetMapping("/findCourseId/{coursename}")
    public int findCourseId(@PathVariable String coursename){
        return courseService.findCourseId(coursename);
    }

    @ApiOperation("查询课程")
    @GetMapping("/findCourseNameCombined")
    public List<String> findCourseNameCombined(){
        return courseService.findCourseNameCombined();
    }

}

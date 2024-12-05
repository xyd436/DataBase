package com.example.dual_selection_platform_back.controller;
import com.example.dual_selection_platform_back.model.InitialScore;
import com.example.dual_selection_platform_back.model.InitialScoreImport;
import com.example.dual_selection_platform_back.service.InitialScoreImportService;
import com.example.dual_selection_platform_back.service.StudentService;
import com.example.dual_selection_platform_back.service.CourseService;
import com.example.dual_selection_platform_back.service.InitialScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class InitialScoreImportController {
    @Autowired
    private InitialScoreImportService initialScoreImportService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private InitialScoreService initialScoreService;

    @ApiOperation("查询初试视图所有信息")
    @GetMapping("/findInitialViewAll")
    public List<InitialScoreImport> findInitialViewAll(){
        return initialScoreImportService.findInitialViewAll();
    }

    @ApiOperation("视图更新初试成绩")
    @PutMapping("/updateInitialScore/{score}/{stuname}/{coursename}")
    public void updateInitialScore(@PathVariable double score, @PathVariable String stuname, @PathVariable String coursename){
        System.out.println(score+","+stuname+","+coursename);
        try{
            int student_id=studentService.findStuId(stuname);
            int course_id=courseService.findCourseId(coursename);
            initialScoreService.updateScore(score,student_id,course_id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

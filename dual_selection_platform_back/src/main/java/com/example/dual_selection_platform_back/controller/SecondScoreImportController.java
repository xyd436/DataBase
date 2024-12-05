package com.example.dual_selection_platform_back.controller;
import com.example.dual_selection_platform_back.service.StudentService;
import com.example.dual_selection_platform_back.service.SecondScoreService;
import com.example.dual_selection_platform_back.model.SecondScoreImport;
import com.example.dual_selection_platform_back.service.SecondScoreImportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class SecondScoreImportController {
    @Autowired
    private SecondScoreImportService secondScoreImportService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SecondScoreService secondScoreService;

    @ApiOperation("查询复试视图所有信息")
    @GetMapping("/findSecondViewAll")
    public List<SecondScoreImport> findSecondViewAll() {
        return secondScoreImportService.findSecondViewAll();
    }

    @ApiOperation("视图更新复试信息")
    @PutMapping("/updateSecondScore/{score}/{stuname}/{course}/{time}/{location}")
    public void updateSecondScore(@PathVariable String score, @PathVariable String stuname, @PathVariable String course,
                                  @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date time, @PathVariable String location) {
        try{
            int student_id=studentService.findStuId(stuname);
            secondScoreService.updateSecondInfo(time,location,score,course,student_id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

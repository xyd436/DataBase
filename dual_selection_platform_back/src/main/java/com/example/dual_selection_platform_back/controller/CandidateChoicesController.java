package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.model.CandidateChoices;
import com.example.dual_selection_platform_back.service.CandidateChoicesService;
import com.example.dual_selection_platform_back.service.StudentService;
import com.example.dual_selection_platform_back.service.TeacherService;
import com.example.dual_selection_platform_back.service.ChoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class CandidateChoicesController {
    @Autowired
    private CandidateChoicesService candidateChoicesService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ChoiceService choiceService;

    @ApiOperation("考生志愿信息和成绩综合")
    @GetMapping("/selectAllChoices_Status_Scores")
    public List<CandidateChoices> selectAllChoices_Status_Scores() {
        return candidateChoicesService.selectAllChoices_Status_Scores();
    }

    @ApiOperation("导师质疑表")
    @GetMapping("/selectAllQuestion")
    public List<CandidateChoices> selectAllQuestion() {
        return candidateChoicesService.selectAllQuestion();
    }

    @ApiOperation("录取结果发布表")
    @GetMapping("/selectAllResult")
    public List<CandidateChoices> selectAllResult() {
        return candidateChoicesService.selectAllResult();
    }

    @ApiOperation("更新被质疑志愿状态")
    @PutMapping("/updateSkepticalStatus/{statusId}/{detail}/{stuname}/{mentorname}")
    public void updateSkepticalStatus(@PathVariable int statusId,@PathVariable String detail,@PathVariable String stuname,@PathVariable String mentorname) {
        try{
            int student_id=studentService.findStuId(stuname);
            int mentor_id=teacherService.findTeaId(mentorname);
            choiceService.updateChoiceStatus(statusId,detail,student_id,mentor_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("查看导师选择")
    @GetMapping("/selectAllMentorSelected")
    public List<CandidateChoices> selectAllMentorSelected() { return candidateChoicesService.selectAllMentorSelected(); }

}

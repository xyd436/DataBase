package com.example.dual_selection_platform_back.controller;

import com.example.dual_selection_platform_back.model.CandidateChoices;
import com.example.dual_selection_platform_back.service.CandidateChoicesService;
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

    @ApiOperation("考生志愿信息和成绩综合")
    @GetMapping("/selectAllChoices_Status_Scores")
    public List<CandidateChoices> selectAllChoices_Status_Scores() {
        return candidateChoicesService.selectAllChoices_Status_Scores();
    }
}

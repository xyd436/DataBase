package com.example.dual_selection_platform_back.controller;


import com.example.dual_selection_platform_back.model.DistributeCandidate;
import com.example.dual_selection_platform_back.service.DistributeCandidateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class DistributeCandidateController {
    @Autowired
    DistributeCandidateService distributeCandidateService;

    @ApiOperation("获取所有导师在所有学科下招生信息——数量、志愿轮次")
    @GetMapping("findAllDistributeCandidate")
    public List<DistributeCandidate> findAllDistributeCandidate() {
        return distributeCandidateService.findAllDistributeCandidate();
    }
}

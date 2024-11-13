package com.example.dual_selection_platform_back.controller;
import com.example.dual_selection_platform_back.model.SecondScore;
import com.example.dual_selection_platform_back.model.SecondScoreImport;
import com.example.dual_selection_platform_back.service.SecondScoreImportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class SecondScoreImportController {
    @Autowired
    private SecondScoreImportService secondScoreImportService;

    @ApiOperation("查询复试视图所有信息")
    @GetMapping("/findSecondViewAll")
    public List<SecondScoreImport> findSecondViewAll() {
        return secondScoreImportService.findSecondViewAll();
    }
}

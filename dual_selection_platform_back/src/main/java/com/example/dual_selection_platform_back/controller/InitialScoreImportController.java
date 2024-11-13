package com.example.dual_selection_platform_back.controller;
import com.example.dual_selection_platform_back.model.InitialScore;
import com.example.dual_selection_platform_back.model.InitialScoreImport;
import com.example.dual_selection_platform_back.service.InitialScoreImportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.List;

@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class InitialScoreImportController {
    @Autowired
    private InitialScoreImportService initialScoreImportService;

    @ApiOperation("查询初试视图所有信息")
    @GetMapping("/findInitialViewAll")
    public List<InitialScoreImport> findInitialViewAll(){
        return initialScoreImportService.findInitialViewAll();
    }
}

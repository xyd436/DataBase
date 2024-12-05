package com.example.dual_selection_platform_back.service;
import com.example.dual_selection_platform_back.mapper.InitialScoreMapper;
import com.example.dual_selection_platform_back.mapper.InitialScoreImportMapper;
import com.example.dual_selection_platform_back.model.InitialScoreImport;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired; // 导入Autowired注解
import java.util.List;

@Service
public class InitialScoreImportService {
    @Autowired // 自动注入InitialScoreMapper
    private InitialScoreImportMapper initialScoreImportMapper;

    @Autowired
    private InitialScoreMapper initialScoreMapper;

    public List<InitialScoreImport> findInitialViewAll() {
        return initialScoreImportMapper.findInitialViewAll();
    }
}

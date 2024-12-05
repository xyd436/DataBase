package com.example.dual_selection_platform_back.service;
import com.example.dual_selection_platform_back.mapper.SecondScoreImportMapper;
import com.example.dual_selection_platform_back.model.SecondScoreImport;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired; // 导入Autowired注解
import java.util.List;
@Service
public class SecondScoreImportService {
    @Autowired
    private SecondScoreImportMapper secondScoreImportMapper;

    public List<SecondScoreImport> findSecondViewAll() {
        return secondScoreImportMapper.findSecondViewAll();
    }


}

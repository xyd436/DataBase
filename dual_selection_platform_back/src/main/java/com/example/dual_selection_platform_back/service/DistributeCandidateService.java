package com.example.dual_selection_platform_back.service;

import com.example.dual_selection_platform_back.mapper.DistributeCandidateMapper;
import com.example.dual_selection_platform_back.model.DistributeCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributeCandidateService {
    @Autowired
    private DistributeCandidateMapper distributeCandidateMapper;

    // 获取所有导师在所有学科下招生信息——数量、志愿轮次
    public List<DistributeCandidate> findAllDistributeCandidate() {
        return distributeCandidateMapper.findAllDistributeCandidate();
    }
}

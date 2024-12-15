package com.example.dual_selection_platform_back.mapper;
import org.apache.ibatis.annotations.*;
import com.example.dual_selection_platform_back.model.DistributeCandidate;

import java.util.List;


@Mapper
public interface DistributeCandidateMapper {
    // 获取所有导师在所有学科下招生信息——数量、志愿轮次
    @Select("SELECT * FROM DistributeCandidate")
    List<DistributeCandidate> findAllDistributeCandidate();

    // 获取导师招生指标

}

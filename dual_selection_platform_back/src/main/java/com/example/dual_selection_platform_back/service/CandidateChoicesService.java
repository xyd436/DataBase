package com.example.dual_selection_platform_back.service;

import com.example.dual_selection_platform_back.mapper.CandidateChoicesMapper;
import com.example.dual_selection_platform_back.model.CandidateChoices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateChoicesService {

    @Autowired
    private CandidateChoicesMapper candidateChoicesMapper;

    /**
     * 查询所有信息
     *
     * @param
     * @return List<Candidatechoices>
     */
    public List<CandidateChoices> selectAllChoices_Status_Scores() {
        return candidateChoicesMapper.selectAllChoices_Status_Scores();
    }

    /**
     * 查询所有质疑信息
     *
     * @param
     * @return List<Candidatechoices>
     */
    public List<CandidateChoices> selectAllQuestion(){
        return candidateChoicesMapper.selectAllQuestion();
    }

    /**
     * 查询所有录取结果
     *
     * @param
     * @return List<Candidatechoices>
     */
    public List<CandidateChoices> selectAllResult(){
        return candidateChoicesMapper.selectAllResult();
    }

    /**
     * 查询所有导师选择
     *
     */
    public List<CandidateChoices> selectAllMentorSelected(){  return candidateChoicesMapper.selectAllMentorSelected(); }
}

package com.example.dual_selection_platform_back.service;

import com.example.dual_selection_platform_back.mapper.InitialScoreMapper;
import com.example.dual_selection_platform_back.model.InitialScore;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired; // 导入Autowired注解
import java.util.List;

@Service
public class InitialScoreService{
    @Autowired // 自动注入InitialScoreMapper
    private InitialScoreMapper initialscoremapper;

    /*
     * 更新信息
     * @param score
     */
    public void updateScore(int score, int student_id,int course_id){
        initialscoremapper.updateScore(score,student_id,course_id);
    }

    /*
     * 选择所有信息
     */
    public List<InitialScore> findAll(){
        return initialscoremapper.findAll();
    }
}

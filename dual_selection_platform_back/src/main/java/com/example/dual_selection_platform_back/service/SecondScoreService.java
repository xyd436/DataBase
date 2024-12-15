package com.example.dual_selection_platform_back.service;

import com.example.dual_selection_platform_back.mapper.SecondScoreMapper;
import com.example.dual_selection_platform_back.model.SecondScore;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired; // 导入Autowired注解
import java.util.Date;
import java.util.List;

@Service
public class SecondScoreService {
    @Autowired
    private SecondScoreMapper secondScoreMapper;
    /*
     * 选择所有信息
     */
    public List<SecondScore> findAllSecond(){
        return secondScoreMapper.findAllSecond();
    }
    /*
     * 更新复试时间、地点、成绩/综合评价、
     */
    public void updateSecondInfo(Date time,String location,String score,String course,int student_id){
        secondScoreMapper.updateSecondInfo(time,location,score,course,student_id);
    }

    public List<SecondScore> findScoreByStudentId(int student_id){
        return secondScoreMapper.findScoreByStudentId(student_id);
    }
}

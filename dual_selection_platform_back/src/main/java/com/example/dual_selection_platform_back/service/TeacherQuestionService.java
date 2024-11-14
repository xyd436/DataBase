package com.example.dual_selection_platform_back.service;

import com.example.dual_selection_platform_back.mapper.TeacherQuestionMapper;
import com.example.dual_selection_platform_back.model.TeacherQuestion;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired; // 导入Autowired注解
import java.util.List;

@Service
public class TeacherQuestionService {
    @Autowired
    private TeacherQuestionMapper teacherQuestionMapper;

    /*
     * 选择所有信息
     */
    public List<TeacherQuestion> findQuestionAll(){
        return teacherQuestionMapper.findQuestionAll();
    }
}

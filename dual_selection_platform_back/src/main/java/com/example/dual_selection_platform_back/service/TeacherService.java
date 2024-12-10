package com.example.dual_selection_platform_back.service;

import com.example.dual_selection_platform_back.mapper.TeacherMapper;
import com.example.dual_selection_platform_back.model.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired; // 导入Autowired注解
import java.util.List;
@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public int findTeaId(String name){
        return teacherMapper.findTeaId(name);
    }
}

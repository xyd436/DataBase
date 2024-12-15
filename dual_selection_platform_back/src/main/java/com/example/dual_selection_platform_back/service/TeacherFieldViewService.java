package com.example.dual_selection_platform_back.service;


import com.example.dual_selection_platform_back.model.Student;
import org.springframework.stereotype.Service;
import com.example.dual_selection_platform_back.mapper.TeacherFieldViewMapper;
import com.example.dual_selection_platform_back.model.TeacherFieldView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TeacherFieldViewService {
    @Autowired
    private TeacherFieldViewMapper teacherFieldViewMapper;

    public List<TeacherFieldView> findTeabyFieldName(String field_name) {
        return teacherFieldViewMapper.findTeabyFieldName(field_name);
    }
}

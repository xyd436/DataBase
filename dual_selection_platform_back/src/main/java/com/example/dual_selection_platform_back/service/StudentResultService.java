package com.example.dual_selection_platform_back.service;
import com.example.dual_selection_platform_back.mapper.StudentMapper;
import com.example.dual_selection_platform_back.mapper.StudentResultMapper;
import com.example.dual_selection_platform_back.model.Student;
import com.example.dual_selection_platform_back.model.StudentResult;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class StudentResultService {
    @Autowired
    private StudentResultMapper studentResultMapper;

    public StudentResult findResultbyStuId(int student_id){
        return studentResultMapper.findResultbyStuId(student_id);
    }
}

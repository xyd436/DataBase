package com.example.dual_selection_platform_back.service;
import com.example.dual_selection_platform_back.mapper.Teacher_DisciplineMapper;
import com.example.dual_selection_platform_back.model.Teacher_Discipline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Teacher_DisciplineService {
    @Autowired
    private Teacher_DisciplineMapper teacher_DisciplineMapper;
    public List<Teacher_Discipline> getAllTeacherDiscipline() {
        return teacher_DisciplineMapper.findAllTeacherDiscipline();
    }
}

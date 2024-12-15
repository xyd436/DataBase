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

    public void updateTeacherDiscipline_quota(int quota,String teacher_number,String disciplineName){
        teacher_DisciplineMapper.updateTeacherDiscipline_quota(quota, teacher_number, disciplineName);
    }

    public void insertTeacherDiscipline(int teacher_id,int discipline_id){
        teacher_DisciplineMapper.insertTeacherDiscipline(teacher_id,discipline_id);
    }
}

package com.example.dual_selection_platform_back.service;
import com.example.dual_selection_platform_back.mapper.Teacher_FieldMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Teacher_FieldService {
    @Autowired
    private Teacher_FieldMapper teacher_fieldMapper;

    public int insertTeacherField(int teacher_id, int field_id) {
        return teacher_fieldMapper.insertTeacherField(teacher_id,field_id);
    }

    @Transactional
    public void deleteTeacherField(int teacher_id, int field_id) {
        teacher_fieldMapper.deleteTeacherField(teacher_id, field_id);
    }
}

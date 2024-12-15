package com.example.dual_selection_platform_back.service;

import com.example.dual_selection_platform_back.mapper.TeacherMapper;
import com.example.dual_selection_platform_back.model.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired; // 导入Autowired注解

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public int findTeaId(String name){
        return teacherMapper.findTeaId(name);
    }

    //导师遴选
    public List<Teacher> findAllTeacher_identity(){ return teacherMapper.findAllTeacher_identity(); }

    public void updateIdentityByID(String teacher_number, String identity) {
        Map<String, Object> params = new HashMap<>();
        params.put("teacher_number", teacher_number);
        params.put("identity", identity);
        teacherMapper.updateIdentityByID(teacher_number,identity); // 调用Mapper的方法
    }

    //导师资格审查
    public List<Teacher> findAllTeachersAdmissionAbility(){ return teacherMapper.findAllTeachersAdmissionAbility(); }
    // 获取拥有招生资格的导师
    public List<Teacher> findAllTeachersAdmissionAbility_true(){ return teacherMapper.findAllTeachersAdmissionAbility_true(); }

    public void updateAbilityByID(String teacher_number, boolean admission_ability) {
        Map<String, Object> params = new HashMap<>();
        params.put("teacher_number", teacher_number);
        params.put("identity", admission_ability);
        teacherMapper.updateAbilityByID(teacher_number,admission_ability); // 调用Mapper的方法
    }

    public int findTeaIdbyTeaName(String name){
        return teacherMapper.findTeaIdbyTeaName(name);
    }

    public String findTeaNamebyTeaId(int id){
        return teacherMapper.findTeaNamebyTeaId(id);
    }

}

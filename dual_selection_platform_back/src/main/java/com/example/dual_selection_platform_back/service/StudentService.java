package com.example.dual_selection_platform_back.service;

import com.example.dual_selection_platform_back.mapper.StudentMapper;
import com.example.dual_selection_platform_back.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired; // 导入Autowired注解
import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> findStuAll() {
        return studentMapper.findStuAll();
    }

    public int findStuId(String stuname){
        return studentMapper.findStuId(stuname);
    }

    public void updateAdmissionStatus_ok(String name){
        studentMapper.updateAdmissionStatus_ok(name);
    }

    public void updateAdmissionStatus_no(String name){
        studentMapper.updateAdmissionStatus_no(name);
    }
}

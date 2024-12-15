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

    public void updateStudentAdmissionStatus(String name,int admission_status){
        studentMapper.updateStudentAdmissionStatus(name,admission_status);
    }

    public Student findStubyUserId(int user_id){
        return studentMapper.findStubyUserId(user_id);
    }

    public boolean updateStudent(int user_id, String gender, String birth, String tel, String email, String emergency_contact_number, String introduction){
        return studentMapper.updateStudent(user_id, gender, birth, tel, email, emergency_contact_number, introduction);
    }

    public boolean updateStudent2(int user_id, String undergraduate_school, String undergraduate_college, String undergraduate_major, String directed_category, String graduating_category){
        return studentMapper.updateStudent2(user_id,undergraduate_school, undergraduate_college, undergraduate_major, directed_category, graduating_category);
    }

    public boolean updateStudent3(int user_id,int field_id, int adjust_accepted){
        return studentMapper.updateStudent3(user_id,field_id, adjust_accepted);
    }
}

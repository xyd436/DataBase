package com.example.dual_selection_platform_back.service;
import com.example.dual_selection_platform_back.mapper.CourseMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired; // 导入Autowired注解

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;
    public int findCourseId(String coursename){
        return courseMapper.findCourseId(coursename);
    }
}

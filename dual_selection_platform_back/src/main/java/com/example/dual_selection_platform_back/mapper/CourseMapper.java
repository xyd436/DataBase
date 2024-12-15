package com.example.dual_selection_platform_back.mapper;
import org.apache.ibatis.annotations.*;
import com.example.dual_selection_platform_back.model.Course;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseMapper {
    //读取course_id
    @Select("select id FROM Course WHERE name=#{coursename}")
    int findCourseId(String coursename);

    @Select("SELECT CONCAT(id, name) AS combined FROM Course")
    List<String> findCourseNameCombined();
}

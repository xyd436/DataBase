package com.example.dual_selection_platform_back.mapper;

import com.example.dual_selection_platform_back.model.Student;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface StudentMapper {
    //选择所有信息
    @Select("select name,gender,birth,undergraduate_major,undergraduate_school,graduating_category,directed_category,adjust_accepted,introduction from Student ")
    List<Student> findStuAll();

    //读取student_id
    @Select("select id FROM Student WHERE name=#{stuname}")
    int findStuId(String stuname);
}

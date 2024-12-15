package com.example.dual_selection_platform_back.mapper;

import com.example.dual_selection_platform_back.model.Student;
import com.example.dual_selection_platform_back.model.StudentResult;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface StudentResultMapper {
    //根据student_id查询学生全部信息
    @Select("select * from StudentResultView where student_id=#{student_id}")
    StudentResult findResultbyStuId(@Param("student_id")int student_id);
}

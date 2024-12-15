package com.example.dual_selection_platform_back.mapper;

import com.example.dual_selection_platform_back.model.StudentInfo;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface StudentInfoMapper {
    //选择所有信息
    @Select("select * from StudentInfo ")
    List<StudentInfo> findStudentInfoAll();
}
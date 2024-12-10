package com.example.dual_selection_platform_back.mapper;
import com.example.dual_selection_platform_back.model.Teacher;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TeacherMapper {
    @Select("select id FROM Teacher WHERE name=#{name}")
    int findTeaId(@Param("name") String name);
}
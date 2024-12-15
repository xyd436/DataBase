package com.example.dual_selection_platform_back.mapper;
import org.apache.ibatis.annotations.*;
import com.example.dual_selection_platform_back.model.Teacher_Discipline;

import java.util.List;

@Mapper
public interface Teacher_DisciplineMapper {
    @Select("SELECT * FROM Teacher_Discipline")
    List<Teacher_Discipline> findAllTeacherDiscipline();
}

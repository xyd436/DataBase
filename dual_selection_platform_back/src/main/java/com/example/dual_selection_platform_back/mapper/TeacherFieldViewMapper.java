package com.example.dual_selection_platform_back.mapper;

import org.apache.ibatis.annotations.Select;
import com.example.dual_selection_platform_back.model.TeacherFieldView;
import java.util.List;
import org.apache.ibatis.annotations.*;


@Mapper
public interface TeacherFieldViewMapper {

    //根据user_id查询学生全部信息
    @Results({
            @Result(property = "field_id",column ="field_id" ),
            @Result(property = "field_name",column = "field_name"),
            @Result(property = "teacher_id",column = "teacher_id"),
            @Result(property = "teacher_name",column = "teacher_name"),
    })
    @Select("select * from TeacherFieldView where field_name=#{field_name}")
    List<TeacherFieldView> findTeabyFieldName(@Param("field_name")String field_name);
}

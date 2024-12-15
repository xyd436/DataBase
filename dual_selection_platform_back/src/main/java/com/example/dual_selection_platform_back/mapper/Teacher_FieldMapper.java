package com.example.dual_selection_platform_back.mapper;
import org.apache.ibatis.annotations.*;
import com.example.dual_selection_platform_back.model.Teacher_Field;

@Mapper
public interface Teacher_FieldMapper {
    // 写入导师-研究方向
    @Insert("INSERT INTO Teacher_Field (teacher_id, field_id) VALUES (#{teacherId}, #{fieldId})")
    int insertTeacherField(@Param("teacherId") int teacherId, @Param("fieldId") int fieldId);

    @Delete("DELETE FROM Teacher_Field WHERE teacher_id=#{teacher_id} AND field_id=#{field_id}")
    void deleteTeacherField(@Param("teacher_id") int teacher_id, @Param("field_id") int field_id);
}

package com.example.dual_selection_platform_back.mapper;
import org.apache.ibatis.annotations.*;
import com.example.dual_selection_platform_back.model.Teacher_Discipline;

import java.util.List;

@Mapper
public interface Teacher_DisciplineMapper {

    @Select("SELECT * FROM Teacher_Discipline")
    List<Teacher_Discipline> findAllTeacherDiscipline();

    @Update("UPDATE Teacher_Discipline\n" +
            "SET quota = #{quota}\n" +
            "WHERE \n" +
            "\tteacher_id=(SELECT id FROM Teacher WHERE teacher_number = #{teacher_number}) \n" +
            "AND discipline_id = (SELECT id FROM Discipline WHERE name = #{disciplineName}) ")
    void updateTeacherDiscipline_quota(@Param("quota") int quota, @Param("teacher_number") String teacher_number,@Param("disciplineName") String disciplineName);

    // 写入导师-研究方向
    @Insert("INSERT INTO Teacher_Discipline (teacher_id, discipline_id) VALUES (#{teacherId}, #{discipline_id})")
    int insertTeacherDiscipline(@Param("teacherId") int teacherId, @Param("discipline_id") int discipline_id);
}

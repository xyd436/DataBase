package com.example.dual_selection_platform_back.mapper;
import com.example.dual_selection_platform_back.model.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Select("select id FROM Teacher WHERE name=#{name}")
    int findTeaId(@Param("name") String name);

    // 导师遴选
    @Select("SELECT id,name,teacher_number,identity FROM Teacher")
    List<Teacher> findAllTeacher_identity();

    // 导师遴选-更新indentity
    @Update("update Teacher set identity = #{identity} where teacher_number=#{teacher_number}")
    void updateIdentityByID(@Param("teacher_number") String teacher_number, @Param("identity") String identity);

    // 导师资格审查
    @Select("SELECT id,name,teacher_number,admission_ability FROM Teacher")
    List<Teacher> findAllTeachersAdmissionAbility();

    // 导师资格审查-更新indentity
    @Update("update Teacher set admission_ability = #{admission_ability} where teacher_number=#{teacher_number}")
    void updateAbilityByID(@Param("teacher_number") String teacher_number, @Param("admission_ability") boolean admission_ability);

    // 获取拥有招生资格的导师
    @Select("SELECT id,name,teacher_number,admission_ability FROM Teacher WHERE admission_ability IS true")
    List<Teacher> findAllTeachersAdmissionAbility_true();

    //根据teacher_name查询teacher_id
    @Select("select id from Teacher where name=#{name}")
    int findTeaIdbyTeaName(@Param("name")String name);

    //根据teacher_id查询teacher_name
    @Select("select name from Teacher where id=#{id}")
    String findTeaNamebyTeaId(@Param("id")int id);


    /**
     * sc
     */


}
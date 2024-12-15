package com.example.dual_selection_platform_back.mapper;

import com.example.dual_selection_platform_back.model.Student;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface StudentMapper {
    //选择所有信息
    @Select("select name,gender,birth,undergraduate_major,undergraduate_school,graduating_category,directed_category,adjust_accepted,introduction,admission_status from Student ")
    List<Student> findStuAll();

    //读取student_id
    @Select("select id FROM Student WHERE name=#{stuname}")
    int findStuId(String stuname);

    //更改学生状态
    @Update("update Student set admission_status=#{admission_status} where name=#{name}")
    void updateStudentAdmissionStatus(@Param("name")String name,@Param("admission_status")int admission_status);

    //根据user_id查询学生全部信息
    @Select("select * from Student where user_id=#{user_id}")
    Student findStubyUserId(@Param("user_id")int user_id);

    //修改学生-个人材料
    @Update("UPDATE Student " +
            "SET " +
            "gender = #{gender}, " +
            "birth = STR_TO_DATE(#{birth}, '%Y-%m-%d'), " +
            "tel = #{tel}, " +
            "email = #{email}, " +
            "emergency_contact_number = #{emergency_contact_number}, " +
            "introduction = #{introduction} " +
            "WHERE user_id = #{user_id}")
    boolean updateStudent(@Param("user_id")int user_id, @Param("gender")String gender, @Param("birth")String birth, @Param("tel")String tel, @Param("email")String email, @Param("emergency_contact_number")String emergency_contact_number, @Param("introduction")String introduction);

    //修改学生-个人报考信息
    @Update("UPDATE Student " +
            "SET " +
            "undergraduate_school = #{undergraduate_school}, " +
            "undergraduate_college = #{undergraduate_college}," +
            "undergraduate_major = #{undergraduate_major}, " +
            "directed_category = #{directed_category}, " +
            "graduating_category = #{graduating_category} " +
            "WHERE user_id = #{user_id}")
    boolean updateStudent2(@Param("user_id")int user_id, @Param("undergraduate_school")String undergraduate_school, @Param("undergraduate_college")String undergraduate_college, @Param("undergraduate_major")String undergraduate_major, @Param("directed_category")String directed_category, @Param("graduating_category")String graduating_category);

    //修改学生-导师志愿信息
    @Update("UPDATE Student " +
            "SET " +
            "field_id = #{field_id}, " +
            "adjust_accepted = #{adjust_accepted} " +
            "WHERE user_id = #{user_id}")
    boolean updateStudent3(@Param("user_id")int user_id, @Param("field_id")int field_id, @Param("adjust_accepted")int adjust_accepted);

}

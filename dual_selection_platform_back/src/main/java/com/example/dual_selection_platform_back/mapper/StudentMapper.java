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

    //学生信息审核通过
    @Update("update Student set admission_status='拟录取' where name=#{name}")
    void updateAdmissionStatus_ok(@Param("name") String name);

    //学生信息审核驳回
    @Update("update Student set admission_status='审核不通过' where name=#{name}")
    void updateAdmissionStatus_no(@Param("name") String name);
}

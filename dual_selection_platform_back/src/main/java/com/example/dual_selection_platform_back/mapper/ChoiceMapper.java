package com.example.dual_selection_platform_back.mapper;

import org.apache.ibatis.annotations.*;
import com.example.dual_selection_platform_back.model.Choice;

import java.util.List;

@Mapper
public interface ChoiceMapper {
    // 插入新数据
    @Insert("INSERT INTO Choice " +
            "(priority, teacher_id, student_id) " +
            "VALUES " +
            "(#{priority}, #{teacher_id}, #{student_id})")
    boolean insertChoice(@Param("priority")int priority, @Param("teacher_id")int teacher_id, @Param("student_id")int student_id);

    //根据student_id查询Choice全部信息
    @Select("select * from Choice where student_id=#{student_id}")
    List<Choice> findChoicebyStuId(@Param("student_id")int student_id);

    @Update("update Choice set status_id=#{status_id},detail=#{detail} where student_id=#{student_id} and teacher_id=#{teacher_id}")
    void updateChoiceStatus(@Param("status_id")int status_id, @Param("detail")String detail, @Param("student_id")int student_id, @Param("teacher_id")int teacher_id);
}

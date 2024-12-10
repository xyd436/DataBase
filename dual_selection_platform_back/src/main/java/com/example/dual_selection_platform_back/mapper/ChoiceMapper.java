package com.example.dual_selection_platform_back.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.dual_selection_platform_back.model.Choice;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ChoiceMapper {
    @Update("update Choice set status_id=#{status_id},detail=#{detail} where student_id=#{student_id} and teacher_id=#{teacher_id}")
    void updateChoiceStatus(@Param("status_id")int status_id, @Param("detail")String detail, @Param("student_id")int student_id, @Param("teacher_id")int teacher_id);
}

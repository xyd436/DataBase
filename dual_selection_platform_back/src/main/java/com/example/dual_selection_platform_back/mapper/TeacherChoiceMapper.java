package com.example.dual_selection_platform_back.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface TeacherChoiceMapper {

    // 更新教师信息
    @Update("UPDATE Choice SET status_id = 11 WHERE id = #{id}")
    int updateStudentStatus(@Param("id") int id);
}

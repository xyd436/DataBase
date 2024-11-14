package com.example.dual_selection_platform_back.mapper;

import com.example.dual_selection_platform_back.model.InitialScore;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface InitialScoreMapper {
    /*
     * 成绩ID
     * @param id
     * 分数
     * @param score
     * 考生ID
     * @param student_id
     * 考试科目ID
     * @param course_id
     *
     * @return
     */
    //选择所有信息
    @Select("select * from InitialScore ")
    List<InitialScore> findAll();

    //更改成绩
    @Update("update InitialScore set score=#{score} where student_id=#{student_id} and course_id=#{course_id}")
    void updateScore(@Param("score") int score, @Param("student_id") int student_id, @Param("course_id") int course_id);
}

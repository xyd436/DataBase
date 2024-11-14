package com.example.dual_selection_platform_back.mapper;

import com.example.dual_selection_platform_back.model.SecondScore;
import org.apache.ibatis.annotations.*;
import java.util.Date;
import java.util.List;

@Mapper
public interface SecondScoreMapper {
    /*
     * 成绩ID
     * @param id
     * 复试科目
     * @param course
     * 分数
     * @param score
     * 时间
     * @param time
     * 地点
     * @param location
     * 考生ID
     * @param student_id
     *
     * @return
     */
    //更改分数/综合评价、时间、地点
    @Update("update SecondScore set id=#{id},score=#{score},time=#{time},location=#{location} where student_id=#{student_id} and course=#{course}")
    void updateInfo(SecondScore secondScore);

    //选择所有信息
    @Select("select * from SecondScore ")
    List<SecondScore> findAllSecond();
}

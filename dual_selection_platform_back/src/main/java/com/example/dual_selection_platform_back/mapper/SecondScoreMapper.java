package com.example.dual_selection_platform_back.mapper;
import com.example.dual_selection_platform_back.model.SecondScore;
import org.apache.ibatis.annotations.*;
import java.util.Date;
import java.util.List;

@Mapper
public interface SecondScoreMapper {
    //选择所有信息
    @Select("select * from SecondScore ")
    List<SecondScore> findAllSecond();

    @Update("update SecondScore set time=#{time},location=#{location},score=#{score} where course=#{course} and student_id=#{student_id}")
    void updateSecondInfo(@Param("time") Date time, @Param("location") String location, @Param("score") String score, @Param("course") String course, @Param("student_id") int student_id);
}
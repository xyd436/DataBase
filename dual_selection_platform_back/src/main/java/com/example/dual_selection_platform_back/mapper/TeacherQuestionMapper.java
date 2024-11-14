package com.example.dual_selection_platform_back.mapper;

import com.example.dual_selection_platform_back.model.TeacherQuestion;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface TeacherQuestionMapper {
    //选择所有信息
    @Select("select * from TeacherQuestion where choicestatus=2")
    List<TeacherQuestion> findQuestionAll();
}

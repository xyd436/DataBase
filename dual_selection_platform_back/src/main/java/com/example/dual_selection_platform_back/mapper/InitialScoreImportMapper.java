package com.example.dual_selection_platform_back.mapper;

import com.example.dual_selection_platform_back.model.InitialScoreImport;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface InitialScoreImportMapper {
    /*
     * 姓名
     * @param name
     * 性别
     * @param gender
     * 准考证号
     * @param id_number
     * 科目名称
     * @param coursename
     * 成绩
     * @param score
     *
     * @return
     */
    //选择所有信息
    @Select("select * from InitialScoreImport ")
    List<InitialScoreImport> findInitialViewAll();
}

package com.example.dual_selection_platform_back.mapper;

import com.example.dual_selection_platform_back.model.InitialScoreImport;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface InitialScoreImportMapper {
    //选择所有信息
    @Select("select * from InitialScoreImport ")
    List<InitialScoreImport> findInitialViewAll();
}

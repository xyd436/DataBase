package com.example.dual_selection_platform_back.mapper;
import com.example.dual_selection_platform_back.model.SecondScoreImport;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface SecondScoreImportMapper {
    //选择所有信息
    @Select("select * from SecondScoreImport ")
    List<SecondScoreImport> findSecondViewAll();
}

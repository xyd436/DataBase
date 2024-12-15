package com.example.dual_selection_platform_back.mapper;

import com.example.dual_selection_platform_back.model.AdmissionsCatalog;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

@Mapper
public interface AdmissionsCatalogMapper {
    /**
     * 查询所有记录
     * @return
     */
    @Results({
            @Result(property = "discipline",column ="discipline" ),
            @Result(property = "disciplineCode",column = "disciplineCode"),
            @Result(property = "fieldName",column = "fieldName"),
            @Result(property = "totalQuota",column = "totalQuota"),
            @Result(property = "recommendationQuota",column = "recommendationQuota"),
            @Result(property = "mentorCode",column = "mentorCode"),
            @Result(property = "mentor",column = "mentor"),
            @Result(property = "course",column = "course"),
            @Result(property = "note",column = "note"),
    })
    @Select("SELECT * FROM AdmissionsCatalog")
    List<AdmissionsCatalog> selectAllAdmissions();

    @Select("SELECT DISTINCT discipline,disciplineCode FROM AdmissionsCatalog")
    List<Map<String,String>> selectDistinctDiscipline();

    @Select("SELECT DISTINCT discipline,disciplineCode,fieldName,totalQuota,recommendationQuota,course,note\n" +
            "FROM AdmissionsCatalog")
    List<AdmissionsCatalog> selectAllAdmissionsCatalog_noTeacher();
}

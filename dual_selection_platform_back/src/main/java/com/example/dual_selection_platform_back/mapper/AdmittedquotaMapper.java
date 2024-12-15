package com.example.dual_selection_platform_back.mapper;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdmittedquotaMapper {
    /**
     * 根据导师ID查询已经选择指标和指标总数的差值
     * @param id 导师ID
     * @return admitted_quota 和 quota 的差值
     */

    @Results({
            @Result(property = "admitted_quota", column = "admitted_quota"),
            @Result(property = "quota", column = "quota"),
    })
    @Select("SELECT admitted_quota, quota FROM Teacher WHERE id = #{id}")
    int[] selectStudentCountDifference(int id);
}

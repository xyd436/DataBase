package com.example.dual_selection_platform_back.mapper;
import org.apache.ibatis.annotations.*;
import com.example.dual_selection_platform_back.model.Discipline;

import java.util.List;


@Mapper
public interface DisciplineMapper {
    @Select("SELECT id,name,code FROM Discipline")
    List<Discipline> getAllDiscipline();

    @Select("SELECT id FROM Discipline WHERE code = #{code} AND name = #{name}")
    int selectDisciplineByCode(@Param("code") String code, @Param("name") String name);

}

package com.example.dual_selection_platform_back.mapper;
import org.apache.ibatis.annotations.*;
import com.example.dual_selection_platform_back.model.Field;

import java.util.List;
import java.util.Map;

@Mapper
public interface FieldMapper {
    // 根据discipline_id读取Field
    @Select("SELECT id,name FROM Field WHERE discipline_id=#{discipline_id}")
    List<Field> findByDisciplineId(int discipline_id);

    @Select("SELECT id FROM Field WHERE name=#{name}")
    int findByName(String name);

    //根据field_id查询研究方向和学科
    @Select("select * from Field where id=#{field_id}")
    Field findFieldbyId(@Param("field_id")int field_id);

    @Select("select id from Field where name=#{name}")
    int findFieldbyName(@Param("name")String name);
}

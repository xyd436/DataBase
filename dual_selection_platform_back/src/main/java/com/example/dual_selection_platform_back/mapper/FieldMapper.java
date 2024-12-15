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
}

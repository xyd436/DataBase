package com.example.dual_selection_platform_back.mapper;

import com.example.dual_selection_platform_back.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper {

    // 根据角色ID查询角色信息
    @Select("SELECT * FROM role WHERE id = #{roleId}")
    Role findByRoleId(int roleId);
}

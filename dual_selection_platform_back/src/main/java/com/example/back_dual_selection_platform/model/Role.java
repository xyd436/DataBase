package com.example.back_dual_selection_platform.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("登录角色")

public class Role {
    @ApiModelProperty(value = "角色ID", required = true, example = "1")
    private int id;

    @ApiModelProperty(value = "角色名称", required = true, example = "考生")
    private String name;

    @ApiModelProperty(value = "角色权限", required = true, example = "查看并填写相关信息")
    private String permission;
}

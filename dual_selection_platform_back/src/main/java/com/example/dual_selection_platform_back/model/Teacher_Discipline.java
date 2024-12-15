package com.example.dual_selection_platform_back.model;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("学科-导师关联")

public class Teacher_Discipline {
    @ApiModelProperty(value = "导师ID", required = true)
    private int teacher_id;

    @ApiModelProperty(value = "研究方向ID", required = true)
    private int field_id;

    @ApiModelProperty(value = "招生指标数", required = false)
    private int quota;

    @ApiModelProperty(value = "已确认招生指标数", required = false)
    private int admitted_quota;

    @ApiModelProperty(value = "许可", required = false)
    private int permission;
}

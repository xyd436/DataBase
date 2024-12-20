package com.example.dual_selection_platform_back.model;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("研究方向-导师关联")

public class Teacher_Field {
    @ApiModelProperty(value = "导师ID", required = true)
    private int teacher_id;

    @ApiModelProperty(value = "研究方向ID", required = true)
    private int field_id;

}

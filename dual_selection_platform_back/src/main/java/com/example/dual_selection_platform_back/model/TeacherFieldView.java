package com.example.dual_selection_platform_back.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("导师学科关联视图")
public class TeacherFieldView {
    @ApiModelProperty(value = "研究方向ID", required = true)
    private int field_id;

    @ApiModelProperty(value = "研究方向名称", required = true)
    private String field_name;

    @ApiModelProperty(value = "导师名称", required = true)
    private String teacher_name;

    @ApiModelProperty(value = "导师ID", required = true)
    private int teacher_id;
}


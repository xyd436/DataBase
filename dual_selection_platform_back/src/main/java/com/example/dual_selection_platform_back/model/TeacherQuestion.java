package com.example.dual_selection_platform_back.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("导师质疑表")
public class TeacherQuestion {
    @ApiModelProperty(value = "考生姓名")
    private String stuname;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "研究方向")
    private String field;

    @ApiModelProperty(value = "导师姓名")
    private String teaname;

    @ApiModelProperty(value = "志愿优先级")
    private int priority;

    @ApiModelProperty(value = "志愿状态")
    private int choicestatus;

    @ApiModelProperty(value = "描述")
    private String detail;
}

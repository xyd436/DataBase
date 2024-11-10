package com.example.dual_selection_platform_back.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("复试成绩")

public class SecondScore {
    @ApiModelProperty(value = "成绩ID", required = true)
    private int id;

    @ApiModelProperty(value = "复试科目", required = true)
    private String course;

    @ApiModelProperty(value = "分数", required = true)
    private String score;

    @ApiModelProperty(value = "时间和地点", required = false)
    private String time_place;

    @ApiModelProperty(value = "考生ID", required = true)
    private int student_id;
}

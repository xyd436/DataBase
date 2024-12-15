package com.example.dual_selection_platform_back.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("考生结果")
public class StudentResult {
    @ApiModelProperty(value = "考生ID", required = true)
    private int student_id;

    @ApiModelProperty(value = "考生姓名", required = true)
    private String student_name;

    @ApiModelProperty(value = "身份证号", required = true)
    private String id_number;

    @ApiModelProperty(value = "准考证号", required = true)
    private String exam_id;

    @ApiModelProperty(value = "研究方向ID", required = true)
    private int field_id;

    @ApiModelProperty(value = "研究方向", required = true)
    private String field_name;

    @ApiModelProperty(value = "学科ID", required = true)
    private int discipline_id;

    @ApiModelProperty(value = "学科", required = true)
    private String discipline_name;

    @ApiModelProperty(value = "学院ID", required = true)
    private int college_id;

    @ApiModelProperty(value = "学院", required = true)
    private String college_name;

    @ApiModelProperty(value = "考生状态ID", required = true)
    private int status_id;

    @ApiModelProperty(value = "考生状态", required = true)
    private String status;
}

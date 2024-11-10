package com.example.dual_selection_platform_back.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("考生信息")

public class Student {
    @ApiModelProperty(value = "考生ID", required = true)
    private int id;

    @ApiModelProperty(value = "姓名", required = true)
    private String name;

    @ApiModelProperty(value = "性别", required = true)
    private String gender;

    @ApiModelProperty(value = "身份证号", required = true)
    private String id_number;

    @ApiModelProperty(value = "准考证号", required = true)
    private String exam_id;

    @ApiModelProperty(value = "出生日期", required = true)
    private Date birth;

    @ApiModelProperty(value = "个人简介", required = false)
    private String introduction;

    @ApiModelProperty(value = "本科专业", required = true)
    private String undergraduate_major;

    @ApiModelProperty(value = "毕业院校", required = true)
    private String undergraduate_school;

    @ApiModelProperty(value = "应届类别", required = true)
    private String graduating_category;

    @ApiModelProperty(value = "定向类别", required = true)
    private String directed_category;

    @ApiModelProperty(value = "录取状态", required = true)
    private String admission_status;

    @ApiModelProperty(value = "电话", required = true)
    private String tel;

    @ApiModelProperty(value = "邮箱", required = true)
    private String email;

    @ApiModelProperty(value = "紧急联系人电话", required = true)
    private String emergency_contact_number;

    @ApiModelProperty(value = "是否接收方向调整", required = true)
    private boolean adjust_accepted;

    @ApiModelProperty(value = "用户ID", required = true)
    private int user_id;

    @ApiModelProperty(value = "研究方向ID", required = true)
    private int field_id;

    @ApiModelProperty(value = "导师ID", required = true)
    private int teacher_id;

}

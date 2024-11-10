package com.example.back_dual_selection_platform.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("导师信息")

public class Teacher {
    @ApiModelProperty(value = "导师ID", required = true)
    private int id;

    @ApiModelProperty(value = "姓名", required = true)
    private String name;

    @ApiModelProperty(value = "导师工号", required = true)
    private String teacher_number;

    @ApiModelProperty(value = "职称", required = false)
    private String title;

    @ApiModelProperty(value = "照片", required = false)
    private byte[] picture;

    @ApiModelProperty(value = "个人简介", required = false)
    private String introduction;

    @ApiModelProperty(value = "导师身份", required = false)
    private String identity;

    @ApiModelProperty(value = "是否具有招生资格", required = false)
    private boolean admission_ability;

    @ApiModelProperty(value = "招生指标", required = false)
    private int quota;

    @ApiModelProperty(value = "电话", required = false)
    private String tel;

    @ApiModelProperty(value = "邮箱", required = false)
    private String email;

    @ApiModelProperty(value = "用户ID", required = true)
    private int user_id;
}

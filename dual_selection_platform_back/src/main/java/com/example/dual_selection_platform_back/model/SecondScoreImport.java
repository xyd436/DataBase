package com.example.dual_selection_platform_back.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@lombok.Data
//@NoArgsConstructor：这也是 Lombok 提供的注解，它会生成一个无参构造器，可以避免手动编写无参构造器。
@NoArgsConstructor
//@AllArgsConstructor：同样是 Lombok 提供的注解，它会生成一个全参构造器，可以避免手动编写全参构造器
@AllArgsConstructor
//@ApiModel：这是 Swagger 框架提供的注解，用于描述一个模型类。这个注解的作用是将模型类描述为一个 API 文档的模型，可以通过该注解指定模型类的名称和描述信息
@ApiModel("复试成绩视图")
public class SecondScoreImport {
    @ApiModelProperty(value = "名字", required = true)
    private String stuname;

    @ApiModelProperty(value = "性别", required = true)
    private String gender;

    @ApiModelProperty(value = "准考证号", required = true)
    private String id_number;

    @ApiModelProperty(value = "科目", required = true)
    private String course;

    @ApiModelProperty(value = "复试时间", required = true)
    private Date time;

    @ApiModelProperty(value = "复试地点", required = true)
    private String location;

    @ApiModelProperty(value = "成绩", required = true)
    private String score;

}

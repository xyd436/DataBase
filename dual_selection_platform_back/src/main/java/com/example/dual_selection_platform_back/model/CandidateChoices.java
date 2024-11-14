package com.example.dual_selection_platform_back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@lombok.Data：这是 Lombok 框架提供的注解，它会自动生成 getter、setter、toString、equals、hashCode 等方法
@lombok.Data
//@NoArgsConstructor：这也是 Lombok 提供的注解，它会生成一个无参构造器，可以避免手动编写无参构造器。
@NoArgsConstructor
//@AllArgsConstructor：同样是 Lombok 提供的注解，它会生成一个全参构造器，可以避免手动编写全参构造器
@AllArgsConstructor
//@ApiModel：这是 Swagger 框架提供的注解，用于描述一个模型类。这个注解的作用是将模型类描述为一个 API 文档的模型，可以通过该注解指定模型类的名称和描述信息
@ApiModel("招生目录")

public class  CandidateChoices {
    //    @ApiModelProperty：也是 Swagger 框架提供的注解，用于描述模型类中的属性信息。该注解可以设置属性的名称、描述、是否必需等信息，以便在 Swagger 生成的 API 文档中显
    @ApiModelProperty(value = "考生姓名", required = true)
    private String StudentName;
    @ApiModelProperty(value = "准考证号", required = true)
    private String AdmissionTicketNumber;
    @ApiModelProperty(value = "志愿优先级", required = true)
    private int Priority;
    @ApiModelProperty(value = "导师姓名", required = true)
    private String MentorName;
    @ApiModelProperty(value = "学科", required = true)
    private String Discipline;
    @ApiModelProperty(value = "研究方向", required = true)
    private String Field;
    @ApiModelProperty(value = "志愿状态ID",required = true)
    private int StatusID;
    @ApiModelProperty(value = "志愿状态",required = true)
    private String Status;
    @ApiModelProperty(value = "志愿相关信息",required = true)
    private String Detail;
    @ApiModelProperty(value = "初试成绩", required = true)
    private String InitialScores;
    @ApiModelProperty(value = "复试成绩", required = true)
    private String SecondScores;
}

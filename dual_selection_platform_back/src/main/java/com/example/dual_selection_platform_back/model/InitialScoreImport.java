package com.example.dual_selection_platform_back.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
//@NoArgsConstructor：这也是 Lombok 提供的注解，它会生成一个无参构造器，可以避免手动编写无参构造器。
@NoArgsConstructor
//@AllArgsConstructor：同样是 Lombok 提供的注解，它会生成一个全参构造器，可以避免手动编写全参构造器
@AllArgsConstructor
//@ApiModel：这是 Swagger 框架提供的注解，用于描述一个模型类。这个注解的作用是将模型类描述为一个 API 文档的模型，可以通过该注解指定模型类的名称和描述信息
@ApiModel("初试成绩视图")

public class InitialScoreImport {
    @ApiModelProperty(value = "名字", required = true)
    private String stuname;

    @ApiModelProperty(value = "性别", required = true)
    private String gender;

    @ApiModelProperty(value = "准考证号", required = true)
    private String id_number;

    @ApiModelProperty(value = "科目名称", required = true)
    private String coursename;

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @ApiModelProperty(value = "成绩", required = true)
    private String score;
}
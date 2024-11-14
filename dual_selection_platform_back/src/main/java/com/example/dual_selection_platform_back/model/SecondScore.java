package com.example.dual_selection_platform_back.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

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

    @ApiModelProperty(value = "时间", required = false)
    private Date time;

    @ApiModelProperty(value = "地点", required = false)
    private String location;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @ApiModelProperty(value = "考生ID", required = true)
    private int student_id;
}

package com.example.dual_selection_platform_back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject:dual_selection_platform
 * @BelongsPackage:com.example.dual_selection_platform_back.model
 * @Author:djx
 * @CreateTime:2024/11/10
 */

//@lombok.Data：这是 Lombok 框架提供的注解，它会自动生成 getter、setter、toString、equals、hashCode 等方法
@lombok.Data
//@NoArgsConstructor：这也是 Lombok 提供的注解，它会生成一个无参构造器，可以避免手动编写无参构造器。
@NoArgsConstructor
//@AllArgsConstructor：同样是 Lombok 提供的注解，它会生成一个全参构造器，可以避免手动编写全参构造器
@AllArgsConstructor
//@ApiModel：这是 Swagger 框架提供的注解，用于描述一个模型类。这个注解的作用是将模型类描述为一个 API 文档的模型，可以通过该注解指定模型类的名称和描述信息
@ApiModel("学院信息")

public class College {
    //    @ApiModelProperty：也是 Swagger 框架提供的注解，用于描述模型类中的属性信息。该注解可以设置属性的名称、描述、是否必需等信息，以便在 Swagger 生成的 API 文档中显
    @ApiModelProperty(value = "学院号", required = true, example = "04")
    private int id;

    @ApiModelProperty(value = "学院名称", required = true, example = "信息学院")
    private String name;

    @ApiModelProperty(value = "学院概述", required = false, example = "")
    private String overview;
}

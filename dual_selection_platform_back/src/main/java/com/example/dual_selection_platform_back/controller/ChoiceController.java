package com.example.dual_selection_platform_back.controller;


import com.example.dual_selection_platform_back.model.Choice;
import com.example.dual_selection_platform_back.service.ChoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "API接口")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class ChoiceController {
    @Autowired
    private ChoiceService choiceService;

    @ApiOperation("向Choice插入新数据")
    @PutMapping("/insertChoice/{priority}/{teacher_id}/{student_id}")
    public boolean insertChoice(@PathVariable int priority,@PathVariable int teacher_id, @PathVariable int student_id){
        System.out.println("向Choice插入新数据："+choiceService.insertChoice(priority, teacher_id, student_id));
        return choiceService.insertChoice(priority, teacher_id, student_id);
    }

    @ApiOperation("由student_id查询Choice全部信息")
    @GetMapping("/findChoicebyStuId/{student_id}")
    public List<Choice> findChoicebyStuId(@PathVariable int student_id){
        System.out.println("由student_id查询Choice全部信息："+choiceService.findChoicebyStuId(student_id));
        return choiceService.findChoicebyStuId(student_id);
    }
}

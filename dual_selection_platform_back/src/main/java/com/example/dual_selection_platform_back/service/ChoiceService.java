package com.example.dual_selection_platform_back.service;
import com.example.dual_selection_platform_back.mapper.ChoiceMapper;
import com.example.dual_selection_platform_back.model.Choice;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired; // 导入Autowired注解
import java.util.List;
@Service
public class ChoiceService {
    @Autowired
    private ChoiceMapper choiceMapper;

    public void updateChoiceStatus(int status_id, String detail,int student_id, int teacher_id){
        choiceMapper.updateChoiceStatus(status_id, detail, student_id, teacher_id);
    }
}

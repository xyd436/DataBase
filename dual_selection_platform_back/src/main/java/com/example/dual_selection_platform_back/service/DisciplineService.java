package com.example.dual_selection_platform_back.service;
import com.example.dual_selection_platform_back.mapper.DisciplineMapper;
import com.example.dual_selection_platform_back.model.Discipline;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired; // 导入Autowired注解

import java.util.List;
import java.util.Map;

@Service
public class DisciplineService {
    @Autowired
    private DisciplineMapper disciplineMapper;

    public List<Discipline> getAllDiscipline(){
        return disciplineMapper.getAllDiscipline();
    }

    public int selectDisciplineByCode(String code,String name){
        return disciplineMapper.selectDisciplineByCode(code,name);
    }
}

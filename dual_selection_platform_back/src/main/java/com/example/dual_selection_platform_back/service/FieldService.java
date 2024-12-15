package com.example.dual_selection_platform_back.service;
import com.example.dual_selection_platform_back.mapper.FieldMapper;
import com.example.dual_selection_platform_back.model.Field;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class FieldService {
    @Autowired
    private FieldMapper fieldMapper;

    public List<Field> findByDisciplineId(int disciplineId) {
        return fieldMapper.findByDisciplineId(disciplineId);
    }

    public int findByName(String name) {
        return fieldMapper.findByName(name);
    }

    public Field findFieldbyId(int field_id){
        return fieldMapper.findFieldbyId(field_id);
    }

    public int findFieldbyName(String name){
        return fieldMapper.findFieldbyName(name);
    }

}

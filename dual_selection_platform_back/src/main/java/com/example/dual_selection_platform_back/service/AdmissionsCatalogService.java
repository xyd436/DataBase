package com.example.dual_selection_platform_back.service;

import com.example.dual_selection_platform_back.mapper.AdmissionsCatalogMapper;
import com.example.dual_selection_platform_back.model.AdmissionsCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionsCatalogService {

    @Autowired
    private AdmissionsCatalogMapper admissionsCatalogMapper;

    /**
     * 查询所有信息
     *
     * @param
     * @return List<AdmissionsCatalog>
     */
    public List<AdmissionsCatalog> selectAllAdmissions() {
        return admissionsCatalogMapper.selectAllAdmissions();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.InstitucionGubernamentalDao;
import com.app.sigeeac.model.InstitucionGubernamental;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luish
 */
@Service
@Transactional
public class InstitucionGubernamentalService {
    @Autowired
    private final InstitucionGubernamentalDao InstitucionGubernamentalRepository;
    
    public InstitucionGubernamentalService(InstitucionGubernamentalDao igr){
        this.InstitucionGubernamentalRepository = igr;
    }
    
    public  List<InstitucionGubernamental> findAll(){
        List<InstitucionGubernamental> InstitucionGubernamentals = new ArrayList<>();
        for(InstitucionGubernamental InstitucionGubernamental : InstitucionGubernamentalRepository.findAll()){
            InstitucionGubernamentals.add(InstitucionGubernamental);
        }
        return InstitucionGubernamentals;
    }
    
    public InstitucionGubernamental findOne(Integer id){
        return InstitucionGubernamentalRepository.findOne(id);
    }
    public void save(InstitucionGubernamental ig){
        InstitucionGubernamentalRepository.save(ig);
    }
    public void delete(Integer id){
        InstitucionGubernamentalRepository.delete(id);
    }
}

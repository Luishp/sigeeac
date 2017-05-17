/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.SrolDao;
import com.app.sigeeac.model.Srol;
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
public class SrolService {
    @Autowired
    private final SrolDao srolRepository;
    
    public SrolService(SrolDao srr){
        this.srolRepository = srr;
    }
    
    public  List<Srol> findAll(){
        List<Srol> sroles = new ArrayList<>();
        for(Srol srol : srolRepository.findAll()){
           sroles.add(srol);
        }
        return sroles;
    }
    
    public Srol findOne(Integer id){
        return srolRepository.findOne(id);
    }
    public void save(Srol sr){
        srolRepository.save(sr);
    }
    public void delete(Integer id){
        srolRepository.delete(id);
    }
}

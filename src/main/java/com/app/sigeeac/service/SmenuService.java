/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.SmenuDao;
import com.app.sigeeac.model.Smenu;
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
public class SmenuService {
    @Autowired
    private final SmenuDao SmenuRepository;
    
    public SmenuService(SmenuDao SmenuRepository){
        this.SmenuRepository = SmenuRepository;
    }
    
    public  List<Smenu> findAll(){
        List<Smenu> Smenus = new ArrayList<>();
        for(Smenu Smenu : SmenuRepository.findAll()){
            Smenus.add(Smenu);
        }
        return Smenus;
    }
    
    public Smenu findOne(Integer id){
        return SmenuRepository.findOne(id);
    }
    public void save(Smenu sm){
        SmenuRepository.save(sm);
    }
    public void delete(Integer id){
        SmenuRepository.delete(id);
    }
}

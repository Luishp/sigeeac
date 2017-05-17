/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.SpermisoDao;
import com.app.sigeeac.model.Spermiso;
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
public class SpermisoService {
    @Autowired
    private final SpermisoDao spermisoRepository;
    
    public SpermisoService(SpermisoDao spd){
        this.spermisoRepository = spd;
    }
    
    public List<Spermiso> findAll(){
        List<Spermiso> sps = new ArrayList<>();
        for(Spermiso spermiso : spermisoRepository.findAll()){
            sps.add(spermiso);
        }
        return sps;
    }
    public Spermiso findOne(Integer id){
        return   spermisoRepository.findOne(id);
    }
    public void save(Spermiso sp){
        spermisoRepository.save(sp);
    }
    public void delete(Integer id){
        spermisoRepository.delete(id);
    }
}

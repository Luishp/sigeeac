/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.BitacoraDao;
import com.app.sigeeac.model.Bitacora;
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
public class BitacoraService {
    @Autowired
    private final BitacoraDao myRepository;
    
    public BitacoraService(BitacoraDao dao){
        this.myRepository = dao;
    }
    
    public  List<Bitacora> findAll(){
        List<Bitacora> registros = new ArrayList<>();
        for(Bitacora item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public Bitacora findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(Bitacora newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

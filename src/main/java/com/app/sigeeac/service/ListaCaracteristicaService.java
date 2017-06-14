/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.ListaCaracteristicaDao;
import com.app.sigeeac.model.ListaCaracteristica;
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
public class ListaCaracteristicaService {
    @Autowired
    private final ListaCaracteristicaDao myRepository;
    
    public ListaCaracteristicaService(ListaCaracteristicaDao dao){
        this.myRepository = dao;
    }
    
    public  List<ListaCaracteristica> findAll(){
        List<ListaCaracteristica> registros = new ArrayList<>();
        for(ListaCaracteristica item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public ListaCaracteristica findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(ListaCaracteristica newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

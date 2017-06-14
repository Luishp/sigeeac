/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.UnidadAdministrativaDao;
import com.app.sigeeac.model.UnidadAdministrativa;
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
public class UnidadAdministrativaService {
    @Autowired
    private final UnidadAdministrativaDao myRepository;
    
    public UnidadAdministrativaService(UnidadAdministrativaDao dao){
        this.myRepository = dao;
    }
    
    public  List<UnidadAdministrativa> findAll(){
        List<UnidadAdministrativa> registros = new ArrayList<>();
        for(UnidadAdministrativa item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public UnidadAdministrativa findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(UnidadAdministrativa newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

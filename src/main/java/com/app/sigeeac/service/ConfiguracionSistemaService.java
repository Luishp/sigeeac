/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.ConfiguracionSistemaDao;
import com.app.sigeeac.model.ConfiguracionSistema;
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
public class ConfiguracionSistemaService {
    @Autowired
    private final ConfiguracionSistemaDao myRepository;
    
    public ConfiguracionSistemaService(ConfiguracionSistemaDao dao){
        this.myRepository = dao;
    }
    
    public  List<ConfiguracionSistema> findAll(){
        List<ConfiguracionSistema> registros = new ArrayList<>();
        for(ConfiguracionSistema item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public ConfiguracionSistema findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(ConfiguracionSistema newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.EquipoElectrico;
import com.app.sigeeac.service.EquipoElectricoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luish
 */
@RestController
@RequestMapping("/equipoElectrico")
public class EquipoElectricoRest {
    @Autowired
    private EquipoElectricoService myService;
    
    @RequestMapping("/all")
    public List<EquipoElectrico> getAllEquipoElectrico(){
        return myService.findAll();
    }
    @RequestMapping("/getById/{id}")
    public EquipoElectrico getEquipoElectricoById(@PathVariable("id") String id){
        return myService.findOne(Integer.parseInt(id));
    }
    @RequestMapping(method=RequestMethod.POST, value="/save")
    public void addEquipoElectrico(@RequestBody EquipoElectrico newRecord){
        myService.save(newRecord);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateEquipoElectrico(@RequestBody EquipoElectrico record, @PathVariable("id") String id){
        myService.save(record);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteEquipoElectrico(@PathVariable("id") String id){
        myService.delete(Integer.parseInt(id));
    }
}

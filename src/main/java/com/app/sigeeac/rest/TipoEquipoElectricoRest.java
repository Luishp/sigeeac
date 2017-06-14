/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.TipoEquipoElectrico;
import com.app.sigeeac.service.TipoEquipoElectricoService;
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
@RequestMapping("/tipoElectrico")
public class TipoEquipoElectricoRest {
    @Autowired
    private TipoEquipoElectricoService myService;
    
    @RequestMapping("/all")
    public List<TipoEquipoElectrico> getAllTipoEquipoElectrico(){
        return myService.findAll();
    }
    @RequestMapping("/getById/{id}")
    public TipoEquipoElectrico getTipoEquipoElectricoById(@PathVariable("id") String id){
        return myService.findOne(Integer.parseInt(id));
    }
    @RequestMapping(method=RequestMethod.POST, value="/save")
    public void addTipoEquipoElectrico(@RequestBody TipoEquipoElectrico newRecord){
        myService.save(newRecord);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateTipoEquipoElectrico(@RequestBody TipoEquipoElectrico record, @PathVariable("id") String id){
        myService.save(record);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteTipoEquipoElectrico(@PathVariable("id") String id){
        myService.delete(Integer.parseInt(id));
    }
}

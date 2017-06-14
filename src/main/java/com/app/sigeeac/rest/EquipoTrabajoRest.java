/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.EquipoTrabajo;
import com.app.sigeeac.service.EquipoTrabajoService;
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
@RequestMapping("/equipoTrabajo")
public class EquipoTrabajoRest {
    @Autowired
    private EquipoTrabajoService myService;
    
    @RequestMapping("/all")
    public List<EquipoTrabajo> getAllEquipoTrabajo(){
        return myService.findAll();
    }
    @RequestMapping("/getById/{id}")
    public EquipoTrabajo getEquipoTrabajoById(@PathVariable("id") String id){
        return myService.findOne(Integer.parseInt(id));
    }
    @RequestMapping(method=RequestMethod.POST, value="/save")
    public void addEquipoTrabajo(@RequestBody EquipoTrabajo newRecord){
        myService.save(newRecord);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateEquipoTrabajo(@RequestBody EquipoTrabajo record, @PathVariable("id") String id){
        myService.save(record);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteEquipoTrabajo(@PathVariable("id") String id){
        myService.delete(Integer.parseInt(id));
    }
}

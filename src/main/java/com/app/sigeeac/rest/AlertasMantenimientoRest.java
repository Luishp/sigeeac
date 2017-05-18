/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.AlertasMantenimiento;
import com.app.sigeeac.service.AlertasMantenimientoService;
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
@RequestMapping("/alertasMantto")
public class AlertasMantenimientoRest {
    @Autowired
    private AlertasMantenimientoService amService;
    
    @RequestMapping("/all")
    public List<AlertasMantenimiento> getAllAlertas(){
        return amService.findAll();
    }
    @RequestMapping("getById/{id}")
    public AlertasMantenimiento getAlertaById(@PathVariable("id") String id){
        return amService.findOne(Integer.parseInt(id));
    }
    @RequestMapping(method=RequestMethod.POST, value="/save")
    public void addAlerta(@RequestBody AlertasMantenimiento am){
        amService.save(am);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateAlerta(@RequestBody AlertasMantenimiento am, @PathVariable("id") String id){
        amService.save(am);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteAlerta(@PathVariable("id") String id){
        amService.delete(Integer.parseInt(id));
    }
}

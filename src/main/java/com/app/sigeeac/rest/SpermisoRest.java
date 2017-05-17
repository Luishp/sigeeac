/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.Spermiso;
import com.app.sigeeac.service.SpermisoService;
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
@RequestMapping("/spermiso")
public class SpermisoRest {
    @Autowired
    private SpermisoService spService;
    
    @RequestMapping("/all")
    public List<Spermiso> getAllPermiso(){
        return spService.findAll();
    }
    @RequestMapping("getById/{id}")
    public Spermiso getPermisoById(@PathVariable("id") String id){
        return spService.findOne(Integer.parseInt(id));
    }
    @RequestMapping(method=RequestMethod.POST, value="/save")
    public void addPermiso(@RequestBody Spermiso sp){
    spService.save(sp);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updatePermiso(@RequestBody Spermiso sm, @PathVariable("id") String id){
        spService.save(sm);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deletePermiso(@PathVariable("id") String id){
        spService.delete(Integer.parseInt(id));
    }
    
}

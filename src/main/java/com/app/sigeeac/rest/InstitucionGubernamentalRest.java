/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.InstitucionGubernamental;
import com.app.sigeeac.service.InstitucionGubernamentalService;
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
@RequestMapping("/instGob")
public class InstitucionGubernamentalRest {
    @Autowired
    private InstitucionGubernamentalService insGobService;
    
    @RequestMapping("/all")
    public List<InstitucionGubernamental> getAllGobs(){
        return insGobService.findAll();
    }
    @RequestMapping("getById/{id}")
    public InstitucionGubernamental getGobById(@PathVariable("id") String id){
        return insGobService.findOne(Integer.parseInt(id));
    }
    @RequestMapping(method=RequestMethod.POST, value="/save")
    public void addInstGob(@RequestBody InstitucionGubernamental ig){
        insGobService.save(ig);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateInstGob(@RequestBody InstitucionGubernamental ig, @PathVariable("id") String id){
        insGobService.save(ig);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteInstGob(@PathVariable("id") String id){
        insGobService.delete(Integer.parseInt(id));
    }
}

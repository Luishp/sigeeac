/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.Srol;
import com.app.sigeeac.service.SrolService;
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
@RequestMapping("/srol")
public class SrolRest {
    @Autowired
    private SrolService srolService;
    
    @RequestMapping("/all")
    public List<Srol> getAllGobs(){
        return srolService.findAll();
    }
    @RequestMapping("getById/{id}")
    public Srol getRolById(@PathVariable("id") String id){
        return srolService.findOne(Integer.parseInt(id));
    }
    @RequestMapping(method=RequestMethod.POST, value="/save")
    public void addRol(@RequestBody Srol sr){
        srolService.save(sr);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateRol(@RequestBody Srol sr, @PathVariable("id") String id){
        srolService.save(sr);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteRol(@PathVariable("id") String id){
        srolService.delete(Integer.parseInt(id));
    }
}

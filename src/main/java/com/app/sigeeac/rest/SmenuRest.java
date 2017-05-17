/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.InstitucionGubernamental;
import com.app.sigeeac.model.Smenu;
import com.app.sigeeac.service.InstitucionGubernamentalService;
import com.app.sigeeac.service.SmenuService;
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
@RequestMapping("/smenu")
public class SmenuRest {
    @Autowired
    private SmenuService smenuService;
    
    @RequestMapping("/all")
    public List<Smenu> getAllMenus(){
        return smenuService.findAll();
    }
    @RequestMapping("getById/{id}")
    public Smenu getMenuById(@PathVariable("id") String id){
        return smenuService.findOne(Integer.parseInt(id));
    }
    @RequestMapping(method=RequestMethod.POST, value="/save")
    public void addMenu(@RequestBody Smenu sm){
    smenuService.save(sm);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateMenu(@RequestBody Smenu sm, @PathVariable("id") String id){
        smenuService.save(sm);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteMenu(@PathVariable("id") String id){
        smenuService.delete(Integer.parseInt(id));
    }
}

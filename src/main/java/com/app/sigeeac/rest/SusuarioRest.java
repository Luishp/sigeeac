/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.Susuario;
import com.app.sigeeac.service.SusuarioService;
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
@RequestMapping("/susuario")
public class SusuarioRest {
    @Autowired
    private SusuarioService userService;
    
    @RequestMapping("/all")
    public List<Susuario> getAllUsuario(){
        return userService.findAll();
    }
    @RequestMapping("getById/{id}")
    public Susuario getUsuarioById(@PathVariable("id") String id){
        return userService.findOne(Integer.parseInt(id));
    }
    @RequestMapping(method=RequestMethod.POST, value="/save")
    public void addUsuario(@RequestBody Susuario user){
        userService.save(user);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateUsuario(@RequestBody Susuario user,@PathVariable("id") String id){
        userService.save(user);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteInstGob(@PathVariable("id") String id){
        userService.delete(Integer.parseInt(id));
    }
}

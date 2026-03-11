package com.lpu.ApiGateWay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lpu.ApiGateWay.entity.Userss;
import com.lpu.ApiGateWay.service.UserssService;

@RestController
@RequestMapping("/userss")
public class UserssController {

    @Autowired
    private UserssService service;

    @PostMapping("/add")
    public String addUserss(@RequestBody Userss u) {
        service.addUserss(u);
        return "saved";
    }

    @GetMapping("/all")
    public List<Userss> getUserss() {
        return service.getAllUserss();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserss(@PathVariable int id) {
        service.deleteUserss(id);
        return "Userss Deleted";
    }

    @PutMapping("/update")
    public Userss updateUserss(@RequestBody Userss u) {
        return service.updateUserss(u);
    }
}
package com.lpu.ApiGateWay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.ApiGateWay.entity.Userss;
import com.lpu.ApiGateWay.repository.UserssRepository;

@Service
public class UserssService {

    @Autowired
    private UserssRepository repo;

    public Userss addUserss(Userss u) {
        return repo.save(u);
    }

    public List<Userss> getAllUserss() {
        return repo.findAll();
    }

    public void deleteUserss(int id) {
        repo.deleteById(id);
    }

    public Userss updateUserss(Userss u) {
        return repo.save(u);
    }
}
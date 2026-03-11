package com.lpu.ApiGateWay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.ApiGateWay.entity.Payment;
import com.lpu.ApiGateWay.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repo;

    public Payment savePayment(Payment p) {
        return repo.save(p);
    }

    public List<Payment> getAllPayments() {
        return repo.findAll();
    }
    public Payment findbyId(int id) {
    	return repo.findById(id).orElse(null);
    }

    public void deletePayment(int id) {
        repo.deleteById(id);
    }

    public Payment updatePayment(Payment p) {
        return repo.save(p);
    }
}
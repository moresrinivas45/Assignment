package com.lpu.ApiGateWay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lpu.ApiGateWay.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer>{

}
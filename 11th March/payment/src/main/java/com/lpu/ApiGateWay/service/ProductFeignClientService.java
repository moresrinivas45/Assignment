package com.lpu.ApiGateWay.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("product")//instance name
public interface ProductFeignClientService {
	
	@GetMapping("/product/feign")
	public String getttt();

}

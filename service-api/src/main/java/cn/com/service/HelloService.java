package cn.com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "eurka-service")
public interface HelloService {
	
	@GetMapping("/sayHello")
	void sayHello(@RequestParam(name="name") String name);

	
	@GetMapping(value="/getHello")
	String getHello(@RequestParam(name="name") String name);
}

package cn.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.service.HelloService;

@RestController
public class ClientController {

	@Autowired
	private HelloService helloService;

	@RequestMapping(value="/hello",method= RequestMethod.GET)
	public void invokeHello() {
		helloService.sayHello("lucy");
	}
	
	@RequestMapping(value = "/getHello", method = RequestMethod.GET)
	public String getHello() {
		System.out.println("Client get hello");
		return helloService.getHello("Client");
	}
	
	@GetMapping("/hello2")
	public void invokeHello2() {
		System.out.println("no invike...");
	}

}

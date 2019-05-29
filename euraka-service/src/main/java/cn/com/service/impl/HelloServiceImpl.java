package cn.com.service.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloServiceImpl{

	
	@RequestMapping(value="/sayHello",method=RequestMethod.GET)
	public void sayHello(@RequestParam(name="name") String name) {
		System.out.println("hello "+name);
	}

	
	@RequestMapping(value="/getHello",method=RequestMethod.GET)
	public String getHello(@RequestParam(name="name") String name) {
		return "hello "+name;
	}

}

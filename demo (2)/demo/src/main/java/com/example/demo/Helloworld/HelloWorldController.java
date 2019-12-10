package com.example.demo.Helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController
{
	@Autowired
	private MessageSource messageSource; 

	@GetMapping(path="hello-world")
	public String helloworld(){
		return "hello world";
	}
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloworldBean(){
		return new HelloWorldBean ("hello world");
	}
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloworldBeanPathVariable(@PathVariable String name){
		return new HelloWorldBean (String.format("hello world %s",name));
	}
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, 
									LocaleContextHolder.getLocale());
	}

}

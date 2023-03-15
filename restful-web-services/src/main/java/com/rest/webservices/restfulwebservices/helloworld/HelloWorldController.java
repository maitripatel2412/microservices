package com.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource=messageSource;
	}
	
//	@RequestMapping(method= RequestMethod.GET,path="/hello-world")
	@GetMapping("/hello-world")
	public String helloworld() {
		return "hello world";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloworldBean() {
		return new HelloWorldBean("hello world");
	}

	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloworldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("hello world " + name);
	}
	
	@GetMapping("/hello-world-Internationalized")
	public String helloworldInternationalized() {
		Locale Locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "default message", Locale );
		//return "hello world v2";
	}
	
}

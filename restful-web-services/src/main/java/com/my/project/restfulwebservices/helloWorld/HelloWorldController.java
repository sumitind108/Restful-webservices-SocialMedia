package com.my.project.restfulwebservices.helloWorld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Rest API

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource=messageSource;
	}
	
	// /hello-world
	@GetMapping(path= "/hello-world")
	public String HelloController() {
		return "Hello World";
	}
	
	@GetMapping(path= "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("hello mr. %s", name));
	}
	
	
	// /hello-world-internationalisation
		@GetMapping(path= "/hello-world-internationalization")
		public String HelloControllerinternationalization() {
			Locale locale= LocaleContextHolder.getLocale();
			return messageSource.getMessage("good.morning.message", null, "default", locale);
			//return "Hello World internation";
		}

}

package com.my.project.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class filteringController {
	
	@GetMapping("/filtering")
	public SomeBean filtering() {
		
		return new SomeBean("value1", "value2", "value3");
		
	}

}

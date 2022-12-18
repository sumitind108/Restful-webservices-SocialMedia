package com.my.project.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class versionController {	
	
	@GetMapping("/v1/person")
	public PersonV1 getfirstVersionOfPerson() {
		return new PersonV1("sumit yadav");
	}
	
	
	@GetMapping("/v2/person")
	public PersonV2 getsecondVersionOfPerson() {
		return new PersonV2(new Name("Sumit", "yadav"));
	}
	
	
//	@GetMapping(path= "/person", params= "version=1")
//	public PersonV1 getfirstVersionOfPersonRequestParameter() {
//		return new PersonV1("sumit yadav");
	@GetMapping(path="/person", params="version=1")
	public PersonV1 getfirstVersionOfPersonRequestParameter() {
		return new PersonV1("sumit yadav");
	}
	
	

}

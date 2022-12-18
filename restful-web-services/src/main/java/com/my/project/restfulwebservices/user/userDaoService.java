package com.my.project.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class userDaoService {
	
	//JPA/hibernate -> database
	//userDaoService -> static list
	
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 0;
	
	static {
		users.add(new User(usersCount++, "sumit", LocalDate.now().minusYears(24)));
		users.add(new User(usersCount++, "Raj", LocalDate.now().minusYears(28)));
		users.add(new User(usersCount++, "Mandeep", LocalDate.now().minusYears(25)));
	}
	
	
//	 public List<User> findAll1(){
//		 return users;
//	 }


	public List<User> findAll() {
		// TODO Auto-generated method stub
		return users;
	}
	
	// public User save(User save){
	
	 public User findOne(int id){
		 Predicate<? super User> predicate = user -> user.getId() == id;
		return users.stream().filter(predicate).findFirst().get();
	 }
	 
	 
	 
	 public Object deletebyid(int id){
		 Predicate<? super User> predicate = user -> user.getId() == id;
		 return users.removeIf(predicate);
	 }
	 
	 
	 
	 
	 
	 public User save(User user) {
		 user.setId(++usersCount);
		 users.add(user);
		 return user;
	 }
}

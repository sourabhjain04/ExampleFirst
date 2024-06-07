package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.UserRepository;
import com.example.demo.entites.User;

@SpringBootApplication
public class DemoJpaApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(DemoJpaApplication.class);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		User user1 = new User();
		user1.setName("AIsiri");
		user1.setCity("Banglore");
		user1.setStatus("I am from Boeing");
		
		
		User user2 = new User();
		user2.setName("Sourabh");
		user2.setCity("Indore");
		user2.setStatus("I am from koenig");
		
		//User resultUser = userRepository.save(user2);
		
		List<User> users = List.of(user1,user2);
		Iterable<User> result = userRepository.saveAll(users); 
		
		result.forEach(user->{
			System.out.println(user);
			});
		
		System.out.println(result);
		System.out.println("Completed");
		
		Optional<User> optional = userRepository.findById(2);
		User user = optional.get();
		
		user.setName("Vedika");
		
		userRepository.save(user);
		System.out.println(user);
	
//		userRepository.deleteById(2);
//		System.out.println("deleted");
//		
		
		
	}

}

package com.mandalorian.todo.config;

import java.time.Instant;
import java.util.Arrays;

import com.mandalorian.todo.entities.ToDo;
import com.mandalorian.todo.entities.User;
import com.mandalorian.todo.entities.UserProfile;
import com.mandalorian.todo.repositories.ToDoRepository;
import com.mandalorian.todo.repositories.UserProfileRepository;
import com.mandalorian.todo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private ToDoRepository toDoRepository;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository profileRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(1L, "Senku Ishigami", "123", Instant.parse("2023-10-10T19:53:07Z"), "Senku Ishigami",
				Instant.parse("2022-02-10T19:53:07Z"), "Senku Ishigami", Instant.parse("2022-02-10T19:53:07Z"), "https://pt.wikipedia.org/wiki/Dr._Stone#/media/Ficheiro:Doctor_stone.jpg", "0", null);
		User u2 = new User(2L, "Monkey D. Luffy", "123", Instant.parse("2023-02-10T19:53:07Z"), "Monkey D. Luffy",
				Instant.parse("2022-02-10T19:53:07Z"), "Monkey D. Luffy", Instant.parse("2022-02-10T19:53:07Z"), "https://en.wikipedia.org/wiki/Monkey_D._Luffy#/media/File:Monkey_D_Luffy.png", "1", null);
		User u3 = new User(3L, "Light Yagami", "123", Instant.parse("2022-02-10T19:53:07Z"), "Light Yagami",
				Instant.parse("2022-02-10T19:53:07Z"), "Light Yagami", Instant.now(), "https://vignette.wikia.nocookie.net/villains/images/5/54/Light_YagamiHD.jpg/revision/latest?cb=20180414020152", "1", null);



		ToDo t1 = new ToDo( 1L,"Estudar", Instant.parse("2023-07-20T19:53:07Z"),null,Instant.parse("2021-09-20T19:53:07Z"),null,"ToDo",null,null);
		ToDo t2 = new ToDo( 2L,"Estudar Java",Instant.parse("2023-10-20T19:53:07Z"),null,Instant.parse("2021-09-20T19:53:07Z"),null,"ToDo",null,null);
		ToDo t3 = new ToDo( 3L,"Estudar React",Instant.parse("2023-09-20T19:53:07Z"),null,Instant.parse("2021-09-20T19:53:07Z"),null,"ToDo",null,null);

		UserProfile p1 = new UserProfile(1L,"admin", Instant.parse("2023-07-20T19:53:07Z"), "Senku Ishigami",Instant.parse("2023-07-20T19:53:07Z"),"Senku Ishigami");
		UserProfile p2 = new UserProfile(2L,"client", Instant.parse("2023-07-20T19:53:07Z"), "Senku Ishigami",Instant.parse("2023-07-20T19:53:07Z"),"Senku Ishigami");


		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		toDoRepository.saveAll(Arrays.asList(t1,t2,t3));
		profileRepository.saveAll(Arrays.asList(p1, p2));


	}
	
	
}

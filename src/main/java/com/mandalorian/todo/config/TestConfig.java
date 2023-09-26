package com.mandalorian.todo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mandalorian.todo.entities.TaskEntity;
import com.mandalorian.todo.repositories.TaskRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public void run(String... args) throws Exception {

		TaskEntity t1 = new TaskEntity(1L, "Estudar React", false);
		TaskEntity t2 = new TaskEntity(2L, "Estudar Java", false);
		TaskEntity t3 = new TaskEntity(3L, "Criar API com SpringBoot", false);
		
		taskRepository.saveAll(Arrays.asList(t1,t2,t3));
		
	}
	
	
}

package com.mandalorian.todo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mandalorian.todo.entities.TaskEntity;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {
	@GetMapping
	public ResponseEntity<TaskEntity> findAll(){
		TaskEntity t = new TaskEntity(1L,"Estudar React",false);
		return ResponseEntity.ok().body(t);
	}

}

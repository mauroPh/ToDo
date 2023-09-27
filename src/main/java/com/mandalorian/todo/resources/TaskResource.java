package com.mandalorian.todo.resources;

import com.mandalorian.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mandalorian.todo.entities.TaskEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {
	@Autowired
	private TaskService service;
	@GetMapping
	public ResponseEntity<List<TaskEntity>> findAll(){
		List<TaskEntity> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TaskEntity> findById(@PathVariable Long id){
		TaskEntity obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

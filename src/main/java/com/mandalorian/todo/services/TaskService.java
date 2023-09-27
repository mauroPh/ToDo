package com.mandalorian.todo.services;

import com.mandalorian.todo.entities.TaskEntity;
import com.mandalorian.todo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService  {
    @Autowired
    private TaskRepository repository;

    public List<TaskEntity> findAll(){
        return repository.findAll();
    }
    public TaskEntity findById(Long id){
        Optional<TaskEntity> obj = repository.findById(id);
        return obj.get();
    }
}

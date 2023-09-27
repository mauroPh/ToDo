package com.mandalorian.todo.services;

import com.mandalorian.todo.entities.TaskEntity;
import com.mandalorian.todo.repositories.TaskRepository;
import com.mandalorian.todo.services.exceptions.DatabaseException;
import com.mandalorian.todo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public TaskEntity insert(TaskEntity obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
       try {
           repository.deleteById(id);
       }catch (EmptyResultDataAccessException e){
           throw new com.mandalorian.todo.services.exceptions.ResourceNotFoundException(id);
       }catch(DataIntegrityViolationException e){
           throw new DatabaseException(e.getMessage());
       }
    }

    public TaskEntity update(Long id, TaskEntity obj) {
        try {
            TaskEntity entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
    }catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
    private void updateData(TaskEntity entity, TaskEntity obj) {
        entity.setDescription(obj.getDescription());
        entity.setCompleted(obj.isCompleted());
    }
}

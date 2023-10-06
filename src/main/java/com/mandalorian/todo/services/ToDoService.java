package com.mandalorian.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mandalorian.todo.entities.ToDo;
import com.mandalorian.todo.repositories.ToDoRepository;
import com.mandalorian.todo.services.exceptions.DatabaseException;
import com.mandalorian.todo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository repository;

    public List<ToDo> findAll() {
        return repository.findAll();
    }

    public ToDo findById(Long id) {
        Optional<ToDo> obj = repository.findById(id);
        return obj.get();
    }

    public ToDo insert(ToDo obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new com.mandalorian.todo.services.exceptions.ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public ToDo update(Long id, ToDo obj) {
        try {
            ToDo entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(ToDo entity, ToDo obj) {
        entity.setDescription(obj.getDescription());
    }
}

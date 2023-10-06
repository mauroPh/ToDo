package com.mandalorian.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mandalorian.todo.entities.UserProfile;
import com.mandalorian.todo.repositories.UserProfileRepository;
import com.mandalorian.todo.services.exceptions.DatabaseException;
import com.mandalorian.todo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepository repository;

    public List<UserProfile> findAll() {
        return repository.findAll();
    }

    public UserProfile findById(Long id) {
        Optional<UserProfile> obj = repository.findById(id);
        return obj.get();
    }

    public UserProfile insert(UserProfile obj) {
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

    public UserProfile update(Long id, UserProfile obj) {
        try {
            UserProfile entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(UserProfile entity, UserProfile obj) {

        entity.setDescription(obj.getDescription());

    }
}

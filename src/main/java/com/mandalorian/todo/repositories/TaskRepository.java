package com.mandalorian.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mandalorian.todo.entities.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long>{

}

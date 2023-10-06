package com.mandalorian.todo.repositories;

import com.mandalorian.todo.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long>{

}

package com.mandalorian.todo.repositories;

import com.mandalorian.todo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long > {

}

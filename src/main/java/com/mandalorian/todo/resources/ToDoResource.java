package com.mandalorian.todo.resources;

import java.util.List;

import com.mandalorian.todo.entities.ToDo;
import com.mandalorian.todo.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/todos/")
public class ToDoResource {
    @Autowired
    private ToDoService service;

    @GetMapping
    public ResponseEntity<List<ToDo>> findAll() {
        List<ToDo> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDo> findById(@PathVariable Long id) {
        ToDo obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping

    public ResponseEntity<ToDo> insert(@RequestBody ToDo obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ToDo> update(@PathVariable Long id, @RequestBody ToDo obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}

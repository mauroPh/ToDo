package com.mandalorian.todo.resources;

import java.util.List;

import com.mandalorian.todo.entities.UserProfile;
import com.mandalorian.todo.services.UserProfileService;
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
@RequestMapping(value = "/profiles/")
public class UserProfileResource {
    @Autowired
    private UserProfileService service;

    @GetMapping
    public ResponseEntity<List<UserProfile>> findAll() {
        List<UserProfile> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserProfile> findById(@PathVariable Long id) {
        UserProfile obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping

    public ResponseEntity<UserProfile> insert(@RequestBody UserProfile obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserProfile> update(@PathVariable Long id, @RequestBody UserProfile obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}

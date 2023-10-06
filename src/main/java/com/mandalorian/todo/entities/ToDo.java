package com.mandalorian.todo.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_todos")
public class ToDo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd   'T' HH : mm:ss'Z'", timezone = "GMT")
    private Instant createdOn;

    private Long createdBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd   'T' HH : mm:ss'Z'", timezone = "GMT")
    private Instant modifiedOn;
    private Long modifiedBy;
    private String state;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User todoUser;

    public ToDo() {

    }

    public ToDo(Long todoId, String description, Instant createdOn, Long createdBy, Instant modifiedOn,Long modifiedBy, String state, String imageUrl, User todoUser) {
        this.todoId = todoId;
        this.description = description;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.modifiedOn = modifiedOn;
        this.modifiedBy = modifiedBy;
        this.state = state;
        this.imageUrl = imageUrl;
        this.todoUser = todoUser;
    }

    public Long getToDoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Instant modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Nullable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@Nullable String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getTodoUser() {
        return todoUser;
    }

    public void setTodoUser(User todoUser) {
        this.todoUser = todoUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToDo todo)) return false;
        return Objects.equals(getToDoId(), todo.getToDoId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getToDoId());
    }
}
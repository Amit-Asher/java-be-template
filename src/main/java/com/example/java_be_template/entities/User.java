package com.example.java_be_template.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "users",
        indexes = { @Index(name = "idx_name", columnList = "name") },
        uniqueConstraints = { @UniqueConstraint(name = "unique_name_created_at", columnNames = { "name", "created_at" }) }
)
public class User {

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt; // Add createdAt field of type LocalDateTime

    public User(String name) {
        this.name = name;
    }

    public User() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
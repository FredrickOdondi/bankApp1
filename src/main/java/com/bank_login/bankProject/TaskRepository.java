package com.bank_login.bankProject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // This is like a way to access data
    //The Spring Data JPA auto-implements basic CRUD methods!
    // JPA provides methods such as save(), findAll(), deleteById()
}

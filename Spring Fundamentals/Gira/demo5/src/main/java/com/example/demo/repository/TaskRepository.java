package com.example.demo.repository;

import com.example.demo.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> getAllBy();

    @Query("SELECT t FROM Task t WHERE t.id = :id")
    Task findTaskById(Long id);
}

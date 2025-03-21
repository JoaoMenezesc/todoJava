package com.todoJava.todoJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.todoJava.todoJava.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


}

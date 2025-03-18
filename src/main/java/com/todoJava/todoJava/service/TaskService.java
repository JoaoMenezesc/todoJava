package com.todoJava.todoJava.service;

import com.todoJava.todoJava.model.Task;
import com.todoJava.todoJava.repository.TaskRepository;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTaskById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Task saveTask(Task task) {
        return repository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        return repository.findById(id)
                .map(
                existingTask -> {
                    existingTask.setTitle(task.getTitle());
                    existingTask.setCompleted(task.isCompleted());
                    return repository.save(existingTask);
                }
        ).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

}

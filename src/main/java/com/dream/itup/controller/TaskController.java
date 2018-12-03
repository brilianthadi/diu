package com.dream.itup.controller;

import com.dream.itup.persistence.model.Task;
import com.dream.itup.persistence.repo.TaskRepository;
import com.dream.itup.web.exception.TaskIdMismatchException;
import com.dream.itup.web.exception.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List<Task> findByTitle(@PathVariable String taskName) {
        return taskRepository.findByName(taskName);
    }

    @GetMapping("/{id}")
    public Task findOne(@PathVariable long id) {
        return taskRepository.findById(id)
                .orElseThrow(TaskNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody Task book) {
        Task book1 = taskRepository.save(book);
        return book1;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        taskRepository.findById(id)
                .orElseThrow(TaskNotFoundException::new);
        taskRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Task updateBook(@RequestBody Task book, @PathVariable long id) {
        if (book.getId() != id) {
            throw new TaskIdMismatchException();
        }
        taskRepository.findById(id)
                .orElseThrow(TaskNotFoundException::new);
        return taskRepository.save(book);
    }
}

package com.dream.itup.persistence.repo;

import com.dream.itup.persistence.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByName(String name);
}
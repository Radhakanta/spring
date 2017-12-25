package org.spring.samples.bootstrap.dao;

import org.spring.samples.bootstrap.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}

package org.spring.samples.bootstrap.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.spring.samples.bootstrap.dao.TaskRepository;
import org.spring.samples.bootstrap.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TaskService {
	static Logger logger = Logger.getLogger(TaskService.class.getName());
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> findAll() {
		List<Task> tasks = new ArrayList<>();
		
		logger.debug("TaskService::findAll");
		for(Task task : taskRepository.findAll()) {
			logger.debug("TaskService - Task : " + task);
			tasks.add(task);
		}
		return tasks;
	}

}

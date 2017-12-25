package org.spring.samples.bootstrap.controller;

import java.util.List;

import org.spring.samples.bootstrap.model.Task;
import org.spring.samples.bootstrap.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring boot";
	}	
	
	@GetMapping("/tasks")
	List<Task> getAllTasks() {
		return taskService.findAll();
	}

}

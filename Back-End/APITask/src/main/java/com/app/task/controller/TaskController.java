package com.app.task.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.task.model.entity.Task;
import com.app.task.service.TaskService;

@RestController
public class TaskController {
	
	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	//localhost:8080/post
	@PostMapping("/post")
	public Task post(@RequestBody Task task) { //RequestBody transforma el Json en objeto
		return taskService.post(task);
	}
	
	//localhost:8080/
	@GetMapping
	public List<Task> findAll() { //RequestBody transforma el Json en objeto
		return taskService.findAll();
	}
	
	//localhost:8080/id
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		taskService.deleteById(id);
	}
	
	@PutMapping
	public Task update(@RequestBody Task task) {
		Task taskDb = taskService.findById(task.getId());
		taskDb.setTitle(task.getTitle());
		taskDb.setDescription(task.getDescription());
		taskDb.setStatus(task.getStatus());
		return taskService.update(taskDb);
	}
}

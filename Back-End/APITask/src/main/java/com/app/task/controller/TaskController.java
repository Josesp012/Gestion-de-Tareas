package com.app.task.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.task.dto.TaskDto;
import com.app.task.mapper.Mapper;
import com.app.task.model.entity.Task;
import com.app.task.service.TaskService;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/api/tasks") // http://localhost:8080/api/tasks
public class TaskController {
	
	private final TaskService taskService;
	
	private final Mapper mapper;
	
	public TaskController(TaskService taskService, Mapper mapper) {
		this.taskService = taskService;
		this.mapper = mapper;
	}
	
	// http://localhost:8080/api/tasks Peticion tipo Post
	@PostMapping("/post")
	public ResponseEntity<TaskDto> post(@RequestBody TaskDto taskDto) { //RequestBody transforma el Json en objeto
		Task task = Mapper.dtoToEntity(taskDto);
		Task createdTask = taskService.post(task);
		TaskDto createddto = Mapper.entityToDto(createdTask);
        return new ResponseEntity<>(createddto, HttpStatus.CREATED);
	}
	
	// http://localhost:8080/api/tasks Peticion tipo Get
	@GetMapping
	public List<TaskDto> findAll(TaskDto dto) {//RequestBody transforma el Json en objeto
		List<Task> tasks = taskService.findAll();
	    return tasks.stream()
	                .map(Mapper::entityToDto)
	                .collect(Collectors.toList());
	}
	
	// http://localhost:8080/api/tasks/1 Peticion tipo Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		taskService.findById(id);
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
	}
	
	// http://localhost:8080/api/tasks/1 Peticion tipo Put
	@PutMapping
	public ResponseEntity<TaskDto> update(@RequestBody TaskDto taskDto) {
		Task taskDb = taskService.findById(taskDto.getId());
		
		taskDb.setTitle(taskDto.getTitle());
		taskDb.setDescription(taskDto.getDescription());
		taskDb.setStatus(taskDto.getStatus());
		
		Task updatedTask = taskService.update(taskDb);
		TaskDto updatedDto = Mapper.entityToDto(updatedTask);
        return ResponseEntity.ok(updatedDto);
	}
	
	// http://localhost:8080/api/tasks/1
	@GetMapping("/{id}")
	public ResponseEntity<TaskDto> findById(@PathVariable Long id) {
		Task task = taskService.findById(id);
		TaskDto dto = Mapper.entityToDto(task);
        return ResponseEntity.ok(dto);
	}
}

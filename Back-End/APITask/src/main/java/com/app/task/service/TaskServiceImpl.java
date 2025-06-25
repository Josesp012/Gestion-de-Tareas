package com.app.task.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.task.exception.ResourceNotFoundException;
import com.app.task.model.entity.Task;
import com.app.task.model.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	private final TaskRepository taskRepository;
	
	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public Task post(Task task) {
		try {
			return taskRepository.save(task);
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		taskRepository.deleteById(id);
	}

	@Override
	public Task update(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task findById(Long id) {
		return taskRepository.findById(id).orElseThrow(
				()->{
					throw new ResourceNotFoundException("No se encontró la tarea con ID: " + id);
				}
				);
	}

}

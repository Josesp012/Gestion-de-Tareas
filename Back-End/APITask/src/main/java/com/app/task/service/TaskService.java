package com.app.task.service;

import java.util.List;

import com.app.task.model.entity.Task;

public interface TaskService {
	Task post(Task task);
	List<Task> findAll();
	Task findById(Long id);
	void deleteById(Long id);
	Task update(Task task);
}

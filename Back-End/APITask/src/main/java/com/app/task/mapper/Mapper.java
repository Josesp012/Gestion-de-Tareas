package com.app.task.mapper;

import org.springframework.stereotype.Component;

import com.app.task.dto.TaskDto;
import com.app.task.model.entity.Task;

@Component
public class Mapper {
	public static TaskDto entityToDto(Task task) {
		if (task == null) {
			return null;
		} else {
			TaskDto taskDto = new TaskDto();
			taskDto.setId(task.getId());
			taskDto.setTitle(task.getTitle());
			taskDto.setDescription(task.getDescription());
			taskDto.setStatus(task.getStatus());
			return taskDto;
		}
	}
	
	public static Task dtoToEntity(TaskDto taskDto) {
		if(taskDto==null) {
			return null;
		}else {
			Task task = new Task();
			task.setId(taskDto.getId());
			task.setTitle(taskDto.getTitle());
			task.setDescription(taskDto.getDescription());
			task.setStatus(taskDto.getStatus());
			return task;
		}
		
		
	}
}

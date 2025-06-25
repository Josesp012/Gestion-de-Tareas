package com.app.task.dto;

public class TaskDto {
	
	private Long id;
	private String title;
	private String description;
	private Long status;
	
	public TaskDto() {
		
	}

	public TaskDto(Long id, String title, String description, Long status) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	
}

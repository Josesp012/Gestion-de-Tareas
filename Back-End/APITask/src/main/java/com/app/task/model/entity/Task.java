package com.app.task.model.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 
 * @author Jose Salazar
 *	Capa del modelo que representa las propiedades de la tabla 
 *	task
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "TASKS")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TASKS_SEQ")
	@SequenceGenerator(name="TASKS_SEQ",sequenceName="TASKS_SEQ", allocationSize = 1)
	@Column(name="ID_TASKS")
	private Long id;
	
	@Column(name="TITLE")
	@NotBlank(message="El nombre del titulo es obligatorio")
	@Size(min=1,max=50,message="El nombre del titulo debe tener entre 1 y 50 caracteres")
	private String title;
	
	@Column(name="DESCRIPTION_TASK")
	@NotBlank(message="La descripcion es obligatoria")
	private String description;
	
	@Column(name= "ID_STATUS")
	@NotNull(message = "El estatus es obligatorio")
	@Min(value=1, message="El estatus debe ser de al menos 1")
	@Max(value=2, message="El estatus no debe ser mayor a 2")
	private Long status;
	
	@Column(name= "CREATED_AT", nullable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date created_at;
	
	@Column(name= "UPDATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updated_at;
	
	@PrePersist
    protected void onCreate() {
		created_at = new Date();
    }
	public Task() {
	}

	public Task(Long id, String title, String description, Long status, Date created_at, Date updated_at) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}	
	
}

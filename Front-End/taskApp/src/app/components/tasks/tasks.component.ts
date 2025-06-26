import { Component } from '@angular/core';
import { Tasks } from '../../models/tasks.models';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TasksService } from '../../services/tasks.service';

@Component({
  selector: 'app-tasks',
  standalone: false,
  templateUrl: './tasks.component.html',
  styleUrl: './tasks.component.css'
})
export class TasksComponent {
  tasks: Tasks[] = [];
  taskForm: FormGroup;
  showForm: boolean = false;
  textoModel: string = "Nueva Tarea";
  isEditModel: boolean = false;
  selectedTask: Tasks | null = null;

  constructor(
    private taskService: TasksService,
    private formBuilder: FormBuilder
  ){
    this.taskForm= this.formBuilder.group({
      idCliente:[null] ,
      nombre: ['',Validators.required],
      apellido: ['',Validators.required],
  })
  }
  ngOnInit():void{
    this.loadTasks();
  }

  loadTasks(): void{
    this.taskService.getTasks().subscribe({
    next: (data) =>{
    this.tasks = data;
  },
  error: (error) => {
    console.error('Error al cargar clientes:', error);
  }
  });
  }

  toggleForm(): void{
  this.showForm = !this.showForm;
  this.textoModel = "Nueva Tarea";
  this.isEditModel = false;
  this.selectedTask = null;
  this.taskForm.reset();
  
  }
  onSubmit(): void{
  if (this.taskForm.invalid) {
    return;
  }
  }
  
}
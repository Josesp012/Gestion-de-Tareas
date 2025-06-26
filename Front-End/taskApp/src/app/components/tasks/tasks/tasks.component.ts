import { Component } from '@angular/core';
import { Tasks } from '../../../models/tasks.models';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TasksService } from '../../../services/tasks.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-tasks',
  standalone: false,
  templateUrl: './tasks.component.html',
  styleUrl: './tasks.component.css'
})
export class TasksComponent {
  tasks: Tasks[]=[];
  taskForm: FormGroup;
  showForm:boolean = false;
  textoModal:string="Nueva Tarea";
  isEditMode:boolean=false;
  selectedTask:Tasks | null = null;

  constructor(private taskService: TasksService,
    private formBuilder: FormBuilder
  ){
    this.taskForm = formBuilder.group({
      id:[null],
      titulo:['',[Validators.required, Validators.maxLength(50)]],
      descripcion:['',[Validators.required, Validators.maxLength(50)]],
      estatus: [1,[Validators.required]],
    })
  }

  ngOnInit(): void{
    this.loadTask();
  }

  loadTask():void{
    this.taskService.getTasks().subscribe({
      next: data =>{
        console.log(data)
        this.tasks = data;
      }
    })
  }

  toggleForm():void{
    this.showForm = !this.showForm;
    this.textoModal = "Nueva Tarea";
    this.isEditMode = false;
    this.selectedTask = null;
    this.taskForm.reset();
  }

  onSubmit():void{
      if(this.taskForm.invalid){
        return;
      }
      const tasksData: Tasks = this.taskForm.value;
      if(this.isEditMode){
        this.taskService.updateTask(tasksData).subscribe({
          next:(updateTask) =>{
            const index = this.tasks.findIndex(a => a.id === tasksData.id);
            if(index !== -1){
              this.tasks[index] = updateTask;
            }
            Swal.fire({
              title: "Tarea " + updateTask.titulo + " Actualizada",
              text: "La tarea fue actualizada exitosamente",
              icon: "success"
            });
          },
          error:(error)=>{
            this.mostrarErrores(error);
          }
        })
      }else{
        this.taskService.createTask(tasksData).subscribe({
          next:(newTask)=>{
            Swal.fire({
              title: "Tarea " + newTask.titulo+ " creada",
              text: "La tarea fue creada exitosamente",
              icon: "success"
            });
            this.tasks.push(newTask);
          },
          error:(error) =>{
            this.mostrarErrores(error);
          }
        })
      }
      this.showForm=false;
      this.taskForm.reset();
  }
  mostrarErrores(errorResponse: any):void{
     if(errorResponse && errorResponse.error){
      let errores = errorResponse.error;
      let mensajeErrores = "";
      for(let campo in errores){
        if(errores.hasOwnProperty(campo)){
          mensajeErrores += errores[campo];
        }
      }
    }
  }

   editarTarea(task: Tasks) {
    // Lógica para editar la tarea
    console.log('Editar tarea: ', task);
    // Aquí podrías abrir un formulario o realizar la lógica necesaria para editar la aerolínea.
    this.selectedTask = task;
    this.textoModal = "Editando Tarea " + task.titulo;
    this.isEditMode = true;
    this.showForm = true;

    this.taskForm.patchValue({
      id:task.id,
      titulo:task.titulo,
      descripcion: task.descripcion,
      status: task.estado,
    })
  }

  eliminarTarea(idTask: number) {
    // this.aerolineas = this.aerolineas.filter(aerolinea => aerolinea.id !== idAerolinea);
    // console.log('Aerolínea eliminada:', idAerolinea);

    Swal.fire({
      title: "Eliminar Tarea",
      text: "¿Estas seguro que deseas eliminar la tarea?",
      icon: "question",
      showConfirmButton:true,
      showCancelButton:true
    }).then(resp=>{
      if(resp.isConfirmed){
        this.taskService.deleteTask(idTask).subscribe({
          next:(deleteTask) =>{
            this.tasks = this.tasks.filter(a => a.id !== idTask);
            Swal.fire({
              title: "Tarea Eliminada",
              text: "La tarea fue eliminada exitosamente",
              icon: "success"
            });
          },
          error:(error)=>{
            this.mostrarErrores(error);
          }
        });
      }
    })
  }
}

import { Component, OnInit } from '@angular/core';
import { Task } from '../../task';
import { TaskService } from '../../service/task.service';

@Component({
  selector: 'app-list',
  imports: [],
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent implements OnInit {

  task: Task []=[];

  constructor(private taskService: TaskService){}

  ngOnInit(): void {
    this.listTask();
  }
  listTask(){
    this.taskService.getTaskList().subscribe(
      data => {
        this.task = data;
        console.log(this.task);
      }
    );
  }
}

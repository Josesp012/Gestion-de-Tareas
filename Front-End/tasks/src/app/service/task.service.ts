import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Task } from '../task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  
  private api: string='http://localhost:8080/api/tasks';
  
  constructor(private http:HttpClient) { }

  getTaskList():Observable<Task []>{
    return this.http.get<Task[]>(this.api);
  }
}

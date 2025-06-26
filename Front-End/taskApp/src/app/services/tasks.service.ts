import { Injectable } from '@angular/core';
import { environment } from '../components/common/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Tasks } from '../models/tasks.models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TasksService {
  private apiUrl: string = environment.apiUrl; 
  constructor(private http:HttpClient) { }
  
  getTasks(): Observable<Tasks[]>{
    return this.http.get<Tasks[]>(this.apiUrl);
  }

  createTask(task: Tasks): Observable<Tasks>{
    return this.http.post<Tasks>(`${this.apiUrl}`, task);
  }

  updateTask(task:Tasks): Observable<Tasks>{
    return this.http.put<Tasks>(`${this.apiUrl}${task.id}`,task);
  }

  deleteTask(idTask:number):Observable<Tasks>{
    return this.http.delete<Tasks>(`${this.apiUrl}${idTask}`);
  }
}

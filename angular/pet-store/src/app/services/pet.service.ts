import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'Basic ' + btoa('admin:admin')
  })
};

const baseUrl = 'http://localhost:8081/api/pet/';

@Injectable({
  providedIn: 'root'
})

export class PetService {

  constructor(private http: HttpClient) { }
  
  getAll(): Observable<any> {
    return this.http.get(baseUrl);
  }
  getPet(id): Observable<any>{
    return this.http.get(`${baseUrl}${id}`);
  }

  create(data):Observable<any>{
    return this.http.post(baseUrl,data,httpOptions);
  }
}

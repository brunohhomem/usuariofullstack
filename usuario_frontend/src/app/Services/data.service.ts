import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  //Inject ApiUrl in constructor to Get it form Service
  constructor(@Inject(String) private APIUrl: string, private http: HttpClient){}

  //Get method
  getAll(): Observable<any>{
    return this.http.get<any>(this.APIUrl);
  }

  //Update method
  Update(data: any): Observable<any>{
    return this.http.put(`${this.APIUrl}`, data);
  }

  //Create method
  Create(data: any): Observable<any> {
    return this.http.post(this.APIUrl, data);
  }

  //Delete method
  Delete(id: any): Observable<any> {
    return this.http.delete(`${this.APIUrl}/${id}`);
  }

}

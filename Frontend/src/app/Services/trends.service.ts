import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class TrendsService {

  private apiServerUrl = environment.apiServerUrl; 
  
  constructor(private http: HttpClient) { }

  public locationTrends(): Observable<any>{
    return this.http.get<any>(`${this.apiServerUrl}/trends/locationTrends`);
  }

  public skillTrends(): Observable<any>{
    return this.http.get<any>(`${this.apiServerUrl}/trends/skillTrends`);
  }

}

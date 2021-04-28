import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment'
import { Trend } from '../Models/trend';

@Injectable({
  providedIn: 'root'
})
export class TrendsService {

  private apiServerUrl = environment.apiServerUrl; 
  
  constructor(private http: HttpClient) { }

  public locationTrends(): Observable<Trend>{
    return this.http.get<Trend>(`${this.apiServerUrl}/trends/locationTrends`);
  }

  public skillTrends(): Observable<Trend>{
    return this.http.get<Trend>(`${this.apiServerUrl}/trends/skillTrends`);
  }

  public quarterTrends(): Observable<Trend>{
    return this.http.get<Trend>(`${this.apiServerUrl}/trends/quarterTrends`);
  }

}

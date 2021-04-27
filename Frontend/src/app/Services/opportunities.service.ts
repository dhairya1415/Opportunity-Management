import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment'
import { Opportunity } from '../Models/opportunity';

@Injectable({
  providedIn: 'root'
})
export class OpportunitiesService {

  private apiServerUrl = environment.apiServerUrl;

  constructor(private http: HttpClient) { 
    
  }

  public getOpportunities(): Observable <Opportunity[]> {
    return this.http.get<Opportunity[]>(`${this.apiServerUrl}/opportunity/getAll`);
  }

  public viewOpportunity(oppId: Number): Observable<Opportunity>{
    return this.http.get<Opportunity>(`${this.apiServerUrl}/opportunity/get/${oppId}`);
  }

  public deleteOpportunity(oppId: Number, name: string, email: string): Observable<Number> {
    return this.http.delete<Number>(`${this.apiServerUrl}/opportunity/delete/${oppId}`, 
    {
      headers: new HttpHeaders({
      'user_name': name,
      'user_email': email,
      })
    })
  }

  public updateOpportunity(opportunity: Opportunity, oppId: Number, name: string, email: string): Observable<Number> {
    return this.http.put<Number>(`${this.apiServerUrl}/opportunity/update/${oppId}`, opportunity, 
    {
      headers: new HttpHeaders({
        'user_name': name,
        'user_email': email,
      })
    })
  }

  public addOpportunity(opportunity: Opportunity, name: string, email: string): Observable<Opportunity> {
    return this.http.post<Opportunity>(`${this.apiServerUrl}/opportunity/add`, opportunity, 
    {
      headers: new HttpHeaders({
        'user_name': name,
        'user_email': email,
      })
    })
  }
}

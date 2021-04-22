import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment'
import { Opportunity } from '../Models/opportunity';

@Injectable({
  providedIn: 'root'
})
export class OpportunitiesService {

  private apiServerUrl = environment.apiServerUrl; 
  
  constructor(private http: HttpClient) { }

  public getOpportunities(): Observable <Opportunity[]> {
    return this.http.get<Opportunity[]>(`${this.apiServerUrl}/opportunity/getAll`);
  }

  public deleteOpportunities(oppId: number): Observable<number> {
    return this.http.delete<number>(`${this.apiServerUrl}/opportunity/delete/${oppId}`)
  }

}

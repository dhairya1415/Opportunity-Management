import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment'
import { Audit } from '../Models/audit'

@Injectable({
  providedIn: 'root'
})
export class AuditService {

  private apiServerUrl = environment.apiServerUrl; 
  
  constructor(private http: HttpClient) { }

  public getAudits(): Observable<Audit[]> {
    return this.http.get<Audit[]>(`${this.apiServerUrl}/audit/getAll`);
  }
}

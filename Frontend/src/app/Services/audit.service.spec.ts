import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpClient } from '@angular/common/http';
import { AuditService } from './audit.service';
import { Audit } from '../Models/audit';
import { of } from 'rxjs';

describe('AuditService', () => {
  let service: AuditService;
  let audit: Audit = <Audit>{};
  let http: HttpClient;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ],
      providers: [AuditService]
    });
    service = TestBed.inject(AuditService);
    http = TestBed.inject(HttpClient);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get all audits', () => {
    spyOn(http, 'get').and.returnValue( of([]) );
    service.getAllAudits();
    expect(service.getAllAudits).toBeTruthy();
    expect(http.get).toHaveBeenCalled();
  });

  it('should search audits', () => {
    spyOn(http, 'get').and.returnValue( of([]) );
    service.searchAudits("oppId", "3");
    expect(service.searchAudits("oppId", "3")).toBeTruthy();
    expect(http.get).toHaveBeenCalled();
  });

});

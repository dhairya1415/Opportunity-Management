import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpClient } from '@angular/common/http';
import { OpportunitiesService } from './opportunities.service';
import { Opportunity } from '../Models/opportunity';
import { of } from 'rxjs';

describe('OpportunitiesService', () => {
  let service: OpportunitiesService;
  let http: HttpClient;
  let opp: Opportunity = <Opportunity>{};

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [OpportunitiesService]
    });
    service = TestBed.inject(OpportunitiesService);
    http = TestBed.inject(HttpClient);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get all Opportunities', () => {
    spyOn(http, 'get').and.returnValue( of ([]));
    service.getOpportunities();
    expect(service.getOpportunities()).toBeTruthy();
    expect(http.get).toHaveBeenCalled();
  });

  it('should get active Opportunities', () => {
    spyOn(http, 'get').and.returnValue( of ([]));
    service.getActiveOpportunities();
    expect(service.getActiveOpportunities()).toBeTruthy();
    expect(http.get).toHaveBeenCalled();
  });

  it('should search Opportunities', () => {
    spyOn(http, 'get').and.returnValue( of ([]));
    service.searchOpportunities("Mumbai1React");
    expect(service.searchOpportunities("Mumbai1React")).toBeTruthy();
    expect(http.get).toHaveBeenCalled();
  });

  it('should get locations', () => {
    spyOn(http, 'get').and.returnValue( of ([]));
    service.getLocations();
    expect(service.getLocations()).toBeTruthy();
    expect(http.get).toHaveBeenCalled();
  });

  it('should get skills', () => {
    spyOn(http, 'get').and.returnValue( of ([]));
    service.getSkills();
    expect(service.getSkills()).toBeTruthy();
    expect(http.get).toHaveBeenCalled();
  });

  it('should view opportunity', () => {
    spyOn(http, 'get').and.returnValue( of ([]));
    service.viewOpportunity(4);
    expect(service.viewOpportunity(4)).toBeTruthy();
    expect(http.get).toHaveBeenCalled();
  });

  it('should delete opportunity', () => {
    spyOn(http, 'delete').and.returnValue(of([]));
    service.deleteOpportunity(100, "D", "d@g.com");
    expect(service.deleteOpportunity(100, "D", "d@g.com")).toBeTruthy();
    expect(http.delete).toHaveBeenCalled();
  });

  it('should update opportunity', () => {
    spyOn(http, 'put').and.returnValue(of([]));
    service.updateOpportunity(opp, 100, "D", "d@g.com");
    expect(service.updateOpportunity(opp, 100, "D", "d@g.com")).toBeTruthy();
    expect(http.put).toHaveBeenCalled();
  });

  it('should add opportunity', () => {
    spyOn(http, 'post').and.returnValue(of([]));
    service.addOpportunity(opp, "D", "d@g.com");
    expect(service.addOpportunity(opp, "D", "d@g.com")).toBeTruthy();
    expect(http.post).toHaveBeenCalled();
  });
});

import { TestBed } from '@angular/core/testing';
import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TrendsService } from './trends.service';
import { of } from 'rxjs';

describe('TrendsService', () => {
  let service: TrendsService;
  let http: HttpClient

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [TrendsService]
    });
    service = TestBed.inject(TrendsService);
    http = TestBed.inject(HttpClient);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get location trends', () => {
    spyOn(http, 'get').and.returnValue( of ([]));
    service.locationTrends();
    expect(service.locationTrends()).toBeTruthy();
    expect(http.get).toHaveBeenCalled();
  });

  it('should get skill trends', () => {
    spyOn(http, 'get').and.returnValue( of ([]));
    service.skillTrends();
    expect(service.skillTrends()).toBeTruthy();
    expect(http.get).toHaveBeenCalled();
  });

  it('should get quarter trends', () => {
    spyOn(http, 'get').and.returnValue( of ([]));
    service.quarterTrends();
    expect(service.quarterTrends()).toBeTruthy();
    expect(http.get).toHaveBeenCalled();
  });

  it('should get location skill trends', () => {
    spyOn(http, 'get').and.returnValue( of ([]));
    service.locationSkillsTrends();
    expect(service.locationSkillsTrends()).toBeTruthy();
    expect(http.get).toHaveBeenCalled();
  });

  it('should get location count', () => {
    spyOn(http, 'get').and.returnValue( of ([]));
    service.locationCount();
    expect(service.locationCount()).toBeTruthy();
    expect(http.get).toHaveBeenCalled();
  });

  it('should get skill count', () => {
    spyOn(http, 'get').and.returnValue( of ([]));
    service.skillCount();
    expect(service.skillCount()).toBeTruthy();
    expect(http.get).toHaveBeenCalled();
  });
});

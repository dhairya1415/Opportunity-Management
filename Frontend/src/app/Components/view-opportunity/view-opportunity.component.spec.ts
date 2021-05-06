import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing'
import { ViewOpportunityComponent } from './view-opportunity.component';
import { By } from '@angular/platform-browser';

describe('ViewOpportunityComponent', () => {
  let component: ViewOpportunityComponent;
  let fixture: ComponentFixture<ViewOpportunityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouterTestingModule, HttpClientTestingModule],
      declarations: [ ViewOpportunityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewOpportunityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have 8 form components', () => {
    const select = fixture.debugElement.queryAll(By.css('.form-group'));
    expect(select.length).toBe(8);
  });
});

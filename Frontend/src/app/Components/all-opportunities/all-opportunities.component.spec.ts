import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientModule } from '@angular/common/http';
import { AllOpportunitiesComponent } from './all-opportunities.component';
import { By } from '@angular/platform-browser';
import { Opportunity } from 'src/app/Models/opportunity';

describe('AllOpportunitiesComponent', () => {
  let component: AllOpportunitiesComponent;
  let fixture: ComponentFixture<AllOpportunitiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouterTestingModule, HttpClientModule],
      declarations: [ AllOpportunitiesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllOpportunitiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have a table', () =>{
    const table = fixture.debugElement.query(By.css('table')).nativeElement;
    expect(table).toBeTruthy();
  });

  it('should have 2 select', () => {
    const select = fixture.debugElement.queryAll(By.css('.form-control'));
    expect(select.length).toBe(2);
  });

  it('should have 2 buttons', () => {
    const buttons = fixture.debugElement.queryAll(By.css('.btn'));
    expect(buttons.length).toBe(2);
  });

  it('should have 4 form components', () => {
    const select = fixture.debugElement.queryAll(By.css('.form-group'));
    expect(select.length).toBe(4);
  });
});

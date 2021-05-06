import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientModule } from '@angular/common/http';
import { UpdateOpportunityComponent } from './update-opportunity.component';
import { SocialAuthService } from 'angularx-social-login';
import { FormsModule } from '@angular/forms';
import { of } from 'rxjs';
import {Location} from '@angular/common';
import { By } from '@angular/platform-browser';

describe('UpdateOpportunityComponent', () => {
  let component: UpdateOpportunityComponent;
  let fixture: ComponentFixture<UpdateOpportunityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouterTestingModule, HttpClientModule, FormsModule],
      providers: [{provide: SocialAuthService, useClass: SocialAuthServiceStub}],
      declarations: [ UpdateOpportunityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateOpportunityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have 8 labels', () =>{
    const location = TestBed.inject(Location);
    const labels = fixture.debugElement.queryAll(By.css('.label'));
    expect(labels.length).toBe(8);
    expect(labels[0].nativeElement.textContent).toBe("Manager Name");
    expect(labels[1].nativeElement.textContent).toBe("Manager Email");
    expect(labels[2].nativeElement.textContent).toBe("Description");
    expect(labels[3].nativeElement.textContent).toBe("Location");
    expect(labels[4].nativeElement.textContent).toBe("Skills");
    expect(labels[5].nativeElement.textContent).toBe("Min Experience");
    expect(labels[6].nativeElement.textContent).toBe("Vacancies");
    expect(labels[7].nativeElement.textContent).toBe("Joining Date");
  });
});

class SocialAuthServiceStub{
  authState = of();
}
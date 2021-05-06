import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientModule } from '@angular/common/http';
import { SocialAuthService } from 'angularx-social-login';
import { OpportunitiesComponent } from './opportunities.component';
import { of } from 'rxjs';
import { By } from '@angular/platform-browser';

describe('OpportunitiesComponent', () => {
  let component: OpportunitiesComponent;
  let fixture: ComponentFixture<OpportunitiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouterTestingModule, HttpClientModule],
      providers: [{provide: SocialAuthService, useClass: SocialAuthServiceStub}],
      declarations: [ OpportunitiesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OpportunitiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have 1 table', () => {
    const table = fixture.debugElement.query(By.css('.table'))
    expect(table).toBeTruthy();
  });
});

class SocialAuthServiceStub{
  authState = of();
}
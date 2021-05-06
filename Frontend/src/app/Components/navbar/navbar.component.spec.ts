import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { CanActivate } from '@angular/router';
import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { SocialAuthService } from 'angularx-social-login';
import { NavbarComponent } from './navbar.component';
import { By } from '@angular/platform-browser';
import {Location} from '@angular/common';

describe('NavbarComponent', () => {
  let component: NavbarComponent;
  let fixture: ComponentFixture<NavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ HttpClientModule, RouterTestingModule.withRoutes([
        {path: 'opportunities', component: DummyComponent},
        {path: 'allOpportunities', component: DummyComponent},
        {path: 'trends', component: DummyComponent},
        {path: 'audit', component: DummyComponent}
      ]) ],
      providers: [{provide: SocialAuthService, useClass: SocialAuthServiceStub}],
      declarations: [ NavbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have 4 anchor tags', () => {
    const anchors = fixture.debugElement.queryAll(By.css('.nav-link'));
    expect(anchors.length).toBe(4);
  });
  
  it('should navigate to /opportunities', () => {
    const location = TestBed.inject(Location)
    const linkDes = fixture.debugElement.queryAll(By.css(".nav-link"))
    const nativeButton: HTMLButtonElement = linkDes[0].nativeElement;
    nativeButton.click();
    fixture.detectChanges()
    fixture.whenStable().then(() => {
      expect(location.path()).toBe('/opportunities')
    });
  });

  it('should navigate to /allOpportunities', () => {
    const location = TestBed.inject(Location)
    const linkDes = fixture.debugElement.queryAll(By.css(".nav-link"))
    const nativeButton: HTMLButtonElement = linkDes[1].nativeElement;
    nativeButton.click();
    fixture.detectChanges()
    fixture.whenStable().then(() => {
      expect(location.path()).toBe('/allOpportunities')
    });
  });

  it('should navigate to /trends', () => {
    const location = TestBed.inject(Location)
    const linkDes = fixture.debugElement.queryAll(By.css(".nav-link"))
    const nativeButton: HTMLButtonElement = linkDes[2].nativeElement;
    nativeButton.click();
    fixture.detectChanges()
    fixture.whenStable().then(() => {
      expect(location.path()).toBe('/trends')
    });
  });

  it('should navigate to /audit', () => {
    const location = TestBed.inject(Location)
    const linkDes = fixture.debugElement.queryAll(By.css(".nav-link"))
    const nativeButton: HTMLButtonElement = linkDes[3].nativeElement;
    nativeButton.click();
    fixture.detectChanges()
    fixture.whenStable().then(() => {
      expect(location.path()).toBe('/audit')
    });
  });
});

class SocialAuthServiceStub implements CanActivate{
  canActivate(){
    return true;
  }
  check(){
    return true;
  }
  signOut()
  {
    
  }
}

@Component({template:''})
export class DummyComponent {}
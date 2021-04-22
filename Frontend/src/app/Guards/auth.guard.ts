import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import {SocialAuthService} from 'angularx-social-login';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  
  constructor(private socialAuthService: SocialAuthService, private router: Router) { }

  loggedIn: boolean = false;
  
  canActivate() {
    this.socialAuthService.authState.subscribe(user => this.loggedIn = (user != null))
    if(this.loggedIn){
      return true;
    } else{
      this.router.navigate(['']);
      return false;
    }
  }
}

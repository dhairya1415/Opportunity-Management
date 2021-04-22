import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import {SocialAuthService} from 'angularx-social-login';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  
  constructor(private socialAuthService: SocialAuthService) { }

  loggedIn: boolean = false;
  
  canActivate() {
    this.socialAuthService.authState.subscribe(user => this.loggedIn = (user != null))
    //return this.loggedIn;
    return true;
  }
}

import { Component, OnInit } from '@angular/core';
import { SocialAuthService } from 'angularx-social-login';
import { SocialUser, GoogleLoginProvider } from 'angularx-social-login';
import { Router } from '@angular/router'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user?: SocialUser;

  constructor(private socialAuthService: SocialAuthService, private router: Router) { }

  ngOnInit(): void {
    this.socialAuthService.authState.subscribe(user => this.user = user)
  }

  signIn(): any {
    this.socialAuthService.signIn(GoogleLoginProvider.PROVIDER_ID).then(u => {
      this.router.navigate(['opportunities']);
      console.log(u);
    })
    console.log("logging in")
  }
}

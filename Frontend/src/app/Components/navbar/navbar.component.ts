import { Component, OnInit } from '@angular/core';
import {SocialAuthService} from 'angularx-social-login';
import {Router} from '@angular/router'

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private socialAuthService: SocialAuthService, private router:Router) { }

  ngOnInit(): void {
  }

  signOut(): any{
    this.socialAuthService.signOut()
    console.log("Logging out")
    this.router.navigate(['/'])
  }

}

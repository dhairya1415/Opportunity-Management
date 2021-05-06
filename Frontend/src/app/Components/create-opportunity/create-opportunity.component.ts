import { Component, OnInit, Input } from '@angular/core';
import { OpportunitiesService } from 'src/app/Services/opportunities.service';
import { SocialAuthService } from 'angularx-social-login';
import { Router } from '@angular/router'
import { Opportunity } from 'src/app/Models/opportunity';

@Component({
  selector: 'app-create-opportunity',
  templateUrl: './create-opportunity.component.html',
  styleUrls: ['./create-opportunity.component.css']
})
export class CreateOpportunityComponent implements OnInit {

  public opportunity:Opportunity = <any>{};
  public name: string = "";
  public email: string = "";
  public currentDate: any = new Date().toISOString().slice(0, 10);

  constructor(private socialAuthService: SocialAuthService, private opportunitiesService: OpportunitiesService, private router: Router) {}

  ngOnInit(): void {
    this.socialAuthService.authState.subscribe(
      user => {
        this.name = user.name,
        this.email = user.email
      }
    );
  }

  public saveOpportunity(): void{
    this.opportunitiesService.addOpportunity(this.opportunity, this.name, this.email).subscribe(
      (res) => {
        console.log(res),
        this.goBackToOpp();
      },
      (error) => alert(error.message)
    );
  }

  public goBackToOpp(): void{
    this.router.navigate(['opportunities'])
  }

  onSubmit(){
    console.log(this.opportunity);
    this.saveOpportunity();
  }

}

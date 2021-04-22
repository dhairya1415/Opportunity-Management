import { Component, OnInit, Input } from '@angular/core';
import { OpportunitiesService } from 'src/app/Services/opportunities.service';
import { Router } from '@angular/router'
import { Opportunity } from 'src/app/Models/opportunity';

@Component({
  selector: 'app-create-opportunity',
  templateUrl: './create-opportunity.component.html',
  styleUrls: ['./create-opportunity.component.css']
})
export class CreateOpportunityComponent implements OnInit {

  public  opportunity:Opportunity = <any>{};

  constructor(private opportunitiesService: OpportunitiesService, private router: Router) {}

  ngOnInit(): void {
  }

  public saveOpportunity(): void{
    this.opportunitiesService.addOpportunity(this.opportunity).subscribe(
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

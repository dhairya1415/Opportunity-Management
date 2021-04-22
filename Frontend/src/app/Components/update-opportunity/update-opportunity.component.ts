import { Component, OnInit } from '@angular/core';
import { OpportunitiesService } from 'src/app/Services/opportunities.service';
import { Router, ActivatedRoute } from '@angular/router'
import { Opportunity } from 'src/app/Models/opportunity';

@Component({
  selector: 'app-update-opportunity',
  templateUrl: './update-opportunity.component.html',
  styleUrls: ['./update-opportunity.component.css']
})
export class UpdateOpportunityComponent implements OnInit {

  public  opportunity:Opportunity = <any>{};
  public oppId: Number = <any>{};

  constructor(private opportunitiesService: OpportunitiesService, private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.oppId = this.route.snapshot.params['oppId'];
    this.opportunitiesService.viewOpportunity(this.oppId).subscribe(
      res => this.opportunity = res,
      error => alert(error.message)
    );
  }

  public saveOpportunity(): void{
    this.opportunitiesService.updateOpportunity(this.opportunity, this.oppId).subscribe(
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

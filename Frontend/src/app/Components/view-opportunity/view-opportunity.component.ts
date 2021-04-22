import { Component, OnInit } from '@angular/core';
import { OpportunitiesService } from 'src/app/Services/opportunities.service';
import { Router, ActivatedRoute } from '@angular/router'
import { Opportunity } from 'src/app/Models/opportunity';

@Component({
  selector: 'app-view-opportunity',
  templateUrl: './view-opportunity.component.html',
  styleUrls: ['./view-opportunity.component.css']
})
export class ViewOpportunityComponent implements OnInit {

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

  public goBackToOpp(): void{
    this.router.navigate(['opportunities'])
  }

}

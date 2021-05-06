import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Opportunity } from 'src/app/Models/opportunity';
import { OpportunitiesService } from 'src/app/Services/opportunities.service';

@Component({
  selector: 'app-all-opportunities',
  templateUrl: './all-opportunities.component.html',
  styleUrls: ['./all-opportunities.component.css']
})
export class AllOpportunitiesComponent implements OnInit {

  public opportunities: Opportunity[] = [];
  public locations: string[] = [];
  public skills: string[] = [];
  public location: string = "";
  public skill:string = "";
  public currentDate: any = new Date().toISOString().slice(0, 10);

  constructor(private opportunitiesService: OpportunitiesService, private router: Router) { }

  ngOnInit(): void {
    this.getOpportunities();
    this.getLocationsandSkills();
  }

  public color(opportunity: Opportunity): any{
    if(opportunity.deleted){
      return "red";
    }
    if(opportunity.joining_date < this.currentDate){
      return "blue";
    }
  }

  public getOpportunities(): void{
    this.opportunitiesService.getOpportunities().subscribe(
      res => this.opportunities = res,
      error => alert(error.message)
    );
  }

  public getLocationsandSkills(): void{
    this.opportunitiesService.getLocations().subscribe(
        (res: string[]) => {
            this.locations = res;
            console.log(this.locations);
        },
        error => alert(error.message)
    );
    this.opportunitiesService.getSkills().subscribe(
        (res: string[]) => {
            this.skills = res;
            console.log(this.skills);
        },
        error => alert(error.message)
    );
  }

  public searchOpportunities(options: string){
    this.opportunitiesService.searchOpportunities(options).subscribe(
        (res: Opportunity[]) => this.opportunities = res,
        error => alert(error.message)
    );
  }

  public onSubmit(): void{
      this.searchOpportunities(this.location+"1"+this.skill);
  }

  public resetSearch(): void{
      this.location = "";
      this.skill = "";
      this.getOpportunities();
  }

  public getOpportunity(oppId: Number): void {
    this.router.navigate(['viewOpportunity', oppId]);
  }

}

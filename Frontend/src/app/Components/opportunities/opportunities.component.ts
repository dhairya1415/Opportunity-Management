import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Opportunity } from 'src/app/Models/opportunity';
import { OpportunitiesService } from 'src/app/Services/opportunities.service';

@Component({
  selector: 'app-opportunities',
  templateUrl: './opportunities.component.html',
  styleUrls: ['./opportunities.component.css']
})
export class OpportunitiesComponent implements OnInit {

  public opportunities: Opportunity[] = [];
  private toggle: boolean = false;

  ngOnInit(): void {
    this.getOpportunities();
  }

  constructor(private opportunitiesService: OpportunitiesService) {}
  
  public getOpportunities(): void {
    this.opportunitiesService.getOpportunities().subscribe(
      (res: Opportunity[]) => {
        this.opportunities = res;
        console.log(this.opportunities)
      },
      (error: HttpErrorResponse) => alert(error.message)
    );
  }

  public deleteOpportunities(oppId: number): void{
    this.opportunitiesService.deleteOpportunities(oppId).subscribe(
      (res: number) => {
        if(res){
          this.getOpportunities();
        } else{
          alert("Opportunity not deleted");
        }
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public search(key: string):void{
    const searchResults: Opportunity[] = [];
    for(const opportunity of this.opportunities){
      if(opportunity.manager_name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || opportunity.description.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || opportunity.location.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || opportunity.joining_date.toString().toLowerCase().indexOf(key.toLowerCase()) !== -1){
        searchResults.push(opportunity);
      }
    }
    this.opportunities = searchResults;
    if(searchResults.length === 0 || !key){
      this.getOpportunities();
    } 
  }

}

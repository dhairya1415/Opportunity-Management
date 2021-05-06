import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Opportunity } from 'src/app/Models/opportunity';
import { OpportunitiesService } from 'src/app/Services/opportunities.service';
import { SocialAuthService } from 'angularx-social-login';
import { Router } from '@angular/router';

@Component({
    selector: 'app-opportunities',
    templateUrl: './opportunities.component.html',
    styleUrls: ['./opportunities.component.css'],
})
export class OpportunitiesComponent implements OnInit {
    public opportunities: Opportunity[] = [];
    public name: string = "";
    public email: string = "";
    public locations: string[] = [];
    public skills: string[] = [];
    public location: string = "";
    public skill:string = "";

    ngOnInit(): void {
        this.getActiveOpportunities();
        this.getLocationsandSkills();
    }

    constructor(private socialAuthService: SocialAuthService, private opportunitiesService: OpportunitiesService, private router: Router) {}

    public searchOpportunities(options: string){
        this.opportunitiesService.searchOpportunities(options).subscribe(
            (res: Opportunity[]) => this.opportunities = res,
            error => alert(error.message)
        );
    }
    
    public onSubmit(): void{
        if(this.location === ""){
            this.searchOpportunities("1"+this.skill);
        } else{
            this.searchOpportunities(this.location+"1"+this.skill);
        }
    }
    
    public resetSearch(): void{
        this.location = "";
        this.skill = "";
        this.getActiveOpportunities();
    }
    
    public getActiveOpportunities(): void {
        this.opportunitiesService.getActiveOpportunities().subscribe(
            (res: Opportunity[]) => {
                this.opportunities = res;
                console.log(this.opportunities);
            },
            (error: HttpErrorResponse) => alert(error.message)
        );
        this.socialAuthService.authState.subscribe(
            user => {
              this.name = user.name,
              this.email = user.email
            }
        );
    }

    public getLocationsandSkills(): void{
        this.opportunitiesService.getLocations().subscribe(
            (res: string[]) => {
                this.locations = res;
                console.log(this.locations);
            },
            (error: HttpErrorResponse) => alert(error.message)
        );
        this.opportunitiesService.getSkills().subscribe(
            (res: string[]) => {
                this.skills = res;
                console.log(this.skills);
            },
            (error: HttpErrorResponse) => alert(error.message)
        );
    }

    public getOpportunity(oppId: Number): void {
        this.router.navigate(['viewOpportunity', oppId]);
    }

    public updateOpportunity(oppId: Number): void {
        this.router.navigate(['updateOpportunity', oppId]);
    }

    public deleteOpportunity(oppId: number): void {
      if(confirm("Are you sure you want to delete this opportunity")){
        this.opportunitiesService.deleteOpportunity(oppId, this.name, this.email).subscribe(
            (res: Number) => {
                if (res) {
                    this.getActiveOpportunities();
                } else {
                    alert('Opportunity not deleted');
                }
            },
            (error: HttpErrorResponse) => {
                alert(error.message);
            }
        );
      }
    }

    public addOpportunity(): void {
        this.router.navigate(['addOpportunity']);
    }

    // public search(key: string): void {
    //     const searchResults: Opportunity[] = [];
    //     for (const opportunity of this.opportunities) {
    //         if (
    //             opportunity.manager_name.toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
    //             opportunity.description.toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
    //             opportunity.location.toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
    //             opportunity.joining_date.toString().toLowerCase().indexOf(key.toLowerCase()) !== -1
    //         ) {
    //             searchResults.push(opportunity);
    //         }
    //     }
    //     this.opportunities = searchResults;
    //     if (searchResults.length === 0 || !key) {
    //         this.getOpportunities();
    //     }
    // }
}

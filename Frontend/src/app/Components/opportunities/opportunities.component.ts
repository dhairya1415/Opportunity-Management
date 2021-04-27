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

    ngOnInit(): void {
        this.getOpportunities();
    }

    constructor(private socialAuthService: SocialAuthService, private opportunitiesService: OpportunitiesService, private router: Router) {}

    public getOpportunities(): void {
        this.opportunitiesService.getOpportunities().subscribe(
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
                    this.getOpportunities();
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

    public search(key: string): void {
        const searchResults: Opportunity[] = [];
        for (const opportunity of this.opportunities) {
            if (
                opportunity.manager_name.toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
                opportunity.description.toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
                opportunity.location.toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
                opportunity.joining_date.toString().toLowerCase().indexOf(key.toLowerCase()) !== -1
            ) {
                searchResults.push(opportunity);
            }
        }
        this.opportunities = searchResults;
        if (searchResults.length === 0 || !key) {
            this.getOpportunities();
        }
    }
}

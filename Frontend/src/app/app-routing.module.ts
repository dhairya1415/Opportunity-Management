import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from './Components/login/login.component'
import {OpportunitiesComponent} from './Components/opportunities/opportunities.component'
import {PageNotFoundComponent} from './Components/page-not-found/page-not-found.component'
import {TrendsComponent} from './Components/trends/trends.component'
import {CreateOpportunityComponent} from './Components/create-opportunity/create-opportunity.component'
import {ViewOpportunityComponent} from './Components/view-opportunity/view-opportunity.component'
import {UpdateOpportunityComponent} from './Components/update-opportunity/update-opportunity.component'
import {AuthGuard} from './Guards/auth.guard'

const routes: Routes = [
  {path:'', component:LoginComponent, pathMatch: 'full'},
  {path:'opportunities', component : OpportunitiesComponent, canActivate:[AuthGuard]},
  {path:'addOpportunity', component : CreateOpportunityComponent, canActivate:[AuthGuard]},
  {path:'viewOpportunity/:oppId', component : ViewOpportunityComponent, canActivate:[AuthGuard]},
  {path:'updateOpportunity/:oppId', component : UpdateOpportunityComponent, canActivate:[AuthGuard]},
  {path:'trends', component : TrendsComponent, canActivate:[AuthGuard]},
  {path: '**' , component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

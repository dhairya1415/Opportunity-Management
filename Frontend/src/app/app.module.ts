import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HighchartsChartModule } from 'highcharts-angular';

import { AppComponent } from './app.component';
import { LoginComponent } from './Components/login/login.component';
import { OpportunitiesComponent } from './Components/opportunities/opportunities.component';

import { SocialAuthServiceConfig} from 'angularx-social-login';
import {SocialLoginModule, GoogleLoginProvider} from 'angularx-social-login';
import {environment} from '../environments/environment';
import { PageNotFoundComponent } from './Components/page-not-found/page-not-found.component';

import {AuthGuard} from './Guards/auth.guard';
import { NavbarComponent } from './Components/navbar/navbar.component'
import { OpportunitiesService } from './Services/opportunities.service';
import { AuditService } from './Services/audit.service';
import { TrendsService } from './Services/trends.service';
import { TrendsComponent } from './Components/trends/trends.component';
import { CreateOpportunityComponent } from './Components/create-opportunity/create-opportunity.component';
import { UpdateOpportunityComponent } from './Components/update-opportunity/update-opportunity.component';
import { ViewOpportunityComponent } from './Components/view-opportunity/view-opportunity.component';
import { AuditComponent } from './Components/audit/audit.component';
import { AllOpportunitiesComponent } from './Components/all-opportunities/all-opportunities.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    OpportunitiesComponent,
    PageNotFoundComponent,
    NavbarComponent,
    TrendsComponent,
    CreateOpportunityComponent,
    UpdateOpportunityComponent,
    ViewOpportunityComponent,
    AuditComponent,
    AllOpportunitiesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SocialLoginModule,
    HttpClientModule,
    FormsModule,
    HighchartsChartModule
  ],
  providers: [
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider(`${environment.googleClientId}`)
          }
        ]
      } as SocialAuthServiceConfig,
    }, 
    AuthGuard,
    OpportunitiesService,
    AuditService,
    TrendsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

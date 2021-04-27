import { Component, OnInit } from '@angular/core';
import * as Highcharts from 'highcharts';
import { TrendsService } from '../../Services/trends.service'

@Component({
  selector: 'app-trends',
  templateUrl: './trends.component.html',
  styleUrls: ['./trends.component.css']
})
export class TrendsComponent implements OnInit {

  public locations: string[] = [];
  public locationData: number[] = [];
  public skills: string[] = [];
  public skillsData: number[] = [];
  public locationFlag: boolean = false;
  public skillsFlag: boolean = false;

  HighchartsLocations: typeof Highcharts = Highcharts;
  HighchartsSkills: typeof Highcharts = Highcharts;
  chartOptionsLocations: Highcharts.Options = { };
  chartOptionsSkills: Highcharts.Options = { };
  
  constructor(private trendsService: TrendsService) { }

  ngOnInit(): void {
    this.getLocationTrends();
    this.getSkillsTrends();
  }

  public getLocationTrends(){
    this.trendsService.locationTrends().subscribe(
      res => {
        this.locations = res[0];
        this.locationData = res[1];
        this.chartOptionsLocations = {
          title: {
            text: 'Opportunities by Location'
          },
          xAxis: {
              categories: res[0],
          },
          series: [{
            type: 'column',
            data: res[1],
            colorByPoint: true,
            name: 'Opportunities'
          }]
        };
        this.locationFlag = true;
      }, 
      error => alert(error.message)
    );
  }

  public getSkillsTrends(){
    this.trendsService.skillTrends().subscribe(
      res => {
        this.skills = res[0];
        this.skillsData = res[1];
        this.chartOptionsSkills = {
          title: {
            text: 'Opportunities by Skills'
          },
          xAxis: {
              categories: res[0],
          },
          series: [{
            type: 'column',
            data: res[1],
            colorByPoint: true,
            name: 'Opportunities'
          }]
        };
        this.skillsFlag = true;
      }, 
      error => alert(error.message)
    );
  }

}

import { Component, OnInit } from '@angular/core';
import * as Highcharts from 'highcharts';
import { TrendsService } from '../../Services/trends.service'

@Component({
  selector: 'app-trends',
  templateUrl: './trends.component.html',
  styleUrls: ['./trends.component.css']
})
export class TrendsComponent implements OnInit {
  public locationFlag: boolean = false;
  public skillFlag: boolean = false;
  public quarterFlag: boolean = false;
  public locationSkillsFlag: boolean = false;
  public locationCountFlag: boolean = false;
  public skillCountFlag: boolean = false;

  public locationSeries: Array<any> = [];
  public skillSeries: Array<any> = [];
  public quarterSeries: Array<any> = [];
  public locationSkills: Array<any> = [];
  public locationCount: Array<any> = [];
  public skillCount: Array<any> = [];

  HighchartsLocations: typeof Highcharts = Highcharts;
  HighchartsSkills: typeof Highcharts = Highcharts;
  HighchartsQuarters: typeof Highcharts = Highcharts;
  HighchartsLocationSkills: typeof Highcharts = Highcharts;
  HighchartsLocationCount: typeof Highcharts = Highcharts;
  HighchartsSkillsCount: typeof Highcharts = Highcharts;
  chartOptionsLocations: Highcharts.Options = { };
  chartOptionsSkills: Highcharts.Options = { };
  chartOptionsQuarters: Highcharts.Options = { };
  chartOptionsLocationSkills: Highcharts.Options = { };
  chartOptionsLocationCount: Highcharts.Options = { };
  chartOptionsSkillsCount: Highcharts.Options = { };
  
  constructor(private trendsService: TrendsService) { }

  ngOnInit(): void {
    this.getLocationTrends();
    this.getSkillsTrends();
    this.getQuarterTrends();
    this.getLocationSkills();
    this.getLocationCount();
    this.getSkillsCount();
  }

  public getLocationTrends(){
    this.trendsService.locationTrends().subscribe(
      res => {
        for(let i = 0; i < res.columns.length; i++){
          this.locationSeries.push({
            type: 'column',
            name: res.columns[i],
            data: res.data[i]
          });
        }
        this.chartOptionsLocations = {
          title: {
            text: 'Opportunities by Location'
          },
          xAxis: {
              categories: res.years,
              crosshair: true
          },
          yAxis: {
            min: 0,
            title: {
              text: "Opportunities"
            }
          },
          tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
          },
          plotOptions: {
            column: {
              pointPadding: 0.2,
              borderWidth: 0
            }
          },
          series: this.locationSeries
        };
        this.locationFlag = true;
      }, 
      error => alert(error.message)
    );
  }

  public getSkillsTrends(){
    this.trendsService.skillTrends().subscribe(
      res => {
        for(let i = 0; i < res.columns.length; i++){
          this.skillSeries.push({
            type: 'column',
            name: res.columns[i],
            data: res.data[i]
          });
        }
        this.chartOptionsSkills = {
          title: {
            text: 'Opportunities by Skills'
          },
          xAxis: {
              categories: res.years,
              crosshair: true
          },
          yAxis: {
            min: 0,
            title: {
              text: "Opportunities"
            }
          },
          tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
          },
          plotOptions: {
            column: {
              pointPadding: 0.2,
              borderWidth: 0
            }
          },
          series: this.skillSeries
        };
        this.skillFlag = true;
      }, 
      error => alert(error.message)
    );
  }

  public getQuarterTrends(){
    this.trendsService.quarterTrends().subscribe(
      res => {
        for(let i = 0; i < res.columns.length; i++){
          this.quarterSeries.push({
            type: 'column',
            name: res.columns[i],
            data: res.data[i]
          });
        }
        this.chartOptionsQuarters = {
          title: {
            text: 'Opportunities by Quarters'
          },
          xAxis: {
              categories: res.years,
              crosshair: true
          },
          yAxis: {
            min: 0,
            title: {
              text: "Opportunities"
            }
          },
          tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
          },
          plotOptions: {
            column: {
              pointPadding: 0.2,
              borderWidth: 0
            }
          },
          series: this.quarterSeries
        };
        this.quarterFlag = true;
      }, 
      error => alert(error.message)
    );
  }

  public getLocationSkills(){
    this.trendsService.locationSkillsTrends().subscribe(
      res => {
        for(let i = 0; i < res.columns.length; i++){
          this.locationSkills.push({
            type: 'column',
            name: res.columns[i],
            data: res.data[i]
          });
        }
        this.chartOptionsLocationSkills = {
          title: {
            text: 'Opportunities by Locations & Skills'
          },
          xAxis: {
              categories: res.years,
              crosshair: true
          },
          yAxis: {
            min: 0,
            title: {
              text: "Opportunities"
            }
          },
          tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
          },
          plotOptions: {
            column: {
              pointPadding: 0.2,
              borderWidth: 0
            }
          },
          series: this.locationSkills
        };
        this.locationSkillsFlag = true;
      }, 
      error => alert(error.message)
    );
  }

  public getLocationCount(){
    this.trendsService.locationCount().subscribe(
      res => {
        this.chartOptionsLocationCount = {
          title: {
            text: "Opportunities Count by Locations"
          },
          xAxis: {
            categories: res[0],
            crosshair: true
          },
          yAxis: {
            min: 0,
            title: {
              text: "Opportunities"
            }
          },
          tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
          },
          plotOptions: {
            column: {
              pointPadding: 0.2,
              borderWidth: 0
            }
          },
          series: [{
            type: 'column',
            name: "Count",
            colorByPoint: true,
            data: res[1],
          }],
        };
        this.locationCountFlag = true;
      },
      error => alert(error.message)
    );
  }

  public getSkillsCount(){
    this.trendsService.skillCount().subscribe(
      res => {
        this.chartOptionsSkillsCount = {
          title: {
            text: "Opportunities Count by Skills"
          },
          xAxis: {
            categories: res[0],
            crosshair: true
          },
          yAxis: {
            min: 0,
            title: {
              text: "Opportunities"
            }
          },
          tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
          },
          plotOptions: {
            column: {
              pointPadding: 0.2,
              borderWidth: 0
            }
          },
          series: [{
            type: 'column',
            name: "Count",
            colorByPoint: true,
            data: res[1],
          }],
        };
        this.skillCountFlag = true;
      },
      error => alert(error.message)
    );
  }

}

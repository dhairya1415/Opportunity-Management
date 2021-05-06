import { Component, OnInit } from '@angular/core';
import { Audit } from '../../Models/audit';
import { AuditService } from '../../Services/audit.service';

@Component({
  selector: 'app-audit',
  templateUrl: './audit.component.html',
  styleUrls: ['./audit.component.css']
})
export class AuditComponent implements OnInit {

  public audits: Audit[] = [];
  public key: string = "";
  public value: string = "";
  
  constructor(private auditService: AuditService) { }

  ngOnInit(): void {
    this.getAllAudits();
  }

  public getAllAudits(): void{
    this.auditService.getAllAudits().subscribe(
      (res: Audit[]) => this.audits = res,
      error => alert(error.message)
    );
  }

  public searchAudits(key: string, value: string): void{
    // console.log(key, value);
    this.auditService.searchAudits(key, value).subscribe(
      (res: Audit[]) => this.audits = res,
      error => alert(error.message)
    );
  }

  public onSubmit(): void{
    this.searchAudits(this.key, this.value);
  }

  public resetSearch(): void{
    this.key = "";
    this.value = "";
    this.getAllAudits();
  }

}

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

  public getAuditsById(oppId: number): void{
    this.auditService.getAuditsById(oppId).subscribe(
      (res: Audit[]) => this.audits = res,
      error => alert(error.message)
    );
  }

}

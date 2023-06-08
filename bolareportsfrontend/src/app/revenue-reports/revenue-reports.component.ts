import { Component, OnDestroy, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { AlertService } from '../@services/alert.service';
import { BolaService } from '../@services/bola.service';
import { UtilsService } from '../@services/utils.service';
import { CollectorListResponse } from '../@restmodels/bola/collectors-list.response ';
import { Collector } from '../@restmodels/bola/collector';

@Component({
  selector: 'app-revenue-reports',
  templateUrl: './revenue-reports.component.html',
})
export class RevenueReportsComponent implements OnInit, OnDestroy {

  searchedKeyword: string;
  listOfCollectors: Collector[];
  customer: Collector;
  modalTitle: string;
  productCode: string;

  startDate: Date;
  endDate: Date;
  searchBy: string;
  searchValue: string;
  searchPlaceholder: string;
  searchByLabel: string;

  constructor(
    private title: Title,
    private alertService: AlertService,
    private bolaService: BolaService,
    private utilsService: UtilsService
  ) {
  }

  ngOnInit(): void {
    this.startDate = this.utilsService.getFirstDayDate();
    this.endDate = new Date();
    this.searchBy = "DR";
    this.title.setTitle("Customers");
    this.fetchCollectors();
  }

  ngOnDestroy(): void {
  }

  refreshButton() {
    this.fetchCustomers();
  }

  searchByListener() {
    if (this.searchBy == 'COLL') {
      this.searchByLabel = 'Select Collector';
      this.searchPlaceholder = 'Enter account number'
    } else if (this.searchBy == 'CID') {
      this.searchPlaceholder = 'Enter customer id'
      this.searchByLabel = 'Customer Id';
    }
  }

  fetchCustomers(): void {
    this.bolaService.generateJasperReport(this.searchBy, this.searchValue, this.startDate, this.endDate);
  }

  fetchCollectors(): void {
    this.listOfCollectors = [];
    this.bolaService.getCollectors().subscribe({
      next: (res: CollectorListResponse) => {
        console.info(`getCollectors response ` + JSON.stringify(res))
        if (res.headerResponse.responseCode !== '000') {
          this.alertService.error(res.headerResponse.responseMessage);
          return;
        }
        this.listOfCollectors = res.collectors;
      },
      error: error => {
        console.error(error);
        this.alertService.showInfoMsg(error);
      }
    });
  }


 
}

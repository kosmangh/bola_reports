import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, timeout } from 'rxjs';
import { environment } from 'src/environments/environment';
import { UtilsService } from './utils.service';
import { RevenueCollectionSummaryReportRequest } from '../@restmodels/bola/revenue-collection-summary-report.request';
import { CollectorListResponse } from '../@restmodels/bola/collectors-list.response ';
import { CollectorListRequest } from '../@restmodels/bola/collectors-list.request';
import { HeaderRequest } from '../@restmodels/header.request';

@Injectable({
    providedIn: 'root'
})
export class BolaService {
    private baseUrl: string;

    SETTINGS = "";

    constructor(
        private utilsService: UtilsService,
        private http: HttpClient,
    ) {
    }

    generateJasperReport(searchBy: string, searchValue: string, startDate: Date, endDate: Date) {
        const request = new RevenueCollectionSummaryReportRequest();
        request.headerRequest = this.getRequestHeader("EGH", 'PRINT_SUMMARY_REPORT');
        request.startDate = startDate;
        request.endDate = endDate;
        request.searchBy = searchBy;
        request.searchValue = searchValue;
        this.http.post(`${environment.url}/revenuereport`, request, { responseType: 'blob' })
            .subscribe(response => {
                // Open the PDF response in a new browser tab
                const file = new Blob([ response ], { type: 'application/pdf' });
                const fileURL = URL.createObjectURL(file);
                window.open(fileURL);
            });
    }

   

    getCollectors(): Observable<CollectorListResponse> {
        const request = new CollectorListRequest();
        request.headerRequest = this.getRequestHeader("EGH", 'COLLECTORS');
        console.info('getCollectors request ' + JSON.stringify(request));
        return this.http.post<CollectorListResponse>(`${environment.url + this.SETTINGS}/collectors`, request)
            .pipe(
                timeout(environment.timeout), // Timeout after 10s of no response
            );
    }


    getRequestHeader(affCode: string, requestType: string): HeaderRequest {
        const headerRequest = new HeaderRequest();
        headerRequest.requestId = "123456";
        headerRequest.affiliateCode = affCode;
        headerRequest.requestToken = "environment.token";
        headerRequest.sourceCode = "environment.sourceCode";
        headerRequest.sourceChannelId = "environment.sourceCode";
        headerRequest.requestType = requestType;
        headerRequest.ipAddress = "10.4.139.49";
        headerRequest.lang = "EN";
        return headerRequest;
    }


}

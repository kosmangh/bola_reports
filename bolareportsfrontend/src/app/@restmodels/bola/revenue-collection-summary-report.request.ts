import { HeaderRequest } from "../header.request";

export class RevenueCollectionSummaryReportRequest {
    headerRequest: HeaderRequest;
    searchBy: string;
    searchValue: string;
    startDate: Date;
    endDate: Date;
}

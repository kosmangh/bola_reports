import { HeaderResponse } from "../header.response";
import { Collector } from "./collector";

export class CollectorListResponse {
    headerResponse: HeaderResponse;
    collectors: Collector[];
}

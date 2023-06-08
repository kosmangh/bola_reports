export class HeaderRequest {
    requestId!: string;
    affiliateCode!: string;
    requestToken!: string;
    sourceCode!: string;
    sourceChannelId!: string;
    requestType!: string;
    ipAddress!: string;
  lang: string;

    toString(): string {
        return '' +
            this.affiliateCode
            + this.ipAddress
            + this.requestId
            + this.requestToken
            + this.requestType
            + this.sourceChannelId
            + this.sourceCode;
    }

}
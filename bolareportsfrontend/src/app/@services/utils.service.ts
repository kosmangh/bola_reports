import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class UtilsService {
  public APP_SESSION_NAME = "bolareports";



  constructor(
    private http: HttpClient,
  ) {
  }





  getFirstDayDate(): Date {
    const date = new Date();
    const y = date.getFullYear();
    const m = date.getMonth();
    const firstDay = new Date(y, m, 1);
    return firstDay;
  }



  getLastDayDate(): Date {
    const date = new Date();
    const y = date.getFullYear();
    const m = date.getMonth();
    let lastDay = new Date(y, m + 1, 0);
    return lastDay;
  }




  getUniqueId(parts: number): string {
    const stringArr = [];
    for (let i = 0; i < parts; i++) {
      const S4 = (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
      stringArr.push(S4);
    }
    let id = stringArr.join('-');
    id = id.replace('-', '');
    id = id.replace('-', '');
    id = id.replace('-', '');
    return id;
  }















  getHeaders(): any {
    const headers = { 'content-type': 'application/json' };
    return headers;
  }

  getUserType(role: string): string {
    if (role.includes('GROUP')) {
      return 'G';
    }
    return 'A';
  }

  getMaskEmail(email: string): string {
    const [ name, domain ] = email.split('@');
    const { length: len } = name;
    const maskedName = name[ 0 ] + '...' + name[ len - 1 ];
    const maskedEmail = maskedName + '@' + domain;
    return maskedEmail;
  }


  getFakeIp(): string {
    const ip = `${Math.floor(Math.random() * 255) + 1}.${Math.floor(Math.random()
      * 255)}.${Math.floor(Math.random() * 255)}.${Math.floor(Math.random() * 255)}`;
    return ip;
  }




}


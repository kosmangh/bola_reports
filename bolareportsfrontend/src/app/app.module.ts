import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RevenueReportsComponent } from './revenue-reports/revenue-reports.component';
import { CalendarModule } from 'primeng/calendar';
import { NgSelectModule } from '@ng-select/ng-select';




@NgModule({
  declarations: [
    AppComponent,
    RevenueReportsComponent
  ],
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    HttpClientModule,
    AppRoutingModule,
    NgSelectModule,
    CalendarModule,
  ],


  providers: [],
  bootstrap: [ AppComponent ]
})
export class AppModule { }

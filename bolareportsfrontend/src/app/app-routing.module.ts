import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RevenueReportsComponent } from './revenue-reports/revenue-reports.component';

const routes: Routes = [
  {
    path: '', component: RevenueReportsComponent,
  },
  {
    path: 'reports', component: RevenueReportsComponent,
  },
 





];

@NgModule({
  imports: [ RouterModule.forRoot(routes, { useHash: true }) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }

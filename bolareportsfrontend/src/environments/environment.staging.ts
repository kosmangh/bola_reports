// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

// import { opsportalres } from "/usr/app/portalres/configs/opsportalres";

import { NgxLoggerLevel } from "ngx-logger";
export const environment = {
  production: false,
  // base_url: 'http://localhost:8888/usermgtservices',
  base_url: 'http://10.4.139.49:7003/usermgtservices',
  elevy_base_url: 'http://10.4.139.49:7003/GRAeLevyAPIPortal/v1',
  //config_url: 'http://localhost:3001',

  // base_url: opsportalres.base_url,
  // elevy_base_url: opsportalres.elevyBase_url,

  elevy_api_key: 'pMP1PsVYHB3FQK0Zr1ORg89tN4b5bA4K9hGFfKZa',
  elevy_secure_key: 'eC0bAnque@1$%^',
  sourceCode: 'OPS_PORTAL',
  token: 'eC0bAnque@1$%^',
  timeout: 10000,
  log_url: 'http://localhost:7003/bolareports/logaction',
  server_log_level: NgxLoggerLevel.DEBUG,
  disable_console_logging: true
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.

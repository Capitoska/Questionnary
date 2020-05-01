import {HTTP_INTERCEPTORS, HttpHeaders} from '@angular/common/http';
import {AuthInterceptor} from './shared/auth.interceptor';

export const apiBaseUrl = 'http://localhost:8081/api/fapi';

export const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

export const authInterceptorProviders = [
  { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
];

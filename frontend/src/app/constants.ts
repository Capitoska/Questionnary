import { HttpHeaders } from '@angular/common/http';

export const apiBaseUrl = 'http://localhost:8081/api/fapi';

export const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {IUser} from '../interfaces/IUser';
import {apiBaseUrl, httpOptions} from '../constants';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private router: Router) {}

  register(user: IUser): Observable<any> {
    return this.http.post(`${apiBaseUrl}/users/`, user, httpOptions);
  }

  login(user: IUser): Observable<any> {
    return this.http.post(`${apiBaseUrl}/token/authenticate`, user, httpOptions);
  }
}

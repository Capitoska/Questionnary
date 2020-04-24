import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {IUser} from '../interfaces/IUser';
import {apiBaseUrl} from '../constants';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  register(user: IUser){
    return this.http.post(`${apiBaseUrl}/users/`, user).subscribe(r => {});
  }

  login(user: IUser): Observable<object> {
    return this.http.post(`${apiBaseUrl}/token/generate-token/`, user);
  }
}

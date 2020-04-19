import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {IUser} from "../interfaces/IUser";
import {apiBaseUrl} from "../constants";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  registerUser(user: IUser) {
    return this.http.post(`${apiBaseUrl}/users/`, user).subscribe(r => {console.log(r)});
  }
}

import {Component, OnInit} from '@angular/core';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  public isLogged = false;
  public token: string;
  constructor(private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    this.checkLogin();
  }

  logOut(): void {
    this.tokenStorage.removeToken();
    this.checkLogin();
  }

  checkLogin() {
     this.token = this.tokenStorage.getToken();
     if (this.token) {
      this.isLogged = true;
     } else {
       this.isLogged = false;
     }
  }
}

import {Component, OnInit} from '@angular/core';
import {UserService} from 'src/app/services/user.service';
import {TokenStorageService} from 'src/app/services/token-storage.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  constructor(private userService: UserService, private tokenStorage: TokenStorageService, private router: Router) { }
  user = {
    username: '',
    password: ''
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage: string;

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }
  }

  onSubmit(): void {
    this.userService.login(this.user).subscribe(data => {
      console.log(data);
      this.tokenStorage.saveToken(data.jwtResponse);
      this.tokenStorage.saveUser(data);
      this.isLoginFailed = false;
      this.isLoggedIn = true;
      this.reloadPage();
      this.router.navigate(['']);
    }, error => {
      this.errorMessage = error.message;
      this.isLoginFailed = true;
    });
  }

  reloadPage(): void {
    window.location.reload();
  }
}

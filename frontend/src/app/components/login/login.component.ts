import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  constructor(private userService: UserService, private tokenStorage: TokenStorageService) { }
  user = {
    username: '',
    password: ''
  };

  ngOnInit() {
  }

  loginUser(): void {
    this.userService.login(this.user).subscribe(data => {
      console.log(data);
      this.tokenStorage.saveToken(data.accessToken);
      this.tokenStorage.saveUser(data);
    }, error => console.log(error));
  }
}

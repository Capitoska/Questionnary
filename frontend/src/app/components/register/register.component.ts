import {Component, OnInit} from '@angular/core';
import {IUser} from '../../interfaces/IUser';
import {UserService} from '../../services/user.service';
import {Router} from '@angular/router';
import {DatePipe} from '@angular/common';
import {TokenStorageService} from '../../services/token-storage.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  user: IUser = {
    birthday: '',
    email: '',
    firstName: '',
    password: '',
    secondName: '',
    thirdName: '',
    username: ''
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private userService: UserService, private datePipe: DatePipe,
              private router: Router, private tokenStorage: TokenStorageService) {
  }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isSuccessful = true;
    }
  }

  onSubmit() {
    this.user.birthday = this.convertDate(this.user.birthday);
    this.userService.register(this.user).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this.userService.login({
          username: this.user.username,
          password: this.user.password
        }).subscribe( response => {
          this.tokenStorage.saveToken(response.jwtResponse);
          window.location.reload();
        });
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      });
  }

  convertDate(date: string | Date): string {
    return this.datePipe.transform(date, 'dd-MM-yyyy');
  }

  quizList(): void {
    this.router.navigate(['']);
  }
}

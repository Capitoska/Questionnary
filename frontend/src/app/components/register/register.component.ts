import {Component, OnInit} from '@angular/core';
import {IUser} from '../../interfaces/IUser';
import {UserService} from '../../services/user.service';
import { Router } from '@angular/router';

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

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.userService.register(this.user).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      });
  }
}

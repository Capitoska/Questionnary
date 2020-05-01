import {Component, OnInit} from '@angular/core';
import {IUser} from '../../interfaces/IUser';
import {UserService} from '../../services/user.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';
import { pipe } from 'rxjs';

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

  constructor(private userService: UserService, private datePipe: DatePipe) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.user.birthday = this.convertDate(this.user.birthday);
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

  convertDate(date: string | Date): string {
    return this.datePipe.transform(date, 'dd-MM-yyyy');
  }
}

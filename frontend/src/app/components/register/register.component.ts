import {Component, OnInit} from '@angular/core';
import {IUser} from "../../interfaces/IUser";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  user: IUser = {
    birthday: "",
    email: "",
    firstName: "",
    password: "",
    secondName: "",
    thirdName: "",
    username: ""
  };

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
  }

  register() {
    this.userService.registerUser(this.user);
  }
}

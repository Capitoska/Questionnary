import {Component, OnInit} from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { IUser } from 'src/app/interfaces/IUser';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  user: IUser = {
    username: '',
    firstName: '',
    secondName: '',
    thirdName: '',
    birthday: '',
    id: 0,
    password: ''
  };
  isDataLoaded = false;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getAuthorizedUser().subscribe( data => {
      this.user = data;
      this.isDataLoaded = true;
      console.log(data);
    }, err => console.log(err));
  }

}

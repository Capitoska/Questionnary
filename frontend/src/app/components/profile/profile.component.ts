import {Component, OnInit} from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { IUser } from 'src/app/interfaces/IUser';
import { QuizService } from 'src/app/services/quiz.service';

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
  quizes: any;
  isDataLoaded = false;

  constructor(private userService: UserService, private quizServise: QuizService) { }

  ngOnInit(): void {
    this.userService.getAuthorizedUser().subscribe( data => {
      this.user = data;
      this.isDataLoaded = true;
      this.reloadQuizes();
    }, err => console.log(err));
  }

  reloadQuizes(): void {
    this.quizes = this.quizServise.getQuizByCreatorId(this.user.id);
  }

}

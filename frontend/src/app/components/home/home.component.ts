import {Component, OnInit} from '@angular/core';
import {IQuiz} from 'src/app/interfaces/IQuiz';
import {QuizService} from 'src/app/services/quiz.service';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { IUser } from 'src/app/interfaces/IUser';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  quizList: Observable<IQuiz[]>;
  user: Observable<any>;
  constructor(private quizService: QuizService, private router: Router, private userService: UserService) { }

  ngOnInit(): void {
    this.reloadData();
    this.user = this.userService.getAuthorizedUser();
  }

  reloadData() {
    this.quizList = this.quizService.getAllQuizes();
  }

}

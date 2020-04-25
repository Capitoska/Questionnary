import {Component, OnInit} from '@angular/core';
import { IQuiz } from 'src/app/interfaces/IQuiz';
import { QuizService } from 'src/app/services/quiz.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  quizList: Observable<IQuiz[]>;
  constructor(private quizService: QuizService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.quizList = this.quizService.getAllQuizes();
  }

  deleteQuiz(id: number){
    this.quizService.deleteQuiz(id);
  }

  quizDetails(id: number) {
    return id;
  }

}

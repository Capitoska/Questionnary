import {Component, OnInit} from '@angular/core';
import {IQuiz} from 'src/app/interfaces/IQuiz';
import {QuizService} from 'src/app/services/quiz.service';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  quizList: Observable<IQuiz[]>;
  constructor(private quizService: QuizService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.quizList = this.quizService.getAllQuizes();
  }

  deleteQuiz(id: number){
    this.quizService.deleteQuiz(id)
      .subscribe(data => {console.log(data);
        this.reloadData()}, error => console.log(error));
  }

  quizDetails(id: number) {
    this.router.navigate(['quizes', id]);
  }

}

import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {QuizService} from 'src/app/services/quiz.service';
import {IQuiz} from 'src/app/interfaces/IQuiz';

@Component({
  selector: 'app-quiz-save',
  templateUrl: './quiz-save.component.html',
  styleUrls: ['./quiz-save.component.scss']
})
export class QuizSaveComponent implements OnInit {

  quiz: IQuiz = {
    author: null,
    id: 0,
    isOpen: false,
    name: "",
    questions: null
  };
  submitted = false;

  constructor(private quizService: QuizService, private router: Router) {
  }

  ngOnInit() {
  }

  save() {
    this.quizService.saveQuiz(this.quiz)
      .subscribe(data => console.log(data), error => console.log(error));
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['']);
  }
}


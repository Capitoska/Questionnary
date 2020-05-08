import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {QuizService} from 'src/app/services/quiz.service';
import {IQuiz} from 'src/app/interfaces/IQuiz';
import { IQuestion } from 'src/app/interfaces/IQuestion';

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
    name: '',
    questions: Array<IQuestion>()
  };

  question: IQuestion;

  submitted = false;

  constructor(private quizService: QuizService, private router: Router) {
  }

  ngOnInit() {
    this.setQuestionisUndefined();
  }

  save() {
    console.log(this.quiz);
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

  setQuestionisUndefined(): void {
    this.question = {
      id: undefined,
      text: undefined,
      answerType: undefined,
      possibleAnswer: undefined,
      rightAnswer: undefined,
    };
  }
}


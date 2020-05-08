import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QuizService } from 'src/app/services/quiz.service';
import { IQuiz } from 'src/app/interfaces/IQuiz';
import { IQuestion } from 'src/app/interfaces/IQuestion';

const quizTemplate: IQuiz = {
  author: null,
  id: 0,
  isOpen: false,
  name: '',
  questions: [],
};

@Component({
  selector: 'app-quiz-save',
  templateUrl: './quiz-save.component.html',
  styleUrls: ['./quiz-save.component.scss'],
})
export class QuizSaveComponent implements OnInit {
  submitted = false;
  quiz: IQuiz;

  constructor(private quizService: QuizService, private router: Router) {}

  ngOnInit() {
    this.quiz = quizTemplate;
    this.addQuestion();
  }

  save() {
    console.log(this.quiz);
    this.quizService.saveQuiz(this.quiz).subscribe(
      (data) => console.log(data),
      (error) => console.log(error)
    );
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['']);
  }

  selectTypeOfAnswer(id: number, type: 'checkbox' | 'radio' | 'text') {
    this.quiz.questions[id].answerType.value = type;
  }

  addAnswer(id: number): void {
    this.quiz.questions[id].possibleAnswer.push({
      id: null,
      value: null,
    });
  }

  addQuestion(): void {
    this.quiz.questions.push(this.createQuestion());
    console.log(this.quiz);
  }

  createQuestion(): IQuestion {
    return {
      id: null,
      text: null,
      answerType: { id: null, value: 'radio' },
      rightAnswer: null,
      possibleAnswer: [{id: null, value: null}],
    };
  }
}

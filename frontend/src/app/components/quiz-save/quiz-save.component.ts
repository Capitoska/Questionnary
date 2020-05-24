import {Component, OnInit} from '@angular/core';
import {QuizService} from 'src/app/services/quiz.service';
import {FormGroup} from '@angular/forms';
import {QuizCreateService} from 'src/app/services/quiz-create.service';

@Component({
  selector: 'app-quiz-save',
  templateUrl: './quiz-save.component.html',
  styleUrls: ['./quiz-save.component.scss'],
})
export class QuizSaveComponent implements OnInit {
  get quizForm(): FormGroup {
    return this.quizCreate.quizForm;
  }

  get questions() {
    return this.quizCreate.questions;
  }

  constructor(private quizService: QuizService, private quizCreate: QuizCreateService) { }

  ngOnInit() {}

  onSubmit() {
    console.warn(this.quizForm.value);
    this.quizService.saveQuiz(this.changeTypes(this.quizForm.value)).subscribe(
      (data) => console.log(data),
      (error) => console.log(error)
    );
  }

  changeTypes(quizForm) {
    const quiz = Object.assign({}, quizForm);
    quiz.questions.forEach(question => {
      question.answerType = {value: question.answerType};
    });
    console.warn(quiz);
    return quiz;
  }
}

import {Component, OnInit} from '@angular/core';
import {FormArray, FormGroup} from '@angular/forms';
import {QuizCreateService} from 'src/app/services/quiz-create.service';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.scss']
})
export class QuestionsComponent implements OnInit {
  get quizForm(): FormGroup {
    return this.quizCreate.quizForm;
  }

  get questions() {
    return this.quizCreate.questions ? this.quizCreate.questions : null;
  }

  constructor(private quizCreate: QuizCreateService) { }

  ngOnInit(): void {
  }

  getAnswers(questionId: number): FormArray {
    return this.quizCreate.getAnswers(questionId);
  }

  getAnswerType(questionId: number): string {
    return this.quizCreate.getAnswerType(questionId);
  }

  selectTypeOfAnswer(questionId: number, type: 'checkbox' | 'radio' | 'text'): void {
    this.quizCreate.selectTypeOfAnswer(questionId, type);
  }

  removeQuestion(questionId: number): void {
    this.quizCreate.removeQuestion(questionId);
  }

  removeAnswer(questionId: number, answerId: number): void {
    this.quizCreate.removeAnswer(questionId, answerId);
  }

  addAnswer(questionId: number): void {
    this.quizCreate.addAnswer(questionId);
  }

  addQuestion(): void {
    this.quizCreate.addQuestion();
  }

}

import { Injectable } from '@angular/core';
import { FormGroup, FormControl, FormArray } from '@angular/forms';

@Injectable({
  providedIn: 'root',
})
export class QuizCreateService {
  quizForm: FormGroup;

  get questions() {
    return this.quizForm.get('questions') as FormArray;
  }

  constructor() {
    this.quizForm = this.createQuizForm();
  }

  private createQuizForm(): FormGroup {
    return new FormGroup({
      name: new FormControl(null),
      questions: new FormArray([this.createNewQuestion()]),
    });
  }

  createNewQuestion(): FormGroup {
    return new FormGroup({
      text: new FormControl(null),
      answerType: new FormControl('radio'),
      answers: new FormArray([this.createAnswer()]),
    });
  }

  createAnswer(): FormControl {
    return new FormControl(null);
  }

  selectTypeOfAnswer(
    questionNumber: number,
    type: 'checkbox' | 'radio' | 'text'
  ): void {
    this.questions.controls[questionNumber].patchValue({ answerType: type });
    if (type === 'text') {
      const answers = this.getAnswers(questionNumber);
      for (let i = answers.controls.length - 1; i > 0; i--) {
        answers.removeAt(i);
      }
    }
  }

  removeAnswer(questionId: number, answerId: number): void {
    const answers = this.getAnswers(questionId);
    answers.removeAt(answerId);
  }

  removeQuestion(questionId: number): void {
    this.questions.removeAt(questionId);
  }

  getAnswerType(questionId: number): string {
    return this.questions.controls[questionId].get('answerType').value;
  }

  getAnswers(questionId: number): FormArray {
    return this.questions.controls[questionId].get('answers') as FormArray;
  }

  addQuestion(): void {
    this.questions.controls.push(this.createNewQuestion());
  }

  addAnswer(questionId: number): void {
    const answers = this.getAnswers(questionId);
    answers.push(this.createAnswer());
  }
}

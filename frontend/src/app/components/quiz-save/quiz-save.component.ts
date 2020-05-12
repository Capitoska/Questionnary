import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QuizService } from 'src/app/services/quiz.service';
import { IQuiz } from 'src/app/interfaces/IQuiz';
import { IQuestion } from 'src/app/interfaces/IQuestion';
import { FormGroup, FormControl, FormArray } from '@angular/forms';

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
  quizForm: FormGroup;

  get questions() {
    return this.quizForm.get('questions') as FormArray;
  }

  constructor(private quizService: QuizService, private router: Router) {
    this.quizForm = this.createQuizForm();
    console.log(this.quizForm);
  }

  ngOnInit() {}

  private createQuizForm(): FormGroup {
    return new FormGroup({
      name: new FormControl(null),
      questions: new FormArray([this.createNewQuestion()]),
    });
  }

  private createNewQuestion(): FormGroup {
    return new FormGroup({
      text: new FormControl(null),
      answerType: new FormControl('radio'),
      answers: new FormArray([this.createAnswer()]),
    });
  }

  createAnswer(): FormControl {
    return new FormControl(null);
  }

  getAnswersOfQuestion(questionId: number): FormArray {
    return this.questions.controls[questionId].get('answers') as FormArray;
  }

  getAnswerType(questionId: number): string {
    return this.questions.controls[questionId].get('answerType').value;
  }

  addQuestion(): void {
    this.questions.controls.push(this.createNewQuestion());
  }

  addAnswer(questionId: number): void {
    const question = this.questions.controls[questionId].get('answers') as FormArray;
    question.push(this.createAnswer());
  }

  save() {
    this.quizService.saveQuiz(this.quiz).subscribe(
      (data) => console.log(data),
      (error) => console.log(error)
    );
  }

  saveQuiz() {
    console.log(this.quizForm.value);

  }

  selectTypeOfAnswer(questionNumber: number, type: 'checkbox' | 'radio' | 'text'): void {
    this.questions.controls[questionNumber].patchValue({answerType: type});
  }
}

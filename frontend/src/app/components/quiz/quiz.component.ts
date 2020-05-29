import {Component, OnInit} from '@angular/core';
import {QuizService} from 'src/app/services/quiz.service';
import {ActivatedRoute, Router} from '@angular/router';
import {MDBModalRef, MDBModalService} from 'angular-bootstrap-md';
import {ModalComponent} from '../modal/modal.component';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.scss'],
})
export class QuizComponent implements OnInit {
  quiz: any;
  id: number;
  modalRef: MDBModalRef;

  get questions() {
    return this.quiz.questions;
  }

  constructor(
    private quizService: QuizService,
    private route: ActivatedRoute,
    private router: Router,
    private modalService: MDBModalService
  ) {
    this.modalService.close.subscribe(() => this.quizList());
   }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    this.quizService.getQuizById(this.id).subscribe(
      (data) => {
        this.quiz = data;
        this.addAnswerClickCheck();
      },
      (error) => console.log(error)
    );
  }

  quizList(): void {
    this.router.navigate(['']);
  }

  private addAnswerClickCheck(): void {
    this.questions.forEach(question => {
      let check = false;
      if (question.answerType.value === 'text') {
        check = true;
      }
      question.answers.forEach(answer => {
        answer.isChecked = check;
      });
    });
  }

  getAnswerType(questionId: number): string {
    return this.questions[questionId].answerType.value;
  }

  private getCheckedAnswers(): Array<any> {
    const checkedAnswers = [];
    this.questions.forEach(question => {
      question.answers.forEach(answer => {
        if (answer.isChecked) {
          const obj = {
            question,
            answer
          };
          checkedAnswers.push(obj);
        }
      });
    });
    console.log('Answers', checkedAnswers);
    return checkedAnswers;
  }

  saveAnswers(): void {
    this.quizService.saveAnswers(this.getCheckedAnswers()).subscribe(res => {
      console.log('Response', res);
      this.openModal();
    }, err => {
      console.log('Error', err);
    });
  }

  checkAnswer(questionId: number, answerId: number): void {
    const type = this.getAnswerType(questionId);
    const notCheck = !this.questions[questionId].answers[answerId].isChecked;
    if (type === 'checkbox') {
      this.checkCheckboxAnswer(questionId, answerId, notCheck);
    }
    if (type === 'radio') {
      this.checkRadioAnswer(questionId, answerId);
    }
  }

  private checkCheckboxAnswer(questionId: number, answerId: number, notCheck: boolean): void {
    this.questions[questionId].answers[answerId].isChecked = notCheck;
  }

  private checkRadioAnswer(questionId: number, answerId: number): void {
    this.questions[questionId].answers.forEach(answer => {
      answer.isChecked = false;
    });
    this.questions[questionId].answers[answerId].isChecked = true;
  }

  openModal(): void {
    this.modalRef = this.modalService.show(ModalComponent);

  }
}

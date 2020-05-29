import {Component, OnInit} from '@angular/core';
import {QuizService} from "../../services/quiz.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MDBModalRef, MDBModalService} from 'angular-bootstrap-md';
import {ModalComponent} from '../modal/modal.component';

@Component({
  selector: 'app-quiz-report',
  templateUrl: './quiz-report.component.html',
  styleUrls: ['./quiz-report.component.scss']
})
export class QuizReportComponent implements OnInit {
  quiz: any;
  reportMessage: string;
  quizId: number;
  modalRef: MDBModalRef;
  constructor(private quizService: QuizService, private router: Router,
     public route: ActivatedRoute, private modalService: MDBModalService) {
    modalService.close.subscribe( r => router.navigate(['']));
   }

  ngOnInit(): void {
    this.quizId = this.route.snapshot.params.id;
    this.quizService.getQuizById(this.quizId).subscribe( quiz => {
      console.log(quiz);
      this.quiz = quiz;
    });
  }

  saveReport(): void {
    this.quizService.sendReport({text: this.reportMessage, quiz: this.quiz}).subscribe( data => {
      console.log(data);
      this.modalRef = this.modalService.show(ModalComponent);
    }, error => console.log(error));
  }
}

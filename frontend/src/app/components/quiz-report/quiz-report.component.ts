import {Component, OnInit} from '@angular/core';
import {QuizService} from "../../services/quiz.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-quiz-report',
  templateUrl: './quiz-report.component.html',
  styleUrls: ['./quiz-report.component.scss']
})
export class QuizReportComponent implements OnInit {
  quiz: any;
  reportMessage: string;
  constructor(private quizService: QuizService, public route: ActivatedRoute) { }

  ngOnInit(): void {
    this.quizService.getQuizById(this.route.snapshot.params.id).subscribe( quiz => {
      console.log(quiz);
      this.quiz = quiz;
    });
  }

  saveReport(): void {

  }

}

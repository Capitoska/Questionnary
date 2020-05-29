import {Component, OnInit} from '@angular/core';
import {QuizService} from 'src/app/services/quiz.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-reports-list',
  templateUrl: './reports-list.component.html',
  styleUrls: ['./reports-list.component.scss']
})
export class ReportsListComponent implements OnInit {
  reports: any;
  id: number;
  constructor(private quizService: QuizService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    this.quizService.getReportsByQuizId(this.id).subscribe( data => {
      this.reports = data;
      console.log('Reports', data);
    }, error => {
      console.log(error);
    });
  }

  goToProfile(): void {
    this.router.navigate(['profile']);
  }
}

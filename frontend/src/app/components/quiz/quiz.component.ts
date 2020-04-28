import {Component, OnInit} from '@angular/core';
import {QuizService} from 'src/app/services/quiz.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.scss']
})
export class QuizComponent implements OnInit {
  quiz;
  id: number;

  constructor(private quizService: QuizService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    console.log('ID = ', this.route.snapshot.params.id);
    this.quizService.getQuizById(this.id).subscribe(data => {
      console.log(data);
      this.quiz = data;
    }, error => console.log(error));
  }

  quizList(): void {
    this.router.navigate(['']);
  }

}

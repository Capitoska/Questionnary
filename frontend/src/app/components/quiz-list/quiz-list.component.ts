import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {QuizService} from '../../services/quiz.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-quiz-list',
  templateUrl: './quiz-list.component.html',
  styleUrls: ['./quiz-list.component.scss']
})
export class QuizListComponent implements OnInit {
  @Input() quizList;
  @Input() user;
  @Output() onDataChange = new EventEmitter<void>();

  constructor(private quizService: QuizService, private router: Router) {
  }

  ngOnInit(): void {
  }

  reloadData() {
    this.onDataChange.emit();
  }

  deleteQuiz(id: number) {
    this.quizService.deleteQuiz(id)
      .subscribe(data => {
        console.log(data);
        this.reloadData();
      }, error => console.log(error));
  }

  quizDetails(id: number) {
    this.router.navigate(['quizes', id]);
  }

  reportQuiz(quizId: number): void {
    this.router.navigate(['quizes', 'report', quizId]);
  }

  currentUserIsCreator(userId: number): boolean {
    return userId === this.user.id;
  }
}

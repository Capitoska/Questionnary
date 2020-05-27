import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {QuizService} from '../../services/quiz.service';
import {Router} from '@angular/router';
import {UserService} from "../../services/user.service";
import {IUser} from "../../interfaces/IUser";

@Component({
  selector: 'app-quiz-list',
  templateUrl: './quiz-list.component.html',
  styleUrls: ['./quiz-list.component.scss']
})
export class QuizListComponent implements OnInit {
  @Input() quizList;
  @Input() user: IUser;
  @Output() onDataChange = new EventEmitter<void>();

  constructor(private quizService: QuizService, private router: Router, private userService: UserService) {
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

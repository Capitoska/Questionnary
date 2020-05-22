import { Component, OnInit } from '@angular/core';
import { QuizService } from 'src/app/services/quiz.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.scss'],
})
export class QuizComponent implements OnInit {
  quiz: any = {
    id: 1,
    name: 'Horses111',
    description: 'Its a simple description for this quiz...',
    author: {
      id: 56,
      firstName: 'Arseni',
      username: 'lastTest3',
      secondName: 'Kamadei',
      email: null,
      password: '$2a$10$spC4IDzm83vZlhGM5d8ujOOSD6VKa4pNjk4sfd7j9wQ9WAo0x7u8y',
      thirdName: 'Nevazhno',
      birthday: '2020-04-02',
      role: {
        id: 2,
        name: 'admin',
      },
    },
    questions: [
      {
        id: 1,
        text: 'How much legs?',
        answerType: {
          id: 1,
          value: 'radio',
        },
        possibleAnswer: [
          {
            id: 8,
            value: '4',
          },
          {
            id: 8,
            value: '4',
          },
        ],
      },
      {
        id: 1,
        text: 'How much legs?',
        answerType: {
          id: 1,
          value: 'checkbox',
        },
        possibleAnswer: [
          {
            id: 8,
            value: '4',
          },
          {
            id: 9,
            value: '5',
          },
        ],
      },
      {
        id: 1,
        text: 'How much legs?',
        answerType: {
          id: 1,
          value: 'text',
        },
        possibleAnswer: [
          {
            id: 8,
            value: '',
          },
        ],
      },
      {
        id: 1,
        text: 'How much legs?',
        answerType: {
          id: 1,
          value: 'checkbox',
        },
        possibleAnswer: [
          {
            id: 8,
            value: '4',
          },
          {
            id: 9,
            value: '5',
          },
        ],
      },
    ],
    isCompleted: null,
    shareTypeEntity: null,
    urlAddress: 'MUhvcnNlczExMTI1NjU0NA==',
  };
  id: number;

  get questions() {
    return this.quiz.questions;
  }

  constructor(
    private quizService: QuizService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    this.quizService.getQuizById(this.id).subscribe(
      (data) => {
        this.quiz = data;
      },
      (error) => console.log(error)
    );
    this.addAnswerClickCheck();
  }

  quizList(): void {
    this.router.navigate(['']);
  }

  private addAnswerClickCheck(): void {
    this.questions.forEach( question => {
      let check = false;
      if (question.answerType.value === 'text') {
        check = true;
      }
      question.possibleAnswer.forEach( answer => {
        answer.isChecked = check;
      });
    });
  }

  getAnswerType(questionId: number): string {
    return this.questions[questionId].answerType.value;
  }

  private getCheckedAnswers(): Array<any> {
    const checkedAnswers = [];
    this.questions.forEach( question => {
      question.possibleAnswer.forEach( answer => {
        if (answer.isChecked) {
          const obj = {
            question,
            answer
          };
          checkedAnswers.push(obj);
        }
      });
    });
    console.log(checkedAnswers);
    return checkedAnswers;
  }

  saveAnswers(): void {
    this.quizService.saveAnswers(this.getCheckedAnswers());
  }

  checkAnswer(questionId: number, answerId: number): void {
    const type = this.getAnswerType(questionId);
    const notCheck = !this.questions[questionId].possibleAnswer[answerId].isChecked;
    if (type === 'checkbox') {
      this.checkCheckboxAnswer(questionId, answerId, notCheck);
    }
    if (type === 'radio') {
      this.checkRadioAnswer(questionId, answerId);
    }
  }

  private checkCheckboxAnswer(questionId: number, answerId: number, notCheck: boolean): void {
    this.questions[questionId].possibleAnswer[answerId].isChecked = notCheck;
  }

  private checkRadioAnswer(questionId: number, answerId: number): void {
    this.questions[questionId].possibleAnswer.forEach( answer => {
      answer.isChecked = false;
    });
    this.questions[questionId].possibleAnswer[answerId].isChecked = true;
  }
}

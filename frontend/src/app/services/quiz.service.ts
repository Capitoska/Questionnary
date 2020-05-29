import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {apiBaseUrl} from '../constants';
import {IQuiz} from '../interfaces/IQuiz';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private http: HttpClient) { }

  getAllQuizes(): Observable<any>{
    return this.http.get(`${apiBaseUrl}/quizes/`);
  }

  getQuizById(id: number): Observable<any> {
    return this.http.get(`${apiBaseUrl}/quizes/${id}`);
  }

  getQuizByCreatorId(creatorId: number): Observable<any> {
    return this.http.get(`${apiBaseUrl}/users/quizes`);
  }

  deleteQuiz(id: number): Observable<any> {
    return this.http.delete(`${apiBaseUrl}/quizes/${id}`);
  }

  saveQuiz(quiz: IQuiz): Observable<any> {
    return this.http.post(`${apiBaseUrl}/quizes/`, quiz);
  }

  saveAnswers(answers: any): Observable<any> {
    return this.http.post(`${apiBaseUrl}/user-answers/`, answers);
  }

  sendReport(report: object): Observable<any> {
    return this.http.post(`${apiBaseUrl}/reports/`, report);
  }

  getReportsByQuizId(quizId: number): Observable<any> {
    return this.http.get(`${apiBaseUrl}/reports/quizes/${quizId}`);
  }
}

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

  deleteQuiz(id: number): Observable<any> {
    return this.http.delete(`${apiBaseUrl}/quizes/${id}`);
  }

  saveQuiz(quiz: IQuiz) {
    return this.http.post(`${apiBaseUrl}/quizes/`, quiz);
  }
}

import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {ProfileComponent} from './components/profile/profile.component';
import {ErrorComponent} from './components/error/error.component';
import {RegisterComponent} from './components/register/register.component';
import {HomeComponent} from './components/home/home.component';
import {QuizComponent} from './components/quiz/quiz.component';
import {QuizSaveComponent} from './components/quiz-save/quiz-save.component';
import {QuizReportComponent} from './components/quiz-report/quiz-report.component';
import {ReportsListComponent} from './components/reports-list/reports-list.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'quizes/:id', component: QuizComponent },
  {path: 'quizes/report/:id', component: QuizReportComponent},
  { path: 'new-quiz', component: QuizSaveComponent },
  { path: 'quiz-reports/:id', component: ReportsListComponent},
  { path: '**', component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

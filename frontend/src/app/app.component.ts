import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Questionnary';
  token: string;

  onChange(event) {
    console.log(event);
    // event.loginEmitter.subscribe(data => {
    //   this.token = data;
    // })
  }
}

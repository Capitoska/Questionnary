/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { QuizCreateService } from './quiz-create.service';

describe('Service: QuizCreate', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [QuizCreateService]
    });
  });

  it('should ...', inject([QuizCreateService], (service: QuizCreateService) => {
    expect(service).toBeTruthy();
  }));
});

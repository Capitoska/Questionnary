import {IAnswerOption} from './IAnswerOption';
import {IAnswerType} from './IAnswerType';

export interface IQuestion {
  id: number;
  text: string;
  answerType: IAnswerType;
  rightAnswer: Array<IAnswerOption>;
  answers: Array<IAnswerOption>;
}

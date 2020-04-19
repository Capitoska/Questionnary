import {IAnswerOption} from "./IAnswerOption";

export interface IUserAnswer {
  id: number;
  user: IUserAnswer;
  answer: IAnswerOption;
}

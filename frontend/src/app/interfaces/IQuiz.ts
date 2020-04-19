import {IUser} from "./IUser";
import {IQuestion} from "./IQuestion";

export interface IQuiz {
  id:number;
  name: string;
  author: IUser;
  questions: Array<IQuestion>;
  isOpen: boolean;
}

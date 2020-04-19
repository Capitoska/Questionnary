import {IUser} from "./IUser";
import {IQuestion} from "./IQuestion";

export interface ITheme {
  id:number;
  name:string;
  isOpen: boolean;
  author: IUser;
  questions: Array<IQuestion>;
}

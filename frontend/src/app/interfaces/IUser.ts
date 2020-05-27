import {IRole} from "./IRole";

export interface IUser {
  id?: number;
  username: string;
  password: string;
  firstName?: string;
  secondName?: string;
  thirdName?: string;
  email?: string;
  birthday?: string;
  role?: IRole;
}

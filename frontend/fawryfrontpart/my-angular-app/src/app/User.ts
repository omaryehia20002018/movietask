import{Role} from './Role'

export interface User {
  id: number;
  username: string;
  password: string;
  //role: Role;

  /*constructor(id: number, username: string, password: string, role: Role) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.role = role;
  }*/
}
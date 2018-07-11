import Api from './Api'
import User from "../domain/User";

class UserApi extends Api {
  current(): Promise<User> {
    return this.get('users/current').then(User.fromApi)
  }

  register(username: string, password: string): Promise<User> {
    return this.post('users/register', {username, password}).then(User.fromApi)
  }

  login(username: string, password: string): Promise<User> {
    return this.post('users/login', {username, password}).then(User.fromApi)
  }
}

export default new UserApi()

import Api from './Api';
import User from "../domain/User";
import Page from "../domain/Page";
import Pageable from "../domain/Pageable";

class AdminUserApi extends Api {
  constructor() {
    super();
    this.agent.defaults.baseURL += "admin/";
  }

  query(pageable: Pageable = undefined, username: string, password: string): Promise<Page<User>> {
    const {page} = pageable || {page: 0};
    return this.get('users', {username, password, page: page + 1}).then(page => {
      page.items = page.items.map(User.fromApi);
      return page;
    });
  }

  find(id: number): Promise<User> {
    return this.get(`users/${id}`).then(user => {
      return user;
    });
  }

  create(username: string, password: string): Promise<any> {
    return this.post('users', {username, password})
  }

  update(id: number, username: string, password: string): Promise<any> {
    return this.patch(`users/${id}`, {username, password})
  }

  destroy(id: number): Promise<any> {
    return this.delete(`users/${id}`)
  }
}

export default new AdminUserApi();

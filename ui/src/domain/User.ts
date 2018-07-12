class User {
  id: number;
  username: string;
  password: string;
  createdAt: Date;
  updatedAt: Date;
  token: string;
  online: boolean;
  avatarUrl: string;

  static fromApi(item: object) {
    const user: User = new User();
    user.id = item['id'];
    user.username = item['username'];
    user.password = item['password'];
    user.createdAt = new Date(item['createdAt']);
    user.updatedAt = new Date(item['updatedAt']);
    user.token = item['token'];
    user.avatarUrl = item['avatarUrl'];
    return user;
  }
}

export default User

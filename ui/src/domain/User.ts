class User {
  id: number;
  username: string;
  password: string;
  nickname: string;
  createdAt: Date;
  updatedAt: Date;
  token: string;
  online: boolean;
  avatarUrl: string;

  static fromApi(obj: object) {
    const user: User = new User();
    user.id = obj['id'];
    user.username = obj['username'];
    user.password = obj['password'];
    user.nickname = obj['nickname'];
    user.createdAt = new Date(obj['createdAt']);
    user.updatedAt = new Date(obj['updatedAt']);
    user.token = obj['token'];
    user.avatarUrl = obj['avatarUrl'];
    return user;
  }
}

export default User

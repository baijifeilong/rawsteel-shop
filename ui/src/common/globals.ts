import User from "../domain/User";

export function getToken(): string {
  return getUser().token;
}

export function getUser(): User {
  return JSON.parse(localStorage.getItem('user')) || new User;
}

export function setUser(user: User): void {
  localStorage.setItem('user', JSON.stringify(user))
}

export function unsetUser(): void {
  setUser(new User)
}

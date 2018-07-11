import User from "../domain/User";

export function getToken(): string {
  return (getUser() || new User).token
}

export function getUser(): User {
  return JSON.parse(localStorage.getItem('user'))
}

export function setUser(user: User): void {
  localStorage.setItem('user', JSON.stringify(user))
}

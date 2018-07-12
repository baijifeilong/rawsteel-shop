import Api from "./Api"

class HomeApi extends Api {

  index() {
    return this.get('home')
  }
}

export default new HomeApi

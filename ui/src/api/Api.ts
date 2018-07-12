import axios, {AxiosInstance} from 'axios'
import * as globals from '../common/globals'

class Api {
  protected agent: AxiosInstance;

  constructor() {
    this.agent = axios.create({
      baseURL: 'http://localhost:8080/api/',
      timeout: 10000
    });

    this.agent.interceptors.request.use(config => {
      console.log(`>>> Request [${config.method.toUpperCase()}] ${config.url}`,
        config.params, config.data);
      return config;
    }, error => {
      console.log(`>>> Request with error`, error);
      return Promise.reject(error);
    });

    this.agent.interceptors.response.use(response => {
      console.log(`<<< Response ${response.status}:${response.statusText}`, response.data);
      return response;
    }, error => {
      console.log('<<< Response with error', error);
      return Promise.reject(error);
    })
  }

  request(method: string, url: string, params: object = undefined): Promise<any> {
    return this.agent.request({
      method: method,
      url: url,
      data: params,
      headers: {
        Authorization: globals.getToken()
      }
    }).then(response => {
      return Promise.resolve(response.data.data)
    }).catch(error => {
      if (error.code === 'ECONNABORTED') {
        return Promise.reject('连接超时');
      } else if (!error.response) {
        return Promise.reject('网络连接错误');
      } else {
        return Promise.reject(error.response.data.error.message || "服务器未知错误");
      }
    })
  }

  get(url: string, params: object = undefined): Promise<any> {
    return this.request('get', url, params);
  }

  post(url: string, params: object = undefined): Promise<any> {
    return this.request('post', url, params);
  }

  patch(url: string, params: object = undefined): Promise<any> {
    return this.request('patch', url, params);
  }

  delete(url: string): Promise<any> {
    return this.request('delete', url);
  }
}

export default Api;

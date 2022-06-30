import axios from "axios";
export default class userService {
  getAll() {
    return axios.get("http://localhost:8080/api/user/getall");
  }
}

import axios from "axios";
export default class talentService {
  getAll() {
    return axios.get("http://localhost:8080/api/talent/getall");
  }
}

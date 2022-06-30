import axios from "axios";

export default class candidateService {
  getAll() {
    axios.get("http://localhost:8080/api/candidate/getall");
  }
}

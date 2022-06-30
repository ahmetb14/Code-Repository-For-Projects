import axios from "axios";
export default class candidateTalentService {
  getAll() {
    return axios.get("http://localhost:8080/api/candidatetalent/getall");
  }
}

import axios from "axios";
export default class candidateLanguageService {
  getAll() {
    return axios.get("http://localhost:8080/api/candidatelanguage/getall");
  }
}

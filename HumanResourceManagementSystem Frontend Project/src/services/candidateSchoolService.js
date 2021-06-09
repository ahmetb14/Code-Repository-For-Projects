import axios from "axios";
export default class candidateSchoolService {
  getAll() {
    return axios.get("http://localhost:8080/api/candidateschools/getall");
  }

  findByCandidateCvId(id) {
    return axios.get(
      "http://localhost:8080/api/candidateschools/findbycandidatecvid?id=" + id
    );
  }

  //curl -X GET "http://localhost:8080/api/candidateschools/getcandidateschoolswithordered?id=1" -H "accept: */*"
  orderedCandidatesSchoolSwithOrdered(id) {
    return axios.get(
      "http://localhost:8080/api/candidateschools/getcandidateschoolswithordered?id=" +
        id
    );
  }
}

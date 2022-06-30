import axios from "axios";
export default class candidateJobExperinceService {
  getAll() {
    return axios.get("http://localhost:8080/api/candidateexperience/getall");
  }

  //

  orderedCandidateCvSchools(id) {
    return axios.get(
      "http://localhost:8080/api/candidateexperience/getcandidateJobExperiencesswithordered?id=" +
        id
    );
  }
}

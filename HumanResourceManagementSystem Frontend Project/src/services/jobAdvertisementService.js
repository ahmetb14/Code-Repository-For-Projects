import axios from "axios";
export default class jobAdvertisementService {
  getAll() {
    return axios.get("http://localhost:8080/api/jobAdvertisements/getall");
  }

  getAllActives() {
    return axios.get(
      "http://localhost:8080/api/jobAdvertisements/getallactive"
    );
  }

  getAllActiveSorted() {
    return axios.get(
      "http://localhost:8080/api/jobAdvertisements/getallactivesorted"
    );
  }

  getEmployerJobAdvertisement(id) {
    return axios.get(
      "http://localhost:8080/api/jobAdvertisements/getEmployerJobAdvertisement?id=" +
        id
    );
  }
}

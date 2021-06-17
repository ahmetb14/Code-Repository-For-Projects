import axios from "axios";

export default class jobAdService {
  getActiveJobAds() {
    return axios.get(
      "http://localhost:8080/api/jobAdvertisements/getallactive"
    );
  }
  getAll() {
    return axios.get("http://localhost:8080/api/jobAdvertisements/getall");
  }
  getActiveAdsByCompanyId(id) {
    return axios.get(
      "http://localhost:8080/api/jobAdvertisements/getEmployerJobAdvertisement?id=" +
        id
    );
  }

  add(values) {
    return axios.post(
      "http://localhost:8080/api/jobAdvertisements/add",
      values
    );
  }
}

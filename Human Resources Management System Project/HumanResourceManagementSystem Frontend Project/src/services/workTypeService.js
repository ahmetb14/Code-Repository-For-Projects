import axios from "axios";

export default class workPlaceService {
  getWorkPlaces() {
    return axios.get("http://localhost:8080/api/worktype/getall");
  }
}

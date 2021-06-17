import axios from "axios";

export default class workTimeService {
  getWorkTimes() {
    return axios.get("http://localhost:8080/api/workhour/getall");
  }
}

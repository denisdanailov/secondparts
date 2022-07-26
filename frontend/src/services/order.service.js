import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/orders/";

class OrderService {
  createOrder(data) {
    return axios.post(API_URL + "create", data, {
      headers: authHeader(),
    });
  }

  getTransmissions() {
    return axios.get(API_URL + "transmissions", {
      headers: authHeader(),
    });
  }

  getEngines() {
    return axios.get(API_URL + "engines", {
      headers: authHeader(),
    });
  }

  getCategories() {
    return axios.get(API_URL + "categories", {
      headers: authHeader(),
    });
  }

  getBrands() {
    return axios.get(API_URL + "brands", {
      headers: authHeader(),
    });
  }
}

export default new OrderService();

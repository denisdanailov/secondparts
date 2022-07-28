import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/orders/";

class OrderService {
  getAllOrders() {
    return axios.get(API_URL + "all", {
      headers: authHeader(),
    });
  }

  getOrderById(orderId) {
    return axios.get(`${API_URL}${orderId}`, {
      headers: authHeader(),
    });
  }

  createOrder(data) {
    return axios.post(API_URL + "create", data, {
      headers: authHeader(),
    });
  }

  deleteOrder(orderId) {
    return axios.delete(`${API_URL}${orderId}`, {
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

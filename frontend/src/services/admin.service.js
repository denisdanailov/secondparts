import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/admin/";

class UserService {
  getAllUsers() {
    return axios.get(API_URL + "all", { headers: authHeader() });
  }

  getUserById(userId) {
    return axios.get(`${API_URL}${userId}`, {
      headers: authHeader(),
    });
  }

  deleteUser(userId) {
    return axios.delete(`${API_URL}${userId}`, {
      headers: authHeader(),
    });
  }

  editUser(userId, data) {
    return axios.put(`${API_URL}${userId}`, data, {
      headers: authHeader(),
    });
  }

  createUser(data) {
    return axios.post(API_URL + "create", data, {
      headers: authHeader(),
    });
  }
}

export default new UserService();

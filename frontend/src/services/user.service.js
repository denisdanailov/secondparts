import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/users/";

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

  editUser(userId) {
    return axios.put(`${API_URL}${userId}`, {
      headers: authHeader(),
    });
  }
}

export default new UserService();

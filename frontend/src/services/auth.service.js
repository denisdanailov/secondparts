import axios from "axios";

const API_URL = "http://localhost:8080/api/auth/";

class AuthService {
  async login(username, password) {
    const response = await axios.post(API_URL + "signin", {
      username,
      password,
    });
    if (response.data.accessToken) {
      localStorage.setItem("user", JSON.stringify(response.data));
    }
    return response.data;
  }

  logout() {
    localStorage.removeItem("user");
  }

  register(firstName, lastName, username, email, password, imageUrl) {
    return axios.post(API_URL + "signup", {
      firstName,
      lastName,
      username,
      email,
      password,
      imageUrl,
    });
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem("user"));
  }
}

export default new AuthService();

import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/category/";

class CategoryService {
  getAllViewCategories() {
    return axios.get(API_URL + "all", { headers: authHeader() });
  }

  getCategoryById(categoryId) {
    return axios.get(`${API_URL}${categoryId}`, {
      headers: authHeader(),
    });
  }
}
export default new CategoryService();

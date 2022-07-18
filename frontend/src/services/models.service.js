import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/models/";

class ModelService {
  getModelsFromBrandAudi() {
    return axios.get(API_URL + "audi", { headers: authHeader() });
  }
}

export default new ModelService();

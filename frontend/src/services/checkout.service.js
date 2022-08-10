import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/shopping-card/";

class CheckoutService {
  addOfferToCard(data) {
    return axios.post(API_URL + "add", data, {
      headers: authHeader(),
    });
  }
  getAllOffersFromCard() {
    return axios.get(API_URL + "all", {
      headers: authHeader(),
    });
  }

  soldOffers() {
    return axios.delete(API_URL + "checkout", {
      headers: authHeader(),
    });
  }
}
export default new CheckoutService();

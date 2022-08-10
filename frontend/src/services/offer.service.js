import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/offers/";

class OfferService {
  getAllOffers() {
    return axios.get(API_URL + "all", {
      headers: authHeader(),
    });
  }

  searchOffer(data) {
    return axios.post(API_URL + "search", data, {
      headers: authHeader(),
    });
  }

  getOfferById(offerId) {
    return axios.get(`${API_URL}${offerId}`, {
      headers: authHeader(),
    });
  }

  createOffer(data) {
    return axios.post(API_URL + "create", data, {
      headers: authHeader(),
    });
  }

  editOffer(offerId, data) {
    return axios.put(`${API_URL}${offerId}`, data, {
      headers: authHeader(),
    });
  }

  deleteOffer(offerId) {
    return axios.delete(`${API_URL}${offerId}`, {
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

  getOffersCount() {
    return axios.get(API_URL + "count", {
      headers: authHeader(),
    });
  }
}

export default new OfferService();

import { useState } from "react";
import { OfferView } from "../catalog/OfferView";
import OfferService from "../../services/offer.service";

export const Search = () => {
  const [offers, setOffers] = useState([]);

  const onSearch = (e) => {
    e.preventDefault();

    const formData = new FormData(e.target);

    const { model, vehicleIdentificationNumber } = Object.fromEntries(formData);

    const searchData = { model, vehicleIdentificationNumber };

    console.log(searchData);
    console.log(offers.length);

    OfferService.searchOffer(searchData).then((offer) => setOffers(offer.data));
  };

  return (
    <div className="search-container container mt-5">
      <div className="row d-flex justify-content-center">
        <div className="col-md-10">
          <div className="card-search p-3  py-2">
            <h5>
              Find your part easily by model and Vehicle Identification Number
            </h5>
            <form method="GET" onSubmit={onSearch}>
              <div className="row g-3 mt-2">
                <div className="search col-md-6">
                  <input
                    type="text"
                    className="form-control"
                    placeholder="Search by vehicle Identification Number"
                    name="vehicleIdentificationNumber"
                  />
                </div>
                <div className="search-col col-md-3">
                  <input
                    type="text"
                    className="form-control"
                    placeholder="Search by model"
                    name="model"
                  />
                </div>

                <div className="search-col col-md-3">
                  <button className="searchBtn btn-outline-secondary">
                    Search Results
                  </button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
      <div className="container mt-100">
        <div className="row">
          {offers.length !== 0 ? (
            offers.map((offer) => <OfferView offer={offer} key={offer.id} />)
          ) : (
            <div className="searchResult">
              <p>No Results</p>
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

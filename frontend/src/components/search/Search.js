import { useState } from "react";
import { OfferView } from "../catalog/OfferView";
import OfferService from "../../services/offer.service";

export const Search = () => {
  const [offers, setOffers] = useState([]);

  const onSearch = (e) => {
    e.preventDefault();

    const formData = new FormData(e.target);

    const { model, vehicleIdentificationNumber } = Object.fromEntries(formData);

    const searchData = { model };

    console.log(searchData);
    console.log(offers.length);

    OfferService.searchOffer(searchData).then((offer) => setOffers(offer.data));
  };

  return (
    <div className="container mt-5">
      <div className="row d-flex justify-content-center">
        <div className="col-md-10">
          <div className="card p-3  py-4">
            <h5>An Easier way to find your Housing</h5>
            <form method="GET" onSubmit={onSearch}>
              <div className="row g-3 mt-2">
                <div className="col-md-3">
                  <div className="dropdown">
                    <button
                      className="btn btn-secondary dropdown-toggle"
                      type="button"
                      id="dropdownMenuButton"
                      data-toggle="dropdown"
                      aria-expanded="false"
                    >
                      Any Status
                    </button>
                    <ul
                      className="dropdown-menu"
                      aria-labelledby="dropdownMenuButton"
                    >
                      <li>
                        <a className="dropdown-item" href="/">
                          Rural
                        </a>
                      </li>
                      <li>
                        <a className="dropdown-item" href="/">
                          Urban
                        </a>
                      </li>
                      <li>
                        <a className="dropdown-item" href="/">
                          All
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>

                <div className="col-md-6">
                  <input
                    type="text"
                    className="form-control"
                    placeholder="Search by model"
                    name="model"
                  />
                </div>

                <div className="col-md-3">
                  <button className="btn btn-secondary btn-block">
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
            <p>No Results</p>
          )}
        </div>
      </div>
    </div>
  );
};

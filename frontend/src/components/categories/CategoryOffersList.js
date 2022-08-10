import { Link, useParams } from "react-router-dom";
import { useEffect, useState } from "react";

import LoadingSpinner from "../spinner/LoadingSpinner";
import CategoryService from "../../services/category.service";

export const CategortOffersList = () => {
  const params = useParams();
  const [offers, setOffers] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    CategoryService.getCategoryById(params.id).then((category) =>
      setOffers(category.data.offers)
    );
    setIsLoading(false);
  }, []);

  return (
    <div className="category-offer-list">
      <div className="container mt-100">
        <div className="offer_list col-8">
          <div className="list-group" id="list-tab" role="tablist">
            {offers.filter((offer) => offer.active === true).length === 0 && (
              <div className="searchResult">
                <img
                  src="https://res.cloudinary.com/diozchjq4/image/upload/v1660078952/clipart2883707_hfxkar.png"
                  alt="img-no-result"
                />
                <Link className="offers-btn" to="/catalog">
                  <p className="offers-btn">&#8594; go to Catalog</p>
                </Link>
              </div>
            )}

            {isLoading ? (
              <LoadingSpinner />
            ) : (
              offers
                .filter((offer) => offer.active === true)
                .map((offer) => (
                  <Link to={`/offer/details/${offer.id}`}>
                    <p
                      className="list-group-item list-group-item-action"
                      id="list-settings-list"
                      data-toggle="list"
                      href="#list-settings"
                      role="tab"
                      aria-controls="settings"
                      key={offer.id}
                    >
                      <h4> {offer.title} </h4>
                      Price: {offer.price} €
                    </p>
                  </Link>
                ))
            )}
          </div>
        </div>
      </div>
    </div>
  );
};

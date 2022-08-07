import "./OfferDetails.css";

import { Link, useParams } from "react-router-dom";

import OfferService from "../../../../services/offer.service";
import { useEffect, useState } from "react";

export const OfferDetails = () => {
  const params = useParams();
  const [offer, setOffer] = useState([]);

  console.log(offer);
  console.log(params.id);

  useEffect(() => {
    OfferService.getOfferById(params.id).then((offer) => setOffer(offer.data));
  }, []);

  return (
    <div className="wrapper">
      <div className="product-img">
        <img src={offer.imageUrl} height="420" width="327" />
      </div>
      <div className="product-info">
        <div className="product-title">
          <h1>{offer.title}</h1>
        </div>
        <div className="product-text">
          <h5>
            <span class="bold">Year: </span>
            {offer.year}
          </h5>
          <h5>
            <span class="bold">Engine: </span> {offer.engine}
          </h5>
          <h5>
            <span class="bold">Transmission: </span> {offer.transmission}
          </h5>
          <h5>
            <span class="bold">Kilometers: </span> {offer.kilometers}
          </h5>
          <h5>
            <span class="bold">ID Nummber: </span>
            {offer.vehicleIdentificationNumber}
          </h5>
          <p>
            <span class="bold">Description: </span> {offer.description}
          </p>
          <h5>
            <span class="bold">Price: </span> {offer.price}$
          </h5>
        </div>
        <div className="product-price-btn">
          <input type="submit" value="Add to Card" className="btn-login" />
          <Link to="/catalog">
            <input
              type="submit"
              value="&#8249; Back to Catalog"
              className="btn-login"
            />
          </Link>
        </div>
      </div>
    </div>
  );
};

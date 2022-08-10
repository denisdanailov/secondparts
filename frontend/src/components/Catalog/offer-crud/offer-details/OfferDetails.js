import "./OfferDetails.css";

import { Link, useParams } from "react-router-dom";

import OfferService from "../../../../services/offer.service";
import { useEffect, useState } from "react";
import { MoreProducts } from "../../more-products/MoreProudcts";

export const OfferDetails = () => {
  const params = useParams();
  const [offer, setOffer] = useState([]);

  useEffect(() => {
    OfferService.getOfferById(params.id).then((offer) => setOffer(offer.data));
  }, []);

  return (
    <div className="offers-details">
      <div className="details-wrapper">
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
                <span className="bold">Year: </span>
                {offer.year}
              </h5>
              <h5>
                <span className="bold">Engine: </span> {offer.engine}
              </h5>
              <h5>
                <span className="bold">Transmission: </span>{" "}
                {offer.transmission}
              </h5>
              <h5>
                <span className="bold">Kilometers: </span> {offer.kilometers}
              </h5>
              <h5>
                <span className="bold">ID Nummber: </span>
                {offer.vehicleIdentificationNumber}
              </h5>
              <p>
                <span className="bold">Description: </span> {offer.description}
              </p>
              <h5>
                <span className="bold">Price: </span> {offer.price}$
              </h5>
            </div>
            <div className="product-price-btn">
              <div className="checkout-btn">
                <i className="fa fa-cart-plus" aria-hidden="true"></i>
                <span>Add to Bag</span>
              </div>

              <Link to="/catalog">
                <input
                  type="submit"
                  value="&#8249; Back to Catalog"
                  className="btn-back"
                />
              </Link>
            </div>
          </div>
        </div>
      </div>
      <div className="more-products">
        <div className="heading_container heading_center">
          <h2>More products</h2>
          <p>
            We work currently only with the most well-known German brands on the
            car market. In the future we will partner with other brands around
            the world.
          </p>
        </div>
        <MoreProducts params={params} />
      </div>
    </div>
  );
};

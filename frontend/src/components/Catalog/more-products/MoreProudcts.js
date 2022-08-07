import { useEffect, useState } from "react";
import "./MoreProducts.css";
import { MoreProductView } from "./MoreProductView";
import OfferService from "../../../services/offer.service";

export const MoreProducts = ({ params }) => {
  const [offers, setoffers] = useState([]);

  useEffect(() => {
    OfferService.getAllOffers().then((offer) => setoffers(offer.data));
  }, []);

  return (
    <>
      <div className="container mt-100r">
        <div className="row">
          {offers
            .splice(0, 3)
            .filter((offers) => offers.id !== Number(params.id))
            .map((offer) => (
              <MoreProductView key={offer.id} offer={offer} />
            ))}
        </div>
      </div>
    </>
  );
};

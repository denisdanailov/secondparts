import { useState, useEffect } from "react";

import OfferService from "../../services/offer.service";
import { OfferActions } from "./offer-crud/OfferListConstants";
import { OfferDelete } from "./offer-crud/OfferDelete";
import { OfferEdit } from "./offer-crud/OfferEdit";
import "./Catalog.css";

import { OfferView } from "./offer-crud/OfferView";

export function Catalog() {
  const [offers, setOffers] = useState([]);
  const [userAction, setUserAction] = useState({ offer: null, action: null });

  useEffect(() => {
    OfferService.getAllOffers().then((offer) => setOffers(offer.data));
  }, []);

  const userActionClickHandler = (offerId, actionType) => {
    OfferService.getOfferById(offerId).then((offer) => {
      setUserAction({
        offer,
        action: actionType,
      });
    });
  };

  const onChangeHandler = () => {
    OfferService.getAllOffers().then((offers) => setOffers(offers.data));
  };

  const deleteHandler = (offerId) => {
    setOffers((state) => state.filter((offer) => offer.id !== offerId));
  };

  const closeHandler = () => {
    setUserAction({ user: null, action: null });
  };

  return (
    <>
      {userAction.action === OfferActions.Delete && (
        <OfferDelete
          offer={userAction.offer}
          onClose={closeHandler}
          deleteHandler={deleteHandler}
        />
      )}

      {userAction.action === OfferActions.Edit && (
        <OfferEdit
          offer={userAction.offer}
          onClose={closeHandler}
          onChange={onChangeHandler}
        />
      )}
      <div className="catalog-section">
        <div className="container mt-100">
          <div className="row">
            {offers.length !== 0 ? (
              offers.map((offer) => (
                <OfferView
                  offer={offer}
                  key={offer.id}
                  onActionClick={userActionClickHandler}
                />
              ))
            ) : (
              <div className="searchResult">
                <img
                  src="https://res.cloudinary.com/diozchjq4/image/upload/v1660078952/clipart2883707_hfxkar.png"
                  alt="no-results-img"
                />
              </div>
            )}
          </div>
        </div>
      </div>
    </>
  );
}

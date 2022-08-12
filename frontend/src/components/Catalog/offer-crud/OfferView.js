import { Link } from "react-router-dom";

import AuthService from "../../../services/auth.service";
import { OfferActions } from "./OfferListConstants";

export const OfferView = ({ offer, onActionClick }) => {
  const BLANK_OFFER_URL =
    "https://res.cloudinary.com/diozchjq4/image/upload/v1659788464/secondparts-blankimges/no-img_ax6rdv.png";

  const currentUserId = AuthService.getUserId();
  const admin = AuthService.getAdmin();

  return (
    <div className="product-card">
      {currentUserId === offer.seller.id ? (
        <div className="badge">Your Offer</div>
      ) : (
        ""
      )}
      <div className="product-tumb">
        <img src={offer.imageUrl || BLANK_OFFER_URL} alt="offer-img" />
      </div>
      <div className="product-details">
        <span className="product-catagory">
          {offer.model.brand.name} ,{offer.model.name}
        </span>

        <h4>{offer.title}</h4>
        <p>Category: {offer.category.name}</p>
        <p>{offer.description}</p>

        <p>Seller: {offer.seller.firstName}</p>

        <div className="product-bottom-details">
          <div className="product-price">
            Price:<span> {offer.price} € </span>
          </div>
          {(() => {
            if (currentUserId === offer.seller.id) {
              return (
                <div className="product-links">
                  <a
                    onClick={() => onActionClick(offer.id, OfferActions.Delete)}
                  >
                    <i className="fa fa-trash"></i>
                  </a>
                  <a onClick={() => onActionClick(offer.id, OfferActions.Edit)}>
                    <i className="fa fa-edit"></i>
                  </a>
                  <Link
                    className="btn-item auction-btn mr-2"
                    to={`/offer/details/${offer.id}`}
                  >
                    <input
                      type="submit"
                      value="Details"
                      className="btn-details"
                    />
                  </Link>
                </div>
              );
            }
            if (admin) {
              return (
                <div className="product-links">
                  {currentUserId !== offer.seller.id ? (
                    <Link to={`/offer/details/${offer.id}`}>
                      <input
                        type="submit"
                        value="Details"
                        className="btn-details"
                      />
                    </Link>
                  ) : (
                    ""
                  )}
                  <a
                    onClick={() => onActionClick(offer.id, OfferActions.Delete)}
                  >
                    <i className="fa fa-trash"></i>
                  </a>
                  <a onClick={() => onActionClick(offer.id, OfferActions.Edit)}>
                    <i className="fa fa-edit"></i>
                  </a>
                </div>
              );
            }

            return (
              <div className="product-links">
                <Link to={`/offer/details/${offer.id}`}>
                  <input
                    type="submit"
                    value="Details"
                    className="btn-details"
                  />
                </Link>
              </div>
            );
          })()}
        </div>
      </div>
    </div>
  );
};

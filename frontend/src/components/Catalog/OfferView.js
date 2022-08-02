import AuthService from "../../services/auth.service";
import { OfferActions } from "./OfferListConstants";

export const OfferView = ({ offer, onActionClick }) => {
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
        <img src={offer.imageUrl} alt="offer-img" />
      </div>
      <div className="product-details">
        <span className="product-catagory">
          {offer.model.brand.name} ,{offer.model.name}
        </span>
        <h4>{offer.title}</h4>

        <p>{offer.description}</p>
        <details>
          <summary>Details</summary>
          <p>Category: {offer.category.name}</p>
          <p>Year: {offer.year}</p>
          <p>Engine: {offer.engine}</p>
          <p>Transmission: {offer.transmission}</p>
          <p>Kilometers: {offer.kilometers}</p>
          <p>ID Nummber: {offer.vehicleIdentificationNumber}</p>
          <p>Seller: {offer.seller.firstName}</p>
        </details>
        <div className="product-bottom-details">
          <div className="product-price">$ {offer.price}</div>
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
                </div>
              );
            }
            if (admin) {
              return (
                <div className="product-links">
                  {currentUserId !== offer.seller.id ? (
                    <a href="/">
                      <i className="fa fa-shopping-cart"></i>
                    </a>
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
                <a href="/">
                  <i className="fa fa-shopping-cart"></i>
                </a>
              </div>
            );
          })()}
        </div>
      </div>
    </div>
  );
};

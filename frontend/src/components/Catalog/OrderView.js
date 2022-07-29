import AuthService from "../../services/auth.service";
import { OrderActions } from "./OrderListConstants";

export const OrderdView = ({ order, onActionClick }) => {
  const currentUserId = AuthService.getUserId();
  const admin = AuthService.getAdmin();

  return (
    <div className="product-card">
      {currentUserId === order.seller.id ? (
        <div className="badge">Your Offer</div>
      ) : (
        ""
      )}
      <div className="product-tumb">
        <img src={order.imageUrl} alt="" />
      </div>
      <div className="product-details">
        <span className="product-catagory">
          {order.model.brand.name} ,{order.model.name}
        </span>
        <h4>{order.title}</h4>

        <p>{order.description}</p>
        <details>
          <summary>Details</summary>
          <p>Category: {order.category.name}</p>
          <p>Year: {order.year}</p>
          <p>Engine: {order.engine}</p>
          <p>Transmission: {order.transmission}</p>
          <p>Kilometers: {order.kilometers}</p>
          <p>ID Nummber: {order.vehicleIdentificationNumber}</p>
          <p>Seller: {order.seller.firstName}</p>
        </details>
        <div className="product-bottom-details">
          <div className="product-price">$ {order.price}</div>
          {(() => {
            if (currentUserId === order.seller.id) {
              return (
                <div className="product-links">
                  <a
                    onClick={() => onActionClick(order.id, OrderActions.Delete)}
                  >
                    <i className="fa fa-trash"></i>
                  </a>
                  <a onClick={() => onActionClick(order.id, OrderActions.Edit)}>
                    <i className="fa fa-edit"></i>
                  </a>
                </div>
              );
            }
            if (admin) {
              return (
                <div className="product-links">
                  {currentUserId !== order.seller.id ? (
                    <a href="/">
                      <i className="fa fa-shopping-cart"></i>
                    </a>
                  ) : (
                    ""
                  )}
                  <a
                    onClick={() => onActionClick(order.id, OrderActions.Delete)}
                  >
                    <i className="fa fa-trash"></i>
                  </a>
                  <a onClick={() => onActionClick(order.id, OrderActions.Edit)}>
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

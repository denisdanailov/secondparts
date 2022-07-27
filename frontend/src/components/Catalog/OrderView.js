import AuthService from "../../services/auth.service";

export const OrderdView = ({ order }) => {
  console.log(order);

  const currentUser = AuthService.getCurrentUser();

  return (
    <div className="product-card">
      {currentUser.id === order.seller.id ? (
        <div className="badge">Your Order</div>
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
        <h4>
          <a href="/">{order.title}</a>
        </h4>
        <p>{order.description}</p>
        <div className="product-bottom-details">
          <div className="product-price">$ {order.price}</div>
          <div className="product-links">
            <a href="">
              <i className="fa fa-heart"></i>
            </a>
            {currentUser.id === order.seller.id ? (
              <a href="/">
                <i class="fa fa-pen-to-square">Edit Order</i>
              </a>
            ) : (
              ""
            )}
            <a href="/">
              <i className="fa fa-shopping-cart"></i>
            </a>
          </div>
        </div>
      </div>
    </div>
  );
};

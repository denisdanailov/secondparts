export const MoreProductView = ({ offer }) => {
  return (
    <div className="product-card">
      <div className="product-tumb">
        <img src={offer.imageUrl} alt="offer-img" />
      </div>
      <div className="product-details">
        <span className="product-catagory">
          {offer.model.brand.name} ,{offer.model.name}
        </span>
        <h4>{offer.title}</h4>

        <p>{offer.description}</p>

        <div className="product-price">$ {offer.price}</div>
      </div>
    </div>
  );
};

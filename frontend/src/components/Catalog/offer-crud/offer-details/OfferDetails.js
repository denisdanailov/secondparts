import "./OfferDetails.css";

export const OfferDetails = () => {
  return (
    <div className="wrapper">
      <div className="product-img">
        <img src="http://bit.ly/2tMBBTd" height="420" width="327" />
      </div>
      <div className="product-info">
        <div className="product-text">
          <h1>Harvest Vase</h1>
          <h2>by studio and friends</h2>
          <p>info</p>
        </div>
        <div className="product-price-btn">
          <p>
            <span>78</span>$
          </p>
          <button type="button">buy now</button>
        </div>
      </div>
    </div>
  );
};

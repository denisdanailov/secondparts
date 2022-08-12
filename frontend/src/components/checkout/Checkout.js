import "./Checkout.css";
import { useState, useEffect, useContext } from "react";

import { ShoppingCartContext } from "../../contexts/ShoppingCartContext";
import CheckoutService from "../../services/checkout.service";
import AuthService from "../../services/auth.service";

import Alert from "@mui/material/Alert";
import Stack from "@mui/material/Stack";

export const Checkout = () => {
  const [offers, setOffers] = useState([]);
  const [error, setError] = useState("");
  const [feed, setFeed] = useState("");

  const { onClean } = useContext(ShoppingCartContext);

  const currentUserId = AuthService.getUserId();

  useEffect(() => {
    CheckoutService.getAllOffersForCurrentUser(currentUserId).then((offer) =>
      setOffers(offer.data)
    );
  }, []);

  let totalSum = 0;
  offers.map((offer) => {
    return (totalSum += Number(offer.offerPrice));
  });

  const onSold = () => {
    if (offers.length === 0) {
      return setError(
        <Stack sx={{ width: "100%", p: 2 }} spacing={2}>
          <Alert severity="error">Shopping Cart is Empty! Go shopping..</Alert>
        </Stack>
      );
    } else {
      CheckoutService.soldOffers();
      setOffers([]);
      onClean();
      return setFeed(
        <Stack sx={{ width: "100%", p: 2 }} spacing={2}>
          <Alert severity="success">Thank you for your order.</Alert>
        </Stack>
      );
    }
  };

  return (
    <section className="payment-form dark">
      <div className="container">
        <div className="block-heading">
          <h2>Shopping Cart</h2>
          <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam
            urna, dignissim nec auctor in, mattis vitae leo.
          </p>
        </div>
        <form>
          <div className="products">
            <h3 className="title">Checkout</h3>

            {offers.map((offer) => (
              <div className="item" key={offer.id}>
                <span className="price">{offer.offerPrice} €</span>
                <p className="item-name">{offer.offerTitle}</p>
              </div>
            ))}
            <div className="total">
              Total<span className="price">{totalSum} €</span>
            </div>
            {feed ? feed : null}
            {error ? error : null}
          </div>

          <div className="card-details">
            {/* <h3 className="title">Credit Card Details</h3> */}
            <div className="row">
              {/* Futures! to be impl... */}
              {/* <div className="form-group col-sm-7">
                <label htmlFor="card-holder">Card Holder</label>
                <input
                  id="card-holder"
                  type="text"
                  className="form-control"
                  placeholder="Card Holder"
                  aria-label="Card Holder"
                  aria-describedby="basic-addon1"
                />
              </div>
              <div className="form-group col-sm-5">
                <label htmlFor="">Expiration Date</label>
                <div className="input-group expiration-date">
                  <input
                    type="text"
                    className="form-control"
                    placeholder="MM"
                    aria-label="MM"
                    aria-describedby="basic-addon1"
                  />
                  <span className="date-separator">/</span>
                  <input
                    type="text"
                    className="form-control"
                    placeholder="YY"
                    aria-label="YY"
                    aria-describedby="basic-addon1"
                  />
                </div>
              </div>
              <div className="form-group col-sm-8">
                <label htmlFor="card-number">Card Number</label>
                <input
                  id="card-number"
                  type="text"
                  className="form-control"
                  placeholder="Card Number"
                  aria-label="Card Holder"
                  aria-describedby="basic-addon1"
                />
              </div>
              <div className="form-group col-sm-4">
                <label htmlFor="cvc">CVC</label>
                <input
                  id="cvc"
                  type="text"
                  className="form-control"
                  placeholder="CVC"
                  aria-label="Card Holder"
                  aria-describedby="basic-addon1"
                />
              </div> */}
              <div className="form-group col-sm-12">
                <button type="button" className="btn-login" onClick={onSold}>
                  Place order
                </button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </section>
  );
};

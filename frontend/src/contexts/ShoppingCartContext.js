import { createContext, useState, useEffect } from "react";
import CheckoutService from "../services/checkout.service";

export const ShoppingCartContext = createContext();

export const ShoppingCartProvider = ({ children }) => {
  const [offers, setOffers] = useState([]);

  useEffect(() => {
    CheckoutService.getAllOffersFromCard().then((offer) =>
      setOffers(offer.data)
    );
  }, []);

  const onUpdate = () => {
    CheckoutService.getAllOffersFromCard().then((offers) => {
      setOffers(offers.data);
    });
  };

  const onClean = () => {
    setOffers([]);
  };

  return (
    <ShoppingCartContext.Provider
      value={{
        offers,
        onUpdate,
        onClean,
      }}
    >
      {children}
    </ShoppingCartContext.Provider>
  );
};

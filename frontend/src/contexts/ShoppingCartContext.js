import { createContext, useState, useEffect } from "react";
import CheckoutService from "../services/checkout.service";
import AuthService from "../services/auth.service";

export const ShoppingCartContext = createContext();

export const ShoppingCartProvider = ({ children }) => {
  const [offers, setOffers] = useState([]);

  const currentUserId = AuthService.getUserId();

  useEffect(() => {
    if (currentUserId !== null) {
      CheckoutService.getAllOffersForCurrentUser(currentUserId).then((offer) =>
        setOffers(offer.data)
      );
    }
  }, []);

  const onUpdate = () => {
    CheckoutService.getAllOffersForCurrentUser(currentUserId).then((offers) => {
      setOffers(offers.data);
    });
  };

  const onClean = () => {
    CheckoutService.soldOffers();
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

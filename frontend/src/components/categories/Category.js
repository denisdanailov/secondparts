import { useState, useEffect } from "react";

import { CategoryView } from "./CategoryView";

import CategoryService from "../../services/category.service";
import OfferService from "../../services/offer.service";

export const Category = () => {
  const [categories, setCategories] = useState([]);
  const [offersCount, setOffersCount] = useState([]);

  useEffect(() => {
    CategoryService.getAllViewCategories().then((category) =>
      setCategories(category.data)
    );

    OfferService.getOffersCount().then((offersCount) =>
      setOffersCount(offersCount.data)
    );
  }, []);

  return (
    <section className="feature_section layout_padding">
      <div className="container">
        <div className="heading_container">
          <h2>Categories</h2>
          <p>
            We have currently 20 categories of auto parts in our online
            marketplace and over 300 offers
          </p>
        </div>

        <div className="col-xl-12 col-xl-4">
          <div className="box-count">
            <div className="detail-box">
              <h4>Europe's biggest market for second hand car parts..</h4>
              <p>
                Right now <span> {offersCount} </span>spare parts for sale.
              </p>
            </div>
          </div>
        </div>
        <div className="row">
          {categories.map((category) => (
            <CategoryView key={category.name} category={category} />
          ))}
        </div>
      </div>
    </section>
  );
};

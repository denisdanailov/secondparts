import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import OfferService from "../../services/offer.service";

export const CategoryView = ({ category }) => {
  console.log(category);
  return (
    <div className="col-sm-6 col-lg-4">
      <div className="box">
        <div className="img-box">
          <img src={category.imageUrl} alt="category-img" />
        </div>
        <div className="detail-box">
          <h5>{category.name}</h5>
          <Link to="/category-offer">
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,</p>
          </Link>
        </div>
      </div>
    </div>
  );
};

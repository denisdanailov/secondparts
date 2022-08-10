import { Link } from "react-router-dom";

export const CategoryView = ({ category }) => {
  return (
    <div className="col-sm-6 col-lg-4">
      <div className="box">
        <div className="img-box">
          <img src={category.imageUrl} alt="category-img" />
        </div>
        <div className="detail-box-category">
          <h5>{category.name}</h5>

          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,</p>

          <Link className="offers-btn" to={`/category/offers/${category.id}`}>
            <p className="offers-btn">
              &#8594; view all offers in this category
            </p>
          </Link>
        </div>
      </div>
    </div>
  );
};

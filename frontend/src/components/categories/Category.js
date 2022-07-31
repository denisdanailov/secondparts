import { useState, useEffect } from "react";

import { CategoryView } from "./CategoryView";

import CategoryService from "../../services/category.service";

export const Category = () => {
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    CategoryService.getAllViewCategories().then((category) =>
      setCategories(category.data)
    );
  }, []);

  return (
    <section className="feature_section layout_padding">
      <div className="container">
        <div className="heading_container">
          <h2>Categories</h2>
          <p>
            Consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
            labore et dolore magna aliqua.
          </p>
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

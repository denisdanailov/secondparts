export const CategoryView = ({ category }) => {
  return (
    <div className="col-sm-6 col-lg-4">
      <div className="box">
        <div className="img-box">
          <img src="images/audi-logo.png" alt="" />
        </div>
        <div className="detail-box">
          <h5>{category.name.toLowerCase()}</h5>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,</p>
          <a href="/">
            <span> View All offers in category </span>
            <i className="fa fa-long-arrow-right" aria-hidden="true"></i>
          </a>
        </div>
      </div>
    </div>
  );
};

export const ModelItem = ({ models }) => {
  return (
    <>
      <div className="product-card-models">
        <div className="product-details">
          <h5 className="mt-0 font-weight-bold mb-2">
            Brand: {models.brand.name}
          </h5>
          <p className="font-italic text-muted mb-0 small">
            <h6 className="font-weight-bold my-2">Model: {models.name}</h6>
            <span>Start year: {models.startYear}</span>
            <br />
            <span>End year: {models.endYear}</span>
          </p>
          <div className="d-flex align-items-center justify-content-between mt-1">
            <ul className="list-inline small">
              <li className="list-inline-item m-0">
                <i className="fa fa-star text-success"></i>
              </li>
              <li className="list-inline-item m-0">
                <i className="fa fa-star text-success"></i>
              </li>
              <li className="list-inline-item m-0">
                <i className="fa fa-star text-success"></i>
              </li>
              <li className="list-inline-item m-0">
                <i className="fa fa-star text-success"></i>
              </li>
              <li className="list-inline-item m-0">
                <i className="fa fa-star-o text-gray"></i>
              </li>
            </ul>
          </div>
        </div>

        <img
          src={models.imageUrl}
          alt="model-img"
          width="200"
          className="ml-lg-5 order-1 order-lg-2"
        />
      </div>
    </>
  );
};

export const ModelItem = ({ models }) => {
  return (
    <>
      <li className="list-group-item">
        <div className="media align-items-lg-center flex-column flex-lg-row p-3">
          <div className="media-body order-2 order-lg-1">
            <h5 className="mt-0 font-weight-bold mb-2">
              Brand: {models.brand.name}
            </h5>
            <p className="font-italic text-muted mb-0 small">
              Year details:
              <span>Strat year: {models.startYear}</span>
              <br />
              <span>End year: {models.endYear}</span>
            </p>
            <div className="d-flex align-items-center justify-content-between mt-1">
              <h6 className="font-weight-bold my-2">Model: {models.name}</h6>
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
            src="images/porsche-13.png"
            alt="Generic placeholder image"
            width="200"
            className="ml-lg-5 order-1 order-lg-2"
          />
        </div>
      </li>
    </>
  );
};

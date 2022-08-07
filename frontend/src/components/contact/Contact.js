export const Contact = () => {
  return (
    <section className="contact_section">
      <div className="container">
        <div className="row">
          <div className="col-md-6">
            <div className="detail-box-contact">
              <div className="heading_container">
                <h2>Contact Us</h2>
              </div>

              <ul className="contact-info">
                <li>
                  {" "}
                  <a href="/">
                    <i className="fa fa-map-marker" aria-hidden="true"></i>
                    <span> Frankfurt am Main </span>
                  </a>
                </li>
                <li>
                  {" "}
                  <a href="/">
                    <i className="fa fa-phone" aria-hidden="true"></i>
                    <span> Call +49 1234567890 </span>
                  </a>
                </li>
                <li>
                  {" "}
                  <a href="/">
                    <i className="fa fa-phone" aria-hidden="true"></i>
                    <span> Call +49 1234567890 </span>
                  </a>
                </li>
                <li>
                  {" "}
                  <a href="/">
                    <i className="fa fa-envelope" aria-hidden="true"></i>
                    <span> secondparts@gmail.com </span>
                  </a>
                </li>
              </ul>
            </div>
          </div>
          <div className="col-md-6">
            <div className="img-box">
              <img
                src="https://res.cloudinary.com/diozchjq4/image/upload/v1659906847/cars/mercedes-benz/kisspng-mercedes-benz-m-class-sport-utility-vehicle-merced-mercedes-5b50c3565c8111.8684943315320195423789_sjaglf.png"
                alt=""
              />
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

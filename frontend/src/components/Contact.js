export const Contact = () => {
  return (
    <section className="contact_section">
      <div className="container">
        <div className="row">
          <div className="col-md-6">
            <div className="detail-box">
              <div className="heading_container">
                <h2>Contact Us</h2>
              </div>
              <a href="/">
                <i className="fa fa-map-marker" aria-hidden="true"></i>
                <span> Frankfurt am Main </span>
              </a>
              <br />
              <a href="/">
                <i className="fa fa-phone" aria-hidden="true"></i>
                <span> Call +01 1234567890 </span>
              </a>
              <br />
              <a href="/">
                <i className="fa fa-phone" aria-hidden="true"></i>
                <span> Call +01 1234567890 </span>
              </a>
              <br />
              <a href="/">
                <i className="fa fa-envelope" aria-hidden="true"></i>
                <span> secondparts@gmail.com </span>
              </a>
            </div>
          </div>
          <div className="col-md-6">
            <div className="img-box">
              <img src="images/mercedes-car-1.png" alt="" />
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

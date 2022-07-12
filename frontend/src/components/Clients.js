export const Clients = () => {
  return (
    <section className="client_section layout_padding">
      <div className="container">
        <div className="heading_container heading_center">
          <h2>Testimonial</h2>
        </div>
        <div className="carousel-wrap">
          <div className="owl-carousel client_owl-carousel">
            <div className="item">
              <div className="box">
                <div className="img-box">
                  <img src="images/c1.jpg" alt="" />
                </div>
                <div className="detail-box">
                  <div className="client_info">
                    <div className="client_name">
                      <h5>Mark Thomas</h5>
                      <h6>Customer</h6>
                    </div>
                    <i className="fa fa-quote-left" aria-hidden="true"></i>
                  </div>
                  <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                    do eiusmod tempor incididunt ut labore et dolore magna
                    aliqua. Ut enim ad minim veniam, quis nostrud exercitation
                    ullamco laboris nisi ut aliquip ex ea commodo consequat.
                    Duis aute irure dolor in reprehenderit in voluptate velit
                    esse cillum dolore eu fugia
                  </p>
                </div>
              </div>
            </div>
            <div className="item">
              <div className="box">
                <div className="img-box">
                  <img src="images/c2.jpg" alt="" />
                </div>
                <div className="detail-box">
                  <div className="client_info">
                    <div className="client_name">
                      <h5>Alina Hans</h5>
                      <h6>Customer</h6>
                    </div>
                    <i className="fa fa-quote-left" aria-hidden="true"></i>
                  </div>
                  <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                    do eiusmod tempor incididunt ut labore et dolore magna
                    aliqua. Ut enim ad minim veniam, quis nostrud exercitation
                    ullamco laboris nisi ut aliquip ex ea commodo consequat.
                    Duis aute irure dolor in reprehenderit in voluptate velit
                    esse cillum dolore eu fugia
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

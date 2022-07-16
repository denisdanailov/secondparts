import { HeroSocial } from "./HeroSocial";
export const Slider = () => {
  return (
    <div className="hero_area">
      <HeroSocial />
      <section className="slider_section">
        <div
          id="customCarousel1"
          className="carousel slide"
          data-ride="carousel"
        >
          <div className="carousel-inner">
            <div className="carousel-item active">
              <div className="container-fluid">
                <div className="row">
                  <div className="col-md-6">
                    <div className="detail-box">
                      <h1>Mercedes-Benz</h1>
                      <p>
                        Aenean scelerisque felis ut orci condimentum laoreet.
                        Integer nisi nisl, convallis et augue sit amet, lobortis
                        semper quam.
                      </p>
                      <div className="btn-box">
                        <a href="/" className="btn1">
                          {" "}
                          View Parts{" "}
                        </a>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-6">
                    <div className="img-box">
                      <img src="images/mercedes-car-5.png" alt="" />
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="carousel-item">
              <div className="container-fluid">
                <div className="row">
                  <div className="col-md-6">
                    <div className="detail-box">
                      <h1>Audi</h1>
                      <p>
                        Aenean scelerisque felis ut orci condimentum laoreet.
                        Integer nisi nisl, convallis et augue sit amet, lobortis
                        semper quam.
                      </p>
                      <div className="btn-box">
                        <a href="/" className="btn1">
                          {" "}
                          View Parts{" "}
                        </a>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-6">
                    <div className="img-box">
                      <img src="images/audi-car.png" alt="" />
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="carousel-item">
              <div className="container-fluid">
                <div className="row">
                  <div className="col-md-6">
                    <div className="detail-box">
                      <h1>Prosche</h1>
                      <p>
                        Aenean scelerisque felis ut orci condimentum laoreet.
                        Integer nisi nisl, convallis et augue sit amet, lobortis
                        semper quam.
                      </p>
                      <div className="btn-box">
                        <a href="/" className="btn1">
                          {" "}
                          View Parts{" "}
                        </a>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-6">
                    <div className="img-box">
                      <img src="images/porshe-12.png" alt="" />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <ol className="carousel-indicators">
            <li
              data-target="#customCarousel1"
              data-slide-to="0"
              className="active"
            ></li>
            <li data-target="#customCarousel1" data-slide-to="1"></li>
            <li data-target="#customCarousel1" data-slide-to="2"></li>
          </ol>
        </div>
      </section>
    </div>
  );
};
